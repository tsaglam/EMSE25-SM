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

class GraphMST {
    private static List<Edge> edges;
    private static UnionFind unionFind;

    private static class UnionFind {
        private int[] parent;
        private int[] height;

        UnionFind(int size) {
            parent = new int[size];
            height = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                height[i] = 0;
            }
        }

        int find(int element) {
            if (parent[element] != element) {
                parent[element] = find(parent[element]);
            }
            return parent[element];
        }

        void union(int element1, int element2) {
            int root1 = find(element1);
            int root2 = find(element2);

            if (height[root1] < height[root2]) {
                parent[root1] = root2;
            } else if (height[root2] < height[root1]) {
                parent[root2] = root1;
            } else {
                parent[root2] = root1;
                height[root1]++;
            }
        }

        boolean connected(int element1, int element2) {
            return find(element1) == find(element2);
        }
    }

    private static double calculateMST(int vertices) {
        double totalCost = 0;
        unionFind = new UnionFind(vertices);
        Collections.sort(edges);
        
        for (Edge edge : edges) {
            if (!unionFind.connected(edge.source, edge.destination)) {
                unionFind.union(edge.source, edge.destination);
                totalCost += edge.weight;
            }
        }
        return totalCost;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int vertices = scanner.nextInt();
        double[] xCoordinates = new double[vertices];
        double[] yCoordinates = new double[vertices];
        edges = new ArrayList<>();

        for (int i = 0; i < vertices; ++i) {
            xCoordinates[i] = scanner.nextDouble();
            yCoordinates[i] = scanner.nextDouble();
        }
        // Compute distances and add edges for every pair of points
        for (int i = 0; i < vertices; i++) {
            for (int j = i + 1; j < vertices; j++) {
                double distance = Math.hypot(xCoordinates[i] - xCoordinates[j], yCoordinates[i] - yCoordinates[j]);
                edges.add(new Edge(distance, i, j));
                edges.add(new Edge(distance, j, i));
            }
        }
        System.out.printf("%.2f\n", calculateMST(vertices));
    }
}