import java.util.*;

class sol {
    Scanner kb;
    int N, count;
    boolean[] visited;
    HashMap<Integer, Integer> map = new HashMap<>();
    ArrayList<LinkedList<Integer>> adj = new ArrayList<>();
    ArrayList<LinkedList<Integer>> tadj = new ArrayList<>();
    Deque<Integer> order = new LinkedList<>();
    LinkedList<Integer> Nodes = new LinkedList<>();

    sol(Scanner kb) {
        this.kb = kb;
    }

    void read() {
        N = kb.nextInt();
        map.clear();
        adj.clear();
        tadj.clear();
        Nodes.clear();
        for (int i = 0; i < N; i++) {
            int u = find_node(kb.nextInt());
            int c = kb.nextInt();
            for (int k = 0; k < c; k++) {
                int v = find_node(kb.nextInt());
                adj.get(u).add(v);
                tadj.get(v).add(u);
            }
        }
        N = map.size();
    }

    int find_node(int u) {
        return map.computeIfAbsent(u, key -> {
            adj.add(new LinkedList<>());
            tadj.add(new LinkedList<>());
            return map.size();
        });
    }

    void dfs(int u) {
        if (visited[u]) return;
        visited[u] = true;
        for (int v : adj.get(u)) {
            if (!visited[v]) dfs(v);
        }
        order.addFirst(u);
    }

    void flood_fill(int u) {
        visited[u] = true;
        count++;
        for (int v : tadj.get(u)) {
            if (!visited[v]) flood_fill(v);
        }
    }

    void solve() {
        order.clear();
        visited = new boolean[N];
        Arrays.fill(visited, false);
        for (int i = 0; i < N; i++) dfs(i);
        Arrays.fill(visited, false);
        int A = 0, B = 0;
        for (int u : order) {
            if (!visited[u]) {
                count = 0;
                flood_fill(u);
                if (count >= 4) A++;
                else B += count;
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