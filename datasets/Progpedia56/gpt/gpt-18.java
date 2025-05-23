import java.util.*;
import java.io.*;

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
}

class Graph {
    int vertices;
    ArrayList<Edge> edges = new ArrayList<>();
    
    Graph(int vertices) {
        this.vertices = vertices;
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
    
    double kruskalMST() {
        Edge result[] = new Edge[vertices];
        int e = 0;
        int i = 0;
        for (i = 0; i < vertices; ++i) {
            result[i] = new Edge(0, 0, 0.0);
        }
        
        Collections.sort(edges);
        
        Subset subsets[] = new Subset[vertices];
        for (i = 0; i < vertices; ++i)
            subsets[i] = new Subset();
        
        for (int v = 0; v < vertices; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
        
        i = 0;
        while (e < vertices - 1) {
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
}

class Freckles {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(reader.readLine());
        double[][] positions = new double[N][2];
        for (int i = 0; i < N; i++) {
            String[] input = reader.readLine().split(" ");
            positions[i][0] = Double.parseDouble(input[0]);
            positions[i][1] = Double.parseDouble(input[1]);
        }
        
        Graph graph = new Graph(N);
        
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                double distance = Math.sqrt(Math.pow(positions[i][0] - positions[j][0], 2) + Math.pow(positions[i][1] - positions[j][1], 2));
                graph.addEdge(i, j, distance);
            }
        }
        
        double result = graph.kruskalMST();
        
        System.out.printf("%.2f\n", result);
    }
}