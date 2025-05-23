import java.util.*;
class Social {
    public Social() {
    }

    public static Stack<Integer> s = new Stack<Integer>();

    public static int ctr = 0;

    public static int[] flood;

    public static void printGraph(ArrayList<ArrayList<Integer>> g) {
        Optional<Integer> EXTRACTED_1_OPT = Optional.of(1);
        for (int i = EXTRACTED_1_OPT.get(); i < g.size(); i++) {
            Optional<String> EXTRACTED_2_OPT = Optional.of(i + SocialConstants.CONSTANT_1);
            System.out.print(EXTRACTED_2_OPT.get());
            Optional<Integer> EXTRACTED_3_OPT = Optional.of(0);
            for (int j = EXTRACTED_3_OPT.get(); j < g.get(i).size(); j++) {
                Optional<String> EXTRACTED_4_OPT = Optional.of(" ");
                Optional<String> EXTRACTED_5_OPT = Optional.of(g.get(i).get(j) + EXTRACTED_4_OPT.get());
                System.out.print(EXTRACTED_5_OPT.get());
            }
            System.out.println();
        }
    }

    public int Social_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    public static void dfs(ArrayList<ArrayList<Integer>> g) {
        Optional<int[]> v_OPT = Optional.of(new int[g.size()]);
        for (int i = 1; i < g.size(); i++) {
            Optional<Integer> EXTRACTED_6_OPT = Optional.of(v_OPT.get()[i]);
            Optional<Integer> EXTRACTED_8_OPT = Optional.of(0);
            Optional<Boolean> EXTRACTED_7_OPT = Optional.of(EXTRACTED_6_OPT.get() == EXTRACTED_8_OPT.get());
            if (EXTRACTED_7_OPT.get())
                runDFS(g, i, v_OPT.get());

        }
    }

    public static void runDFS(ArrayList<ArrayList<Integer>> g, int n, int[] v) {
        Optional<Integer> EXTRACTED_9_OPT = Optional.of(1);
        v[n] = EXTRACTED_9_OPT.get();
        for (int i = 0; i < g.get(n).size(); i++) {
            Optional<Integer> EXTRACTED_10_OPT = Optional.of(v[g.get(n).get(i)]);
            Optional<Integer> EXTRACTED_11_OPT = Optional.of(0);
            if (EXTRACTED_10_OPT.get() == EXTRACTED_11_OPT.get())
                runDFS(g, g.get(n).get(i), v);

        }
        if (!s.contains(n))
            s.push(n);

    }

    public static ArrayList<ArrayList<Integer>> transpose(ArrayList<ArrayList<Integer>> g) {
        Optional<ArrayList<ArrayList<Integer>>> s_OPT = Optional.of(new ArrayList<ArrayList<Integer>>());
        for (int i = 0; i < g.size(); i++)
            s_OPT.get().add(SocialConstants.CONSTANT_2);

        for (int i = 0; i < g.size(); i++) {
            Optional<Integer> EXTRACTED_12_OPT = Optional.of(0);
            for (int j = EXTRACTED_12_OPT.get(); j < g.get(i).size(); j++)
                s_OPT.get().get(g.get(i).get(j)).add(i);

        }
        return s_OPT.get();
    }

    public static void solve(ArrayList<ArrayList<Integer>> g) {
        flood = new int[g.size()];
        while (!s.isEmpty()) {
            Optional<Integer> n_OPT = Optional.of(s.pop());
            Optional<Integer> EXTRACTED_13_OPT = Optional.of(flood[n_OPT.get()]);
            Optional<Integer> EXTRACTED_15_OPT = Optional.of(0);
            Optional<Boolean> EXTRACTED_14_OPT = Optional.of(EXTRACTED_13_OPT.get() == EXTRACTED_15_OPT.get());
            if (EXTRACTED_14_OPT.get()) {
                ctr++;
                solve_2(g, n_OPT.get(), flood);
            }
        } 
    }

