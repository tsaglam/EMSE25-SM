import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest;
    double weight;
    
    Edge(int src, int dest, double weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
    
    public int compareTo(Edge compareEdge) {
        if (this.weight - compareEdge.weight > 0) return 1;
        else if (this.weight - compareEdge.weight < 0) return -1;
        else return 0;
    }
}

class DisjointSet {
    int[] parent, rank;
    int n;
    
    // Constructor
    public DisjointSet(int n) {
        this.n = n;
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    
    // Find the parent of a node
    int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }
    
    // Union of two subsets
    void union(int x, int y) {
        int xRoot = find(x), yRoot = find(y);
        
        if (xRoot == yRoot) return;

        if (rank[xRoot] < rank[yRoot])
            parent[xRoot] = yRoot;
        else if (rank[yRoot] < rank[xRoot])
            parent[yRoot] = xRoot;
        else {
            parent[yRoot] = xRoot;
            rank[xRoot] = rank[xRoot] + 1;
        }
    }
}

class Freckles {

    static double calcDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }
    
    static void Kruskal(Edge[] edges, int N) {
        Edge[] result = new Edge[N];  
        int e = 0;  
        int i = 0; 
        for (i = 0; i < N; ++i)
            result[i] = new Edge(0, 0, 0);
        
        Arrays.sort(edges);
        DisjointSet disjointSet = new DisjointSet(N);
        
        i = 0;  
        while (e < N - 1) {
            Edge next_edge = new Edge(edges[i].src, edges[i].dest, edges[i].weight);
            i++;
            
            int x = disjointSet.find(next_edge.src);
            int y = disjointSet.find(next_edge.dest);
            
            if (x != y) {
                result[e++] = next_edge;
                disjointSet.union(x, y);
            }
        }
        
        double minimumCost = 0.0;
        for (i = 0; i < e; ++i)
            minimumCost += result[i].weight;
        System.out.printf("%.2f\n", minimumCost);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        double[][] points = new double[N][2];
        for (int i = 0; i < N; i++) {
            points[i][0] = scanner.nextDouble();
            points[i][1] = scanner.nextDouble();
        }
        
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                edges.add(new Edge(i, j, calcDistance(points[i][0], points[i][1], points[j][0], points[j][1])));
            }
        }

        Edge[] edgesArray = new Edge[edges.size()];
        edges.toArray(edgesArray);
        
        Kruskal(edgesArray, N);
        scanner.close();
    }
}