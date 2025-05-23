import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class Freckles {

    static class Point {
        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge> {
        int src, dest;
        double weight;

        Edge(int src, int dest, double weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        public int compareTo(Edge compareEdge) {
            if (this.weight < compareEdge.weight) return -1;
            if (this.weight > compareEdge.weight) return 1;
            return 0;
        }
    }

    // A class to represent a subset for union-find
    static class Subset {
        int parent, rank;
    }

    int V, E; // V-> no. of vertices & E->no.of edges
    Edge[] edge; // /collection of all edges

    // Creates a graph with V vertices and E edges
    Freckles(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < e; ++i) {
            edge[i] = new Edge(0, 0, 0.0);
        }
    }

    int find(Subset subsets[], int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    void Union(Subset subsets[], int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank) {
            subsets[xroot].parent = yroot;
        } else if (subsets[xroot].rank > subsets[yroot].rank) {
            subsets[yroot].parent = xroot;
        } else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    // The main function to construct MST using Kruskal's algorithm
    double KruskalMST() {
        Edge result[] = new Edge[V];
        int e = 0;
        int i = 0;
        for (i = 0; i < V; ++i) {
            result[i] = new Edge(0, 0, 0.0);
        }

        // Step 1: Sort all the edges in non-decreasing order of their weight.
        ArrayList<Edge> edges = new ArrayList<>();
        Collections.addAll(edges, edge);
        
        Collections.sort(edges);

        // Allocate memory for creating V ssubsets
        Subset subsets[] = new Subset[V];
        for (i = 0; i < V; ++i) {
            subsets[i] = new Subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }

        i = 0;

        while (e < V - 1 && i < E) {
            Edge next_edge = edges.get(i++);

            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            if (x != y) {
                result[e++] = next_edge;
                Union(subsets, x, y);
            }
        }

        double minimumCost = 0.0;
        for (i = 0; i < e; ++i) {
            minimumCost += result[i].weight;
        }
        return minimumCost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int V = scanner.nextInt();
        Point[] points = new Point[V];

        for (int i = 0; i < V; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            points[i] = new Point(x, y);
        }

        int E = V * (V - 1) / 2;
        Freckles graph = new Freckles(V, E);

        int edgeCount = 0;
        for (int i = 0; i < V; ++i) {
            for (int j = i + 1; j < V; ++j) {
                double weight = Math.sqrt(Math.pow((points[i].x - points[j].x), 2) + 
                                          Math.pow((points[i].y - points[j].y), 2));
                graph.edge[edgeCount++] = new Edge(i, j, weight);
            }
        }

        double inkSpent = graph.KruskalMST();
        System.out.printf("%.2f\n", inkSpent);
    }
}