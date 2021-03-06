package com.jicstech.orumesh;

import com.jicstech.orumesh.controllers.TransactionViewModel;
import com.jicstech.orumesh.model.Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;


public class Snapshot {
    private static final Logger log = LoggerFactory.getLogger(Snapshot.class);

    public static final Map<Hash, Long> initialState = new HashMap<>();
    public static final Snapshot latestSnapshot;
    public static final Snapshot initialSnapshot;

    static {
        initialState.put(Hash.NULL_HASH, 908343229829300L);

        // TODO: Read this from a singed binary file
        initialState.put(new Hash("GH9TBJICDYIRWHQIVJPQMNW9TCRTSFKHSUDSAV9DQS99OUXXGGYJIRNGNRYPQZTNHRVMIYSLWDZWSBNUH"), 18166864596689L);
        initialState.put(new Hash("UZUDPXUCFJNUYQQSW9Q9SIEHLBEOYYAZWSVQMDGVCGOIDDTULFWQJCVJACIMNNBHYRIMBIEQBSKYRDMEJ"), 18166864596586L);
        initialState.put(new Hash("NXVDMIFWMBEQSTMCGJ9BHOKSIIV9LLWVRWDKCLWRTGKVDEFYUBHFMVWRDVKLXAHFX9EAMTFHYKKYIPLD9"), 18166864596586L);
        initialState.put(new Hash("UUOXQLBOZIYPTKLWREB9YILKSOSSODQKDHSBS9SVDP9RD9JHBSPAQYGBTHM9JWGOWFK9IZHGQQCHVSZVS"), 18166864596586L);
        initialState.put(new Hash("IFZHFF9IMCRXSNFSZRXFCIX99BGHX9PLKPSVNEVIDPZXRPFAPQBNWJAIUZRJQAFRIAJHTQKVP9DIJDJTC"), 18166864596586L);
        initialState.put(new Hash("JTC9KCBLLGDSCUQRMWFNYFTTOGIVDHYJSOESBJTKOIZKZ9MBWUOZNZPKU9DIBNCJIWKOPPIHFIZTNRIPR"), 18166864596586L);
        initialState.put(new Hash("NJCTNTWOKJOZRKJUFOSYLT9DHNAHKOEWSBOGZWDOWSYTHXFRDNUXABARMNPUHWPRYTW9WMVKYBZFNCFKT"), 18166864596586L);
        initialState.put(new Hash("UZCETOVRPOUIVMWLJDZKCTHKLCVELPRJHGFBJHFRDJIE9DKGITFIVMULJJCHCPOREZKZZCTNZVXUPZENV"), 18166864596586L);
        initialState.put(new Hash("HDPZRJJEABLLGOHZRLIFZHYHVTPUSVCLGHUDVZFISHFKO9VXNZGQP99REHGYKOXWJMYQFQSWFQZGGWNJK"), 18166864596586L);
        initialState.put(new Hash("S9IPUUUNSSBMXAPP9ILXXSBOKYPYKTMQWEUBTZJ9TADTWCYOEYXJJKRQYUSQHGVQUWTGBEGCAHLCGETGN"), 18166864596586L);
        initialState.put(new Hash("IOSODUBCRDWCIFVZ9EEELCCPIOHLRQSFFOBVYJSLYAGTLZQGADY9OXZBSBLL9SBANSGTSDXPNJFLCILKZ"), 18166864596586L);
        initialState.put(new Hash("FUIUXMTGJSSUXOPYJUBJAOUNBJCDBLIFXK9CNKQUPVSZRUQPCPIPEDTPSQXBRNYQKNYOOWFMRBFC9UTGI"), 18166864596586L);
        initialState.put(new Hash("IAGINMMHWLSTKYUCYLBJEOAONHPRJUSHOSBMJKYJOYDKLDUUZRPZRGGBZ9QXWZJKCGUX9EOCVYJIEOCMX"), 18166864596586L);
        initialState.put(new Hash("9KTGNCQHJAWULCQEJKXONDXACSQSFEOLMOKXKRYCRQOVLIH9DPHMZ9CYTKZBHXTIIUZBKN9STJFOZDIEC"), 18166864596586L);
        initialState.put(new Hash("XVUWBFJRGZZLDDWGKHNPZIPLCQQQAUDUPDGGZYFDGQHDBWCTFKU9PGWGOWRMZPXTZEJM9NIVLIKCHXOOK"), 18166864596586L);
        initialState.put(new Hash("DWHEVRVJJOSCPEQYPNASNROVQMGNMZYSZEJLGIYIGNY9W9WKMZUPW9JBMQEKVQJLFJTQKFXESQOMCTBDQ"), 18166864596586L);
        initialState.put(new Hash("HYZOJHCQMOMW9EXMTJCZSDKBGTXEIBTBTTSKNPTWPWVDTD9XCNMLWSTBEQKHDRGTQPX9OJFIFNEMFCMCZ"), 18166864596586L);
        initialState.put(new Hash("DGVBLVBJHRVSJZCWZHLHVDUYFFN9RM9CAWIFSWBRGOQIIMALMZUNJYENHMZTZGCDZFPNWYTXVAVIUDJNI"), 18166864596586L);
        initialState.put(new Hash("SSTRUEVBNIKDELOYXRSDVSDNSPSHVW9BUALBGAOSYVLHTECFLZSLTWLJMZIHQWFLAXDKQFHFRFTPCSTPC"), 18166864596586L);
        initialState.put(new Hash("GLBZREYOIUSRMVESSRJRMGFKANHTNPXG9UTXVLPFNNYQJGDTHLFYMABQTKCECLLVEQKYILOLUUIPSIFYP"), 18166864596586L);
        initialState.put(new Hash("B9PARKQ9KARTNQL9XQEP9OUIYCZEHHWNZZSDDKODUJRNQKIF9VZ9VNZKLDRAJXLUULPIBMXFAWZVPWVRP"), 18166864596586L);
        initialState.put(new Hash("FTPOEEBMBBQBPCFLRKSUP9XVCGNFBTFLNZMMGNOOZMIXZFMRGEUN99TQGWQLZTMEIJXKWTHGGJGFCCVJN"), 18166864596586L);
        initialState.put(new Hash("TADIRCQZDWPEOPAVXIHQLGONKKXJT9MAZBKCNFPIPQS9CTWPMNOGBJGDGVQWDVTS9GSKSFWRQJYRYUJHY"), 18166864596586L);
        initialState.put(new Hash("PDMHCW9EJNAZJKJXPTEVNBLHSIROJUCUEKBZEJXLS9IWNRWWKNHFUVGPRBWKDYRFAMAAU9WOXRQXVSHUU"), 18166864596586L);
        initialState.put(new Hash("HOKTVRWCVALF99UELC9VDUCKXNIFLKBDHRPMWMCROANLVPROQMHZ9SMJEVBOGBVTCRFHCRHUZXMKJOVY9"), 18166864596586L);
        initialState.put(new Hash("EQDYWQYPOLLLHVDNWWQISMKNJDGRBFOVJFPJ9AP9AUIVUICDWJVDL9RI9V9ANALDCYZTMURSFVRLQR9MC"), 18166864596586L);
        initialState.put(new Hash("OKLILODGHOKSDAJQPFPUS9G9XRVMFYIGLRLFCSYCFUTYQSSXBWTSRYZEMOJVTEYHOKOSUZDERA9PAZDXL"), 18166864596586L);
        initialState.put(new Hash("IH9AXIIDQDISWN9DWNUKMSVCXJZGCDOOPPRJWBOSJWTVIMNAXHPIYTHRHLHXYZFYLEEIKJWNFJSVCKYBE"), 18166864596586L);
        initialState.put(new Hash("QEHWBEBWZSMRNVSMHNBRA9BNRTKPMJKXFXKVSFCRWXXUSTQILR9MZUUU9DPGCLUHJUKXNODDPBALLBKOS"), 18166864596586L);
        initialState.put(new Hash("NELLAKAGRONHIJXSCCDGHHJLDGXBYNAGIIBSEOCHPNIZVMBUJYIQ9SKIAV9YWDQLZIUTVMNXNFL9DG9QU"), 18166864596586L);
        initialState.put(new Hash("ZPEYEHLQOUYIMDYNKDUKFWTEPHWZQZYGNWRBFSRJSNKCTDBALDZLESMOYPBUDNBVMXYISFAIFBEOKXVCA"), 18166864596586L);
        initialState.put(new Hash("SOPXM9ZKPJTFTYJSKA9VGKXR9CLRAAEOOHJNGKEAUJF9YZTGGGPJLNZBTWKVCBGUBBZPTDAIKYUUHKSEQ"), 18166864596586L);
        initialState.put(new Hash("YAPXPERJMWKWWDNENDTSPRLRLIDNNFIVYFBLPNXQERNTXTVGR9BYMRPHOXTQAMR9J9JZYPJDYWIIAYLWG"), 18166864596586L);
        initialState.put(new Hash("9WJIVTBIDXKEUTCNDSTTIANAKULMDCBBPXFINYUSXJZWGCBFPGCU9FNBPGQQMWKBLBQCZKNZINYRZKRQR"), 18166864596586L);
        initialState.put(new Hash("EVWHFXP9HPKKTEFYOAOYJSQWJYWMFNREANBBBCXTJR9JHIUCNHCCUNZQKOLBMJYLQBLNJUWOWPNIRTKHW"), 18166864596586L);
        initialState.put(new Hash("PSSTFS9LRFBAAGFOQX9BBRGWMMIVKGDDSEGEIYRZFXJRDEXUNUVXPXUTESNGMVWZ9NWTOQMBVKNYWQUI9"), 18166864596586L);
        initialState.put(new Hash("OQCEATGQYGACPXFKIOJWTKETKJGEDTMRGMDYRWRZUANAGIKQUJYAOWEIBFWYXTGRDLLFVIUZZUEHPHZQM"), 18166864596586L);
        initialState.put(new Hash("OCYYKOTCVKTJRHSJIZDKTCVWPUHUKCJWKISUWKSMXEDAR9FZNCBUXLXNDAKXCPSIYGKNUETHINIVQPEVE"), 18166864596586L);
        initialState.put(new Hash("9QFBMYJLZKOXXYMIXQLZB9FNUWJXENJWHFMVKFKDZZF9CRVABYCEQRJDEBDUDHMQRKFDIGC9BJWUBRQAY"), 18166864596586L);
        initialState.put(new Hash("DWTMPPHFGIVHM9RZUUWIVEPSNNWHIHJFXAC9ZP9NKXZZYXDBWFXQNQZIZEHBZVCALSAPSEDMBMUONULHY"), 18166864596586L);
        initialState.put(new Hash("IHOILPGYYLVDIWEQDRAYN9OARWPOHRKNUFVFUAPHJTLDME9TQIBLNHZECRZCACYGSIDTKUPIW9TCPWVHU"), 18166864596586L);
        initialState.put(new Hash("KKFHUGMECIEBLZOQLGASQBKRUNNLTHXP9HPKBGCDFQZ9QX99GPJMNUQNDQLKQTFEKBWSWAXGOKPZLUBRM"), 18166864596586L);
        initialState.put(new Hash("OOTEBGKLKRAWMMYJTVFNYOTUOALLMDAWECE9CEPNIJCHYMVJWTMYWQQGUUBIGSFJWNGCUIWAUVAUIEVQS"), 18166864596586L);
        initialState.put(new Hash("TXEGYQAAWCQUXABDD9QKLOQYRNJHBHIZLXBTQXKQCSDKNNBXHSYNUEELVVMJRELRUYX9TXVNLAZCIYZOU"), 18166864596586L);
        initialState.put(new Hash("BE9SXTZSXUQQHTJSLDJXBPPLXTXEBLSZEQWWYNVMUKAHVMFHEUZEKIJGIOIJZEJIHSFOWYKRFRMJVDLRR"), 18166864596586L);
        initialState.put(new Hash("SYDOKHNGSEINK9NPOIKPFKBZMSMPBLACAZZRDVFLB9UBWQVSYOWPOTGKCPUMWQLO9KIOZWFBXTXF9Y9IT"), 18166864596586L);
        initialState.put(new Hash("XPHHBCJLZFPJTAXG9XFVWBFMQ9UKVYPRXSVLRYXVIQOWUFMVXPBALPGNRXFWXRDULCWMJY9REMGWINKDU"), 18166864596586L);
        initialState.put(new Hash("EOUJSFFWRJEOKFAOPMGNSJQSXDWWHHBKPYXF9ALMENJ9PKDQQMQHXZDZVRSNCWDWULGT9VTTBCYPJNTMI"), 18166864596586L);
        initialState.put(new Hash("HXJKDODINR99XCSKADEISAFBPGTBCRGAYBMVVJPYGSIOLPYMFUFUNELLDTZOHXVVXNTFOYLOQBAYELPNN"), 18166864596586L);
        initialState.put(new Hash("LTIK9MTETWOPOEPHEWBZDVLFVBXQLJUVQOUPXGQRWEFQVWXMKHTAKI9RWJQRBMVJQCISFLSMDWRDIDVNC"), 18166864596586L);
        initialState.put(new Hash("DLPNMEHFUSVMYNOHTFGASLGWXEKLYLHVQBNVZY9HVVJDJIGHTRXLVYSISCVOZKBBRGBPUWSDAY9XRSGWK"), 18166864596586L);
        initialState.put(new Hash("EXFKKKRUQIQRFBRSSNKCGQ9YRRJSDAHYJRCNNKLPIIHQWLTOKQDNADKKAQFXCEFEKNMHVVY9KJWTIHTWZ"), 18166864596586L);
        initialState.put(new Hash("LQBYCQDCIDVYONUXVISFQFUULQOA9NSCZAISXCQVGLBSGMTBWHLQKNWFD9AVVLARANGAGQ9FPYXGDGSHT"), 18166864596586L);
        initialState.put(new Hash("CUHCPSCENHMB9IGXWBROLZQZWRWLHJUGUCGKUEIECJVM9MBH9N9HZKQNGDMOM9CZTGENRGDPTFPQDUVJR"), 18166864596586L);
        initialState.put(new Hash("EHLITDOFWG9PUBRWAUQEDB9UVPMVKOWGQMCIJJDLKYKVVQUYZIHPMEDSEKOGRKNVGPMHSUNAZLDUBFFEN"), 18166864596586L);
        initialState.put(new Hash("ZXRSC9YDEFGOZNMF9WUYHEUJC9FCCMRCYHBPDYNLTBP9NHHJBBWIJRBA9MWVMFEERKRULTLVTJTVTDUZI"), 18166864596586L);
        initialState.put(new Hash("FZRND9KLWEDCNTGTZQHGCERXDHVRLBAIXARKZOLVABFBSWEXEMZRQBJ9ZTUJBVATVWZOPUCZMBXCRWGIY"), 18166864596586L);
        initialState.put(new Hash("9OHYXBHRBJFUPQNWBKJJWJUXDJQHTAQWKEWRYETOZJGYET9ZSJQN9NEMZASMXXROXTCC9CIBRNXNJTPFP"), 18166864596586L);
        initialState.put(new Hash("WEALKN9RKKAHHQRRBCAXJNLCZCVAVDCZQILSLECERHPFWJGHBAHPCHVJC99UNHHLOK9YKPAJATXMVGFGQ"), 18166864596586L);
        initialState.put(new Hash("A9BUEZLGPSPBMXVCKCKHMNGVCSFQGQCRCDWSEP9IZXBKJJKNMUQEK9MO9BGOW9MSSOSMUVCLWCWGJCYCX"), 18166864596586L);
        initialState.put(new Hash("LJZITGQGNIHZUTZSKYYYUEFKQUZSTRAPYKOQFNUCBAYYRPUGONYZLFTWOLFMCHNE9QNI9FIXKQEMSTBUF"), 18166864596586L);
        initialState.put(new Hash("BPWNRFYHIDDVEHUFYJDVGNXIW9HDPRPETDFOLTCLYG9RWXHTZZAMMHMFXFONDMKPLQKHTXENAWCEDXBAP"), 18166864596586L);
        initialState.put(new Hash("HYFZRUIHOQWVESZAHAWFHDQXEND9OPFIS9ZW9KPDYAPQOJBOMGVHJXKHXDMDXCI9YBTMDL9XDPOGNXIJJ"), 18166864596586L);
        initialState.put(new Hash("RWZAUYXFYCGNGEQYQRQDMIXGSQYKGCVEOPQACDGCWAEIZDRUQOCWZIANDYKWRRXJYFYEFAIR9KUKMGUPI"), 18166864596586L);
        initialState.put(new Hash("CBXJEMNDLJI9OKDLVPFQNECBUSULNYAHDYTGYLAPU9NCNQLFDWABEIX99YEMUCT9WQRTGTPXFXFXOFAZH"), 18166864596586L);
        initialState.put(new Hash("PYBM9UUM9YDEUPWEXJUVJSYVGYBMCCEVAERWBYCULLSFZGFWHY99LEGYQLHOJEHNSPRIOGSKYPOOJXB9J"), 18166864596586L);
        initialState.put(new Hash("AINZASQEPPDORSWEYVYBNAKOZRLE9GXKFDNOZQRVPPOQYFFPMOSBYXBNROLJL9OKDBD9SDAWACIPGOIBV"), 18166864596586L);
        initialState.put(new Hash("WOVBUDXENXFZBVQYEOCAPWXWKRR9FNSCNXXYAPNSYHMJMSFRSXMOOYKZVBJPSMAPP99DFWNYYQBVYYYAX"), 18166864596586L);
        initialState.put(new Hash("VDAJREDTHRGSOIHLNOJUECCFETOTHCLNYEEXPIZPH9C9IWAQUCXMCLPCOWORXZMRJLVJQMYDTAMQVINHF"), 18166864596586L);
        initialState.put(new Hash("9ATUFF9YEH9BFSCBO9FCQXDYZTNJYKLSEGFFCOCYVAILTSSHPJMMP9QYCFDFCYJVDQPMQJPZBTOGVCQHZ"), 18166864596586L);
        initialState.put(new Hash("WGAVHI9ZKFKUBOJKSOHRQAX9CAXEBSYZQISAVLUMBGMQEGUGFUGQRGUQPKVXBBYLLMUTFRJRLFAVLNZNX"), 18166864596586L);
        initialState.put(new Hash("DVPJMNEWNBX9OTRIVJWRZURLRWTYYVLKZEUOHGHNXY9OWDLDENHNOIFDED9PXOSTEEKFLAJRKKRRUNHDG"), 18166864596586L);
        initialState.put(new Hash("EGQGSACUDAHALK9LBKSZCYR9MIOJJXPXQNWKUYMXASJVLCKKV9IYIDIKW9HCAHIAXJDVLXXJMBHGTTIGP"), 18166864596586L);
        initialState.put(new Hash("TUITVSUODIHTSENQINWHY9ZMNENSJEQUIXSSUSWJBGIBLYCGSRMGWGOEAUXAAVGIJCXYKIBXLOUORKFFO"), 18166864596586L);
        initialState.put(new Hash("EOGGBGBIPMUGVOGGWDVCFXTBNJMYOROQKQOUKZQAUNPVYZGME9XWALKLK9AEIDOKRYQBVYSNEMDCXAVVC"), 18166864596586L);
        initialState.put(new Hash("I9SVTYGLCEEUBYQYUNBGNAHWHCG9UVAZQISZYYAGULIBNUPLJBCIOKBRESZYJUZWVTFDYHKWNHYW9KIFK"), 18166864596586L);
        initialState.put(new Hash("RHKDRXFVJEZXKVDUYCQOUQRHNCDGXINVHSFASSJWESPSBNYPUHBCUSAIEYNQRAQDEPBWFYTQD9PKIZSUL"), 18166864596586L);
        initialState.put(new Hash("JM9NQG9HFAONDSX9WQOKDFVIGHLGYFQISQKGN9WFNGDUKBNKBITAEBUFKYNGABJXCCSZNWRB9QD9TGUGI"), 18166864596586L);
        initialState.put(new Hash("UZUDPXUCFJNUYQQSW9Q9SIEHLBEOYYAZWSVQMDGVCGOIDDTULFWQJCVJACIMNNBHYRIMBIEQBSKYRDMEJ"), 18166864596586L);
        initialState.put(new Hash("NXVDMIFWMBEQSTMCGJ9BHOKSIIV9LLWVRWDKCLWRTGKVDEFYUBHFMVWRDVKLXAHFX9EAMTFHYKKYIPLD9"), 18166864596586L);
        initialState.put(new Hash("HNXZBJHSTXUT99KKATIYDKFTZLREAMGMT9VZJFEDVEOUJULXQILEKWBNIUOBERH9HUKQKDZKNAQALBDPS"), 18166864596586L);
        initialState.put(new Hash("IFZHFF9IMCRXSNFSZRXFCIX99BGHX9PLKPSVNEVIDPZXRPFAPQBNWJAIUZRJQAFRIAJHTQKVP9DIJDJTC"), 18166864596586L);
        initialState.put(new Hash("JTC9KCBLLGDSCUQRMWFNYFTTOGIVDHYJSOESBJTKOIZKZ9MBWUOZNZPKU9DIBNCJIWKOPPIHFIZTNRIPR"), 18166864596586L);
        initialState.put(new Hash("GLOJG9OYHIIJJZFPPX9WCKSNFWLDAEDCCJYLZNQOVAGZVB9IQELTBFHUJEPQQSCQD9SMYOQEUJAQCIQNZ"), 18166864596586L);
        initialState.put(new Hash("UZCETOVRPOUIVMWLJDZKCTHKLCVELPRJHGFBJHFRDJIE9DKGITFIVMULJJCHCPOREZKZZCTNZVXUPZENV"), 18166864596586L);
        initialState.put(new Hash("HDPZRJJEABLLGOHZRLIFZHYHVTPUSVCLGHUDVZFISHFKO9VXNZGQP99REHGYKOXWJMYQFQSWFQZGGWNJK"), 18166864596586L);
        initialState.put(new Hash("UYYWRQONGBZRPJLIEHMBNCZFDGXEJKH9SKAAQRTGECNK9BG9PXVQEQHTUATRGZOUGIPTIJ9QZIGAERGAP"), 18166864596586L);
        initialState.put(new Hash("IOSODUBCRDWCIFVZ9EEELCCPIOHLRQSFFOBVYJSLYAGTLZQGADY9OXZBSBLL9SBANSGTSDXPNJFLCILKZ"), 18166864596586L);
        initialState.put(new Hash("FUIUXMTGJSSUXOPYJUBJAOUNBJCDBLIFXK9CNKQUPVSZRUQPCPIPEDTPSQXBRNYQKNYOOWFMRBFC9UTGI"), 18166864596586L);
        initialState.put(new Hash("ASUDN9LTYICGVOGTJLKQJROO99ONMNFBYNWHIYSZLREKVBJOHMISCIKPRFOHSRWYHHARTOTFKW9QRBCXL"), 18166864596586L);
        initialState.put(new Hash("9KTGNCQHJAWULCQEJKXONDXACSQSFEOLMOKXKRYCRQOVLIH9DPHMZ9CYTKZBHXTIIUZBKN9STJFOZDIEC"), 18166864596586L);
        initialState.put(new Hash("XVUWBFJRGZZLDDWGKHNPZIPLCQQQAUDUPDGGZYFDGQHDBWCTFKU9PGWGOWRMZPXTZEJM9NIVLIKCHXOOK"), 18166864596586L);
        initialState.put(new Hash("AF9XZYJFFTTEDDYVQQMHPRBHCWDELPZYLPQRUTWLRERPV9EZJDUMXYXGYXLMXZTTAYMPB9AWXHOKVDYDZ"), 18166864596586L);
        initialState.put(new Hash("HYZOJHCQMOMW9EXMTJCZSDKBGTXEIBTBTTSKNPTWPWVDTD9XCNMLWSTBEQKHDRGTQPX9OJFIFNEMFCMCZ"), 18166864596586L);
        initialState.put(new Hash("DGVBLVBJHRVSJZCWZHLHVDUYFFN9RM9CAWIFSWBRGOQIIMALMZUNJYENHMZTZGCDZFPNWYTXVAVIUDJNI"), 18166864596586L);
        initialState.put(new Hash("VWKEPOTRJLAPMDSZANNPQKKIQKYJBBWFZQMIAOXZZHABTEZUTMFNGLWAUKNEAFHQSSABMHESMPJNL9YUS"), 18166864596586L);
        initialState.put(new Hash("GLBZREYOIUSRMVESSRJRMGFKANHTNPXG9UTXVLPFNNYQJGDTHLFYMABQTKCECLLVEQKYILOLUUIPSIFYP"), 18166864596586L);
        initialState.put(new Hash("B9PARKQ9KARTNQL9XQEP9OUIYCZEHHWNZZSDDKODUJRNQKIF9VZ9VNZKLDRAJXLUULPIBMXFAWZVPWVRP"), 18166864596586L);
        initialState.put(new Hash("EQLXOYRWHZERM9WCDABQGAZJEYSWMCKASHNRHMH9MOSOPEPMV99OVIALWRTBOEXOXFRTTKXAXEFEPVHKN"), 18166864596586L);
        initialState.put(new Hash("TADIRCQZDWPEOPAVXIHQLGONKKXJT9MAZBKCNFPIPQS9CTWPMNOGBJGDGVQWDVTS9GSKSFWRQJYRYUJHY"), 18166864596586L);
        initialState.put(new Hash("PDMHCW9EJNAZJKJXPTEVNBLHSIROJUCUEKBZEJXLS9IWNRWWKNHFUVGPRBWKDYRFAMAAU9WOXRQXVSHUU"), 18166864596586L);
        initialState.put(new Hash("YOP9HTFWONQUUVPOBPHRLI9GBKLBLITBAOLYOKJ9QXNGQNLKCDESOFPDBXSWXISDEHVHJPOHH9GBUNRDI"), 18166864596586L);
        initialState.put(new Hash("EQDYWQYPOLLLHVDNWWQISMKNJDGRBFOVJFPJ9AP9AUIVUICDWJVDL9RI9V9ANALDCYZTMURSFVRLQR9MC"), 18166864596586L);
        initialState.put(new Hash("OKLILODGHOKSDAJQPFPUS9G9XRVMFYIGLRLFCSYCFUTYQSSXBWTSRYZEMOJVTEYHOKOSUZDERA9PAZDXL"), 18166864596586L);
        initialState.put(new Hash("IUEZDKJGXCSDRGRVPRJCAYWAVPGTNRZLKEHXITEIXAIHWSTKUXJLNRNFEWHWW9NQKGWFVEHYMCPQHULBM"), 18166864596586L);
        initialState.put(new Hash("QEHWBEBWZSMRNVSMHNBRA9BNRTKPMJKXFXKVSFCRWXXUSTQILR9MZUUU9DPGCLUHJUKXNODDPBALLBKOS"), 18166864596586L);
        initialState.put(new Hash("NELLAKAGRONHIJXSCCDGHHJLDGXBYNAGIIBSEOCHPNIZVMBUJYIQ9SKIAV9YWDQLZIUTVMNXNFL9DG9QU"), 18166864596586L);
        initialState.put(new Hash("PKLSKZUONSTGYGGZHBF9BGNHRDEPSFWKXYLCBQVLQFQCQXVDJMEBXTDKQIKWDXYCEGYB9LXITHBZCILHK"), 18166864596586L);
        initialState.put(new Hash("SOPXM9ZKPJTFTYJSKA9VGKXR9CLRAAEOOHJNGKEAUJF9YZTGGGPJLNZBTWKVCBGUBBZPTDAIKYUUHKSEQ"), 18166864596586L);
        initialState.put(new Hash("YAPXPERJMWKWWDNENDTSPRLRLIDNNFIVYFBLPNXQERNTXTVGR9BYMRPHOXTQAMR9J9JZYPJDYWIIAYLWG"), 18166864596586L);
        initialState.put(new Hash("KFY9ADMTYONUSGNTVGJNOWMONSZEAAIFDSAQSDJRNLIRQICESRNWKFOAGPWSIRXJUDZTDAQP9BDOAXPLL"), 18166864596586L);
        initialState.put(new Hash("EVWHFXP9HPKKTEFYOAOYJSQWJYWMFNREANBBBCXTJR9JHIUCNHCCUNZQKOLBMJYLQBLNJUWOWPNIRTKHW"), 18166864596586L);
        initialState.put(new Hash("PSSTFS9LRFBAAGFOQX9BBRGWMMIVKGDDSEGEIYRZFXJRDEXUNUVXPXUTESNGMVWZ9NWTOQMBVKNYWQUI9"), 18166864596586L);
        initialState.put(new Hash("XNGE9HYDQZJNGWQTWCQKFZTCUUHHAKGPATSPENZIQZDVDFVDYKTCXDRGKXMQESLCN9ED9ITADEDSHMMWP"), 18166864596586L);
        initialState.put(new Hash("OCYYKOTCVKTJRHSJIZDKTCVWPUHUKCJWKISUWKSMXEDAR9FZNCBUXLXNDAKXCPSIYGKNUETHINIVQPEVE"), 18166864596586L);
        initialState.put(new Hash("9QFBMYJLZKOXXYMIXQLZB9FNUWJXENJWHFMVKFKDZZF9CRVABYCEQRJDEBDUDHMQRKFDIGC9BJWUBRQAY"), 18166864596586L);
        initialState.put(new Hash("OWHFOGNENMIKETFZATJW9FHCYOTZWULCVIMEWMQLVJBOYKJOL99QYTKTHXDVSYSCBIPQEIHPPIAADRHC9"), 18166864596586L);
        initialState.put(new Hash("IHOILPGYYLVDIWEQDRAYN9OARWPOHRKNUFVFUAPHJTLDME9TQIBLNHZECRZCACYGSIDTKUPIW9TCPWVHU"), 18166864596586L);
        initialState.put(new Hash("KKFHUGMECIEBLZOQLGASQBKRUNNLTHXP9HPKBGCDFQZ9QX99GPJMNUQNDQLKQTFEKBWSWAXGOKPZLUBRM"), 18166864596586L);
        initialState.put(new Hash("JKRQKCQDEWVAQFQMHIXRPETOJHRXEBXHBMBBSAJCZWF9YANUZRVSPOVYMWQQNFBRVMJBUBAGNAXRXDNTW"), 18166864596586L);
        initialState.put(new Hash("TXEGYQAAWCQUXABDD9QKLOQYRNJHBHIZLXBTQXKQCSDKNNBXHSYNUEELVVMJRELRUYX9TXVNLAZCIYZOU"), 18166864596586L);
        initialState.put(new Hash("BE9SXTZSXUQQHTJSLDJXBPPLXTXEBLSZEQWWYNVMUKAHVMFHEUZEKIJGIOIJZEJIHSFOWYKRFRMJVDLRR"), 18166864596586L);
        initialState.put(new Hash("HYWVWYCKAUPFRRFOPYQCSAAEYWGFDLYSX9KENDIPKVYRCXSOXTSERSBVLEGBBBZEFAYGJZZBLPHVLKRJH"), 18166864596586L);
        initialState.put(new Hash("XPHHBCJLZFPJTAXG9XFVWBFMQ9UKVYPRXSVLRYXVIQOWUFMVXPBALPGNRXFWXRDULCWMJY9REMGWINKDU"), 18166864596586L);
        initialState.put(new Hash("EOUJSFFWRJEOKFAOPMGNSJQSXDWWHHBKPYXF9ALMENJ9PKDQQMQHXZDZVRSNCWDWULGT9VTTBCYPJNTMI"), 18166864596586L);
        initialState.put(new Hash("ZAMTBUHOETHOOFSCJXOLJCOBJZXIYOOJZMNNWWUIKAPLKVCMUFCCHA9JNCBPVJAZHCAY9JBIYJUDNMBBZ"), 18166864596586L);
        initialState.put(new Hash("LTIK9MTETWOPOEPHEWBZDVLFVBXQLJUVQOUPXGQRWEFQVWXMKHTAKI9RWJQRBMVJQCISFLSMDWRDIDVNC"), 18166864596586L);
        initialState.put(new Hash("DLPNMEHFUSVMYNOHTFGASLGWXEKLYLHVQBNVZY9HVVJDJIGHTRXLVYSISCVOZKBBRGBPUWSDAY9XRSGWK"), 18166864596586L);
        initialState.put(new Hash("UQNAYTNDXBIOIGZPJPDVSZHLBOBVLMRAHHWFFMHPTVNOGNYWO9AISARBGTJNOSPZDAVQAXWMTBMHGGTZT"), 18166864596586L);
        initialState.put(new Hash("LQBYCQDCIDVYONUXVISFQFUULQOA9NSCZAISXCQVGLBSGMTBWHLQKNWFD9AVVLARANGAGQ9FPYXGDGSHT"), 18166864596586L);
        initialState.put(new Hash("CUHCPSCENHMB9IGXWBROLZQZWRWLHJUGUCGKUEIECJVM9MBH9N9HZKQNGDMOM9CZTGENRGDPTFPQDUVJR"), 18166864596586L);
        initialState.put(new Hash("IRPKFVPOMZDPAWXIDOTBGLZDSKNMCSMMTCMNYSCFWYDMXKNITSKKTDX9BEKXCALMXGPGMNUIVRFANGXMH"), 18166864596586L);
        initialState.put(new Hash("ZXRSC9YDEFGOZNMF9WUYHEUJC9FCCMRCYHBPDYNLTBP9NHHJBBWIJRBA9MWVMFEERKRULTLVTJTVTDUZI"), 18166864596586L);
        initialState.put(new Hash("FZRND9KLWEDCNTGTZQHGCERXDHVRLBAIXARKZOLVABFBSWEXEMZRQBJ9ZTUJBVATVWZOPUCZMBXCRWGIY"), 18166864596586L);
        initialState.put(new Hash("SCA9DRXSRDQQFXGZAUIXWJKHQABHGCWRJBBEPONWUNCCZFHUYYSHZEXXIC9NLKKXWHWZJDARWRN9VWEJN"), 18166864596586L);
        initialState.put(new Hash("WEALKN9RKKAHHQRRBCAXJNLCZCVAVDCZQILSLECERHPFWJGHBAHPCHVJC99UNHHLOK9YKPAJATXMVGFGQ"), 18166864596586L);
        initialState.put(new Hash("A9BUEZLGPSPBMXVCKCKHMNGVCSFQGQCRCDWSEP9IZXBKJJKNMUQEK9MO9BGOW9MSSOSMUVCLWCWGJCYCX"), 18166864596586L);
        initialState.put(new Hash("99UIBIGBHGHSDTXJVXHJPME9ZAGCKFVNLVOMLAIYA9IJEKSQZQBDJTT9YRQJKNPGD9SXNTNRPSLKXICRQ"), 18166864596586L);
        initialState.put(new Hash("BPWNRFYHIDDVEHUFYJDVGNXIW9HDPRPETDFOLTCLYG9RWXHTZZAMMHMFXFONDMKPLQKHTXENAWCEDXBAP"), 18166864596586L);
        initialState.put(new Hash("HYFZRUIHOQWVESZAHAWFHDQXEND9OPFIS9ZW9KPDYAPQOJBOMGVHJXKHXDMDXCI9YBTMDL9XDPOGNXIJJ"), 18166864596586L);
        initialState.put(new Hash("SPJWWTBQIUUVQGR9MWUNDX9LGWDCGADECRBVHFGQMBZNPNWWOUE9OGBPMKAVHP9QLCKLATKTCWFVZ9GMR"), 18166864596586L);
        initialState.put(new Hash("CBXJEMNDLJI9OKDLVPFQNECBUSULNYAHDYTGYLAPU9NCNQLFDWABEIX99YEMUCT9WQRTGTPXFXFXOFAZH"), 18166864596586L);
        initialState.put(new Hash("PYBM9UUM9YDEUPWEXJUVJSYVGYBMCCEVAERWBYCULLSFZGFWHY99LEGYQLHOJEHNSPRIOGSKYPOOJXB9J"), 18166864596586L);
        initialState.put(new Hash("PDCQQXKJCANEJXKYPUDUQBZCEVTCZBAXXWMFEDUIBCTBOVIRZGODBOPKXSVJEIZZMPGXCURZOCHCFGSKY"), 18166864596586L);
        initialState.put(new Hash("WOVBUDXENXFZBVQYEOCAPWXWKRR9FNSCNXXYAPNSYHMJMSFRSXMOOYKZVBJPSMAPP99DFWNYYQBVYYYAX"), 18166864596586L);
        initialState.put(new Hash("VDAJREDTHRGSOIHLNOJUECCFETOTHCLNYEEXPIZPH9C9IWAQUCXMCLPCOWORXZMRJLVJQMYDTAMQVINHF"), 18166864596586L);
        initialState.put(new Hash("XLQ9SYDCKUAMSCQJBBPIHXUKKXYMDXDCRHUJDGKTNERAITDIADCU9WMSEQGKULRETHWAH9IRQTXZIYYMR"), 18166864596586L);
        initialState.put(new Hash("WGAVHI9ZKFKUBOJKSOHRQAX9CAXEBSYZQISAVLUMBGMQEGUGFUGQRGUQPKVXBBYLLMUTFRJRLFAVLNZNX"), 18166864596586L);
        initialState.put(new Hash("DVPJMNEWNBX9OTRIVJWRZURLRWTYYVLKZEUOHGHNXY9OWDLDENHNOIFDED9PXOSTEEKFLAJRKKRRUNHDG"), 18166864596586L);
        initialState.put(new Hash("IKEB9OQNTZBNUEMJYPOESKUPYYDUFIFTKFSWZ9A9OWWRVVKNVEVEWROIR9XAXDRWFAYWBIRTOZMUZG9FB"), 18166864596586L);
        initialState.put(new Hash("TUITVSUODIHTSENQINWHY9ZMNENSJEQUIXSSUSWJBGIBLYCGSRMGWGOEAUXAAVGIJCXYKIBXLOUORKFFO"), 18166864596586L);
        initialState.put(new Hash("EOGGBGBIPMUGVOGGWDVCFXTBNJMYOROQKQOUKZQAUNPVYZGME9XWALKLK9AEIDOKRYQBVYSNEMDCXAVVC"), 18166864596586L);
        initialState.put(new Hash("ESKJOWWRCMQDIBX9VJBR9UIUDRWTMQPIUK9ZZKQRNCPSAYTMQCOB9EHYTPACZHCMHCBZYUAKDHKYYNMZP"), 18166864596586L);


        latestSnapshot = new Snapshot(initialState, 0);
        initialSnapshot = new Snapshot(latestSnapshot);
    }