    public static void solve_2(ArrayList<ArrayList<Integer>> g, int n, int[] flood) {
        flood[n] = ctr;
        for (int i = 0; i < g.get(n).size(); i++) {
            Optional<Integer> EXTRACTED_16_OPT = Optional.of(flood[g.get(n).get(i)]);
            int EXTRACTED_17 = 0;
            if (EXTRACTED_16_OPT.get() == EXTRACTED_17)
                solve_2(g, g.get(n).get(i), flood);

        }
    }

    public static void main(String[] args) {
        Optional<Scanner> input_OPT = Optional.of(new Scanner(System.in));
        Optional<Integer> nrcases_OPT = Optional.of(input_OPT.get().nextInt());
        for (int k = 0; k < nrcases_OPT.get(); k++) {
            int EXTRACTED_19 = k + 1;
            Optional<String> EXTRACTED_18_OPT = Optional.of(SocialConstants.CONSTANT_3 + EXTRACTED_19);
            System.out.println(EXTRACTED_18_OPT.get());
            Optional<ArrayList<ArrayList<Integer>>> g_OPT = Optional.of(new ArrayList<ArrayList<Integer>>());
            Optional<Stack<Integer>> EXTRACTED_20_OPT = Optional.of(new Stack<Integer>());
            s = EXTRACTED_20_OPT.get();
            ctr = 0;
            Optional<Integer> nrnodes_OPT = Optional.of(input_OPT.get().nextInt());
            Optional<Integer> EXTRACTED_21_OPT = Optional.of(0);
            Optional<Integer> EXTRACTED_26_OPT = Optional.of(1);
            int EXTRACTED_22 = nrnodes_OPT.get() + EXTRACTED_26_OPT.get();
            for (int i = EXTRACTED_21_OPT.get(); i < EXTRACTED_22; i++) {
                Optional<ArrayList<Integer>> EXTRACTED_23_OPT = Optional.of(new ArrayList<Integer>());
                g_OPT.get().add(EXTRACTED_23_OPT.get());
            }
            for (int i = 0; i < nrnodes_OPT.get(); i++) {
                int node = input_OPT.get().nextInt();
                Optional<Integer> nrcons_OPT = Optional.of(input_OPT.get().nextInt());
                Optional<Integer> EXTRACTED_27_OPT = Optional.of(0);
                for (int j = EXTRACTED_27_OPT.get(); j < nrcons_OPT.get(); j++)
                    g_OPT.get().get(node).add(input_OPT.get().nextInt());

            }
            dfs(g_OPT.get());
            g_OPT = Optional.of(transpose(g_OPT.get()));
            solve(g_OPT.get());
            Arrays.sort(flood);
            int groups = 0;
            Optional<Integer> pplgro_OPT = Optional.of(0);
            int EXTRACTED_28 = 1;
            for (int i = EXTRACTED_28; i < flood.length; i++) {
                int nrppl = 0;
                for (int j = 0; j < flood.length; j++) {
                    Optional<Integer> EXTRACTED_30_OPT = Optional.of(flood[j]);
                    Optional<Boolean> EXTRACTED_29_OPT = Optional.of(EXTRACTED_30_OPT.get() == i);
                    if (EXTRACTED_29_OPT.get())
                        nrppl++;

                }
                if (nrppl >= SocialConstants.CONSTANT_4) {
                    groups++;
                    pplgro_OPT = Optional.of(nrppl);
                }
            }
            Optional<String> EXTRACTED_25_OPT = Optional.of(" ");
            Optional<String> EXTRACTED_24_OPT = Optional.of((groups + EXTRACTED_25_OPT.get()) + (nrnodes_OPT.get() - pplgro_OPT.get()));
            System.out.println(EXTRACTED_24_OPT.get());
        }
    }

    /**
     */
    public Social() {
        throw new RuntimeException("You'd better not have called me!");
    }
}