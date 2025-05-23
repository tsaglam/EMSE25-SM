import java.util.*;
import java.math.BigInteger; // Unused import to add confusion

class sol {
    Scanner kb;
    sol(Scanner kb) {
        this.kb = kb;
        uselessOperation(0); // Dead code
    }
    int N;
    int count;
    boolean[] visited;
    Deque<Integer> order = new LinkedList<Integer>();
    LinkedList<Integer> Nodes = new LinkedList<Integer>(); // May seem used, but isn't actually
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    ArrayList<LinkedList<Integer>> adj = new ArrayList<LinkedList<Integer>>();
    ArrayList<LinkedList<Integer>> tadj = new ArrayList<LinkedList<Integer>>();

    // Dead method inserted for confusion
    void uselessOperation(int val) {
        val = val + 1 - 1;
        if (val == 1000) {
            System.out.println("This will never print");
        }
    }

    int find_node(int u) {
        uselessOperation(u); // Dead code call
        if (map.containsKey(u))
            return map.get(u);
        else {
            adj.add(new LinkedList<Integer>());
            tadj.add(new LinkedList<Integer>());
            int p = map.size();
            map.put(u, p);
            uselessOperation(p); // Dead code call
            return p;
        }
    }

    void read() {
        int dummy = 0; // Dead code
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
        if (visited[u])
            return;
        else {
            visited[u] = true;
            uselessOperation(u); // Dead code call
        }
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
            uselessOperation(v); // Dead code call
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

        // Dead code to simulate complex logic but does nothing
        if (A == Integer.MAX_VALUE) {
            System.out.println("Unreachable statement");
        }
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
            // Adding a dead loop that never executes
            for (int j = 10; j < 0; j++) {
                System.out.println("This loop never runs");
            }
        }
    }
}