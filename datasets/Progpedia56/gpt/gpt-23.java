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

        // Sorting edges based on their weight
        public int compareTo(Edge compareEdge) {
            return Double.compare(this.weight, compareEdge.weight);
        }
    }

    static class Subset {
        int parent, rank;

        Subset(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }
    }

    static class Point {
        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int find(Subset subsets[], int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    private static void union(Subset subsets[], int x, int y) {
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

    private static double kruskalMST(ArrayList<Edge> edges, int N) {
        Collections.sort(edges);

        Subset[] subsets = new Subset[N];
        for (int v = 0; v < N; ++v) {
            subsets[v] = new Subset(v, 0);
        }

        int e = 0;
        double result = 0.0;

        int i = 0;
        while (e < N - 1) {
            Edge next_edge = edges.get(i++);

            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            if (x != y) {
                result += next_edge.weight;
                union(subsets, x, y);
                e++;
            }
        }
        return result;
    }

    public static double calculateDistance(Point p1, Point p2) {
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        ArrayList<Point> points = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            points.add(new Point(x, y));
        }

        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                edges.add(new Edge(i, j, calculateDistance(points.get(i), points.get(j))));
            }
        }
        
        double result = kruskalMST(edges, N);
        System.out.printf("%.2f\n", result);
        scanner.close();
    }
}