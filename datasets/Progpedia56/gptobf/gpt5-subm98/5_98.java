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
    public int compareTo(Edge compareEdge) {
        return Double.compare(this.weight, compareEdge.weight);
    }
}

class GraphSolver {
    static ArrayList<Edge> edgeList;
    static int vertexCount;
    static int[] root;
    static int[] depth;

    static void initializeDisjointSet(int size) {
        root = new int[size];
        depth = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            depth[i] = 0;
        }
    }

    static int findRoot(int i) {
        if (root[i] != i) {
            root[i] = findRoot(root[i]); // Path compression
        }
        return root[i];
    }

    static boolean isConnected(int i, int j) {
        return findRoot(i) == findRoot(j);
    }

    static void unionSet(int i, int j) {
        int rootI = findRoot(i);
        int rootJ = findRoot(j);
        if (depth[rootI] > depth[rootJ]) {
            root[rootJ] = rootI;
        } else {
            root[rootI] = rootJ;
            if (depth[rootI] == depth[rootJ]) {
                depth[rootJ]++;
            }
        }
    }

    static double executeKruskal() {
        double minCost = 0;
        initializeDisjointSet(vertexCount);
        Collections.sort(edgeList);
        for (Edge edge : edgeList) {
            if (!isConnected(edge.source, edge.destination)) {
                unionSet(edge.source, edge.destination);
                minCost += edge.weight;
            }
        }
        return minCost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        vertexCount = scanner.nextInt();
        double[] xCoordinates = new double[vertexCount];
        double[] yCoordinates = new double[vertexCount];
        edgeList = new ArrayList<>();

        for (int i = 0; i < vertexCount; i++) {
            xCoordinates[i] = scanner.nextDouble();
            yCoordinates[i] = scanner.nextDouble();
        }
        for (int i = 0; i < vertexCount - 1; i++) {
            for (int j = i + 1; j < vertexCount; j++) {
                double distance = Math.hypot(xCoordinates[i] - xCoordinates[j], yCoordinates[i] - yCoordinates[j]);
                edgeList.add(new Edge(distance, i, j));
            }
        }
        System.out.printf("%.2f\n", executeKruskal());
    }
}