import java.util.PriorityQueue;
import java.util.Scanner;

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

    private static double calculateDistance(Freckle a, Freckle b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    private static double primMST(Freckle[] freckles, int N) {
        double[] key = new double[N];
        boolean[] mstSet = new boolean[N];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        
        for (int i = 0; i < N; i++) {
            key[i] = Double.MAX_VALUE;
            mstSet[i] = false;
        }
        
        pq.add(new Edge(0, 0, 0.0)); //start with the first freckle
        key[0] = 0;
        
        while (!pq.isEmpty()) {
            int u = pq.poll().dest;
            mstSet[u] = true;
            
            for (int v = 0; v < N; v++) {
                double weight = calculateDistance(freckles[u], freckles[v]);
                
                if (!mstSet[v] && weight < key[v]) {
                    key[v] = weight;
                    pq.add(new Edge(u, v, weight));
                }
            }
        }
        
        double totalWeight = 0;
        for (double weight : key) totalWeight += weight;
        return totalWeight;
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

        double inkSpent = primMST(freckles, N);

        System.out.printf("%.2f\n", inkSpent);
    }
}