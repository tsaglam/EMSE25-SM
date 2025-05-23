import java.util.*;

class Freckles {
    static double[][] matrix;
    static boolean[][] visited;
    static double[] dist;
    static int[] pred;
    static int q;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in).useLocale(Locale.US);
        int n = in.nextInt();
        q = n;
        matrix = new double[n][n];
        visited = new boolean[n][n];
        dist = new double[n];
        pred = new int[n];
        double[][] coordinates = new double[n][2];
        
        for (int i = 0; i < n; i++) {
            coordinates[i][0] = in.nextDouble();
            coordinates[i][1] = in.nextDouble();
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                matrix[i][j] = matrix[j][i] = calc(coordinates[i][0], coordinates[j][0], coordinates[i][1], coordinates[j][1]);
            }
        }
        
        prim(matrix, 0);
        
        double sum = 0;
        for (double v : dist) sum += v;

        System.out.printf(Locale.US, "%.2f\n", sum);
    }

    private static double calc(double xi, double xj, double yi, double yj) {
        double dx = xi - xj, dy = yi - yj;
        return Math.sqrt(dx * dx + dy * dy);
    }

    private static void prim(double[][] graph, int start) {
        Arrays.fill(dist, Double.MAX_VALUE);
        Arrays.fill(pred, -1);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingDouble(i -> dist[i]));
        
        dist[start] = 0;
        pq.offer(start);
        
        while (!pq.isEmpty()) {
            int u = pq.poll();
            for (int v = 0; v < q; v++) {
                if (graph[u][v] != 0 && graph[u][v] < dist[v]) {
                    pred[v] = u;
                    dist[v] = graph[u][v];
                    if (!pq.contains(v)) pq.offer(v);
                }
            }
        }
    }
}