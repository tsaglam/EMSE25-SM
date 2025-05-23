import java.util.*;

class Graph {
    private static final int MAX_NODES = 1000;
    private List<List<Integer>> adjList; // Adjacency List
    private int[] color, parent, discoveryTime, finishTime;
    private int timeCounter;

    public Graph(int numberOfNodes) {
        initGraph(numberOfNodes);
    }

    private void initGraph(int numberOfNodes) {
        adjList = new ArrayList<>(MAX_NODES);
        for (int i = 0; i < MAX_NODES; i++) {
            adjList.add(new LinkedList<>());
        }
        color = new int[MAX_NODES];
        parent = new int[MAX_NODES];
        discoveryTime = new int[MAX_NODES];
        finishTime = new int[MAX_NODES];
        Arrays.fill(parent, -1);
    }

    public void addEdge(int source, int dest) {
        adjList.get(source).add(dest);
    }

    public Graph transpose() {
        Graph transposedGraph = new Graph(MAX_NODES);
        for (int i = 0; i < MAX_NODES; i++) {
            for (int node : adjList.get(i)) {
                transposedGraph.addEdge(node, i);
            }
        }
        return transposedGraph;
    }

    public void depthFirstSearch(Deque<Integer> order, Deque<Integer> result) {
        Arrays.fill(color, 0);
        timeCounter = 0;
        for (int source : order) {
            if (color[source] == 0) {
                depthFirstVisit(source, result);
            }
        }
    }

    private void depthFirstVisit(int node, Deque<Integer> result) {
        color[node] = 1;
        discoveryTime[node] = ++timeCounter;
        for (int neighbor : adjList.get(node)) {
            if (color[neighbor] == 0) {
                parent[neighbor] = node;
                depthFirstVisit(neighbor, result);
            }
        }
        color[node] = 2;
        finishTime[node] = ++timeCounter;
        result.addFirst(node);
    }

    public List<List<Integer>> buildTreeForest() {
        List<List<Integer>> forest = new ArrayList<>();
        for (int i = 0; i < MAX_NODES; i++) {
            if (!adjList.get(i).isEmpty() && parent[i] == -1) {
                List<Integer> tree = new LinkedList<>();
                buildTree(tree, i);
                forest.add(tree);
            }
        }
        return forest;
    }

    private void buildTree(List<Integer> tree, int value) {
        if (value != -1) {
            tree.add(value);
            for (int i = 0; i < MAX_NODES; i++) {
                if (parent[i] == value) {
                    buildTree(tree, i);
                }
            }
        }
    }
}

class SociologyStudy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nScenarios = scanner.nextInt();
        for (int scenario = 0; scenario < nScenarios; scenario++) {
            Deque<Integer> initial = new LinkedList<>();
            Deque<Integer> transposedOrder = new LinkedList<>();

            int nStudents = scanner.nextInt();
            Graph graph = new Graph(nStudents);
            for (int student = 0; student < nStudents; student++) {
                initial.addLast(student);
            }
            for (int student = 0; student < nStudents; student++) {
                int studentId = scanner.nextInt() - 1;
                int nFriends = scanner.nextInt();
                for (int friend = 0; friend < nFriends; friend++) {
                    int friendId = scanner.nextInt() - 1;
                    graph.addEdge(studentId, friendId);
                }
            }
            graph.depthFirstSearch(initial, transposedOrder);

            Graph transposedGraph = graph.transpose();
            initial.clear();
            transposedGraph.depthFirstSearch(transposedOrder, initial);

            List<List<Integer>> groups = transposedGraph.buildTreeForest();
            int nGroups = 0;
            int nElemOut = 0;
            System.out.printf("Caso #%d\n", scenario + 1);
            for (List<Integer> group : groups) {
                int size = group.size();
                if (size >= 4) {
                    nGroups++;
                } else {
                    nElemOut += size;
                }
            }
            System.out.printf("%d %d\n", nGroups, nElemOut);
        }
    }
}