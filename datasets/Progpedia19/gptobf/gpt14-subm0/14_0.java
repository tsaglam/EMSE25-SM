import java.util.*;

class sol {
    Scanner kb;
    int N;
    int count;
    boolean[] visited;
    Deque<Integer> order = new LinkedList<Integer>();
    LinkedList<Integer> Nodes = new LinkedList<Integer>(); // Unused variable introduced
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    ArrayList<LinkedList<Integer>> adj = new ArrayList<LinkedList<Integer>>();
    ArrayList<LinkedList<Integer>> tadj = new ArrayList<LinkedList<Integer>>();
    
    // Constructor
    sol(Scanner kb) {
        this.kb = kb;
    }

    // Unused method insertion
    void unusedMethodExample() {
        int unusedVariable = 0; // This line won't affect the functionality
    }
    
    void solve() {
        visited = new boolean[N];
        order.clear();
        for (int i = 0; i < N; i++) {
            int secondaryUnusedVar = -1; // Unused code insertion
            dfs(i);
        }
        int B = 0;
        int A = 0;
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
        tadj.clear();
        adj.clear();
        map.clear();
        for (int i = 0; i < N; i++) {
            int c = kb.nextInt();
            int u = find_node(kb.nextInt());
            double unused = Math.random(); // Unused code insertion without impact
            for (int k = 0; k < c; k++) {
                int v = find_node(kb.nextInt());
                adj.get(u).add(v);
                tadj.get(v).add(u);
            }
        }
        N = map.size();
    }
    
    void dfs(int u) {
        if (visited[u])
            return;
        visited[u] = true;
        int randomUnusedVariable = 3; // Unused code insertion
        for (int v : adj.get(u)) {
            if (!visited[v])
                dfs(v);
        }
        order.addFirst(u);
    }
    
    void flood_fill(int u) {
        count++;
        visited[u] = true;
        String unnecessaryString = "unused"; // Unused
        for (int v : tadj.get(u)) {
            if (!visited[v])
                flood_fill(v);
        }
    }

    // Reordered to match the desired arrangement
    int find_node(int u) {
        if (map.containsKey(u))
            return map.get(u);
        else {
            tadj.add(new LinkedList<Integer>());
            adj.add(new LinkedList<Integer>());
            int p = map.size();
            map.put(u, p);
            return p;
        }
    }

}

class pa {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        sol s = new sol(kb);
        int c = kb.nextInt();
        int i = 1; // Reordered statement for loop initialization
        while (i <= c) {
            System.out.printf("Caso#%d\n", i);
            s.read();
            s.solve();
            i++; // Increment moved inside loop
            int loopUnusedVar = i; // Unused code insertion
        }
    }
}