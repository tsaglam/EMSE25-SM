import java.util.*;
class sol {
    Scanner kb;
    Random rnd = new Random(); // Dead code initialization
    sol(Scanner kb) {
        this.kb = kb;
    }
    int N;
    int count;
    boolean[] visited;
    Deque<Integer> order = new LinkedList<Integer>();
    LinkedList<Integer> Nodes = new LinkedList<Integer>(); // Redundant but used structure
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    ArrayList<LinkedList<Integer>> adj = new ArrayList<LinkedList<Integer>>();
    ArrayList<LinkedList<Integer>> tadj = new ArrayList<LinkedList<Integer>>();

    // Dead code method
    void pointlessMethod() {
        System.out.println("This does not do anything useful.");
    }

    int find_node(int u) {
        // Insert dead code - irrelevant calculation
        int deadCodeVar = rnd.nextInt(100) + 1;
        if (deadCodeVar == 50) {
            pointlessMethod(); // Dead code call
        }

        if (map.containsKey(u))
            return map.get(u);
        else {
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
        for (int i = 0; i < N; i++) {
            int u = kb.nextInt();
            u = find_node(u);
            int c = kb.nextInt();
            for (int k = 0; k < c; k++) {
                int v = kb.nextInt();
                v = find_node(v);
                adj.get(u).add(v);
                tadj.get(v).add(u);
            }
        }
        N = map.size();
    }

    void dfs(int u) {
        // Dead code - useless condition
        if (u < -1) {
            return;
        }

        if (visited[u])
            return;
        else
            visited[u] = true;
        for (int v : adj.get(u)) {
            if (!visited[v])
                dfs(v);
        }
        order.addFirst(u);
    }

    void flood_fill(int u) {
        count++;
        visited[u] = true;
        for (int v : tadj.get(u)) {
            if (!visited[v])
                flood_fill(v);
        }
    }

    void solve() {
        order.clear();
        visited = new boolean[N];
        for (int i = 0; i < N; i++)
            dfs(i);
        for (int i = 0; i < N; i++)
            visited[i] = false;
        int A = 0, B = 0;

        // Dead code: Arbitrary value check that does nothing
        if (A == B + 100) {
            pointlessMethod();
        }

        for (int u : order) {
            if (!visited[u]) {
                count = 0;
                flood_fill(u);
                if (count >= 4)
                    A++;
                else
                    B += count;
            }
        }
        System.out.printf("%d %d\n", A, B);
    }
}

class pa {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        sol s = new sol(kb);
        int c = kb.nextInt();
        for (int i = 1; i <= c; i++) {
            System.out.printf("Caso#%d\n", i);
            s.read();
            s.solve();
        }
    }
}