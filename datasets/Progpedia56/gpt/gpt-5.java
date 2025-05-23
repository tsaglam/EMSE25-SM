import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge> {
    int src, dest;
    double weight;
    
    // Constructor
    Edge(int src, int dest, double weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
    
    // Compare two edges based on their weights
    @Override
    public int compareTo(Edge compareEdge) {
        return Double.compare(this.weight, compareEdge.weight);
    }
}

class Subset {
    int parent, rank;
}

class Freckles {
    private int V; // Number of vertices
    private ArrayList<Edge> edges; // Collection of all edges
    
    public Freckles(int v) {
        V = v;
        edges = new ArrayList<>();
    }
    
    // A utility function to find set of an element i
    int find(Subset subsets[], int i) {
        if (subsets[i].parent != i) 
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }
    
    // A function that does union of two sets of x and y
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
    
    // The main function to construct MST using Kruskal's algorithm
    double kruskalMST() {
        Edge result[] = new Edge[V];
        int e = 0;
        int i = 0;
        for(i=0; i<V; ++i)
            result[i] = new Edge(0, 0, 0);
        
        Collections.sort(edges);
        
        Subset subsets[] = new Subset[V];
        for(i=0; i<V; ++i)
            subsets[i] = new Subset();
        
        for (int v = 0; v < V; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
        
        i = 0;
        while (e < V - 1) {
            Edge next_edge = edges.get(i++);
            
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
    
    void addEdge(int src, int dest, double weight) {
        Edge edge = new Edge(src, dest, weight);
        edges.add(edge);
    }
    
    // Utility function to calculate distance between two points
    double calcDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double[][] points = new double[N][2];
        
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            points[i][0] = Double.parseDouble(input[0]);
            points[i][1] = Double.parseDouble(input[1]);
        }
        
        Freckles graph = new Freckles(N);
        
        // Add all edges to the graph
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                double distance = graph.calcDistance(points[i][0], points[i][1], points[j][0], points[j][1]);
                graph.addEdge(i, j, distance);
                graph.addEdge(j, i, distance);
            }
        }
        
        System.out.printf("%.2f\n", graph.kruskalMST());
    }
}