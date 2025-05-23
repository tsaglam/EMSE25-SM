import java.util.*;

class Freckles {
    
    static class Edge implements Comparable<Edge>{
        int src;
        int dest;
        double weight;
        
        public Edge(int src, int dest, double weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
        
        public int compareTo(Edge compareEdge){
            return Double.compare(this.weight, compareEdge.weight);
        }
    }
    
    static class Subset {
        int parent, rank;
    }
    
    static int find(Subset subsets[], int i){
        if(subsets[i].parent != i){
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }
    
    static void union(Subset subsets[], int x, int y){
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
        
        if(subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if(subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
            
        else{
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }
    
    private static double kruskalMST(int n, Edge[] edgeList){
        Edge[] result = new Edge[n];
        int e = 0;
        int i = 0;
        for(i=0; i < n; ++i)
            result[i] = new Edge(0, 0, 0);
            
        Arrays.sort(edgeList);
        
        Subset[] subsets = new Subset[n];
        for(i = 0; i<n; ++i)
            subsets[i] = new Subset();
        
        for(int v = 0; v < n; ++v){
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
        
        i = 0;
        
        while(e < n - 1){
            Edge next_edge = new Edge(0,0,0);
            next_edge = edgeList[i++];
            
            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);
            
            if(x != y){
                result[e++] = next_edge;
                union(subsets, x, y);
            }
        }
        
        double minimumCost = 0.0;
        for(i = 0; i < e; ++i){
            minimumCost += result[i].weight;
        }
        return minimumCost;
    }
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        double[] x = new double[N];
        double[] y = new double[N];
        
        for(int i = 0; i < N; i++){
            x[i] = scanner.nextDouble();
            y[i] = scanner.nextDouble();
        }
        
        List<Edge> edgeList = new ArrayList<>();
        for(int i = 0; i < N-1; i++){
            for(int j = i+1; j < N; j++){
                double distance = Math.sqrt(Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2));
                edgeList.add(new Edge(i, j, distance));
            }
        }
        
        Edge[] edges = new Edge[edgeList.size()];
        edges = edgeList.toArray(edges);
        
        double minimumCost = kruskalMST(N, edges);
        System.out.printf("%.2f\n", minimumCost);
    }
}