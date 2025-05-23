import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class Freckle{
    double x, y;
    Freckle(double x, double y){
        this.x = x;
        this.y = y;
    }
}

class Edge implements Comparable<Edge>{
    int src, dest;
    double weight;
    Edge(int src, int dest, double weight){
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
    public int compareTo(Edge compareEdge){
        return Double.compare(this.weight, compareEdge.weight);
    }
}

class Subset{
    int parent, rank;
}

class FrecklesInk {

    ArrayList<Edge> edges = new ArrayList<>();
    int V; // Number of vertices (freckles)

    FrecklesInk(int v){
        V = v;
    }

    int find(Subset subsets[], int i){
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    void Union(Subset subsets[], int x, int y){
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else{
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }
    
    void addEdge(int src, int dest, double weight){
        edges.add(new Edge(src, dest, weight));
    }

    double KruskalMST(){
        Edge result[] = new Edge[V];  
        int e = 0;
        int i = 0;
        for (i=0; i<V; ++i)
            result[i] = new Edge(0, 0, 0);
        Collections.sort(edges);
        Subset subsets[] = new Subset[V];
        for(i=0; i<V; ++i)
            subsets[i]=new Subset();
        for (int v = 0; v < V; ++v){
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
        i = 0;
        while (e < V - 1){
            Edge next_edge = new Edge(0, 0, 0);
            if(i < edges.size()){
                next_edge = edges.get(i++);
            }
            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);
            if (x != y){
                result[e++] = next_edge;
                Union(subsets, x, y);
            }
        }
        double minimumCost = 0.0;
        for (i = 0; i < e; ++i)
            minimumCost += result[i].weight;
        return minimumCost;
    }
    
    public static double calculateDistance(Freckle a, Freckle b){
        return Math.sqrt(Math.pow((a.x - b.x), 2) + Math.pow((a.y - b.y), 2));
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Freckle[] freckles = new Freckle[N];
        for(int i = 0; i < N; i++){
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            freckles[i] = new Freckle(x, y);
        }
        FrecklesInk graph = new FrecklesInk(N);
        for(int i = 0; i < N - 1; i++){
            for(int j = i + 1; j < N; j++){
                double weight = calculateDistance(freckles[i], freckles[j]);
                graph.addEdge(i, j, weight);
            }
        }
        double minimumInk = graph.KruskalMST();
        System.out.printf("%.2f\n", minimumInk);
        scanner.close();
    }
}