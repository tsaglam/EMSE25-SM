import java.util.*;

class Point {
    double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class Edge implements Comparable<Edge> {
    int src, dest;
    double weight;

    public Edge(int src, int dest, double weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge compareEdge) {
        return Double.compare(this.weight, compareEdge.weight);
    }
}

class UnionFind {
    int[] parent, rank;
    int n;

    public UnionFind(int n) {
        this.n = n;
        this.parent = new int[n];
        this.rank = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
    }

    int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        if (rank[xRoot] < rank[yRoot])
            parent[xRoot] = yRoot;
        else if (rank[xRoot] > rank[yRoot])
            parent[yRoot] = xRoot;
        else {
            parent[yRoot] = xRoot;
            rank[xRoot]++;
        }
    }
}

class Freckles {

    static double calculateDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // Number of freckles

        Point[] points = new Point[N];

        for (int i = 0; i < N; i++) {
            points[i] = new Point(scanner.nextDouble(), scanner.nextDouble());
        }

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                edges.add(new Edge(i, j, calculateDistance(points[i], points[j])));
            }
        }

        Collections.sort(edges);

        UnionFind uf = new UnionFind(N);

        int edgeCount = 0;
        double result = 0;

        for (Edge nextEdge : edges) {
            int x = uf.find(nextEdge.src);
            int y = uf.find(nextEdge.dest);

            if (x != y) {
                result += nextEdge.weight;
                uf.union(x, y);
                edgeCount++;
                if (edgeCount == N - 1) break;
            }
        }

        System.out.printf(Locale.US, "%.2f\n", result);
    }
}