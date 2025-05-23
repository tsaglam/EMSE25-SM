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

class UnionFind {
    int[] parent, rank;

    UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
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
        int xRoot = find(x), yRoot = find(y);
        if (xRoot == yRoot) return;
        if (rank[xRoot] < rank[yRoot])
            parent[xRoot] = yRoot;
        else if (rank[yRoot] < rank[xRoot])
            parent[yRoot] = xRoot;
        else {
            parent[yRoot] = xRoot;
            rank[xRoot]++;
        }
    }
}

class Freckles {
    private static double calculateWeight(Freckle a, Freckle b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Freckle[] freckles = new Freckle[N];
        ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            freckles[i] = new Freckle(scanner.nextDouble(), scanner.nextDouble());
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                edges.add(new Edge(i, j, calculateWeight(freckles[i], freckles[j])));
            }
        }

        // Sort edges based on their weight
        Collections.sort(edges);

        UnionFind uf = new UnionFind(N);

        double result = 0.0;
        for (Edge e : edges) {
            if (uf.find(e.src) != uf.find(e.dest)) {
                result += e.weight;
                uf.union(e.src, e.dest);
            }
        }

        System.out.printf(Locale.US, "%.2f\n", result);
    }
}