import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

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

class Freckles {

    private int find(Subset subsets[], int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    private void union(Subset subsets[], int x, int y) {
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

    double kruskalMST(ArrayList<Freckle> freckles, ArrayList<Edge> edges, int N) {
        Edge[] result = new Edge[N];
        int e = 0;
        int i = 0;
        for (i = 0; i < N; ++i) {
            result[i] = new Edge(0, 0, 0.0);
        }

        Collections.sort(edges);

        Subset[] subsets = new Subset[N];
        for (i = 0; i < N; ++i)
            subsets[i] = new Subset(i, 0);

        i = 0;
        while (e < N - 1) {
            Edge next_edge = edges.get(i++);

            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            if (x != y) {
                result[e++] = next_edge;
                union(subsets, x, y);
            }
        }

        double minimumCost = 0.0;
        for (i = 0; i < e; ++i) {
            minimumCost += result[i].weight;
        }
        return minimumCost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        ArrayList<Freckle> freckles = new ArrayList<>();
        ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            freckles.add(new Freckle(x, y));
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                double distance = Math.sqrt(Math.pow(freckles.get(i).x - freckles.get(j).x, 2) + Math.pow(freckles.get(i).y - freckles.get(j).y, 2));
                edges.add(new Edge(i, j, distance));
            }
        }

        Freckles program = new Freckles();
        double minimumInkRequired = program.kruskalMST(freckles, edges, N);
        System.out.printf("%.2f\n", minimumInkRequired);
        scanner.close();
    }
}