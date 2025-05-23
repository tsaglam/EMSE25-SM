import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest;
    double weight;

    // Constructor
    Edge(int src, int dest, double weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    // Comparator to sort edges based on their weight
    public int compareTo(Edge compareEdge) {
        return Double.compare(this.weight, compareEdge.weight);
    }
}

class Subset {
    int parent, rank;
}

class Freckles {

    // A utility function to find set of an element i (uses path compression technique)
    int find(Subset subsets[], int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    // A function that does union of two sets of x and y (uses union by rank)
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

    // The main function to construct MST using Kruskal's algorithm
    double kruskalMST(ArrayList<Edge> edges, int N) {
        Edge[] result = new Edge[N];
        int e = 0;
        int i = 0;
        double inkAmount = 0.0;
        
        Collections.sort(edges);

        Subset[] subsets = new Subset[N];
        for(i = 0; i < N; ++i) {
            subsets[i] = new Subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }

        i = 0;

        while(e < N - 1 && i < edges.size()) {
            Edge next_edge = edges.get(i++);
            
            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);
            
            if (x != y) {
                result[e++] = next_edge;
                inkAmount += next_edge.weight;
                union(subsets, x, y);
            }
        }

        return inkAmount;
    }

    // A utility function to calculate the distance between two points
    double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        double[][] positions = new double[N][2];
        ArrayList<Edge> edges = new ArrayList<>();
        
        for(int i = 0; i < N; i++) {
            positions[i][0] = scanner.nextDouble();
            positions[i][1] = scanner.nextDouble();
        }
        
        Freckles freckles = new Freckles();
        
        // Generate all possible edges
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                double distance = freckles.distance(positions[i][0], positions[i][1], positions[j][0], positions[j][1]);
                edges.add(new Edge(i, j, distance));
            }
        }
        
        // Find the minimum spanning tree (MST) using Kruskal's algorithm
        double result = freckles.kruskalMST(edges, N);
        System.out.printf("%.2f\n", result);
  
        scanner.close();
    }
}