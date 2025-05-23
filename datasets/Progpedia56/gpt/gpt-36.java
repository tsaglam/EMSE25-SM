import java.util.*;
import java.io.*;

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
    
    int find(Subset subsets[], int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }
    
    void Union(Subset subsets[], int x, int y) {
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
    
    double kruskalMST() {
        Edge result[] = new Edge[V]; 
        int e = 0; 
        int i = 0;  
        for (i = 0; i < V; ++i)
            result[i] = new Edge(0, 0, 0.0);

        Arrays.sort(edge);
        Subset subsets[] = new Subset[V];
        for (i = 0; i < V; ++i)
            subsets[i] = new Subset();

        for (int v = 0; v < V; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
        
        i = 0;
        while (e < V - 1 && i < E) {
            Edge next_edge = new Edge(0, 0, 0.0);
            next_edge = edge[i++];
            
            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);
            
            if (x != y) {
                result[e++] = next_edge;
                Union(subsets, x, y);
            }
        }
        
        double minimumCost = 0.0;
        for (i = 0; i < e; ++i)
            minimumCost += result[i].weight;
        return minimumCost;
    }
    
    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }
    
    public static void main(String[] args) throws IOException {
        
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        
        double[][] freckles = new double[N][2];
        for (int i = 0; i < N; i++) {
            freckles[i][0] = scanner.nextDouble();
            freckles[i][1] = scanner.nextDouble();
        }
        
        int totalEdges = N * (N - 1) / 2;
        Freckles graph = new Freckles(N, totalEdges);
        
        int edgeCount = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = i + 1; j < N; ++j) {
                double distance = calculateDistance(freckles[i][0], freckles[i][1], freckles[j][0], freckles[j][1]);
                graph.edge[edgeCount++] = new Edge(i, j, distance);
            }
        }
        
        double minimumInk = graph.kruskalMST();
        
        System.out.printf("%.2f\n", minimumInk);
    }
}