    public static final Object latestSnapshotSyncObject = new Object();
    private final Map<Hash, Long> state;
    private int index;

    public int index() {
        return index;
    }

    public Snapshot(Snapshot snapshot) {
        state = new HashMap<>(snapshot.state);
        this.index = snapshot.index;
    }

    private Snapshot(Map<Hash, Long> initialState, int index) {
        state = new HashMap<>(initialState);
        this.index = index;
    }

    public Map<Hash, Long> getState() {
        return state;
    }

    public Map<Hash, Long> diff(Map<Hash, Long> newState) {
        return newState.entrySet().parallelStream()
                .map(hashLongEntry ->
                        new HashMap.SimpleEntry<>(hashLongEntry.getKey(),
                                hashLongEntry.getValue() -
                                        (state.containsKey(hashLongEntry.getKey()) ?
                                                state.get(hashLongEntry.getKey()): 0) ))
                .filter(e -> e.getValue() != 0L)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Snapshot patch(Map<Hash, Long> diff, int index) {
        Map<Hash, Long> patchedState = state.entrySet().parallelStream()
                .map( hashLongEntry ->
                        new HashMap.SimpleEntry<>(hashLongEntry.getKey(),
                                hashLongEntry.getValue() +
                                        (diff.containsKey(hashLongEntry.getKey()) ?
                                         diff.get(hashLongEntry.getKey()) : 0)) )
                .filter(e -> e.getValue() != 0L)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        diff.entrySet().stream()
                .filter(e -> e.getValue() > 0L)
                .forEach(e -> patchedState.putIfAbsent(e.getKey(), e.getValue()));
        return new Snapshot(patchedState, index);
    }

    void merge(Snapshot snapshot) {
        state.clear();
        state.putAll(snapshot.state);
        index = snapshot.index;
    }

    boolean isConsistent() {
        long stateValue = state.values().stream().reduce(Math::addExact).orElse(Long.MAX_VALUE);
        if(stateValue != TransactionViewModel.SUPPLY) {
            long difference = TransactionViewModel.SUPPLY - stateValue;
            log.error("Ledger balance incorrect: " + difference);
            return false;
        }
        final Iterator<Map.Entry<Hash, Long>> stateIterator = state.entrySet().iterator();
        while (stateIterator.hasNext()) {

            final Map.Entry<Hash, Long> entry = stateIterator.next();
            if (entry.getValue() <= 0) {

                if (entry.getValue() < 0) {
                    log.info("Skipping negative value for address: " + entry.getKey() + ": " + entry.getValue());
                    return false;
                }

                stateIterator.remove();
            }
            //////////// --Coo only--
                /*
                 * if (entry.getValue() > 0) {
                 *
                 * System.out.ln("initialState.put(new Hash(\"" + entry.getKey()
                 * + "\"), " + entry.getValue() + "L);"); }
                 */
            ////////////
        }
        return true;
    }
}
