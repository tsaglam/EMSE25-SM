import java.util.*;
import java.io.*;

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

class DisjointSet {
    int[] rank, parent;
    int n;

    public DisjointSet(int n) {
        rank = new int[n];
        parent = new int[n];
        this.n = n;
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
            rank[xRoot] = rank[xRoot] + 1;
        }
    }
}

class FrecklesInk {

    static List<Edge> edges;
    static Freckle[] freckles;

    static double calculateDistance(Freckle a, Freckle b) {
        return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }

    static void addEdge(int src, int dest, double weight) {
        edges.add(new Edge(src, dest, weight));
    }

    static double kruskalMST(int N) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(edges.size(), Comparator.comparingDouble(o -> o.weight));

        pq.addAll(edges);

        DisjointSet disjointSet = new DisjointSet(N);

        int index = 0;
        double cost = 0;

        while (index < N - 1) {
            Edge edge = pq.remove();

            int x = disjointSet.find(edge.src);
            int y = disjointSet.find(edge.dest);

            if (x != y) {
                cost += edge.weight;
                disjointSet.union(x, y);
                index++;
            }
        }

        return cost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        freckles = new Freckle[N];
        edges = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            freckles[i] = new Freckle(scanner.nextDouble(), scanner.nextDouble());
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                addEdge(i, j, calculateDistance(freckles[i], freckles[j]));
            }
        }

        double result = kruskalMST(N);
        System.out.printf("%.2f\n", result);
    }
}