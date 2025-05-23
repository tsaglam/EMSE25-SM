import java.io.*;
import java.util.*;

// Renaming Node to Edge for clarity
class Edge implements Comparable<Edge> {
    double weight;
    int startVertex;
    int endVertex;

    Edge(double weight, int startVertex, int endVertex) {
        this.weight = weight;
        this.startVertex = startVertex;
        this.endVertex = endVertex;
    }

    @Override
    public int compareTo(Edge other) {
        return Double.compare(this.weight, other.weight);
    }
}

class MinimumSpanningTreeKruskal {
    static List<Edge> edgeList;
    static int vertexCount;
    static int[] parent;
    static int[] rank;

    static void initializeDisjointSet(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    static int findParent(int i) {
        if (i != parent[i]) {
            parent[i] = findParent(parent[i]); // Path compression
        }
        return parent[i];
    }

    static void unionByRank(int i, int j) {
        int rootI = findParent(i);
        int rootJ = findParent(j);
        if (rank[rootI] > rank[rootJ]) {
            parent[rootJ] = rootI;
        } else {
            parent[rootI] = rootJ;
            if (rank[rootI] == rank[rootJ]) {
                rank[rootJ]++;
            }
        }
    }

    static double kruskalMST() {
        double totalCost = 0;
        initializeDisjointSet(vertexCount);
        Collections.sort(edgeList);
        for (Edge edge : edgeList) {
            if (findParent(edge.startVertex) != findParent(edge.endVertex)) {
                unionByRank(edge.startVertex, edge.endVertex);
                totalCost += edge.weight;
            }
        }
        return totalCost;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        vertexCount = scanner.nextInt();
        double[] xCoordinates = new double[vertexCount];
        double[] yCoordinates = new double[vertexCount];
        edgeList = new ArrayList<>();

        for (int i = 0; i < vertexCount; ++i) {
            xCoordinates[i] = scanner.nextDouble();
            yCoordinates[i] = scanner.nextDouble();
        }

        // Building the edge list with distances as edge weights
        for (int i = 0; i < vertexCount - 1; ++i) {
            for (int j = i + 1; j < vertexCount; ++j) {
                double dx = xCoordinates[i] - xCoordinates[j];
                double dy = yCoordinates[i] - yCoordinates[j];
                double distance = Math.sqrt(dx * dx + dy * dy);
                edgeList.add(new Edge(distance, i, j));
            }
        }

        System.out.printf("%.2f\n", kruskalMST());
    }
}