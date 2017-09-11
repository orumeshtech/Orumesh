package com.jicstech.orumesh;

import com.jicstech.orumesh.conf.Configuration;
import com.jicstech.orumesh.controllers.TipsViewModel;
import com.jicstech.orumesh.model.Hash;
import com.jicstech.orumesh.network.Node;
import com.jicstech.orumesh.network.TransactionRequester;
import com.jicstech.orumesh.network.UDPReceiver;
import com.jicstech.orumesh.network.replicator.Replicator;
import com.jicstech.orumesh.service.TipsManager;
import com.jicstech.orumesh.storage.FileExportProvider;
import com.jicstech.orumesh.storage.Mesh;
import com.jicstech.orumesh.storage.rocksDB.RocksDBPersistenceProvider;
import org.apache.commons.lang3.NotImplementedException;

public class OruMesh {

    public static final Hash MAINNET_COORDINATOR = new Hash("KPWCHICGJZXKE9GSUDXZYUAPLHAKAHYHDXNPHENTERYMMBQOPSQIDENXKLKCEYCPVTZQLEEJVYJZV9BWU");
    public static final Hash TESTNET_COORDINATOR = new Hash("XNZBYAST9BETSDNOVQKKTBECYIPMF9IPOZRWUPFQGVH9HJW9NDSQVIPVBWU9YKECRYGDSJXYMZGHZDXCA");

    public final LedgerValidator ledgerValidator;
    public final Milestone milestone;
    public final Snapshot latestSnapshot;
    public final Mesh mesh;
    public final TransactionValidator transactionValidator;
    public final TipsManager tipsManager;
    public final TransactionRequester transactionRequester;
    public final Node node;
    public final UDPReceiver udpReceiver;
    public final Replicator replicator;
    public final Configuration configuration;
    public final Hash coordinator;
    public final TipsViewModel tipsViewModel;

    public final boolean testnet;
    public final int maxPeers;
    public final int udpPort;
    public final int tcpPort;

    public OruMesh(Configuration configuration) {
        this.configuration = configuration;
        testnet = configuration.booling(Configuration.DefaultConfSettings.TESTNET);
        maxPeers = configuration.integer(Configuration.DefaultConfSettings.MAX_PEERS);
        udpPort = configuration.integer(Configuration.DefaultConfSettings.UDP_RECEIVER_PORT);
        tcpPort = configuration.integer(Configuration.DefaultConfSettings.TCP_RECEIVER_PORT);
        if(testnet) {
            String coordinatorTrytes = configuration.string(Configuration.DefaultConfSettings.COORDINATOR);
            if(coordinatorTrytes != null) {
                coordinator = new Hash(coordinatorTrytes);
            } else {
                coordinator = TESTNET_COORDINATOR;
            }
        } else {
            coordinator = MAINNET_COORDINATOR;
        }
        mesh = new Mesh();
        tipsViewModel = new TipsViewModel();
        transactionRequester = new TransactionRequester(mesh);
        transactionValidator = new TransactionValidator(mesh, tipsViewModel, transactionRequester);
        latestSnapshot = new Snapshot(Snapshot.initialSnapshot);
        milestone =  new Milestone(mesh, coordinator, transactionValidator, testnet);
        node = new Node(configuration, mesh, transactionValidator, transactionRequester, tipsViewModel, milestone);
        replicator = new Replicator(node, tcpPort, maxPeers, testnet);
        udpReceiver = new UDPReceiver(udpPort, node);
        ledgerValidator = new LedgerValidator(mesh, milestone, transactionRequester);
        tipsManager = new TipsManager(mesh, ledgerValidator, transactionValidator, tipsViewModel, milestone);
    }

    public void init() throws Exception {
        initializeTangle();
        mesh.init();
        milestone.init(ledgerValidator, configuration.booling(Configuration.DefaultConfSettings.REVALIDATE));
        transactionValidator.init(testnet);
        tipsManager.init();
        transactionRequester.init(configuration.doubling(Configuration.DefaultConfSettings.P_REMOVE_REQUEST.name()));
        udpReceiver.init();
        replicator.init();
        node.init();
    }

    public void shutdown() throws Exception {
        milestone.shutDown();
        tipsManager.shutdown();
        node.shutdown();
        udpReceiver.shutdown();
        replicator.shutdown();
        transactionValidator.shutdown();
        mesh.shutdown();
    }

    private void initializeTangle() {
        String dbPath = configuration.string(Configuration.DefaultConfSettings.DB_PATH);
        if (testnet) {
            if (dbPath.isEmpty() || dbPath.equals("mainnetdb")) {
                // testnetusers must not use mainnetdb, overwrite it unless an explicit name is set.
                configuration.put(Configuration.DefaultConfSettings.DB_PATH.name(), "testnetdb");
                configuration.put(Configuration.DefaultConfSettings.DB_LOG_PATH.name(), "testnetdb.log");
            }
        } else {
            if (dbPath.isEmpty() || dbPath.equals("testnetdb")) {
                // mainnetusers must not use testnetdb, overwrite it unless an explicit name is set.
                configuration.put(Configuration.DefaultConfSettings.DB_PATH.name(), "mainnetdb");
                configuration.put(Configuration.DefaultConfSettings.DB_LOG_PATH.name(), "mainnetdb.log");
            }
        }
        switch (configuration.string(Configuration.DefaultConfSettings.MAIN_DB)) {
            case "rocksdb": {
                mesh.addPersistenceProvider(new RocksDBPersistenceProvider(
                        configuration.string(Configuration.DefaultConfSettings.DB_PATH),
                        configuration.string(Configuration.DefaultConfSettings.DB_LOG_PATH) ));
                break;
            }
            default: {
                throw new NotImplementedException("No such database type.");
            }
        }
        if (configuration.booling(Configuration.DefaultConfSettings.EXPORT)) {
            mesh.addPersistenceProvider(new FileExportProvider());
        }
    }
}
