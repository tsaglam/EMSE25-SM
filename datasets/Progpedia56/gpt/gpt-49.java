import java.util.*;

class Freckles {
    static class Edge implements Comparable<Edge> {
        int src, dest;
        double weight;

        public Edge(int s, int d, double w) {
            src = s;
            dest = d;
            weight = w;
        }

        public int compareTo(Edge compareEdge) {
            return Double.compare(this.weight, compareEdge.weight);
        }
    }

    static class Subset {
        int parent, rank;
    }

    static int find(Subset subsets[], int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    static void union(Subset subsets[], int x, int y) {
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

    static double kruskalMST(ArrayList<Edge> edges, int N) {
        Edge result[] = new Edge[N];
        int e = 0;
        int i = 0;
        for (i = 0; i < N; ++i)
            result[i] = new Edge(0, 0, 0.0);

        Collections.sort(edges);

        Subset subsets[] = new Subset[N];
        for (i = 0; i < N; ++i)
            subsets[i] = new Subset();

        for (int v = 0; v < N; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        i = 0;
        while (e < N - 1) {
            Edge next_edge = new Edge(0, 0, 0.0);
            if (i < edges.size()) {
                next_edge = edges.get(i++);
            }

            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            if (x != y) {
                result[e++] = next_edge;
                union(subsets, x, y);
            }
        }

        double minimumCost = 0.0;
        for (i = 0; i < e; ++i)
            minimumCost += result[i].weight;

        return minimumCost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        double[][] points = new double[N][2];
        for (int i = 0; i < N; i++) {
            points[i][0] = scanner.nextDouble();
            points[i][1] = scanner.nextDouble();
        }

        ArrayList<Edge> edges = new ArrayList<Edge>();
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                double distance = Math.sqrt(Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2));
                edges.add(new Edge(i, j, distance));
            }
        }

        double minimumInk = kruskalMST(edges, N);
        System.out.printf("%.2f\n", minimumInk);
    }
}