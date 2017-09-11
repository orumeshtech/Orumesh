package com.jicstech.orumesh;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.net.ssl.HttpsURLConnection;

import com.jicstech.orumesh.controllers.*;
import com.jicstech.orumesh.storage.Mesh;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jicstech.orumesh.hash.ISS;
import com.jicstech.orumesh.model.Hash;
import com.jicstech.orumesh.utils.Converter;

public class Milestone {

    private final Logger log = LoggerFactory.getLogger(Milestone.class);
    private final Mesh mesh;
    private final Hash coordinator;
    private final TransactionValidator transactionValidator;
    private final boolean testnet;

    private LedgerValidator ledgerValidator;
    public Hash latestMilestone = Hash.NULL_HASH;
    public Hash latestSolidSubtangleMilestone = latestMilestone;

    public static final int MILESTONE_START_INDEX = 0;
    private static final int NUMBER_OF_KEYS_IN_A_MILESTONE = 20;

    public int latestMilestoneIndex = MILESTONE_START_INDEX;
    public int latestSolidSubtangleMilestoneIndex = MILESTONE_START_INDEX;

    private final Set<Hash> analyzedMilestoneCandidates = new HashSet<>();
    private final Set<Hash> analyzedMilestoneRetryCandidates = new HashSet<>();

    public Milestone(final Mesh mesh,
              final Hash coordinator,
              final TransactionValidator transactionValidator,
              final boolean testnet
              ) {
        this.mesh = mesh;
        this.coordinator = coordinator;
        this.transactionValidator = transactionValidator;
        this.testnet = testnet;
    }

    private boolean shuttingDown;
    private static int RESCAN_INTERVAL = 5000;

    public void init(final LedgerValidator ledgerValidator, final boolean revalidate) {
        this.ledgerValidator = ledgerValidator;
        (new Thread(() -> {
            while (!shuttingDown) {
                long scanTime = System.currentTimeMillis();

                try {
                    final int previousLatestMilestoneIndex = latestMilestoneIndex;

                    updateLatestMilestone();

                    if (previousLatestMilestoneIndex != latestMilestoneIndex) {

                        log.info("Latest milestone has changed from #" + previousLatestMilestoneIndex
                                + " to #" + latestMilestoneIndex);
                    }

                    Thread.sleep(Math.max(1, RESCAN_INTERVAL - (System.currentTimeMillis() - scanTime)));

                } catch (final Exception e) {
                    log.error("Error during Latest Milestone updating", e);
                }
            }
        }, "Latest Milestone Tracker")).start();

        (new Thread(() -> {

            try {
                ledgerValidator.init(revalidate);
            } catch (Exception e) {
                log.error("Error initializing snapshots. Skipping.", e);
            }
            while (!shuttingDown) {
                long scanTime = System.currentTimeMillis();

                try {
                    final int previousSolidSubtangleLatestMilestoneIndex = latestSolidSubtangleMilestoneIndex;

                    if(latestSolidSubtangleMilestoneIndex < latestMilestoneIndex) {
                        updateLatestSolidSubtangleMilestone();
                    }

                    if (previousSolidSubtangleLatestMilestoneIndex != latestSolidSubtangleMilestoneIndex) {

                        log.info("Latest SOLID SUBTANGLE milestone has changed from #"
                                + previousSolidSubtangleLatestMilestoneIndex + " to #"
                                + latestSolidSubtangleMilestoneIndex);
                    }

                    Thread.sleep(Math.max(1, RESCAN_INTERVAL - (System.currentTimeMillis() - scanTime)));

                } catch (final Exception e) {
                    log.error("Error during Solid Milestone updating", e);
                }
            }
        }, "Solid Milestone Tracker")).start();


    }

    void updateLatestMilestone() throws Exception { // refactor
        findNewMilestones();
        MilestoneViewModel milestoneViewModel = MilestoneViewModel.latest(mesh);
        if(milestoneViewModel != null && milestoneViewModel.index() > latestMilestoneIndex) {
            latestMilestone = milestoneViewModel.getHash();
            latestMilestoneIndex = milestoneViewModel.index();
        }
    }

