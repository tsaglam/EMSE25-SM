import java.util.*;

class Freckles {
    static double[][] matrix;
    static boolean[][] visited;
    static double[] dist;
    static int[] pred;
    static int q;

    // Unused method introduced as requested
    private static void unusedMethod() {
        System.out.println("This is an unused method.");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in).useLocale(Locale.US);
        int n = q = in.nextInt();
        double[][] coordinates = new double[n][2]; // Moved this statement up, it's independent.
        matrix = new double[n][n];
        visited = new boolean[n][n];
        dist = new double[n];
        pred = new int[n];
        // Unused variable as requested
        String unusedVariable = "unused";

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

    // Method order changed as requested
    private static void prim(double[][] graph, int no) {
        LinkedList<Integer> vertices = new LinkedList<>();
        for (int i = 0; i < q; i++) {
            pred[i] = 0;
            dist[i] = Double.MAX_VALUE;
            vertices.add(i);
        }
        dist[no] = 0;
        while (vertices.peekFirst() != null) {
            int u = min(vertices);
            for (int i = 0; i < q; i++) {
                if (vertices.indexOf(i) != -1 && graph[u][i] < dist[i]) {
                    pred[i] = u;
                    dist[i] = graph[u][i];
                }
            }
        }
    }

    private static double calc(double xi, double xj, double yi, double yj) {
        return Math.sqrt((xi - xj) * (xi - xj) + (yi - yj) * (yi - yj));
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

    // This method is kept at the end as per reordering request but remains unchanged because it's not used and hence does not impact functionality.
    private static void kruskall() {}

    // Reordered print method
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