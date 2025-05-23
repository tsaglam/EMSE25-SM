import java.util.*;

class NetworkGraph {
    private static final Integer SIZE = 1000;
    List<Integer>[] adjacencyList = null;
    int[] visitedStatus, predecessor, discoveryTime, finishTime;
    int timeStamp;

    NetworkGraph() {
        adjacencyList = new List[SIZE];
        visitedStatus = new int[SIZE];
        predecessor = new int[SIZE];
        discoveryTime = new int[SIZE];
        finishTime = new int[SIZE];
    }

    NetworkGraph reverseGraph() {
        NetworkGraph reverse = new NetworkGraph();
        for (int i = 0; this.adjacencyList[i] != null; i++) {
            reverse.adjacencyList[i] = new LinkedList<>();
        }
        for (int i = 0; this.adjacencyList[i] != null; i++) {
            for (int node : adjacencyList[i]) {
                reverse.adjacencyList[node].add(i);
            }
        }
        return reverse;
    }

    void runDFS(List<Integer> startVertices, List<Integer> resultVertices) {
        Arrays.fill(visitedStatus, 0);
        Arrays.fill(predecessor, -1);
        Arrays.fill(discoveryTime, -1);
        Arrays.fill(finishTime, -1);
        timeStamp = 0;
        for (int vertex : startVertices) {
            if (visitedStatus[vertex] == 0)
                performDFS(vertex, resultVertices);
        }
    }

    void performDFS(int vertex, List<Integer> resultVertices) {
        visitedStatus[vertex] = 1;
        timeStamp++;
        discoveryTime[vertex] = timeStamp;
        for (int adjacency : adjacencyList[vertex]) {
            if (visitedStatus[adjacency] == 0) {
                predecessor[adjacency] = vertex;
                performDFS(adjacency, resultVertices);
            }
        }
        visitedStatus[vertex] = 2;
        timeStamp++;
        finishTime[vertex] = timeStamp;
        resultVertices.add(0, vertex);
    }

    PriorityQueue<Integer> searchForValue(int targetValue, int[] vector) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; adjacencyList[i] != null; i++)
            if (vector[i] == targetValue)
                queue.add(i);
        return queue;
    }

    void constructTree(List<Integer> treeStructure, int rootNode) {
        if (rootNode != -1)
            treeStructure.add(rootNode);
        PriorityQueue<Integer> queue = searchForValue(rootNode, predecessor);
        while (!queue.isEmpty()) {
            int nextRoot = queue.poll();
            constructTree(treeStructure, nextRoot);
        }
    }

    @SuppressWarnings("unchecked")
    List<Integer>[] generateForest() {
        List<Integer>[] forest = new List[SIZE];
        for (int i = 0; adjacencyList[i] != null; i++) {
            if (predecessor[i] == -1) {
                int position = 0;
                while (forest[position] != null) position++;
                forest[position] = new LinkedList<>();
                constructTree(forest[position], i);
            }
        }
        return forest;
    }
}

class SociologyStudy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scenarios = scanner.nextInt();
        for (int scenario = 0; scenario < scenarios; scenario++) {
            List<Integer> firstList = new LinkedList<>();
            List<Integer> secondList = new LinkedList<>();
            NetworkGraph graph = new NetworkGraph();
            int students = scanner.nextInt();
            for (int studentIndex = 0; studentIndex < students; studentIndex++) {
                graph.adjacencyList[studentIndex] = new LinkedList<>();
                firstList.add(studentIndex);
            }
            for (int j = 0; j < students; j++) {
                int studentNum = scanner.nextInt();
                int friendsCount = scanner.nextInt();
                for (int friend = 0; friend < friendsCount; friend++)
                    graph.adjacencyList[studentNum - 1].add(scanner.nextInt() - 1);
            }
            graph.runDFS(firstList, secondList);
            NetworkGraph reversedGraph = graph.reverseGraph();
            firstList.clear();
            reversedGraph.runDFS(secondList, firstList);
            List<Integer>[] groups = reversedGraph.generateForest();
            int counter = 0, groupsCount = 0, individualsCount = 0;
            System.out.printf("Scenario #%d\n", scenario + 1);
            for (List<Integer> group : groups) {
                if (group == null) break;
                counter = group.size();
                if (counter >= 4)
                    groupsCount++;
                else
                    individualsCount += counter;
            }
            System.out.printf("%d %d\n", groupsCount, individualsCount);
        }
    }
}