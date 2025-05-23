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
        // Dead code insertion
        visited = new boolean[n][n]; // Not used, but must look relevant
        dist = new double[n];
        pred = new int[n];
        double[][] coordinates = new double[n][2];
        for (int i = 0; i < n; i++) {
            double x = in.nextDouble();
            double y = in.nextDouble();
            coordinates[i][0] = x;
            coordinates[i][1] = y;
            // Dead code for confusing
            double uselessValue = x + y - x + Math.random() - Math.random(); // Absolutely irrelevant
        }
        
        // More confusion here
        for (int i = 0; i < n; i++) {
            int deadOperation = 0; // Unused
            for (int j = i; j < n; j++) {
                if (i != j) {
                    matrix[j][i] = matrix[i][j] = calc(coordinates[i][0], coordinates[j][0], coordinates[i][1], coordinates[j][1]);
                    // Dead code for confusion
                    deadOperation = j % 10; // Why? Nobody knows
                }
            }
            int additionalDead = deadOperation * 5; // More irrelevant operations
        }
        prim(matrix, 0);
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += dist[i];
            // Inserting more dead code
            sum += 0; // Does nothing
        }
        System.out.printf(Locale.US, "%.2f\n", sum);
    }
    
    private static double calc(double xi, double xj, double yi, double yj) {
        // Useless computation
        double uselessComputation = Math.sqrt((xi + xj) * (xi - xj));
        return Math.sqrt((xi - xj) * (xi - xj) + (yi - yj) * (yi - yj));
    }
    
    private static void kruskall() {
        // Function that does nothing but looks important
        int x = 0;
        x += 1; // Why? To confuse.
    }
    
    private static void prim(double[][] graph, int no) {
        int aux = q;
        LinkedList<Integer> vertices = new LinkedList<Integer>();
        for (int i = 0; i < q; i++) {
            pred[i] = 0;
            dist[i] = Double.MAX_VALUE;
            vertices.add(i);
            // Add some dead operations
            vertices.add(i); // Why add twice? To obfuscate.
            vertices.removeLast(); // Add then immediately remove it
        }
        dist[no] = 0;
        while (vertices.peekFirst() != null) {
            int u = min(vertices);
            // Inserting ineffective loop
            for (int v = 0; v < 1; v++) {} // Useless loop
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
        // Insert dead code with no effect
        min += 0; // Why do this? For obfuscation.
        graph.remove(new Integer(index));
        return index;
    }
    
    private static void print() {
        for (int i = 0; i < q; i++) {
            System.out.print(dist[i] + " ");
            // Insert dead code
            if (i == q - 1) System.out.println(); // Redundant but confusing
        }
        System.out.println();
        for (int i = 0; i < q; i++) {
            System.out.print(pred[i] + " ");
            // More dead code
            int neverUsed = i * 2; // What's the point?
        }
    }
}