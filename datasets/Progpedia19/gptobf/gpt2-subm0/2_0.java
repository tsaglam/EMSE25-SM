import java.util.*;

// Renamed `pa` to `ProblemSolver` for clarity.
class ProblemSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution(scanner);
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            System.out.printf("Case#%d\n", i);
            solution.readInput();
            solution.process();
        }
    }
}

// Renamed `sol` to `Solution` for clarity.
class Solution {
    private final Scanner scanner;
    private int nodeCount;
    private boolean[] visited;
    private Deque<Integer> topologicalOrder = new LinkedList<>();
    private Map<Integer, Integer> indexMap = new HashMap<>();
    private List<List<Integer>> adjacencyList = new ArrayList<>();
    private List<List<Integer>> reversedAdjList = new ArrayList<>();
    private int componentSize;

    Solution(Scanner scanner) {
        this.scanner = scanner;
    }

    // Finding or creating a node's index
    private int findOrCreateNodeIndex(int node) {
        if (!indexMap.containsKey(node)) {
            int index = indexMap.size();
            adjacencyList.add(new LinkedList<>());
            reversedAdjList.add(new LinkedList<>());
            indexMap.put(node, index);
        }
        return indexMap.get(node);
    }

    // Reading and initializing the graph from input
    void readInput() {
        nodeCount = scanner.nextInt();
        indexMap.clear();
        adjacencyList.clear();
        reversedAdjList.clear();
        for (int i = 0; i < nodeCount; i++) {
            int from = findOrCreateNodeIndex(scanner.nextInt());
            int edges = scanner.nextInt();
            for (int j = 0; j < edges; j++) {
                int to = findOrCreateNodeIndex(scanner.nextInt());
                adjacencyList.get(from).add(to);
                reversedAdjList.get(to).add(from);
            }
        }
        nodeCount = indexMap.size(); // Updating node count to unique nodes.
    }

    // Depth-First Search to populate `topologicalOrder`
    private void dfs(int node) {
        if (visited[node]) return;
        visited[node] = true;
        for (int nextNode : adjacencyList.get(node)) {
            if (!visited[nextNode]) dfs(nextNode);
        }
        topologicalOrder.addFirst(node);
    }

    // Flood Fill to count reachable nodes in the reversed graph
    private void floodFill(int node) {
        componentSize++;
        visited[node] = true;
        for (int nextNode : reversedAdjList.get(node)) {
            if (!visited[nextNode]) floodFill(nextNode);
        }
    }

    // Solving the problem based on DFS and Flood Fill
    void process() {
        topologicalOrder.clear();
        visited = new boolean[nodeCount];
        for (int i = 0; i < nodeCount; i++) dfs(i);

        Arrays.fill(visited, false);
        int largeComponents = 0, smallComponentsSize = 0;
        for (int node : topologicalOrder) {
            if (!visited[node]) {
                componentSize = 0;
                floodFill(node);
                if (componentSize >= 4) largeComponents++;
                else smallComponentsSize += componentSize;
            }
        }
        System.out.printf("%d %d\n", largeComponents, smallComponentsSize);
    }
}