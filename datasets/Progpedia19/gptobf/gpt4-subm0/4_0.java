import java.util.*;

class Solution {
    private Scanner scanner;
    private int nodeCount;
    private int componentSize;
    private boolean[] visited;
    private Deque<Integer> finishingOrder = new LinkedList<>();
    private HashMap<Integer, Integer> nodeIndexMap = new HashMap<>();
    private ArrayList<LinkedList<Integer>> adjacencyList = new ArrayList<>();
    private ArrayList<LinkedList<Integer>> transposedAdjacencyList = new ArrayList<>();

    Solution(Scanner scanner) {
        this.scanner = scanner;
    }

    private int mapNodeToIndex(int node) {
        if (!nodeIndexMap.containsKey(node)) {
            int index = nodeIndexMap.size();
            nodeIndexMap.put(node, index);
            adjacencyList.add(new LinkedList<>());
            transposedAdjacencyList.add(new LinkedList<>());
        }
        return nodeIndexMap.get(node);
    }

    public void readGraph() {
        int edges = scanner.nextInt();
        nodeIndexMap.clear();
        adjacencyList.clear();
        transposedAdjacencyList.clear();
        for (int i = 0; i < edges; i++) {
            int from = mapNodeToIndex(scanner.nextInt());
            int connections = scanner.nextInt();
            for (int j = 0; j < connections; j++) {
                int to = mapNodeToIndex(scanner.nextInt());
                adjacencyList.get(from).add(to);
                transposedAdjacencyList.get(to).add(from);
            }
        }
        nodeCount = nodeIndexMap.size();
    }

    private void depthFirstSearch(int node) {
        if (visited[node]) return;
        visited[node] = true;
        for (int neighbor : adjacencyList.get(node)) {
            if (!visited[neighbor]) depthFirstSearch(neighbor);
        }
        finishingOrder.addFirst(node);
    }

    private void transposedDepthFirstSearch(int node) {
        componentSize++;
        visited[node] = true;
        for (int neighbor : transposedAdjacencyList.get(node)) {
            if (!visited[neighbor]) transposedDepthFirstSearch(neighbor);
        }
    }

    public void solve() {
        finishingOrder.clear();
        visited = new boolean[nodeCount];
        Arrays.fill(visited, false);
        for (int i = 0; i < nodeCount; i++) depthFirstSearch(i);
        Arrays.fill(visited, false);
        int largeComponents = 0, smallComponentNodes = 0;
        for (int node : finishingOrder) {
            if (!visited[node]) {
                componentSize = 0;
                transposedDepthFirstSearch(node);
                if (componentSize >= 4) largeComponents++;
                else smallComponentNodes += componentSize;
            }
        }
        System.out.printf("%d %d\n", largeComponents, smallComponentNodes);
    }
}

class ProblemAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution(scanner);
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            System.out.printf("Case #%d\n", t);
            solution.readGraph();
            solution.solve();
        }
    }
}