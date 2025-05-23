import java.util.*;

class Solver {
    private Scanner scanner;
    private int graphSize; // Renamed from N for clarity
    private int componentSize; // Renamed from count for clarity
    private boolean[] visited;
    private Deque<Integer> sortOrder = new LinkedList<>();
    private Map<Integer, Integer> nodeToIndex = new HashMap<>();
    private List<List<Integer>> graph = new ArrayList<>();
    private List<List<Integer>> transposedGraph = new ArrayList<>();

    public Solver(Scanner scanner) {
        this.scanner = scanner;
    }

    private int getOrCreateNodeIndex(int node) {
        return nodeToIndex.computeIfAbsent(node, k -> {
            graph.add(new LinkedList<>());
            transposedGraph.add(new LinkedList<>());
            return nodeToIndex.size();
        });
    }

    public void readGraph() {
        graphSize = scanner.nextInt();
        nodeToIndex.clear();
        graph.clear();
        transposedGraph.clear();
        for (int i = 0; i < graphSize; i++) {
            int nodeIndex = getOrCreateNodeIndex(scanner.nextInt());
            int edges = scanner.nextInt();
            for (int j = 0; j < edges; j++) {
                int targetIndex = getOrCreateNodeIndex(scanner.nextInt());
                graph.get(nodeIndex).add(targetIndex);
                transposedGraph.get(targetIndex).add(nodeIndex);
            }
        }
        graphSize = nodeToIndex.size(); // Update graph size to reflect number of unique nodes
    }

    private void depthFirstSearch(int nodeIndex) {
        if (visited[nodeIndex]) {
            return;
        }
        visited[nodeIndex] = true;
        for (int neighbor : graph.get(nodeIndex)) {
            if (!visited[neighbor]) {
                depthFirstSearch(neighbor);
            }
        }
        sortOrder.addFirst(nodeIndex);
    }

    private void transposeGraphDFS(int nodeIndex) {
        componentSize++;
        visited[nodeIndex] = true;
        for (int neighbor : transposedGraph.get(nodeIndex)) {
            if (!visited[neighbor]) {
                transposeGraphDFS(neighbor);
            }
        }
    }

    public void process() {
        sortOrder.clear();
        visited = new boolean[graphSize];
        Arrays.fill(visited, false);
        for (int i = 0; i < graphSize; i++) {
            depthFirstSearch(i);
        }

        Arrays.fill(visited, false);
        int largeComponents = 0, smallComponentsSize = 0;
        for (int nodeIndex : sortOrder) {
            if (!visited[nodeIndex]) {
                componentSize = 0;
                transposeGraphDFS(nodeIndex);
                if (componentSize >= 4) largeComponents++;
                else smallComponentsSize += componentSize;
            }
        }
        System.out.printf("%d %d\n", largeComponents, smallComponentsSize);
    }
}

class SolutionRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solver solverInstance = new Solver(scanner);
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            System.out.printf("Case#%d\n", i);
            solverInstance.readGraph();
            solverInstance.process();
        }
    }
}