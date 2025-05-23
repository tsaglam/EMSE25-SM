import java.util.Scanner;
import java.util.PriorityQueue;

class Freckles {

    static class Edge implements Comparable<Edge> {
        int src, dest;
        double weight;

        public Edge(int src, int dest, double weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        public int compareTo(Edge compareEdge) {
            return Double.compare(this.weight, compareEdge.weight);
        }
    }

    static class Point {
        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    // Function to calculate distance between two points
    static double distance(Point a, Point b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        Point[] freckles = new Point[N];
        for (int i = 0; i < N; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            freckles[i] = new Point(x, y);
        }

        System.out.printf("%.2f\n", primMST(freckles));
    }

    static double primMST(Point[] points) {
        boolean[] inMST = new boolean[points.length];
        double[] key = new double[points.length];
        for (int i = 0; i < points.length; i++) {
            key[i] = Double.MAX_VALUE;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        key[0] = 0.0;
        pq.offer(new Edge(-1, 0, 0));

        double result = 0.0;

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int u = edge.dest;

            if (inMST[u]) continue;
            inMST[u] = true;

            result += edge.weight;

            for (int v = 0; v < points.length; v++) {
                if (!inMST[v]) {
                    double distance = distance(points[u], points[v]);
                    if (distance < key[v]) {
                        key[v] = distance;
                        pq.offer(new Edge(u, v, distance));
                    }
                }
            }
        }

        return result;
    }
}