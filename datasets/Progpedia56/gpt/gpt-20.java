import java.util.Scanner;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Edge implements Comparable<Edge> {
    int src, dest;
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

class Freckles {

    // Method to calculate distance between two points
    private static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    // Method to generate the Minimum Spanning Tree using Prim's Algorithm
    private static double primMST(ArrayList<Edge>[] graph, int N) {
        boolean[] visited = new boolean[N];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        double result = 0.0;
        int edgesAdded = 0; // count of edges added in the MST

        // starting from vertex 0
        visited[0] = true;
        // add all connections of vertex 0 to the queue
        pq.addAll(graph[0]);

        while (!pq.isEmpty() && edgesAdded < N - 1) {
            Edge edge = pq.poll();

            if (visited[edge.dest]) continue;
            visited[edge.dest] = true;
            result += edge.weight;
            edgesAdded++;

            for (Edge nextEdge : graph[edge.dest]) {
                if (!visited[nextEdge.dest]) {
                    pq.add(nextEdge);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        double[][] freckles = new double[N][2];

        // Reading freckle coordinates
        for (int i = 0; i < N; i++) {
            freckles[i][0] = scanner.nextDouble();
            freckles[i][1] = scanner.nextDouble();
        }

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        // Connecting all the points (freckles) with edges having their pairwise distance as weight
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                double distance = calculateDistance(freckles[i][0], freckles[i][1], freckles[j][0], freckles[j][1]);
                graph[i].add(new Edge(i, j, distance));
                graph[j].add(new Edge(j, i, distance));
            }
        }

        // Applying Prim's algorithm to find the minimal connecting ink (weight)
        double minimumInkRequired = primMST(graph, N);

        // Printing the total ink required with two decimal places
        System.out.printf("%.2f%n", minimumInkRequired);
        
        scanner.close();
    }
}