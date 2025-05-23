import java.util.*;

class sol {
    Scanner kb;
    int N;
    int count;
    boolean[] visited;
    Deque<Integer> order = new LinkedList<Integer>();
    LinkedList<Integer> Nodes = new LinkedList<Integer>(); // Nodes list remains as part of the original code snippet but unused
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    ArrayList<LinkedList<Integer>> adj = new ArrayList<LinkedList<Integer>>();
    ArrayList<LinkedList<Integer>> tadj = new ArrayList<LinkedList<Integer>>();
    
    // Unused variables introduction for refactor task
    int unusedInt = 0;
    String unusedString = "unused";
    double unusedDouble = 0.0;

    sol(Scanner kb) {
        this.kb = kb;
    }
    
    void solve() {
        visited = new boolean[N];
        order.clear();
        for (int i = 0; i < N; i++)
            dfs(i);
        Arrays.fill(visited, false); // Changed to use Arrays.fill for resetting visited
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
    
    int find_node(int u) {
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
    
    void dfs(int u) {
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

    // Unused methods introduction
    void unusedMethod1() {
        System.out.println("Unused Method 1");
    }
    
    void unusedMethod2() {
        System.out.println("Unused Method 2");
    }
    
    void unusedMethod3() {
        System.out.println("Unused Method 3");
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