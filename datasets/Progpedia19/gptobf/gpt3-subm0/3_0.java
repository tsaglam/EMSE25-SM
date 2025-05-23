import java.util.*;

class Solution {
    private Scanner kb;
    private int N;
    private int count;
    private boolean[] visited;
    private Deque<Integer> order = new LinkedList<>();
    private HashMap<Integer, Integer> nodeMap = new HashMap<>();
    private ArrayList<LinkedList<Integer>> adjList = new ArrayList<>();
    private ArrayList<LinkedList<Integer>> transposeAdjList = new ArrayList<>();

    Solution(Scanner kb) {
        this.kb = kb;
    }

    private int findOrCreateNode(int u) {
        return nodeMap.computeIfAbsent(u, k -> {
            adjList.add(new LinkedList<>());
            transposeAdjList.add(new LinkedList<>());
            return nodeMap.size();
        });
    }

    void readGraph() {
        N = kb.nextInt();
        nodeMap.clear();
        adjList.clear();
        transposeAdjList.clear();
        for (int i = 0; i < N; i++) {
            int u = findOrCreateNode(kb.nextInt());
            int connections = kb.nextInt();
            for (int k = 0; k < connections; k++) {
                int v = findOrCreateNode(kb.nextInt());
                adjList.get(u).add(v);
                transposeAdjList.get(v).add(u);
            }
        }
        N = nodeMap.size();
    }

    void depthFirstSearch(int u) {
        if (visited[u]) return;
        visited[u] = true;
        for (int v : adjList.get(u)) {
            if (!visited[v]) depthFirstSearch(v);
        }
        order.addFirst(u);
    }

    void floodFill(int u) {
        count++;
        visited[u] = true;
        for (int v : transposeAdjList.get(u)) {
            if (!visited[v]) floodFill(v);
        }
    }

    void solve() {
        order.clear();
        visited = new boolean[N];
        Arrays.fill(visited, false);
        order.forEach(this::depthFirstSearch);
        Arrays.fill(visited, false);
        int componentsWith4OrMoreNodes = 0, smallComponentsTotal = 0;
        for (int u : order) {
            if (!visited[u]) {
                count = 0;
                floodFill(u);
                if (count >= 4) componentsWith4OrMoreNodes++;
                else smallComponentsTotal += count;
            }
        }
        System.out.printf("%d %d%n", componentsWith4OrMoreNodes, smallComponentsTotal);
    }
}

class GraphProcessor {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Solution s = new Solution(kb);
        int cases = kb.nextInt();
        for (int i = 1; i <= cases; i++) {
            System.out.printf("Case#%d%n", i);
            s.readGraph();
            s.solve();
        }
    }
}