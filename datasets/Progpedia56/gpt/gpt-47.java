import java.util.Scanner;

class Freckles {
    static final int MAX = 100;
    static int N;
    static Point[] points = new Point[MAX];
    static double[][] dist = new double[MAX][MAX];
    static boolean[] visited = new boolean[MAX];
    static double[] minDist = new double[MAX];
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            points[i] = new Point(x, y);
        }

        calculateDistances();
        double result = prim();
        System.out.printf("%.2f\n", result);
    }
    
    static void calculateDistances() {
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                double distance = points[i].distance(points[j]);
                dist[i][j] = dist[j][i] = distance;
            }
        }
    }
    
    static double prim() {
        double totalWeight = 0;
        for (int i = 0; i < N; i++) {
            minDist[i] = Double.MAX_VALUE;
        }
        minDist[0] = 0;
        
        for (int i = 0; i < N; i++) {
            int u = -1;
            for (int j = 0; j < N; j++) {
                if (!visited[j] && (u == -1 || minDist[j] < minDist[u])) u = j;
            }
            
            visited[u] = true;
            totalWeight += minDist[u];
            
            for (int v = 0; v < N; v++) {
                if (!visited[v] && dist[u][v] < minDist[v]) {
                    minDist[v] = dist[u][v];
                }
            }
        }
        
        return totalWeight;
    }
}

class Point {
    double x, y;
    
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double distance(Point other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }
}