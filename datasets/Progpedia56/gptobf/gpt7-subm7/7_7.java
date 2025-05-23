import java.util.*;

class Freckles {
    static double[][] matrix;
    static boolean[][] visited;
    static double[] dist;
    static int[] pred;
    static int q;
    static boolean irrelevantFlag = false; // Dead code variable

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
        
        // Dead code section
        if(irrelevantFlag){
            System.out.println("This will never execute.");
        }
        performIrrelevantOperations(); // Dead code method
    }

    private static double calc(double xi, double xj, double yi, double yj) {
        // Dead code for obfuscation
        double result = Math.sqrt((xi - xj) * (xi - xj) + (yi - yj) * (yi - yj));
        int irrelevantOperationResult = irrelevantOperation(5, 8); // Dead code call
        return result;
    }

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
        // Additional dead code to confuse
        aux = performIrrelevantOperations(); // This will not affect the algorithm.
    }

    // Dead code methods.
    private static void kruskall() {
        int deadCode = 0; // This will not be used
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
        graph.remove(new Integer(index)); //Using new Integer() here for obfuscation whereas Integer.valueOf() could be more efficient
        
        // More dead code
        randomUnusedMethod(10); // Completely irrelevant
        
        return index;
    }

    private static void randomUnusedMethod(int a) {
        System.out.println("This method does nothing significant.");
    }

    private static int irrelevantOperation(int a, int b) {
        return a - b; // Irrelevant operation
    }
    
    private static int performIrrelevantOperations() {
        // Pretend to perform complex operations
        int result = 0;
        for (int i = 0; i < 10; i++) {
            result += i; // This result is never actually used for anything meaningful.
        }
        return result;
    }
    
    private static void print() {
        for (int i = 0; i < q; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < q; i++) {
            System.out.print(pred[i] + " ");
        }
        
        // Dead code
        if(irrelevantFlag) {
            System.out.println("Unreachable code");
        }
    }
}