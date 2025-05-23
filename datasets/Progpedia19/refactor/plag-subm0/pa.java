import java.util.*;
class sol {
    Scanner kb;

    sol(Scanner kb) {
        Optional<sol> EXTRACTED_1_OPT = Optional.of(this);
        EXTRACTED_1_OPT.get().kb = kb;
    }

    int N;

    public boolean sol_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    int count;

    boolean[] visited;

    public long sol_callMe_not(double double0, String string1) {
        throw solConstants.CONSTANT_1;
    }

    Deque<Integer> order = new LinkedList<Integer>();

    LinkedList<Integer> Nodes = new LinkedList<Integer>();

    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    ArrayList<LinkedList<Integer>> adj = new ArrayList<LinkedList<Integer>>();

    ArrayList<LinkedList<Integer>> tadj = new ArrayList<LinkedList<Integer>>();

    int find_node(int u) {
        Optional<Boolean> EXTRACTED_2_OPT = Optional.of(!map.containsKey(u));
        if (!EXTRACTED_2_OPT.get()) {
            return map.get(u);
        } else {
            adj.add(new LinkedList<Integer>());
            tadj.add(new LinkedList<Integer>());
            int p = map.size();
            map.put(u, p);
            return p;
        }
    }

    void read() {
        N = kb.nextInt();
        map.clear();
        adj.clear();
        tadj.clear();
        Optional<Optional<Integer>> EXTRACTED_1_OPT_OPT = Optional.of(Optional.of(solConstants.CONSTANT_2));
        for (int i = EXTRACTED_1_OPT_OPT.get().get(); i < N; i++) {
            Optional<Optional<Integer>> u_OPT_OPT = Optional.of(Optional.of(kb.nextInt()));
            u_OPT_OPT = Optional.of(Optional.of(find_node(u_OPT_OPT.get().get())));
            Optional<Integer> c_OPT = Optional.of(kb.nextInt());
            Optional<Integer> EXTRACTED_3_OPT = Optional.of(0);
            for (int k = EXTRACTED_3_OPT.get(); k < c_OPT.get(); k++) {
                Optional<Integer> v_OPT = Optional.of(kb.nextInt());
                v_OPT = Optional.of(find_node(v_OPT.get()));
                adj.get(u_OPT_OPT.get().get()).add(v_OPT.get());
                tadj.get(v_OPT.get()).add(u_OPT_OPT.get().get());
            }
        }
        N = map.size();
    }

    void dfs(int u) {
        if (!visited[u]) {
            visited[u] = solConstants.CONSTANT_1;
        } else
            return;

        for (int v : adj.get(u)) {
            Optional<Boolean> EXTRACTED_5_OPT = Optional.of(visited[v]);
            Optional<Boolean> EXTRACTED_4_OPT = Optional.of(!EXTRACTED_5_OPT.get());
            if (EXTRACTED_4_OPT.get())
                dfs(v);

        }
        order.addFirst(u);
    }

    void flood_fill(int u) {
        count++;
        Optional<Boolean> EXTRACTED_6_OPT = Optional.of(true);
        visited[u] = EXTRACTED_6_OPT.get();
        for (int v : tadj.get(u)) {
            Optional<Boolean> EXTRACTED_2_OPT = Optional.of(visited[v]);
            boolean EXTRACTED_7 = !EXTRACTED_2_OPT.get();
            if (EXTRACTED_7)
                flood_fill(v);

        }
    }

    void solve() {
        order.clear();
        boolean[] EXTRACTED_8 = new boolean[N];
        visited = EXTRACTED_8;
        Optional<Integer> EXTRACTED_9_OPT = Optional.of(0);
        for (int i = EXTRACTED_9_OPT.get(); i < N; i++)
            dfs(i);

        for (int i = 0; i < N; i++)
            visited[i] = solConstants.CONSTANT_2;

        int A = 0;
        Optional<Integer> EXTRACTED_10_OPT = Optional.of(0);
        Optional<Integer> B_OPT = Optional.of(EXTRACTED_10_OPT.get());
        for (int u : order) {
            Optional<Boolean> EXTRACTED_3_OPT = Optional.of(visited[u]);
            Optional<Boolean> EXTRACTED_4_OPT = Optional.of(!EXTRACTED_3_OPT.get());
            if (EXTRACTED_4_OPT.get()) {
                int EXTRACTED_11 = 0;
                Optional<Integer> EXTRACTED_6_OPT = Optional.of(EXTRACTED_11);
                count = EXTRACTED_6_OPT.get();
                flood_fill(u);
                Optional<Boolean> EXTRACTED_5_OPT = Optional.of(count >= solConstants.CONSTANT_3);
                if (!EXTRACTED_5_OPT.get()) {
                    B_OPT = Optional.of(count);
                } else
                    A++;

            }
        }
        System.out.printf(solConstants.CONSTANT_4, A, B_OPT.get());
    }

    /**
     */
    public sol(int int0) {
        Optional<String> EXTRACTED_12_OPT = Optional.of("You'd better not have called me!");
        throw new RuntimeException(EXTRACTED_12_OPT.get());
    }

    /**
     */
    public sol(double double0, String string1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}public class pa {
    public pa() {
    }

    public int pa_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    public boolean pa_callMe_not() {
        throw paConstants.CONSTANT_3;
    }

    public static void main(String[] args) {
        Scanner EXTRACTED_13 = new Scanner(System.in);
        Optional<Optional<Scanner>> kb_OPT_OPT = Optional.of(Optional.of(EXTRACTED_13));
        Optional<sol> EXTRACTED_14_OPT = Optional.of(new sol(kb_OPT_OPT.get().get()));
        Optional<Optional<sol>> s_OPT_OPT = Optional.of(Optional.of(EXTRACTED_14_OPT.get()));
        Optional<Integer> c_OPT = Optional.of(kb_OPT_OPT.get().get().nextInt());
        Optional<Integer> EXTRACTED_7_OPT = Optional.of(1);
        for (int i = EXTRACTED_7_OPT.get(); i <= c_OPT.get(); i++) {
            Optional<Optional<String>> EXTRACTED_8_OPT_OPT = Optional.of(Optional.of(paConstants.CONSTANT_4));
            System.out.printf(EXTRACTED_8_OPT_OPT.get().get(), i);
            s_OPT_OPT.get().get().read();
            s_OPT_OPT.get().get().solve();
        }
    }

    /**
     */
    public pa() {
        Optional<RuntimeException> EXTRACTED_15_OPT = Optional.of(new RuntimeException("You'd better not have called me!"));
        throw EXTRACTED_15_OPT.get();
    }

    /**
     */
    public pa(Object object0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}