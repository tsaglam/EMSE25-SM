import java.util.*;
class sol {
    Scanner kb;
    sol(Scanner kb) {
        this.kb = kb;
    }
    int N;
    int count;
    boolean[] visited;
    Deque<Integer> order = new LinkedList<Integer>();
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    LinkedList<Integer> Nodes = new LinkedList<Integer>();
    ArrayList<LinkedList<Integer>> adj = new ArrayList<LinkedList<Integer>>();
    ArrayList<LinkedList<Integer>> tadj = new ArrayList<LinkedList<Integer>>();
    int find_node(int u) {
        if (!map.containsKey(u)) {
            adj.add(new LinkedList<Integer>());
            tadj.add(new LinkedList<Integer>());
            int p = map.size();
            map.put(u, p);
        }
        return map.get(u);
    }
    void read() {
        N = kb.nextInt();
        adj.clear();
        map.clear();
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
        visited[u] = true;
        for (int v : adj.get(u)) {
            if (!visited[v])
                dfs(v);
        }
        order.addFirst(u);
    }
    void flood_fill(int u) {
        visited[u] = true;
        count++;
        for (int v : tadj.get(u)) {
            if (!visited[v])
                flood_fill(v);
        }
    }
    void solve() {
        visited = new boolean[N];
        order.clear();
        for (int i = 0; i < N; i++)
            if (!visited[i]) dfs(i);
        Arrays.fill(visited, false);
        int B = 0, A = 0;
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