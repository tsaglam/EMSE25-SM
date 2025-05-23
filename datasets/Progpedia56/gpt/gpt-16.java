import java.util.Scanner;
import java.util.PriorityQueue;

class Freckle implements Comparable<Freckle> {
    int index;
    double cost;

    Freckle(int index, double cost) {
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Freckle other) {
        return Double.compare(this.cost, other.cost);
    }
}

class Main {
    static final int MAX = 100;
    static double[][] positions = new double[MAX][2];
    static boolean[] visited = new boolean[MAX];
    static PriorityQueue<Freckle> pq = new PriorityQueue<>();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // Reading freckles' positions
        for (int i = 0; i < n; i++) {
            positions[i][0] = scanner.nextDouble();
            positions[i][1] = scanner.nextDouble();
        }
        // Prim's algorithm to find the minimum ink
        double totalInk = prim(n);
        System.out.printf("%.2f\n", totalInk);
        scanner.close();
    }

    // Prim's algorithm
    private static double prim(int n) {
        double result = 0;
        pq.add(new Freckle(0, 0)); // Starting from the first freckle;

        while (!pq.isEmpty()) {
            Freckle current = pq.poll();
            int currentIndex = current.index;
            if (visited[currentIndex]) continue;
            visited[currentIndex] = true;
            result += current.cost;

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    double dist = distance(positions[currentIndex], positions[i]);
                    pq.add(new Freckle(i, dist));
                }
            }
        }
        return result;
    }

    // Calculating distance between two points
    private static double distance(double[] a, double[] b) {
        return Math.sqrt(Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
    }
}