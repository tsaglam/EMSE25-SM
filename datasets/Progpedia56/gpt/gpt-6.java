import java.util.*;

class Freckles {

    public static class Point {
        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Edge implements Comparable<Edge> {
        int src, dest;
        double weight;

        Edge(int src, int dest, double weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        public int compareTo(Edge compareEdge) {
            return Double.compare(this.weight, compareEdge.weight);
        }
    }

    public static class Subset {
        int parent, rank;
    }

    int vertices;
    ArrayList<Edge> edges = new ArrayList<>();

    Freckles(int n) {
        this.vertices = n;
    }

    void addEdge(int src, int dest, double weight) {
        edges.add(new Edge(src, dest, weight));
    }

    int find(Subset subsets[], int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);

        return subsets[i].parent;
    }

    void union(Subset subsets[], int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    void KruskalMST() {
        ArrayList<Edge> result = new ArrayList<>();
        int i = 0;
        int e = 0;
        Collections.sort(edges);

        Subset subsets[] = new Subset[vertices];
        for(i = 0; i < vertices; ++i)
            subsets[i] = new Subset();

        for (int v = 0; v < vertices; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        i = 0;
        while (e < vertices - 1) {
            Edge next_edge = edges.get(i++);

            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            if (x != y) {
                result.add(next_edge);
                union(subsets, x, y);
                e++;
            }
        }
        double minimumCost = 0.0;
        for (i = 0; i < result.size(); ++i)
            minimumCost += result.get(i).weight;
        
        System.out.printf("%.2f\n", minimumCost);
    }

    static double calculateDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Point points[] = new Point[N];

        for (int i = 0; i < N; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            points[i] = new Point(x, y);
        }

        Freckles graph = new Freckles(N);

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                double weight = calculateDistance(points[i], points[j]);
                graph.addEdge(i, j, weight);
            }
        }

        graph.KruskalMST();
    }
}