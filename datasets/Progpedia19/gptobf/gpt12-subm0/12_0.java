import java.util.*;

class sol {
    int N;
    int count;
    boolean[] visited;
    Scanner kb;
    Deque<Integer> order = new LinkedList<Integer>();
    LinkedList<Integer> Nodes = new LinkedList<Integer>(); // Statement reordering example
    ArrayList<LinkedList<Integer>> adj = new ArrayList<LinkedList<Integer>>();
    ArrayList<LinkedList<Integer>> tadj = new ArrayList<LinkedList<Integer>>();
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    sol(Scanner kb) {
        this.kb = kb;
    }
    
    // Unused variable insertion
    int unusedVariable = 42; // This change does not impact the code's behavior
    
    void read() {
        N = kb.nextInt();
        map.clear();
        adj.clear();
        tadj.clear();
        visited = new boolean[N]; // Moved this initialization here (it's a logical error to have it here for the initial reading before knowing N, but follows instructions for reordering)
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
        if (visited[u]) return;
        visited[u] = true;
        for (int v : adj.get(u)) {
            if (!visited[v]) dfs(v);
        }
        order.addFirst(u);
    }
    
    void flood_fill(int u) {
        count++;
        visited[u] = true;
        for (int v : tadj.get(u)) {
            if (!visited[v]) flood_fill(v);
        }
    }
    
    int find_node(int u) { // Method reordering example
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
    
    // Unused method insertion
    void unusedMethod() {
        System.out.println("This is an unused method.");
    }
    
    void solve() {
        order.clear();
        visited = new boolean[N];
        Arrays.fill(visited, false); // Make sure to correctly re-initialize `visited` here due to logical reordering mistake in read()
        for (int i = 0; i < N; i++)
            dfs(i);
        Arrays.fill(visited, false); // Ensuring all nodes are marked unvisited before the flood fill
        int A = 0, B = 0;
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