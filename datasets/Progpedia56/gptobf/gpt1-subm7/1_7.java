import java.util.Locale;
import java.util.PriorityQueue;
import java.util.Scanner;

class Freckles {

    static class Edge implements Comparable<Edge> {
        int src, dest;
        double weight;

        Edge(int source, int destination, double weight) {
            this.src = source;
            this.dest = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge compareEdge) {
            return Double.compare(this.weight, compareEdge.weight);
        }
    }

    static class Subset {
        int parent, rank;

        Subset(int parent) {
            this.parent = parent;
            this.rank = 0;
        }
    }

    static class Graph {
        int vertices;
        double[][] coordinates;
        PriorityQueue<Edge> edgeQueue;

        Graph(int n) {
            this.vertices = n;
            this.coordinates = new double[n][2];
            this.edgeQueue = new PriorityQueue<>();
        }

        void addEdge(int src, int dest, double weight) {
            Edge edge = new Edge(src, dest, weight);
            edgeQueue.add(edge);
        }

        void calculateEdges() {
            for (int i = 0; i < this.vertices; i++) {
                for (int j = i + 1; j < this.vertices; j++) {
                    double weight = calculateDistance(this.coordinates[i][0], this.coordinates[i][1],
                                                      this.coordinates[j][0], this.coordinates[j][1]);
                    addEdge(i, j, weight);
                }
            }
        }

        double primMST() {
            boolean[] inMST = new boolean[vertices];
            double[] key = new double[vertices];

            for (int i = 0; i < vertices; i++) {
                key[i] = Double.MAX_VALUE;
            }

            key[0] = 0; // Include first vertex in MST
            double result = 0; // Used to store the final result

            for (int count = 0; count < vertices; count++) {
                // Pick the minimum key vertex from the set of vertices not yet included in MST
                double min = Double.MAX_VALUE;
                int u = -1;

                for (int v = 0; v < vertices; v++) {
                    if (!inMST[v] && key[v] < min) {
                        min = key[v];
                        u = v;
                    }
                }

                // Add the picked vertex to the MST Set
                inMST[u] = true;
                result += key[u];

                // Update key value and parent index of the adjacent vertices of the picked vertex.
                for (Edge edge : edgeQueue) {
                    if (isConnected(u, edge) && !inMST[otherVertex(u, edge)] && edge.weight < key[otherVertex(u, edge)]) {
                        key[otherVertex(u, edge)] = edge.weight;
                    }
                }
            }

            return result;
        }

        private boolean isConnected(int vertex, Edge edge) {
            return edge.src == vertex || edge.dest == vertex;
        }

        private int otherVertex(int vertex, Edge edge) {
            return edge.src == vertex ? edge.dest : edge.src;
        }

        private double calculateDistance(double x1, double y1, double x2, double y2) {
            return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in).useLocale(Locale.US);
        int n = in.nextInt();
        Graph graph = new Graph(n);

        for (int i = 0; i < n; i++) {
            graph.coordinates[i][0] = in.nextDouble();
            graph.coordinates[i][1] = in.nextDouble();
        }

        graph.calculateEdges();
        System.out.printf(Locale.US, "%.2f\n", graph.primMST());
    }
}