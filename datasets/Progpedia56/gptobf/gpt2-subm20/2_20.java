import java.util.*;

class Node {
    double x, y; // Coordinates
    int index; // Index in the graph
    Node parent; // For union-find structure

    Node() {}

    Node(double x, double y, int index) {
        this.x = x;
        this.y = y;
        this.index = index;
    }
}

class Graph {
    Node[] nodes;

    Graph(int size) {
        this.nodes = new Node[size];
    }

    void addNode(Node node, int index) {
        this.nodes[index] = node;
    }
}

class Edge implements Comparable<Edge> {
    Node nodeA, nodeB;
    double distance;

    Edge(Node a, Node b) {
        this.nodeA = a;
        this.nodeB = b;
        this.distance = Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y, 2));
    }

    @Override
    public int compareTo(Edge e) {
        return Double.compare(this.distance, e.distance);
    }
}

class KruskalAlgorithm {
    private static ArrayList<Set<Node>> sets = new ArrayList<>();

    private static int findSetIndex(Node node) {
        for (int i = 0; i < sets.size(); i++) {
            if (sets.get(i).contains(node)) {
                return i;
            }
        }
        return -1;
    }

    private static void union(int setIndexA, int setIndexB) {
        sets.get(setIndexA).addAll(sets.get(setIndexB));
        sets.remove(setIndexB);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Graph graph = new Graph(n);

        for (int i = 0; i < n; i++) {
            Node node = new Node(input.nextDouble(), input.nextDouble(), i); // Use double for coordinates input
            graph.addNode(node, i);
            sets.add(new HashSet<>(Collections.singleton(node))); // Create a set for each node
        }

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                edges.add(new Edge(graph.nodes[i], graph.nodes[j]));
            }
        }
        
        edges.sort(Edge::compareTo); // Use method reference for sorting

        double totalDistance = 0.0;
        for (Edge edge : edges) {
            int setIndexA = findSetIndex(edge.nodeA);
            int setIndexB = findSetIndex(edge.nodeB);

            if (setIndexA != setIndexB) {
                totalDistance += edge.distance;
                union(setIndexA, setIndexB);
            }
        }

        System.out.printf("%.2f\n", totalDistance);
    }
}