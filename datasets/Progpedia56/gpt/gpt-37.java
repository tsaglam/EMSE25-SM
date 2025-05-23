import java.util.Scanner;
import java.util.PriorityQueue;

class FrecklesInk {

    static class Freckle {
        double x, y;

        Freckle(double x, double y) {
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

        @Override
        public int compareTo(Edge compareEdge) {
            return Double.compare(this.weight, compareEdge.weight);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Freckle[] freckles = new Freckle[N];

        for (int i = 0; i < N; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            freckles[i] = new Freckle(x, y);
        }

        double result = primMST(freckles, N);
        System.out.printf("%.2f\n", result);
    }

    static double calculateDistance(Freckle a, Freckle b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    static double primMST(Freckle[] freckles, int N) {
        boolean[] inMST = new boolean[N];
        Edge[] edge = new Edge[N];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            edge[i] = new Edge(-1, i, Double.MAX_VALUE);
        }
        
        edge[0].weight = 0;
        pq.add(edge[0]);

        double mstWeight = 0;

        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            int u = e.dest;

            if (inMST[u]) {
                continue;
            }

            inMST[u] = true;
            mstWeight += e.weight;

            for (int v = 0; v < N; v++) {
                if (!inMST[v]) {
                    double distance = calculateDistance(freckles[u], freckles[v]);
                    if (distance < edge[v].weight) {
                        pq.remove(edge[v]);
                        edge[v].weight = distance;
                        pq.add(edge[v]);
                    }
                }
            }
        }
        return mstWeight;
    }
}