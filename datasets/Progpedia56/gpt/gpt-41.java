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
    int to;
    double weight;

    Edge(int to, double weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge compareEdge) {
        return Double.compare(this.weight, compareEdge.weight);
    }
}

class Freckles {

    private static double prim(int n, double[][] distanceMatrix) {
        double result = 0.0;
        boolean[] visited = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        // Add all edges from vertex 0 to the priority queue.
        for(int i = 1; i < n; i++) {
            pq.add(new Edge(i, distanceMatrix[0][i]));
        }
        visited[0] = true;

        while(!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (!visited[edge.to]) {
                result += edge.weight;
                visited[edge.to] = true;

                for (int to = 0; to < n; to++) {
                    if (!visited[to]) {
                        pq.add(new Edge(to, distanceMatrix[edge.to][to]));
                    }
                }
            }
        }

        return result;
    }

    private static double calculateDistance(Freckle a, Freckle b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Freckle[] freckles = new Freckle[n];
        double[][] distanceMatrix = new double[n][n];

        for(int i = 0; i < n; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            freckles[i] = new Freckle(x, y);
        }

        // Calculate all pairwise freckle distances.
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                double dist = calculateDistance(freckles[i], freckles[j]);
                distanceMatrix[i][j] = dist;
                distanceMatrix[j][i] = dist; // Since the graph is undirected.
            }
        }

        double inkRequired = prim(n, distanceMatrix);
        System.out.printf("%.2f\n", inkRequired);
        scanner.close();
    }
}