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

        // Used for sorting edges by their weight
        public int compareTo(Edge compareEdge) {
            return Double.compare(this.weight, compareEdge.weight);
        }
    }

    static class Subset {
        int parent, rank;

        Subset(int parent) {
            this.parent = parent;
            this.rank = 0;
        }
    }

    static class Graph {
        int vertices;
        ArrayList<Edge> edges;

        Graph(int vertices) {
            this.vertices = vertices;
            edges = new ArrayList<>();
        }

        void addEdge(int src, int dest, double weight) {
            edges.add(new Edge(src, dest, weight));
        }

        int find(Subset subsets[], int i) {
            if (subsets[i].parent != i) {
                subsets[i].parent = find(subsets, subsets[i].parent);
            }
            return subsets[i].parent;
        }

        void union(Subset subsets[], int x, int y) {
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

        double kruskalMST() {
            Edge[] result = new Edge[vertices]; // This will store the resultant MST
            int e = 0; // An index variable for result[]
            double totalWeight = 0; // Initialize total weight of MST

            Collections.sort(edges);

            Subset[] subsets = new Subset[vertices];
            for (int v = 0; v < vertices; ++v) {
                subsets[v] = new Subset(v);
            }

            for (Edge edge : edges) {
                int x = find(subsets, edge.src);
                int y = find(subsets, edge.dest);

                // If including this edge doesn't cause cycle,
                // include it in result and increment the index
                // of result for next edge
                if (x != y) {
                    result[e++] = edge;
                    totalWeight += edge.weight;
                    union(subsets, x, y);
                }
            }

            return totalWeight;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        double[][] freckles = new double[N][2];

        for (int i = 0; i < N; i++) {
            freckles[i][0] = scanner.nextDouble();
            freckles[i][1] = scanner.nextDouble();
        }

        Graph graph = new Graph(N);
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                double distance = Math.sqrt(Math.pow(freckles[i][0] - freckles[j][0], 2) +
                                            Math.pow(freckles[i][1] - freckles[j][1], 2));
                graph.addEdge(i, j, distance);
            }
        }

        double weight = graph.kruskalMST();
        System.out.printf("%.2f\n", weight);
    }
}