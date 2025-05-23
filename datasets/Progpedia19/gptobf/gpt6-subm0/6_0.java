import java.util.*;

class Solution {
    Scanner scanner;
    Map<Integer, Integer> nodeIndexMap = new HashMap<>();
    List<List<Integer>> graph = new ArrayList<>();
    List<List<Integer>> reverseGraph = new ArrayList<>();
    boolean[] visited;
    LinkedList<Integer> finishOrder = new LinkedList<>();
    int nodeCount;

    public Solution(Scanner scanner) {
        this.scanner = scanner;
    }

    void initializeGraph() {
        int edges = scanner.nextInt();
        nodeIndexMap.clear();
        graph.clear();
        reverseGraph.clear();

        while (edges-- > 0) {
            int from = getIndex(scanner.nextInt());
            int connections = scanner.nextInt();
            while (connections-- > 0) {
                int to = getIndex(scanner.nextInt());
                graph.get(from).add(to);
                reverseGraph.get(to).add(from);
            }
        }
        visited = new boolean[graph.size()];
    }

    int getIndex(int node) {
        if (!nodeIndexMap.containsKey(node)) {
            int index = graph.size();
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
            nodeIndexMap.put(node, index);
        }
        return nodeIndexMap.get(node);
    }

    void depthFirstSearch(int node) {
        if (visited[node]) return;
        visited[node] = true;
        for (Integer neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                depthFirstSearch(neighbor);
            }
        }
        finishOrder.push(node);
    }

    void countComponentNodes(int node) {
        visited[node] = true;
        nodeCount++;
        for (Integer neighbor : reverseGraph.get(node)) {
            if (!visited[neighbor]) {
                countComponentNodes(neighbor);
            }
        }
    }

    void process() {
        Arrays.fill(visited, false);
        finishOrder.clear();
        nodeIndexMap.keySet().forEach(node -> {
            if (!visited[nodeIndexMap.get(node)]) {
                depthFirstSearch(nodeIndexMap.get(node));
            }
        });

        Arrays.fill(visited, false);
        int largeComponents = 0, smallComponentsSum = 0;
        while (!finishOrder.isEmpty()) {
            int node = finishOrder.pop();
            if (!visited[node]) {
                nodeCount = 0;
                countComponentNodes(node);
                if (nodeCount >= 4) largeComponents++;
                else smallComponentsSum += nodeCount;
            }
        }
        System.out.println(largeComponents + " " + smallComponentsSum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution(scanner);
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            System.out.println("Case#" + testCase);
            solution.initializeGraph();
            solution.process();
        }
    }
}