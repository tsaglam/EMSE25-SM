import java.util.*;

class Edge implements Comparable<Edge> {
    double weight;
    int start;
    int end;

    Edge(double weight, int start, int end) {
        this.weight = weight;
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Edge otherEdge) {
        return Double.compare(this.weight, otherEdge.weight);
    }
}

class DisjointSet {
    private int[] parent;
    private int[] rank;

    DisjointSet(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    int find(int item) {
        if (parent[item] != item) {
            parent[item] = find(parent[item]);
        }
        return parent[item];
    }

    void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }
}

class GraphMinimumSpanningTree {
    private static double calculateMinimumSpanningTree(List<Edge> edges, int numberOfVertices) {
        double minimumCost = 0;
        Collections.sort(edges);
        DisjointSet disjointSet = new DisjointSet(numberOfVertices);

        for (Edge edge : edges) {
            if (disjointSet.find(edge.start) != disjointSet.find(edge.end)) {
                disjointSet.union(edge.start, edge.end);
                minimumCost += edge.weight;
            }
        }

        return minimumCost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPoints = scanner.nextInt();
        double[] xCoords = new double[numberOfPoints];
        double[] yCoords = new double[numberOfPoints];
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < numberOfPoints; i++) {
            xCoords[i] = scanner.nextDouble();
            yCoords[i] = scanner.nextDouble();
        }

        for (int i = 0; i < numberOfPoints; i++) {
            for (int j = i + 1; j < numberOfPoints; j++) {
                double distance = Math.sqrt(Math.pow(xCoords[i] - xCoords[j], 2) + Math.pow(yCoords[i] - yCoords[j], 2));
                edges.add(new Edge(distance, i, j));
            }
        }

        double cost = calculateMinimumSpanningTree(edges, numberOfPoints);
        System.out.printf("%.2f\n", cost);
    }
}