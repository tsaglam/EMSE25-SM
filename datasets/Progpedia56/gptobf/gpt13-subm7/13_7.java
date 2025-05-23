import java.util.*;

class Freckles {
    static double[][] matrix;
    static boolean[][] visited; 
    static double[] dist;
    static int[] pred;
    static int q;

    // ------------------ Reordered main method with unused code inserted ------------------
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in).useLocale(Locale.US);
        q = in.nextInt(); // moved assignment to here, original place of `int n = q = in.nextInt();`
        int n = q;
        double[][] coordinates = new double[n][2]; // moved up for statement reordering
        matrix = new double[n][n];
        visited = new boolean[n][n]; // moved but it's unused
        dist = new double[n];
        pred = new int[n];
        for (int i = 0; i < n; i++) {
            double x = in.nextDouble();
            double y = in.nextDouble();
            coordinates[i][0] = x; // kept order due to dependency
            coordinates[i][1] = y; // kept order due to dependency
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
            sum += dist[i]; // this loop's position is fixed due to dependency on dist being fully populated
        }
        System.out.printf(Locale.US, "%.2f\n", sum);
        
        // Unused variables
        int unusedInt = 0;
        double unusedDouble = 0.0;
        String unusedString = "Hello";
    }

    // ------------------ Reordered methods ------------------
    private static double calc(double xi, double xj, double yi, double yj) {
        // Unused method variables
        double unusedCalcVar = 0.0;
        return Math.sqrt((xi - xj) * (xi - xj) + (yi - yj) * (yi - yj));
    }


    private static void prim(double[][] graph, int no) {
        // Unused method variables
        double unusedPrimVar = 1.1;
        LinkedList<Integer> vertices = new LinkedList<Integer>();
        for (int i = 0; i < q; i++) {
            pred[i] = 0;
            dist[i] = Double.MAX_VALUE;
            vertices.add(i);
        }
        dist[no] = 0;
        while (!vertices.isEmpty()) {
            int u = min(vertices);
            for (int i = 0; i < q; i++) {
                if (vertices.contains(i) && graph[u][i] < dist[i]) {
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

    // ------------------ Unused methods ------------------
    private static void unusedMethod1() {
        System.out.println("Unused 1");
    }

    private static void unusedMethod2() {
        System.out.println("Unused 2");
    }

    private static void unusedMethod3() {
        System.out.println("Unused 3");
    }
}