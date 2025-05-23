import java.util.Scanner;
import java.util.PriorityQueue;

class Freckles {

    static class Edge implements Comparable<Edge> {
        int from, to;
        double weight;

        Edge(int from, int to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge compareEdge) {
            return Double.compare(this.weight, compareEdge.weight);
        }
    }

    static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
    
    static double prim(int n, double[][] freckles) {
        boolean[] visited = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        double result = 0.0;
        // Add all edges from first vertex to the priority queue
        for (int i = 1; i < n; i++) {
            pq.offer(new Edge(0, i, calculateDistance(freckles[0][0], freckles[0][1], freckles[i][0], freckles[i][1])));
        }
        visited[0] = true; // Mark the first vertex as visited

        while (!pq.isEmpty()) {
            Edge edge = pq.poll(); // Get the edge with the minimum weight
            if (visited[edge.to]) continue; // If the destination vertex is already visited, skip
            result += edge.weight; // Add the edge's weight to the result
            visited[edge.to] = true; // Mark the destination vertex as visited

            // Add new edges to the queue
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    pq.offer(new Edge(edge.to, i, calculateDistance(freckles[edge.to][0], freckles[edge.to][1], freckles[i][0], freckles[i][1])));
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // Number of freckles
        double[][] freckles = new double[N][2]; // Coordinates of freckles

        for (int i = 0; i < N; i++) {
            freckles[i][0] = scanner.nextDouble(); // X coordinate
            freckles[i][1] = scanner.nextDouble(); // Y coordinate
        }
        
        double result = prim(N, freckles);
        System.out.printf("%.2f\n", result);
        
        scanner.close();
    }
}