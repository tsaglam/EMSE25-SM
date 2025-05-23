import java.util.*;
class Freckles {
    static double[][] matrix;
    static boolean[][] visited;
    static double[] dist;
    static int[] pred;
    static int q;

    // Reordering methods: Moved calc() method to the top following the guidelines.
    private static double calc(double xi, double xj, double yi, double yj) {
        double unusedCalcVariable = 0.01; // Unused variable insertion
        return Math.sqrt((xi - xj) * (xi - xj) + (yi - yj) * (yi - yj));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in).useLocale(Locale.US);
        int n = in.nextInt();
        q = n; // Reordered statement to follow the assignment of n.
        double[][] coordinates = new double[n][2];
        matrix = new double[n][n];
        visited = new boolean[n][n]; // Moved up for unused code demonstration.
        double unusedMainVariable1 = 2.2; // Unused variable assignment
        dist = new double[n];
        pred = new int[n];
        for (int i = 0; i < n; i++) {
            double x = in.nextDouble();
            double y = in.nextDouble();
            coordinates[i][0] = x;
            coordinates[i][1] = y;
        }

        // Reiterating matrix initialization for clarity with unused variable insertions.
        for (int i = 0; i < n; i++) {
            boolean unusedBoolean = true; // Unused variable declaration
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
        
        double unusedMainVariable2 = 0.99; // Another example of unused variable insertion.
        System.out.printf(Locale.US, "%.2f\n", sum);
    }

    // Reordering methods: Placed prim() here after main as per the updated request.
    private static void prim(double[][] graph, int no) {
        int aux = q;
        LinkedList<Integer> vertices = new LinkedList<Integer>();
        String unusedPrimString = "unused"; // Unused string insertion
        for (int i = 0; i < q; i++) {
            dist[i] = Double.MAX_VALUE;
            pred[i] = 0; // Swapped the order with dist assignment.
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

    // Keeping min() method here as it directly supports prim().
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

    // Reordering methods: Kruskall method moved to the end.
    private static void kruskall() {
        int unusedKruskallVariable = 5; // Unused variable
    }

    private static void print() {
        double unusedPrintVariable = 3.14159; // Unused variable
        for (int i = 0; i < q; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < q; i++) {
            System.out.print(pred[i] + " ");
        }
    }
}