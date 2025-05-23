import java.util.*;

class Freckles {
    static class Edge implements Comparable<Edge> {
        int src, dest;
        double weight;
        
        // Constructor
        Edge(int src, int dest, double weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
        
        // Comparator function for sorting edges based on their weight
        public int compareTo(Edge compareEdge) {
            return Double.compare(this.weight, compareEdge.weight);
        }
    }

    static class Subset {
        int parent, rank;
    }

    static class Graph {
        int V, E;    // V-> no. of vertices & E->no.of edges
        Edge[] edge; // collection of all edges
        
        // Creates a graph with V vertices and E edges
        Graph(int v, int e) {
            V = v;
            E = e;
            edge = new Edge[E];
            for (int i = 0; i < e; ++i) {
                edge[i] = new Edge(0, 0, 0.0);
            }
        }

        // A utility function to find set of an element i
        int find(Subset[] subsets, int i) {
            if (subsets[i].parent != i) {
                subsets[i].parent = find(subsets, subsets[i].parent);
            }
            return subsets[i].parent;
        }

        // A function that does union of two sets of x and y
        void Union(Subset[] subsets, int x, int y) {
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
        
        // The main function to construct MST using Kruskal's algorithm
        void KruskalMST() {
            Edge[] result = new Edge[V];  
            int e = 0;  // An index variable, used for result[]
            int i;  // An index variable, used for sorted edges
            for (i = 0; i < V; ++i)
                result[i] = new Edge(0, 0, 0.0);

            // Step 1:  Sort all the edges in non-decreasing order of their weight
            Arrays.sort(edge);
            
            Subset[] subsets = new Subset[V];
            for(i = 0; i < V; ++i)
                subsets[i] = new Subset();
            
            for (int v = 0; v < V; ++v) {
                subsets[v].parent = v;
                subsets[v].rank = 0;
            }
            
            i = 0;  // Index used to pick next edge
            
            // Number of edges to be taken is equal to V-1
            while (e < V - 1) {
                // Step 2: Pick the smallest edge. And increment the index for next iteration
                Edge next_edge = new Edge(0, 0, 0.0);
                if (i < edge.length) {
                    next_edge = edge[i++];
                }

                int x = find(subsets, next_edge.src);
                int y = find(subsets, next_edge.dest);

                // If including this edge does't cause cycle, include it in result and increment the index of result for next edge
                if (x != y) {
                    result[e++] = next_edge;
                    Union(subsets, x, y);
                }
                // Else discard the next_edge
            }
            
            // print the contents of result[] to display the built MST
            double minimumCost = 0;
            for (i = 0; i < e; ++i) {
                minimumCost += result[i].weight;
            }
            System.out.printf("%.2f\n", minimumCost);
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
        
        // Calculate the distance between each pair of points to create edges
        int totalEdges = N * (N - 1) / 2; // Maximum number of edges in a fully connected network
        Graph graph = new Graph(N, totalEdges);
        
        int edgeCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                double distance = Math.sqrt(Math.pow(freckles[i][0] - freckles[j][0], 2)
                        + Math.pow(freckles[i][1] - freckles[j][1], 2));
                graph.edge[edgeCount++] = new Edge(i, j, distance);
            }
        }
        
        graph.KruskalMST();
    }
}