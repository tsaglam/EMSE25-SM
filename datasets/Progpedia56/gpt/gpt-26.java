import java.awt.geom.Point2D;
import java.util.PriorityQueue;
import java.util.Scanner;

class Freckles {

    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
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

    static class Graph {
        int vertices;
        Point2D[] coordinates;

        public Graph(int vertices) {
            this.vertices = vertices;
            coordinates = new Point2D[vertices];
        }

        public void addCoordinate(int index, double x, double y) {
            coordinates[index] = new Point2D.Double(x, y);
        }

        public double primMST() {
            boolean[] visited = new boolean[vertices];
            double[] key = new double[vertices];
            for (int i = 0; i < vertices; i++) {
                key[i] = Double.MAX_VALUE;
            }

            PriorityQueue<Edge> pq = new PriorityQueue<Edge>();

            key[0] = 0;
            pq.offer(new Edge(-1, 0, 0));

            double result = 0;

            while (!pq.isEmpty()) {
                Edge e = pq.poll();
                int vertex = e.dest;

                if (visited[vertex]) continue;

                visited[vertex] = true;
                result += e.weight;

                for (int dest = 0; dest < vertices; dest++) {
                    if (vertex != dest) {
                        double distance = coordinates[vertex].distance(coordinates[dest]);
                        if (!visited[dest] && distance < key[dest]) {
                            key[dest] = distance;
                            pq.offer(new Edge(vertex, dest, distance));
                        }
                    }
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Graph graph = new Graph(n);

        for (int i = 0; i < n; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            graph.addCoordinate(i, x, y);
        }

        System.out.format("%.2f\n", graph.primMST());
    }
}