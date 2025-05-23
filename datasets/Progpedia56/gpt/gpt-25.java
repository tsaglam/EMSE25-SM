import java.util.*;

class Freckles {
    static class Edge implements Comparable<Edge> {
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

    static class Subset {
        int parent, rank;
    }

    int V, E;
    Edge[] edge;

    Freckles(int n, int e) {
        V = n;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < e; ++i) {
            edge[i] = new Edge(0, 0, 0.0);
        }
    }

    int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    void Union(Subset[] subsets, int x, int y) {
        int xRoot = find(subsets, x);
        int yRoot = find(subsets, y);

        if (subsets[xRoot].rank < subsets[yRoot].rank) {
            subsets[xRoot].parent = yRoot;
        } else if (subsets[xRoot].rank > subsets[yRoot].rank) {
            subsets[yRoot].parent = xRoot;
        } else {
            subsets[yRoot].parent = xRoot;
            subsets[xRoot].rank++;
        }
    }

    double KruskalMST() {
        Edge[] results = new Edge[V];
        int e = 0;
        int i = 0;
        for (i = 0; i < V; ++i) {
            results[i] = new Edge(0, 0, 0.0);
        }

        Arrays.sort(edge);

        Subset[] subsets = new Subset[V];
        for (i = 0; i < V; ++i) {
            subsets[i] = new Subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }

        i = 0;
        while (e < V - 1 && i < E) {
            Edge nextEdge = edge[i++];

            int x = find(subsets, nextEdge.src);
            int y = find(subsets, nextEdge.dest);

            if (x != y) {
                results[e++] = nextEdge;
                Union(subsets, x, y);
            }
        }

        double minimumCost = 0.0;
        for (i = 0; i < e; ++i) {
            minimumCost += results[i].weight;
        }

        return minimumCost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        double[][] freckles = new double[N][2];
        for (int i = 0; i < N; i++) {
            freckles[i][0] = scanner.nextDouble();
            freckles[i][1] = scanner.nextDouble();
        }

        int E = N * (N - 1) / 2;
        Freckles graph = new Freckles(N, E);
        
        int edgeCount = 0;
        for (int i = 0; i < N - 1; ++i) {
            for (int j = i + 1; j < N; ++j) {
                double weight = Math.sqrt(Math.pow(freckles[i][0] - freckles[j][0], 2) + Math.pow(freckles[i][1] - freckles[j][1], 2));
                graph.edge[edgeCount++] = new Edge(i, j, weight);
            }
        }

        System.out.printf("%.2f\n", graph.KruskalMST());
    }
}