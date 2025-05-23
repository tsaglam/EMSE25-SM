import java.util.*;

class Edge implements Comparable<Edge> {
    double weight;
    int startPoint;
    int endPoint;

    Edge(double weight, int startPoint, int endPoint) {
        this.weight = weight;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    @Override
    public int compareTo(Edge other) {
        return Double.compare(this.weight, other.weight);
    }
}

class GraphOptimizer {
    private static List<Edge> edgesList;
    private static int[] parent, depth;
    private static int vertices;

    private static void initializeSets(int size) {
        parent = new int[size];
        depth = new int[size];
        Arrays.fill(parent, -1);
        Arrays.fill(depth, 0);
    }

    private static int findRoot(int node) {
        if (parent[node] == -1) return node;
        return parent[node] = findRoot(parent[node]);
    }

    private static boolean mergeIfDistinctSets(int node1, int node2) {
        int root1 = findRoot(node1);
        int root2 = findRoot(node2);

        if (root1 != root2) {
            if (depth[root1] > depth[root2]) {
                parent[root2] = root1;
            } else {
                parent[root1] = root2;
                if (depth[root1] == depth[root2]) depth[root2]++;
            }
            return true;
        }
        return false;
    }

    private static double calculateMinimumSpanningTreeWeight() {
        double totalWeight = 0.0;
        initializeSets(vertices);
        Collections.sort(edgesList);

        for (Edge edge : edgesList) {
            if (mergeIfDistinctSets(edge.startPoint, edge.endPoint)) {
                totalWeight += edge.weight;
            }
        }
        return totalWeight;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        vertices = input.nextInt();
        double[] xCoords = new double[vertices];
        double[] yCoords = new double[vertices];
        edgesList = new ArrayList<>();

        for (int v = 0; v < vertices; ++v) {
            xCoords[v] = input.nextDouble();
            yCoords[v] = input.nextDouble();
        }

        for (int i = 0; i < vertices - 1; i++) {
            for (int j = i + 1; j < vertices; j++) {
                double distance = Math.hypot(xCoords[i] - xCoords[j], yCoords[i] - yCoords[j]);
                edgesList.add(new Edge(distance, i, j));
                edgesList.add(new Edge(distance, j, i));
            }
        }
        
        System.out.printf("%.2f\n", calculateMinimumSpanningTreeWeight());
    }
}