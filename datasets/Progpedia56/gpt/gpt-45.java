import java.util.*;

class Freckle {
    double x, y;

    Freckle(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class Edge implements Comparable<Edge> {
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

class Subset {
    int parent, rank;

    Subset(int parent, int rank) {
        this.parent = parent;
        this.rank = rank;
    }
}

class FrecklesKruskal {
    private final List<Freckle> freckles;
    private final List<Edge> edges;
    private int V;

    FrecklesKruskal() {
        this.freckles = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public void addFreckle(double x, double y) {
        freckles.add(new Freckle(x, y));
        V = freckles.size();
    }

    private double calculateDistance(Freckle a, Freckle b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    private void prepareEdges() {
        for (int i = 0; i < V - 1; i++) {
            for (int j = i + 1; j < V; j++) {
                double distance = calculateDistance(freckles.get(i), freckles.get(j));
                edges.add(new Edge(i, j, distance));
            }
        }
    }

    private int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    private void union(Subset[] subsets, int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank) {
            subsets[xroot].parent = yroot;
        }
        else if (subsets[xroot].rank > subsets[yroot].rank) {
            subsets[yroot].parent = xroot;
        }
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    public double calculateInk() {
        double result = 0;
        int e = 0;
        prepareEdges();

        Collections.sort(edges);

        Subset[] subsets = new Subset[V];
        for (int v = 0; v < V; ++v) {
            subsets[v] = new Subset(v, 0);
        }

        int i = 0;
        while (e < V - 1 && i < edges.size()) {
            Edge next_edge = edges.get(i++);
            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            if (x != y) {
                result += next_edge.weight;
                union(subsets, x, y);
                e++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        FrecklesKruskal graph = new FrecklesKruskal();

        for (int i = 0; i < N; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            graph.addFreckle(x, y);
        }

        System.out.printf(Locale.US, "%.2f\n", graph.calculateInk());
    }
}