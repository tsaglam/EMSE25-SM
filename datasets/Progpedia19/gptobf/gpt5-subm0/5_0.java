import java.util.*;

class ProblemSolver {
    private static Scanner inputScanner;
    private Map<Integer, Integer> nodeIndexMap = new HashMap<>();
    private List<List<Integer>> graph = new ArrayList<>();
    private List<List<Integer>> reverseGraph = new ArrayList<>();
    private List<Integer> topologicalOrder = new LinkedList<>();
    private boolean[] visited;
    private int nodeCount;
    private int groupSize;

    public ProblemSolver(Scanner scanner) {
        inputScanner = scanner;
    }

    private int addOrGetNodeIndex(int node) {
        if (!nodeIndexMap.containsKey(node)) {
            int newIndex = nodeIndexMap.size();
            nodeIndexMap.put(node, newIndex);
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }
        return nodeIndexMap.get(node);
    }

    public void initialize() {
        int edges = inputScanner.nextInt();
        nodeIndexMap.clear();
        graph.clear();
        reverseGraph.clear();
        for (int i = 0; i < edges; i++) {
            int from = addOrGetNodeIndex(inputScanner.nextInt());
            int connections = inputScanner.nextInt();
            for (int j = 0; j < connections; j++) {
                int to = addOrGetNodeIndex(inputScanner.nextInt());
                graph.get(from).add(to);
                reverseGraph.get(to).add(from);
            }
        }
        nodeCount = nodeIndexMap.size();
    }

    private void explore(int node) {
        if (visited[node]) return;
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                explore(neighbor);
            }
        }
        topologicalOrder.add(0, node);
    }

    private void identifyComponent(int node) {
        groupSize++;
        visited[node] = true;
        for (int neighbor : reverseGraph.get(node)) {
            if (!visited[neighbor]) {
                identifyComponent(neighbor);
            }
        }
    }

    public void execute() {
        topologicalOrder.clear();
        visited = new boolean[nodeCount];
        Arrays.fill(visited, false);
        for (int i = 0; i < nodeCount; i++) explore(i);
        Arrays.fill(visited, false);
        int largeGroups = 0, smallGroupSum = 0;
        for (int node : topologicalOrder) {
            if (!visited[node]) {
                groupSize = 0;
                identifyComponent(node);
                if (groupSize >= 4) largeGroups++;
                else smallGroupSum += groupSize;
            }
        }
        System.out.printf("%d %d%n", largeGroups, smallGroupSum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProblemSolver solver = new ProblemSolver(scanner);
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            System.out.println("Case #" + testCase + ":");
            solver.initialize();
            solver.execute();
        }
    }
}