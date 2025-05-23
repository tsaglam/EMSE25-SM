import java.util.Scanner;
import java.util.PriorityQueue;

class Freckles {

    static class Edge implements Comparable<Edge> {
        int src, dest;
        double weight;

        Edge(int src, int dest, double weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

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

    private static int find(Subset subsets[], int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
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

    private static double kruskalMST(Point[] points, int N) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        Subset[] subsets = new Subset[N];
        for (int i = 0; i < N; ++i) {
            subsets[i] = new Subset(i, 0);
            for (int j = i + 1; j < N; j++) {
                double weight = Math.sqrt(Math.pow(points[i].x - points[j].x, 2) + Math.pow(points[i].y - points[j].y, 2));
                pq.add(new Edge(i, j, weight));
            }
        }

        int edgeCount = 0;
        double result = 0;
        while (edgeCount < N - 1) {
            Edge next_edge = pq.remove();

            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            if (x != y) {
                result += next_edge.weight;
                union(subsets, x, y);
                edgeCount++;
            }
        }
        return result;
    }

    static class Point {
        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        Point[] points = new Point[N];
        for(int i = 0; i < N; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            points[i] = new Point(x, y);
        }

        double result = kruskalMST(points, N);
        System.out.printf("%.2f\n", result);
    }
}