import java.util.*;
import java.lang.*;

// Improved Graph class with slight adjustments
class ImprovedGraph {
    private final static int DIM = 1000; // Made static as it's a constant
    List<Integer>[] adjList;
    int[] color, parent, startTime, finishTime;
    int time;

    public ImprovedGraph() {
        adjList = new List[DIM];
        color = new int[DIM];
        parent = new int[DIM];
        startTime = new int[DIM];
        finishTime = new int[DIM];
        for (int i = 0; i < DIM; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Creates transposed graph
    public ImprovedGraph transpose() {
        ImprovedGraph transposed = new ImprovedGraph();
        for (int i = 0; i < adjList.length && adjList[i] != null; i++) {
            for (int node : adjList[i]) {
                transposed.adjList[node].add(i);
            }
        }
        return transposed;
    }

    // Performs depth-first search
    public void dfs(List<Integer> orderOfVisit, List<Integer> outputList) {
        Arrays.fill(color, 0);
        Arrays.fill(parent, -1);
        Arrays.fill(startTime, -1);
        Arrays.fill(finishTime, -1);
        time = 0;
        orderOfVisit.forEach(source -> {
            if (color[source] == 0) dfsVisit(source, outputList);
        });
    }

    // Helper method for DFS
    private void dfsVisit(int source, List<Integer> outputList) {
        color[source] = 1;
        startTime[source] = ++time;
        for (int node : adjList[source]) {
            if (color[node] == 0) {
                parent[node] = source;
                dfsVisit(node, outputList);
            }
        }
        color[source] = 2;
        finishTime[source] = ++time;
        outputList.add(0, source);
    }

    // Finds values in the graph
    public PriorityQueue<Integer> findValues(int value) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < adjList.length && adjList[i] != null; i++) {
            if (parent[i] == value) {
                queue.add(i);
            }
        }
        return queue;
    }

    // Builds a tree from the given root
    public void buildTree(List<Integer> tree, int root) {
        if (root != -1) tree.add(root);
        findValues(root).forEach(node -> buildTree(tree, node));
    }

    // Creates forest of trees
    public List<Integer>[] buildForest() {
        List<Integer>[] forest = new List[DIM];
        for (int i = 0; i < adjList.length && adjList[i] != null; i++) {
            if (parent[i] == -1) {
                forest[i] = new LinkedList<>();
                buildTree(forest[i], i);
            }
        }
        return forest;
    }
}

// Main class for the problem, renamed from Sociologia to ImprovedSociologia for clarity
class ImprovedSociologia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scenarios = scanner.nextInt();
        for (int i = 0; i < scenarios; i++) {
            List<Integer> first = new LinkedList<>();
            List<Integer> second = new LinkedList<>();
            ImprovedGraph graph = new ImprovedGraph();
            int nStudents = scanner.nextInt();
            for (int j = 0; j < nStudents; j++) {
                first.add(j);
            }
            for (int j = 0; j < nStudents; j++) {
                int student = scanner.nextInt();
                int nFriends = scanner.nextInt();
                for (int k = 0; k < nFriends; k++) {
                    graph.adjList[student - 1].add(scanner.nextInt() - 1);
                }
            }
            graph.dfs(first, second);
            ImprovedGraph transposedGraph = graph.transpose();
            second.clear();
            transposedGraph.dfs(first, second);
            List<Integer>[] groups = transposedGraph.buildForest();
            
            int count = 0, nGroups = 0, nElemOut = 0;
            System.out.printf("Caso #%d\n", i + 1);
            for (List<Integer> group : groups) {
                if (group == null) continue;
                if (group.size() >= 4)
                    nGroups++;
                else
                    nElemOut += group.size();
            }
            System.out.printf("%d %d\n", nGroups, nElemOut);
        }
    }
}