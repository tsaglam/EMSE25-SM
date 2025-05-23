import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    double weight;
    int source;
    int destination;

    Edge(double weight, int source, int destination) {
        this.weight = weight;
        this.source = source;
        this.destination = destination;
    }

    @Override
    public int compareTo(Edge other) {
        return Double.compare(this.weight, other.weight);
    }
}

class KruskalAlgorithm {
    private static List<Edge> edgeList;
    private static int verticesCount;
    private static int[] parent;
    private static int[] depth;

    private static void initializeDisjointSets(int size) {
        parent = new int[size];
        depth = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            depth[i] = 0;
        }
    }

    private static int findParent(int i) {
        if (i != parent[i]) {
            parent[i] = findParent(parent[i]);  // Path compression
        }
        return parent[i];
    }

    private static boolean areInTheSameSet(int i, int j) {
        return findParent(i) == findParent(j);
    }

    private static void union(int i, int j) {
        int rootI = findParent(i);
        int rootJ = findParent(j);
        if (depth[rootI] > depth[rootJ]) {
            parent[rootJ] = rootI;
        } else if (depth[rootI] < depth[rootJ]) {
            parent[rootI] = rootJ;
        } else {
            parent[rootJ] = rootI;
            depth[rootI]++;
        }
    }

    private static double calculateMST() {
        double totalCost = 0;
        initializeDisjointSets(verticesCount);
        Collections.sort(edgeList);

        for (Edge edge : edgeList) {
            if (!areInTheSameSet(edge.source, edge.destination)) {
                union(edge.source, edge.destination);
                totalCost += edge.weight;
            }
        }
        return totalCost;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        verticesCount = scanner.nextInt();
        double[] xCoords = new double[verticesCount];
        double[] yCoords = new double[verticesCount];
        edgeList = new ArrayList<>();

        for (int i = 0; i < verticesCount; ++i) {
            xCoords[i] = scanner.nextDouble();
            yCoords[i] = scanner.nextDouble();
        }

        for (int i = 0; i < verticesCount - 1; ++i) {
            for (int j = i + 1; j < verticesCount; ++j) {
                double distance = Math.sqrt(Math.pow(xCoords[i] - xCoords[j], 2) + Math.pow(yCoords[i] - yCoords[j], 2));
                edgeList.add(new Edge(distance, i, j));
                edgeList.add(new Edge(distance, j, i));  // Adding both directions since it's undirected
            }
        }

        System.out.printf("%.2f%n", calculateMST());
    }
}