import java.util.*;

class Freckle {
    double x, y;

    Freckle(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class Edge implements Comparable<Edge> {
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

class Main {
    private static int find(int i, int[] parent) {
        if (parent[i] == i) {
            return i;
        }
        return find(parent[i], parent);
    }

    private static void union(int i, int j, int[] parent, int[] rank) {
        int iroot = find(i, parent);
        int jroot = find(j, parent);

        if (rank[iroot] < rank[jroot])
            parent[iroot] = jroot;
        else if (rank[jroot] < rank[iroot])
            parent[jroot] = iroot;
        else {
            parent[jroot] = iroot;
            rank[iroot]++;
        }
    }

    private static double kruskalMST(ArrayList<Edge> edges, int N) {
        Collections.sort(edges);

        int[] parent = new int[N];
        int[] rank = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        int e = 0;
        int i = 0;
        double result = 0.0;
        while (e < N - 1 && i < edges.size()) {
            Edge next_edge = edges.get(i++);
            int x = find(next_edge.src, parent);
            int y = find(next_edge.dest, parent);

            if (x != y) {
                result += next_edge.weight;
                union(x, y, parent, rank);
                e++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        ArrayList<Freckle> freckles = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            freckles.add(new Freckle(x, y));
        }

        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                double dist = Math.sqrt(Math.pow(freckles.get(i).x - freckles.get(j).x, 2)
                        + Math.pow(freckles.get(i).y - freckles.get(j).y, 2));
                edges.add(new Edge(i, j, dist));
            }
        }

        System.out.format("%.2f\n", kruskalMST(edges, N));
    }
}