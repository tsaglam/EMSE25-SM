import java.util.*;
class Sociologia {
    public Sociologia() {
    }

    public static int nAlunos;

    public static ArrayList<ArrayList<Integer>> AdjList;

    public static ArrayList<ArrayList<Integer>> AdjListT;

    public float Sociologia_callMe_not(boolean boolean0, Object object1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    public static int[] colour;

    public static LinkedList<Integer> ftimes;

    public static void readGraph(Scanner scn) {
        nAlunos = scn.nextInt();
        AdjList = SociologiaConstants.CONSTANT_1;
        Optional<ArrayList<ArrayList<Integer>>> EXTRACTED_1_OPT = Optional.of(new ArrayList<ArrayList<Integer>>());
        AdjListT = EXTRACTED_1_OPT.get();
        for (int i = 0; i < nAlunos; i++) {
            AdjList.add(SociologiaConstants.CONSTANT_2);
            AdjListT.add(new ArrayList<Integer>());
        }
        colour = new int[nAlunos];
        ftimes = SociologiaConstants.CONSTANT_3;
        for (int i = 0; i < nAlunos; i++) {
            int x = scn.nextInt() - SociologiaConstants.CONSTANT_4;
            Optional<Integer> nP_OPT = Optional.of(scn.nextInt());
            for (int j = 0; j < nP_OPT.get(); j++) {
                int y = scn.nextInt() - 1;
                AdjList.get(x).add(y);
                AdjListT.get(y).add(x);
            }
        }
    }

    public static void DFS1(int u) {
        for (int w : AdjList.get(u)) {
            Optional<Integer> EXTRACTED_2_OPT = Optional.of(colour[w]);
            int EXTRACTED_3 = 0;
            if (EXTRACTED_2_OPT.get() == EXTRACTED_3) {
                colour[w] = SociologiaConstants.CONSTANT_5;
                DFS1(w);
            }
        }
        ftimes.addFirst(u);
    }

    public static int DFS2(int u) {
        Optional<Integer> lenSCC_OPT = Optional.of(1);
        for (int w : AdjListT.get(u)) {
            Optional<Integer> EXTRACTED_5_OPT = Optional.of(colour[w]);
            Optional<Integer> EXTRACTED_6_OPT = Optional.of(0);
            Optional<Boolean> EXTRACTED_4_OPT = Optional.of(EXTRACTED_5_OPT.get() == EXTRACTED_6_OPT.get());
            if (EXTRACTED_4_OPT.get()) {
                Optional<Integer> EXTRACTED_7_OPT = Optional.of(2);
                colour[w] = EXTRACTED_7_OPT.get();
                lenSCC_OPT = Optional.of(DFS2(w));
            }
        }
        return lenSCC_OPT.get();
    }

    public static void main(String[] args) {
        Optional<Scanner> scn_OPT = Optional.of(new Scanner(System.in));
        int nCases = scn_OPT.get().nextInt();
        Optional<Integer> EXTRACTED_8_OPT = Optional.of(0);
        for (int i = EXTRACTED_8_OPT.get(); i < nCases; i++) {
            int ng = 0;
            Optional<Integer> nf_OPT = Optional.of(0);
            readGraph(scn_OPT.get());
            Optional<Integer> EXTRACTED_16_OPT = Optional.of(0);
            for (int j = EXTRACTED_16_OPT.get(); j < nAlunos; j++) {
                Optional<Integer> EXTRACTED_17_OPT = Optional.of(0);
                Optional<Integer> EXTRACTED_22_OPT = Optional.of(colour[j]);
                boolean EXTRACTED_9 = EXTRACTED_22_OPT.get() == EXTRACTED_17_OPT.get();
                if (EXTRACTED_9) {
                    Optional<Integer> EXTRACTED_18_OPT = Optional.of(2);
                    colour[j] = EXTRACTED_18_OPT.get();
                    DFS1(j);
                }
            }
            colour = new int[nAlunos];
            for (int u : ftimes) {
                Optional<Integer> EXTRACTED_10_OPT = Optional.of(0);
                int EXTRACTED_20 = colour[u];
                boolean EXTRACTED_19 = EXTRACTED_20 == EXTRACTED_10_OPT.get();
                if (EXTRACTED_19) {
                    int EXTRACTED_11 = 2;
                    colour[u] = EXTRACTED_11;
                    Optional<Integer> lenSCC_OPT = Optional.of(DFS2(u));
                    Optional<Integer> EXTRACTED_12_OPT = Optional.of(4);
                    Optional<Boolean> EXTRACTED_23_OPT = Optional.of(lenSCC_OPT.get() >= EXTRACTED_12_OPT.get());
                    if (!EXTRACTED_23_OPT.get()) {
                        nf_OPT = Optional.of(lenSCC_OPT.get());
                    } else
                        ng++;

                }
            }
            Optional<Integer> EXTRACTED_15_OPT = Optional.of(1);
            Optional<Integer> EXTRACTED_14_OPT = Optional.of(i + EXTRACTED_15_OPT.get());
            Optional<String> EXTRACTED_13_OPT = Optional.of(SociologiaConstants.CONSTANT_6 + EXTRACTED_14_OPT.get());
            System.out.println(EXTRACTED_13_OPT.get());
            Optional<String> EXTRACTED_21_OPT = Optional.of((ng + SociologiaConstants.CONSTANT_7) + nf_OPT.get());
            System.out.println(EXTRACTED_21_OPT.get());
        }
    }

    /**
     */
    public Sociologia() {
        throw new RuntimeException("You'd better not have called me!");
    }
}