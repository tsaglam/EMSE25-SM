import java.util.*;
class Freckles {
    static double[][] matrix;
    static boolean[][] visited;
    static double[] dist;
    static int[] pred;
    static int q;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in).useLocale(Locale.US);
        int n = q = in.nextInt();
        matrix = new double[n][n];
        visited = new boolean[n][n];
        dist = new double[n];
        pred = new int[n];
        double[][] coordinates = new double[n][2];
        for (int i = 0; i < n; i++) {
            double x = in.nextDouble();
            double y = in.nextDouble();
            coordinates[i][0] = x;
            coordinates[i][1] = y;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i != j) {
                    matrix[j][i] = matrix[i][j] = calc(coordinates[i][0], coordinates[j][0], coordinates[i][1], coordinates[j][1]);
                }
            }
        }
        prim(matrix, 0);
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += dist[i];
        }
        System.out.printf(Locale.US, "%.2f\n", sum);
    }
    private static double calc(double xi, double xj, double yi, double yj) {
        return Math.sqrt((xi - xj) * (xi - xj) + (yi - yj) * (yi - yj));
    }
    private static void kruskall() {}
    private static void prim(double[][] graph, int no) {
        int aux = q;
        LinkedList<Integer> vertices = new LinkedList<Integer>();
        for (int i = 0; i < q; i++) {
            pred[i] = 0;
            dist[i] = Double.MAX_VALUE;
            vertices.add(i);
        }
        dist[no] = 0;
        while (vertices.peekFirst() != null) {
            int u = min(vertices);
            for (int i = 0; i < q; i++) {
                if (vertices.indexOf(new Integer(i)) != -1 && graph[u][i] < dist[i]) {
                    pred[i] = u;
                    dist[i] = graph[u][i];
                }
            }
        }
    }
    private static int min(LinkedList<Integer> graph) {
        double min = Double.MAX_VALUE;
        int index = 0;
        for (Integer i : graph) {
            if (dist[i] < min) {
                index = i;
                min = dist[i];
            }
        }
        graph.remove(new Integer(index));
        return index;
    }
    private static void print() {
        for (int i = 0; i < q; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < q; i++) {
            System.out.print(pred[i] + " ");
        }
    }
}
