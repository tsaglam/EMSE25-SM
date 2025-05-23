import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    @Override
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

class FrecklesInk {

    private static double calcDistance(Freckle a, Freckle b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    void union(Subset[] subsets, int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank) {
            subsets[xroot].parent = yroot;
        } else if (subsets[xroot].rank > subsets[yroot].rank) {
            subsets[yroot].parent = xroot;
        } else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    void KruskalMST(List<Freckle> freckles, int N) {
        List<Edge> result = new ArrayList<>();
        List<Edge> edges = new ArrayList<>();
        Subset[] subsets = new Subset[N];

        for (int i = 0; i < N; ++i) {
            subsets[i] = new Subset(i, 0);
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                edges.add(new Edge(i, j, calcDistance(freckles.get(i), freckles.get(j))));
            }
        }

        Collections.sort(edges);

        int e = 0;
        int i = 0;
        while (e < N - 1) {
            Edge next_edge = edges.get(i++);
            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            if (x != y) {
                result.add(next_edge);
                e++;
                union(subsets, x, y);
            }
        }

        double minimumInk = 0;
        for (i = 0; i < result.size(); i++) {
            Edge edge = result.get(i);
            minimumInk += edge.weight;
        }
        System.out.printf("%.2f\n", minimumInk);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<Freckle> freckles = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            freckles.add(new Freckle(x, y));
        }

        new FrecklesInk().KruskalMST(freckles, N);
    }
}