import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

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

    // Sorting edges based on their weight
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

class FrecklesConnector {

    private static double calculateDistance(Freckle a, Freckle b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    private static int find(Subset subsets[], int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }

        return subsets[i].parent;
    }

    private static void union(Subset subsets[], int xroot, int yroot) {
        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    private static double kruskalMST(ArrayList<Edge> edges, int N) {
        Edge result[] = new Edge[N];
        int e = 0;
        int i = 0;
        double minCost = 0.0;

        // Initialize subsets for union-find
        Subset subsets[] = new Subset[N];
        for (i = 0; i < N; ++i) {
            subsets[i] = new Subset(i, 0);
        }

        // Sort all the edges in non-decreasing order of their weight
        Collections.sort(edges);

        i = 0;
        while (e < N - 1) {
            // Pick the smallest edge
            Edge next_edge = edges.get(i++);

            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            // If including this edge doesn't cause cycle,
            // include it in result and increment index of result for next edge
            if (x != y) {
                result[e++] = next_edge;
                minCost += next_edge.weight;
                union(subsets, x, y);
            }
        }

        return minCost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        ArrayList<Freckle> freckles = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            freckles.add(new Freckle(scanner.nextDouble(), scanner.nextDouble()));
        }

        ArrayList<Edge> edges = new ArrayList<>();
        // Create all possible edges between freckles with their distances as weights
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                double distance = calculateDistance(freckles.get(i), freckles.get(j));
                edges.add(new Edge(i, j, distance));
            }
        }

        double result = kruskalMST(edges, N);
        System.out.printf("%.2f\n", result);
    }
}