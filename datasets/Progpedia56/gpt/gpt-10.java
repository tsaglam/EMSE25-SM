import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Freckles {
    
    static class Edge implements Comparable<Edge> {
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

    static class Subset {
        int parent, rank;
    }

    int V, E; // V -> no. of vertices & E -> no.of edges
    ArrayList<Edge> edgeList;

    Freckles(int n) {
        V = n;
        E = 0;
        edgeList = new ArrayList<>();
    }

    void addEdge(int src, int dest, double weight) {
        Edge edge = new Edge(src, dest, weight);
        edgeList.add(edge);
        E++;
    }

    int find(Subset subsets[], int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);

        return subsets[i].parent;
    }

    void Union(Subset subsets[], int x, int y) {
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

    void KruskalMST() {
        Edge result[] = new Edge[V];
        int e = 0;
        int i = 0;
        for (i = 0; i < V; ++i)
            result[i] = new Edge(0, 0, 0);

        Collections.sort(edgeList);

        Subset subsets[] = new Subset[V];
        for (i = 0; i < V; ++i)
            subsets[i] = new Subset();

        for (int v = 0; v < V; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        i = 0;
        while (e < V - 1) {
            Edge next_edge = new Edge(0, 0, 0);
            if (i < edgeList.size()) {
                next_edge = edgeList.get(i++);
            }

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
        System.out.printf("%.2f\n", minimumCost);
    }

    public static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        double[][] points = new double[N][2];
        for (int i = 0; i < N; i++) {
            points[i][0] = scanner.nextDouble();
            points[i][1] = scanner.nextDouble();
        }

        Freckles graph = new Freckles(N);

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double weight = distance(points[i][0], points[i][1], points[j][0], points[j][1]);
                graph.addEdge(i, j, weight);
            }
        }

        graph.KruskalMST();
        scanner.close();
    }
}