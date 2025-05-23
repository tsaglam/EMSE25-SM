import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
public class Sociologia {
    public Sociologia() {
    }

    public static int nCountElem = 0;

    public int Sociologia_callMe_not(int int0, int int1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    public static void main(String[] args) {
        Optional<Scanner> EXTRACTED_1_OPT = Optional.of(new Scanner(System.in));
        Optional<Optional<Scanner>> myscan_OPT_OPT = Optional.of(Optional.of(EXTRACTED_1_OPT.get()));
        Optional<Integer> nCases_OPT = Optional.of(0);
        Optional<Optional<Integer>> nNumAlumni_OPT_OPT = Optional.of(Optional.of(0));
        int EXTRACTED_2 = 0;
        Optional<Optional<Integer>> nIdAl_OPT_OPT = Optional.of(Optional.of(EXTRACTED_2));
        int EXTRACTED_3 = 0;
        Optional<Optional<Integer>> nIdAl2_OPT_OPT = Optional.of(Optional.of(EXTRACTED_3));
        Optional<Integer> nNumFriends_OPT = Optional.of(0);
        Optional<Integer> nNumGroup_OPT = Optional.of(0);
        Optional<Optional<Integer>> nCountElem_OPT_OPT = Optional.of(Optional.of(0));
        Optional<ArrayList<Integer>> alOnAGroup_OPT = Optional.of(null);
        Optional<int[]> arVisited_OPT = Optional.of(null);
        Optional<int[][]> arGroups_OPT = Optional.of(null);
        Optional<Optional<int[][]>> arTransp_OPT_OPT = Optional.of(Optional.of(null));
        alOnAGroup_OPT = Optional.of(SociologiaConstants.CONSTANT_1);
        nCases_OPT = Optional.of(myscan_OPT_OPT.get().get().nextInt());
        for (int i = 0; i < nCases_OPT.get(); i++) {
            nNumAlumni_OPT_OPT = Optional.of(Optional.of(myscan_OPT_OPT.get().get().nextInt()));
            Optional<int[][]> EXTRACTED_1_OPT = Optional.of(new int[nNumAlumni_OPT_OPT.get().get()][nNumAlumni_OPT_OPT.get().get()]);
            arGroups_OPT = Optional.of(EXTRACTED_1_OPT.get());
            int[][] EXTRACTED_2 = new int[nNumAlumni_OPT_OPT.get().get()][nNumAlumni_OPT_OPT.get().get()];
            arTransp_OPT_OPT = Optional.of(Optional.of(EXTRACTED_2));
            int[] EXTRACTED_5 = new int[nNumAlumni_OPT_OPT.get().get()];
            Optional<int[]> EXTRACTED_3_OPT = Optional.of(EXTRACTED_5);
            arVisited_OPT = Optional.of(EXTRACTED_3_OPT.get());
            Optional<Integer> EXTRACTED_12_OPT = Optional.of(0);
            for (int j = EXTRACTED_12_OPT.get(); j < nNumAlumni_OPT_OPT.get().get(); j++) {
                nIdAl_OPT_OPT = Optional.of(Optional.of(myscan_OPT_OPT.get().get().nextInt()));
                nNumFriends_OPT = Optional.of(myscan_OPT_OPT.get().get().nextInt());
                int EXTRACTED_4 = 0;
                for (int k = EXTRACTED_4; k < nNumFriends_OPT.get(); k++) {
                    nIdAl2_OPT_OPT = Optional.of(Optional.of(myscan_OPT_OPT.get().get().nextInt()));
                    Optional<Integer> EXTRACTED_10_OPT = Optional.of(nIdAl_OPT_OPT.get().get() - SociologiaConstants.CONSTANT_2);
                    Optional<Optional<Integer>> EXTRACTED_6_OPT_OPT = Optional.of(Optional.of(EXTRACTED_10_OPT.get()));
                    Optional<int[]> EXTRACTED_6_OPT = Optional.of(arGroups_OPT.get()[EXTRACTED_6_OPT_OPT.get().get()]);
                    Optional<int[]> EXTRACTED_5_OPT = Optional.of(EXTRACTED_6_OPT.get());
                    Optional<Optional<Integer>> EXTRACTED_13_OPT_OPT = Optional.of(Optional.of(SociologiaConstants.CONSTANT_1));
                    int EXTRACTED_14 = 1;
                    Optional<Integer> EXTRACTED_14_OPT = Optional.of(nIdAl2_OPT_OPT.get().get() - EXTRACTED_13_OPT_OPT.get().get());
                    Optional<Optional<Integer>> EXTRACTED_16_OPT_OPT = Optional.of(Optional.of(EXTRACTED_14_OPT.get()));
                    EXTRACTED_5_OPT.get()[EXTRACTED_16_OPT_OPT.get().get()] = EXTRACTED_14_OPT.get();
                    Optional<Integer> EXTRACTED_11_OPT = Optional.of(1);
                    Optional<Optional<Integer>> EXTRACTED_9_OPT_OPT = Optional.of(Optional.of(EXTRACTED_11_OPT.get()));
                    Optional<Integer> EXTRACTED_7_OPT = Optional.of(nIdAl2_OPT_OPT.get().get() - EXTRACTED_9_OPT_OPT.get().get());
                    Optional<Optional<Integer>> EXTRACTED_8_OPT_OPT = Optional.of(Optional.of(EXTRACTED_7_OPT.get()));
                    Optional<int[]> EXTRACTED_12_OPT = Optional.of(arTransp_OPT_OPT.get().get()[EXTRACTED_8_OPT_OPT.get().get()]);
                    Optional<int[]> EXTRACTED_7_OPT = Optional.of(EXTRACTED_12_OPT.get());
                    Optional<Integer> EXTRACTED_8_OPT = Optional.of(1);
                    Optional<Integer> EXTRACTED_15_OPT = Optional.of(EXTRACTED_8_OPT.get());
                    int EXTRACTED_13 = 1;
                    int EXTRACTED_9 = nIdAl_OPT_OPT.get().get() - EXTRACTED_13;
                    EXTRACTED_7_OPT.get()[EXTRACTED_9] = EXTRACTED_15_OPT.get();
                }
            }
            for (int l = 0; l < nNumAlumni_OPT_OPT.get().get(); l++) {
                Optional<Integer> EXTRACTED_4_OPT = Optional.of(0);
                Optional<Integer> EXTRACTED_10_OPT = Optional.of(EXTRACTED_4_OPT.get());
                arVisited_OPT.get()[l] = EXTRACTED_10_OPT.get();
            }
            Optional<ArrayList<Integer>> EXTRACTED_11_OPT = Optional.of(new ArrayList<Integer>());
            alOnAGroup_OPT = Optional.of(EXTRACTED_11_OPT.get());
            CC(arGroups_OPT.get(), arVisited_OPT.get());
            CC_Transp(nNumGroup_OPT.get(), arTransp_OPT_OPT.get().get(), arVisited_OPT.get(), alOnAGroup_OPT.get(), i);
        }
    }

    public static void CC(int[][] arGroups, int[] arVisited) {
        Optional<Optional<Integer>> EXTRACTED_17_OPT_OPT = Optional.of(Optional.of(0));
        for (int i = EXTRACTED_17_OPT_OPT.get().get(); i < arVisited.length; i++) {
            Optional<Integer> EXTRACTED_15_OPT = Optional.of(0);
            Optional<Optional<Integer>> EXTRACTED_18_OPT_OPT = Optional.of(Optional.of(EXTRACTED_15_OPT.get()));
            Optional<Integer> EXTRACTED_17_OPT = Optional.of(arVisited[i]);
            Optional<Boolean> EXTRACTED_16_OPT = Optional.of(EXTRACTED_17_OPT.get() == EXTRACTED_18_OPT_OPT.get().get());
            Optional<Optional<Boolean>> EXTRACTED_19_OPT_OPT = Optional.of(Optional.of(EXTRACTED_16_OPT.get()));
            if (EXTRACTED_19_OPT_OPT.get().get()) {
                DFS(arGroups, arVisited, i);
            }
        }
    }

    public static void CC_Transp(int nNumGroup, int[][] arGroups, int[] arVisited, ArrayList<Integer> alOnAGroup, int nCase) {
        Optional<Integer> nDummy_OPT = Optional.of(0);
        Optional<Optional<Integer>> EXTRACTED_20_OPT_OPT = Optional.of(Optional.of(0));
        for (int i = EXTRACTED_20_OPT_OPT.get().get(); i < arVisited.length; i++) {
            int EXTRACTED_18 = arVisited[i];
            Optional<Optional<Integer>> EXTRACTED_22_OPT_OPT = Optional.of(Optional.of(EXTRACTED_18));
            Optional<Boolean> EXTRACTED_25_OPT = Optional.of(EXTRACTED_22_OPT_OPT.get().get() < SociologiaConstants.CONSTANT_3);
            Optional<Optional<Boolean>> EXTRACTED_21_OPT_OPT = Optional.of(Optional.of(EXTRACTED_25_OPT.get()));
            if (EXTRACTED_21_OPT_OPT.get().get()) {
                Optional<Integer> EXTRACTED_19_OPT = Optional.of(0);
                Optional<Optional<Integer>> EXTRACTED_29_OPT_OPT = Optional.of(Optional.of(EXTRACTED_19_OPT.get()));
                nCountElem = EXTRACTED_29_OPT_OPT.get().get();
                DFS_Transp(arGroups, arVisited, alOnAGroup, i);
                Optional<Boolean> EXTRACTED_23_OPT = Optional.of(nCountElem >= SociologiaConstants.CONSTANT_4);
                boolean EXTRACTED_20 = !EXTRACTED_23_OPT.get();
                if (!EXTRACTED_20) {
                    nNumGroup++;
                } else {
                    Optional<Optional<Boolean>> EXTRACTED_24_OPT_OPT = Optional.of(Optional.of(j <= nCountElem));
                    Optional<Boolean> EXTRACTED_30_OPT = Optional.of(!alOnAGroup.isEmpty());
                    int EXTRACTED_26 = 1;
                    Optional<Optional<Integer>> EXTRACTED_32_OPT_OPT = Optional.of(Optional.of(EXTRACTED_26));
                    for (int j = EXTRACTED_32_OPT_OPT.get().get(); EXTRACTED_24_OPT_OPT.get().get() && EXTRACTED_30_OPT.get(); j++) {
                        Optional<Integer> EXTRACTED_21_OPT = Optional.of(1);
                        Optional<Optional<Integer>> EXTRACTED_31_OPT_OPT = Optional.of(Optional.of(EXTRACTED_21_OPT.get()));
                        Optional<Integer> EXTRACTED_25_OPT = Optional.of(alOnAGroup.size() - EXTRACTED_31_OPT_OPT.get().get());
                        nDummy_OPT = Optional.of(alOnAGroup.remove(EXTRACTED_25_OPT.get()));
                    }
                }
            }
        }
        int EXTRACTED_22 = nCase + 1;
        System.out.println(SociologiaConstants.CONSTANT_5 + EXTRACTED_22);
        Optional<String> EXTRACTED_23_OPT = Optional.of(nNumGroup + SociologiaConstants.CONSTANT_6);
        Optional<Optional<String>> EXTRACTED_27_OPT_OPT = Optional.of(Optional.of(EXTRACTED_23_OPT.get()));
        Optional<Integer> EXTRACTED_24_OPT = Optional.of(arVisited.length - alOnAGroup.size());
        Optional<Integer> EXTRACTED_28_OPT = Optional.of(EXTRACTED_24_OPT.get());
        Optional<Optional<String>> EXTRACTED_26_OPT_OPT = Optional.of(Optional.of(EXTRACTED_27_OPT_OPT.get().get() + EXTRACTED_28_OPT.get()));
        System.out.println(EXTRACTED_26_OPT_OPT.get().get());
    }

    public static void DFS(int[][] arGroups, int[] arVis, int n) {
        arVis[n]++;
        Optional<int[]> EXTRACTED_33_OPT = Optional.of(arGroups[n]);
        for (int i = 0; i < EXTRACTED_33_OPT.get().length; i++) {
            Optional<Integer> EXTRACTED_27_OPT = Optional.of(arVis[i]);
            Optional<Optional<Integer>> EXTRACTED_34_OPT_OPT = Optional.of(Optional.of(EXTRACTED_27_OPT.get()));
            Optional<Integer> EXTRACTED_35_OPT = Optional.of(0);
            Optional<Boolean> EXTRACTED_28_OPT = Optional.of(EXTRACTED_34_OPT_OPT.get().get() == 0);
            int EXTRACTED_30 = arGroups[n][i];
            Optional<Boolean> EXTRACTED_29_OPT = Optional.of(EXTRACTED_30 != EXTRACTED_35_OPT.get());
            Optional<Boolean> EXTRACTED_31_OPT = Optional.of(EXTRACTED_28_OPT.get() && EXTRACTED_29_OPT.get());
            Optional<Boolean> EXTRACTED_36_OPT = Optional.of(EXTRACTED_31_OPT.get());
            if (EXTRACTED_36_OPT.get())
                DFS(arGroups, arVis, i);

        }
    }

    public static void DFS_Transp(int[][] arGroups, int[] arVis, ArrayList<Integer> alOnAGroup, int n) {
        int EXTRACTED_32 = arVis[n];
        EXTRACTED_32++;
        Optional<Integer> EXTRACTED_37_OPT = Optional.of(arVis[n]);
        Optional<Integer> EXTRACTED_38_OPT = Optional.of(1);
        if (EXTRACTED_37_OPT.get() > EXTRACTED_38_OPT.get()) {
            alOnAGroup.add(n);
            nCountElem++;
        }
        int EXTRACTED_33 = 0;
        Optional<int[]> EXTRACTED_34_OPT = Optional.of(arGroups[n]);
        for (int i = EXTRACTED_33; i < EXTRACTED_34_OPT.get().length; i++) {
            Optional<Integer> EXTRACTED_40_OPT = Optional.of(arVis[i]);
            int EXTRACTED_35 = 2;
            Optional<Optional<Integer>> EXTRACTED_41_OPT_OPT = Optional.of(Optional.of(EXTRACTED_35));
            Optional<Boolean> EXTRACTED_39_OPT = Optional.of(EXTRACTED_40_OPT.get() < EXTRACTED_41_OPT_OPT.get().get());
            int[] EXTRACTED_43 = arGroups[n];
            Optional<Integer> EXTRACTED_36_OPT = Optional.of(EXTRACTED_43[i]);
            Optional<Integer> EXTRACTED_37_OPT = Optional.of(0);
            boolean EXTRACTED_42 = EXTRACTED_36_OPT.get() != EXTRACTED_37_OPT.get();
            Optional<Boolean> EXTRACTED_38_OPT = Optional.of(EXTRACTED_39_OPT.get() && EXTRACTED_42);
            if (EXTRACTED_38_OPT.get())
                DFS_Transp(arGroups, arVis, alOnAGroup, i);

        }
    }

    public int Sociologia_callMe_not(float float0, double double1) {
        throw SociologiaConstants.CONSTANT_2;
    }

    /**
     */
    public Sociologia(long long0) {
        Optional<RuntimeException> EXTRACTED_39_OPT = Optional.of(new RuntimeException("You'd better not have called me!"));
        throw EXTRACTED_39_OPT.get();
    }

    /**
     */
    public Sociologia(int int0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}