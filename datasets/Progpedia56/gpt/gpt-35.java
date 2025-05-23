import java.util.Scanner;
import java.util.PriorityQueue;

class Freckle {
    double x, y;

    Freckle(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

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

class Main {

    public static double calcDistance(Freckle a, Freckle b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    public static double primMST(Freckle[] freckles, int N) {
        boolean[] visited = new boolean[N];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        double result = 0.0; // Total weight of the MST
        int edgesInMST = 0; // Count of edges included in the MST

        // Add all edges from the first node to the priority queue
        visited[0] = true;
        for (int i = 1; i < N; i++) {
            pq.add(new Edge(0, i, calcDistance(freckles[0], freckles[i])));
        }

        while (!pq.isEmpty() && edgesInMST < N - 1) {
            Edge edge = pq.poll();
            if (!visited[edge.dest]) {
                visited[edge.dest] = true;
                result += edge.weight;
                edgesInMST++;

                // Add all edges from the newly visited node if the destination node is not visited
                for (int i = 0; i < N; i++) {
                    if (!visited[i]) {
                        pq.add(new Edge(edge.dest, i, calcDistance(freckles[edge.dest], freckles[i])));
                    }
                }
            }
        }

        return result;
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

        double inkAmount = primMST(freckles, N);

        System.out.printf("%.2f\n", inkAmount);
    }
}