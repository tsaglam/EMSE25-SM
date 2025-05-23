import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
    int src, dest;
    double weight;

    public Edge(int src, int dest, double weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge compareEdge) {
        return Double.compare(this.weight, compareEdge.weight);
    }
}

class Subset {
    int parent, rank;
}

class Graph {
    int vertices;
    ArrayList<Edge> edges = new ArrayList<>();

    Graph(int vertices) {
        this.vertices = vertices;
    }

    void addEdge(int src, int dest, double weight) {
        edges.add(new Edge(src, dest, weight));
    }

    int find(Subset subsets[], int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }

        return subsets[i].parent;
    }

    void union(Subset subsets[], int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    double kruskalMST() {
        Edge result[] = new Edge[vertices];
        int e = 0;
        int i = 0;
        for (i = 0; i < vertices; ++i)
            result[i] = new Edge(0, 0, 0);

        Collections.sort(edges);

        Subset subsets[] = new Subset[vertices];
        for (i = 0; i < vertices; ++i)
            subsets[i] = new Subset();

        for (int v = 0; v < vertices; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        i = 0;
        while (e < vertices - 1 && i < edges.size()) {
            Edge next_edge = edges.get(i++);
            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            if (x != y) {
                result[e++] = next_edge;
                union(subsets, x, y);
            }
        }

        double minimumCost = 0.0;
        for (i = 0; i < e; ++i) {
            minimumCost += result[i].weight;
        }
        return minimumCost;
    }
}

class Freckles {

    static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        double[] x = new double[N];
        double[] y = new double[N];

        for (int i = 0; i < N; i++) {
            x[i] = scanner.nextDouble();
            y[i] = scanner.nextDouble();
        }

        Graph g = new Graph(N);

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                double distance = calculateDistance(x[i], y[i], x[j], y[j]);
                g.addEdge(i, j, distance);
                g.addEdge(j, i, distance);
            }
        }

        double result = g.kruskalMST();
        System.out.printf("%.2f\n", result);
        scanner.close();
    }
}