import java.util.*;

class GraphSccSolver {
    private Scanner inputScanner;
    private int nodeCount;
    private boolean[] visited;
    private Deque<Integer> finishingOrder = new LinkedList<>();
    private Map<Integer, Integer> nodeIdMap = new HashMap<>();
    private List<List<Integer>> adjacencyList = new ArrayList<>();
    private List<List<Integer>> transposedAdjacencyList = new ArrayList<>();

    public GraphSccSolver(Scanner scanner) {
        this.inputScanner = scanner;
    }

    private int findOrCreateNodeId(int originalNodeId) {
        return nodeIdMap.computeIfAbsent(originalNodeId, id -> {
            int newIndex = nodeIdMap.size();
            adjacencyList.add(new LinkedList<>());
            transposedAdjacencyList.add(new LinkedList<>());
            return newIndex;
        });
    }

    public void readGraph() {
        int edgeCount = inputScanner.nextInt();
        nodeIdMap.clear();
        adjacencyList.clear();
        transposedAdjacencyList.clear();

        for (int i = 0; i < edgeCount; i++) {
            int fromNodeId = findOrCreateNodeId(inputScanner.nextInt());
            int connections = inputScanner.nextInt();
            for (int j = 0; j < connections; j++) {
                int toNodeId = findOrCreateNodeId(inputScanner.nextInt());
                adjacencyList.get(fromNodeId).add(toNodeId);
                transposedAdjacencyList.get(toNodeId).add(fromNodeId);
            }
        }
        nodeCount = nodeIdMap.size();
    }

    private void depthFirstSearch(int nodeId) {
        if (visited[nodeId]) return;
        visited[nodeId] = true;
        for (int nextNodeId : adjacencyList.get(nodeId)) {
            if (!visited[nextNodeId]) depthFirstSearch(nextNodeId);
        }
        finishingOrder.addFirst(nodeId);
    }

    private void floodFill(int nodeId, Counter counter) {
        counter.increment();
        visited[nodeId] = true;
        for (int nextNodeId : transposedAdjacencyList.get(nodeId)) {
            if (!visited[nextNodeId]) floodFill(nextNodeId, counter);
        }
    }

    public void solve() {
        finishingOrder.clear();
        visited = new boolean[nodeCount];

        for (int i = 0; i < nodeCount; i++) {
            depthFirstSearch(i);
        }

        Arrays.fill(visited, false);
        int largeGroups = 0, smallGroupSum = 0;

        for (int nodeId : finishingOrder) {
            if (!visited[nodeId]) {
                Counter counter = new Counter();
                floodFill(nodeId, counter);
                if (counter.getCount() >= 4)
                    largeGroups++;
                else 
                    smallGroupSum += counter.getCount();
            }
        }
        System.out.printf("%d %d\n", largeGroups, smallGroupSum);
    }

    private static class Counter {
        private int count = 0;
        public void increment() { this.count++; }
        public int getCount() { return count; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GraphSccSolver solver = new GraphSccSolver(scanner);
        int cases = scanner.nextInt();
        for (int i = 1; i <= cases; i++) {
            System.out.printf("Case #%d\n", i);
            solver.readGraph();
            solver.solve();
        }
    }
}