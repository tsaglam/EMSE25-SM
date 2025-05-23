import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge> {
    int src, dest;
    double weight;

    Edge(int src, int dest, double weight) {
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

class Freckles {
    int V, E;
    Edge[] edge;

    Freckles(int n) {
        V = n;
        E = n * (n - 1) / 2;
        edge = new Edge[E];
    }

    int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);

        return subsets[i].parent;
    }

    void Union(Subset[] subsets, int x, int y) {
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

    double KruskalMST() {
        Edge[] result = new Edge[V];
        int e = 0;
        int i = 0;
        for (i = 0; i < V; ++i)
            result[i] = new Edge(0, 0, 0);

        Arrays.sort(edge);

        Subset[] subsets = new Subset[V];
        for (i = 0; i < V; ++i)
            subsets[i] = new Subset();

        for (int v = 0; v < V; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        i = 0;
        while (e < V - 1) {
            Edge next_edge = new Edge(0, 0, 0);
            if (i < edge.length) {
                next_edge = edge[i++];
            }

            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            if (x != y) {
                result[e++] = next_edge;
                Union(subsets, x, y);
            }
        }

        double minimumCost = 0.0;
        for (i = 0; i < e; ++i)
            minimumCost += result[i].weight;
        return minimumCost;
    }

    public static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Freckles graph = new Freckles(N);

        double[][] freckles = new double[N][2];
        for (int i = 0; i < N; i++) {
            freckles[i][0] = scanner.nextDouble();
            freckles[i][1] = scanner.nextDouble();
        }

        int edgeCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                double distance = distance(freckles[i][0], freckles[i][1], freckles[j][0], freckles[j][1]);
                graph.edge[edgeCount++] = new Edge(i, j, distance);
            }
        }

        System.out.printf("%.2f\n", graph.KruskalMST());
    }
}