    private boolean validateMilestone(TransactionViewModel transactionViewModel, int index) throws Exception {

        if (MilestoneViewModel.get(mesh, index) != null) {
            // Already validated.
            return true;
        }
        final List<List<TransactionViewModel>> bundleTransactions = BundleValidator.validate(mesh, transactionViewModel.getBundleHash());
        if (bundleTransactions.size() == 0) {
            return false;
        }
        else {
            for (final List<TransactionViewModel> bundleTransactionViewModels : bundleTransactions) {

                //if (Arrays.equals(bundleTransactionViewModels.get(0).getHash(),transactionViewModel.getHash())) {
                if (bundleTransactionViewModels.get(0).getHash().equals(transactionViewModel.getHash())) {

                    //final TransactionViewModel transactionViewModel2 = StorageTransactions.instance().loadTransaction(transactionViewModel.trunkTransactionPointer);
                    final TransactionViewModel transactionViewModel2 = transactionViewModel.getTrunkTransaction(mesh);
                    if (transactionViewModel2.getType() == TransactionViewModel.FILLED_SLOT
                            && transactionViewModel.getBranchTransactionHash().equals(transactionViewModel2.getTrunkTransactionHash())) {

                        final int[] trunkTransactionTrits = transactionViewModel.getTrunkTransactionHash().trits();
                        final int[] signatureFragmentTrits = Arrays.copyOfRange(transactionViewModel.trits(), TransactionViewModel.SIGNATURE_MESSAGE_FRAGMENT_TRINARY_OFFSET, TransactionViewModel.SIGNATURE_MESSAGE_FRAGMENT_TRINARY_OFFSET + TransactionViewModel.SIGNATURE_MESSAGE_FRAGMENT_TRINARY_SIZE);

                        final int[] merkleRoot = ISS.getMerkleRoot(ISS.address(ISS.digest(
                                Arrays.copyOf(ISS.normalizedBundle(trunkTransactionTrits),
                                        ISS.NUMBER_OF_FRAGMENT_CHUNKS),
                                signatureFragmentTrits)),
                                transactionViewModel2.trits(), 0, index, NUMBER_OF_KEYS_IN_A_MILESTONE);
                        if (testnet || (new Hash(merkleRoot)).equals(coordinator)) {
                            new MilestoneViewModel(index, transactionViewModel.getHash()).store(mesh);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    void updateLatestSolidSubtangleMilestone() throws Exception {
        MilestoneViewModel milestoneViewModel;
        MilestoneViewModel latest = MilestoneViewModel.latest(mesh);
        if (latest != null) {
            for (milestoneViewModel = MilestoneViewModel.findClosestNextMilestone(mesh, latestSolidSubtangleMilestoneIndex);
                 milestoneViewModel != null && milestoneViewModel.index() <= latest.index() && !shuttingDown;
                 milestoneViewModel = milestoneViewModel.next(mesh)) {
                if (transactionValidator.checkSolidity(milestoneViewModel.getHash(), true) &&
                        milestoneViewModel.index() >= latestSolidSubtangleMilestoneIndex &&
                        ledgerValidator.updateSnapshot(milestoneViewModel)) {
                    latestSolidSubtangleMilestone = milestoneViewModel.getHash();
                    latestSolidSubtangleMilestoneIndex = milestoneViewModel.index();
                } else {
                    break;
                }
            }
        }
    }

    static int getIndex(TransactionViewModel transactionViewModel) {
        return (int) Converter.longValue(transactionViewModel.trits(), TransactionViewModel.TAG_TRINARY_OFFSET, 15);
    }

    private void findNewMilestones() throws Exception {
        AddressViewModel.load(mesh, coordinator).getHashes().stream()
                .filter(analyzedMilestoneCandidates::add)
                .map(hash -> TransactionViewModel.quietFromHash(mesh, hash))
                .filter(t -> t.getCurrentIndex() == 0)
                .forEach(t -> {
                    try {
                        if(!validateMilestone(t, getIndex(t))) {
                            analyzedMilestoneCandidates.remove(t.getHash());
                        }
                    } catch (Exception e) {
                        analyzedMilestoneCandidates.remove(t.getHash());
                        log.error("Could not validate milestone: ", t.getHash());
                    }
                });
    }

    void shutDown() {
        shuttingDown = true;
    }

    public void reportToSlack(final int milestoneIndex, final int depth, final int nextDepth) {

        try {

            final String request = "token=" + URLEncoder.encode("<botToken>", "UTF-8") + "&channel=" + URLEncoder.encode("#botbox", "UTF-8") + "&text=" + URLEncoder.encode("TESTNET: ", "UTF-8") + "&as_user=true";

            final HttpURLConnection connection = (HttpsURLConnection) (new URL("https://slack.com/api/chat.postMessage")).openConnection();
            ((HttpsURLConnection)connection).setHostnameVerifier((hostname, session) -> true);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            OutputStream out = connection.getOutputStream();
            out.write(request.getBytes("UTF-8"));
            out.close();
            ByteArrayOutputStream result = new ByteArrayOutputStream();
            InputStream inputStream = connection.getInputStream();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {

                result.write(buffer, 0, length);
            }
            log.info(result.toString("UTF-8"));

        } catch (final Exception e) {

            e.printStackTrace();
        }
    }
}
