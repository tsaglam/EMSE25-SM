import java.util.*;

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
    int n;

    public UnionFind(int n) {
        this.n = n;
        parent = new int[n];
        rank = new int[n];
        makeSet();
    }

    void makeSet() {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    void union(int x, int y) {
        int xRoot = find(x), yRoot = find(y);

        if (xRoot == yRoot)
            return;

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

    public static double findMST(int n, Edge[] edges) {
        Arrays.sort(edges);

        UnionFind uf = new UnionFind(n);

        int e = 0;
        int i = 0;
        double mstWeight = 0.0;

        while (e < n - 1 && i < edges.length) {
            Edge next_edge = edges[i++];

            int x = uf.find(next_edge.src);
            int y = uf.find(next_edge.dest);

            if (x != y) {
                mstWeight += next_edge.weight;
                uf.union(x, y);
                e++;
            }
        }

        return mstWeight;
    }

    public static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        double[][] freckles = new double[N][2];

        for (int i = 0; i < N; i++) {
            freckles[i][0] = scanner.nextDouble();
            freckles[i][1] = scanner.nextDouble();
        }

        List<Edge> edges = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                double weight = distance(freckles[i][0], freckles[i][1], freckles[j][0], freckles[j][1]);
                edges.add(new Edge(i, j, weight));
            }
        }

        Edge[] edgesArr = edges.toArray(new Edge[0]);
        double mstWeight = findMST(N, edgesArr);

        System.out.printf("%.2f\n", mstWeight);
    }
}