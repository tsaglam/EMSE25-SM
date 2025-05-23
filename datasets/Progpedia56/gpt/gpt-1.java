import java.util.*;

class Freckles {

    static class Edge implements Comparable<Edge> {
        int src, dest;
        double weight;

        public Edge(int src, int dest, double weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge compareEdge) {
            return Double.compare(this.weight, compareEdge.weight);
        }
    }

    static class Subset {
        int parent, rank;
    }

    int V, E;
    Edge[] edge;

    Freckles(int n) {
        this.V = n;
        this.E = (n * (n - 1)) / 2;
        edge = new Edge[E];
        for (int i = 0; i < E; ++i) {
            edge[i] = new Edge(0, 0, 0.0);
        }
    }

    int find(Subset subsets[], int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    void Union(Subset subsets[], int x, int y) {
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
        Edge result[] = new Edge[V];
        int e = 0;
        int i = 0;
        for (i = 0; i < V; ++i) {
            result[i] = new Edge(0, 0, 0.0);
        }

        Arrays.sort(edge);

        Subset subsets[] = new Subset[V];
        for(i = 0; i < V; ++i) {
            subsets[i] = new Subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }

        i = 0;
        while (e < V - 1) {
            Edge next_edge = new Edge(0, 0, 0.0);
            if (i < edge.length) {
                next_edge = edge[i++];
            }

            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            if (x != y) {
                result[e++] = next_edge;
                Union(subsets, x, y);
            }
        }

        double minimumCost = 0.0;
        for (i = 0; i < e; ++i) {
            minimumCost += result[i].weight;
        }
        System.out.printf("%.2f\n", minimumCost);
    }

    public void addEdge(int edgeNum, int src, int dest, double weight) {
        edge[edgeNum] = new Edge(src, dest, weight);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        double[][] freckles = new double[N][2];

        for (int i = 0; i < N; i++) {
            freckles[i][0] = scanner.nextDouble();
            freckles[i][1] = scanner.nextDouble();
        }

        Freckles graph = new Freckles(N);

        int edgeCount = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = i + 1; j < N; ++j) {
                double dist = Math.sqrt(Math.pow(freckles[i][0] - freckles[j][0], 2) + Math.pow(freckles[i][1] - freckles[j][1], 2));
                graph.addEdge(edgeCount++, i, j, dist);
            }
        }

        graph.KruskalMST();
    }
}