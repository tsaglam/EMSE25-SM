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
    private static double calculateDistance(Freckle freckle1, Freckle freckle2) {
        return Math.sqrt(Math.pow(freckle1.x - freckle2.x, 2) + Math.pow(freckle1.y - freckle2.y, 2));
    }

    private static double primMST(Freckle[] freckles) {
        int n = freckles.length;
        boolean[] added = new boolean[n];
        double[] minWeight = new double[n];
        Edge[] edgeTo = new Edge[n];

        // Initialize keys to infinity
        for (int i = 0; i < n; i++) {
            minWeight[i] = Double.MAX_VALUE;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        // Start with vertex 0
        minWeight[0] = 0;
        pq.add(new Edge(0, 0, 0)); // Weight is 0 to add to the PQ

        double minSpanningTreeWeight = 0;
        
        while (!pq.isEmpty()) {
            int u = pq.poll().dest; // Vertex with the smallest weight
            if (added[u]) continue; // Skip if already added to the MST
            added[u] = true; // Mark this node as added to MST
            minSpanningTreeWeight += minWeight[u];

            for (int v = 0; v < n; v++) {
                if (u != v && !added[v]) {
                    double weight = calculateDistance(freckles[u], freckles[v]);
                    if (weight < minWeight[v]) {
                        minWeight[v] = weight;
                        edgeTo[v] = new Edge(u, v, weight);
                        pq.offer(new Edge(u, v, weight));
                    }
                }
            }
        }

        return minSpanningTreeWeight;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Freckle[] freckles = new Freckle[n];

        for (int i = 0; i < n; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            freckles[i] = new Freckle(x, y);
        }
        
        double result = primMST(freckles);
        System.out.printf("%.2f\n", result);
    }
}