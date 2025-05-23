import java.util.*;

class MyGraph {
    private List<List<Integer>> adjacencyList;
    private int[] color;    // 0 = white, 1 = gray, 2 = black
    private int[] discoveryTime, finishingTime, parent;
    private int time, size;

    public MyGraph(int nodes) {
        this.size = nodes;
        this.adjacencyList = new ArrayList<>(nodes);
        for (int i = 0; i < nodes; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        this.color = new int[nodes];
        this.parent = new int[nodes];
        this.discoveryTime = new int[nodes];
        this.finishingTime = new int[nodes];
    }

    public void addEdge(int src, int dest) {
        adjacencyList.get(src).add(dest);
    }

    public MyGraph transpose() {
        MyGraph gt = new MyGraph(size);
        for (int i = 0; i < size; i++) {
            for (int v : adjacencyList.get(i)) {
                gt.addEdge(v, i);
            }
        }
        return gt;
    }

    public void dfs(Stack<Integer> order) {
        Arrays.fill(color, 0);
        Arrays.fill(parent, -1);
        time = 0;
        while (!order.isEmpty()) {
            int u = order.pop();
            if (color[u] == 0) {
                dfsVisit(u, order);
            }
        }
    }

    private void dfsVisit(int u, Stack<Integer> stack) {
        color[u] = 1;
        discoveryTime[u] = ++time;
        for (int v : adjacencyList.get(u)) {
            if (color[v] == 0) {
                parent[v] = u;
                dfsVisit(v, stack);
            }
        }
        color[u] = 2;
        finishingTime[u] = ++time;
        stack.push(u);
    }

    public List<List<Integer>> getForestGroups() {
        List<List<Integer>> forest = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (parent[i] == -1) {
                List<Integer> tree = new ArrayList<>();
                buildTree(tree, i);
                forest.add(tree);
            }
        }
        return forest;
    }

    private void buildTree(List<Integer> tree, int node) {
        tree.add(node);
        for (int i = 0; i < size; i++) {
            if (parent[i] == node) {
                buildTree(tree, i);
            }
        }
    }
}

class SociologyStudy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int nStudents = scanner.nextInt();
            MyGraph graph = new MyGraph(nStudents);
            Stack<Integer> order = new Stack<>();

            for (int i = 0; i < nStudents; i++) {
                order.push(i);  // Preparing first DFS order (initially 0 to n-1)

                int student = scanner.nextInt();
                int friendsCount = scanner.nextInt();
                for (int j = 0; j < friendsCount; j++) {
                    int friend = scanner.nextInt() - 1;
                    graph.addEdge(student - 1, friend);  // Adjusting indexes (1-based to 0-based)
                }
            }

            graph.dfs(order);  // First DFS to compute finishing times
            MyGraph transposedGraph = graph.transpose();
            Stack<Integer> secondOrder = new Stack<>();
            secondOrder.addAll(order);
            transposedGraph.dfs(secondOrder);  // Second DFS on transposed graph

            List<List<Integer>> groups = transposedGraph.getForestGroups();
            int groupCount = 0, singleElements = 0;
            for (List<Integer> group : groups) {
                int size = group.size();
                if (size >= 4) {
                    groupCount++;
                } else {
                    singleElements += size;
                }
            }

            System.out.printf("Caso #%d\n", t);
            System.out.println(groupCount + " " + singleElements);
        }
        scanner.close();
    }
}