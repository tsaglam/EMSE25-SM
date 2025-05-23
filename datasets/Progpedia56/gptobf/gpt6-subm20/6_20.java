import java.util.*;

class GraphNode {
    double x, y;
    int index;
    
    GraphNode(double x, double y, int index) {
        this.x = x;
        this.y = y;
        this.index = index;
    }
}

class GraphEdge implements Comparable<GraphEdge> {
    GraphNode node1, node2;
    double distance;
    
    GraphEdge(GraphNode node1, GraphNode node2) {
        this.node1 = node1;
        this.node2 = node2;
        this.distance = Math.sqrt(Math.pow(node2.x - node1.x, 2) + Math.pow(node2.y - node1.y, 2));
    }
    
    @Override
    public int compareTo(GraphEdge other) {
        return Double.compare(this.distance, other.distance);
    }
}

class DisjointSet {
    private Map<GraphNode, GraphNode> parent = new HashMap<>();
    
    public void makeSet(GraphNode node) {
        parent.put(node, node);
    }
    
    public boolean union(GraphNode node1, GraphNode node2) {
        GraphNode root1 = find(node1);
        GraphNode root2 = find(node2);
        
        if (root1 != root2) {
            parent.put(root1, root2);
            return true;
        }
        return false;
    }
    
    public GraphNode find(GraphNode node) {
        GraphNode root = node;
        while (parent.get(root) != root) {
            root = parent.get(root);
        }
        while (node != root) {
            GraphNode next = parent.get(node);
            parent.put(node, root);
            node = next;
        }
        return root;
    }
}

class KruskalMST {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<GraphNode> nodes = new ArrayList<>();
        List<GraphEdge> edges = new ArrayList<>();
        DisjointSet disjointSet = new DisjointSet();
        
        for (int i = 0; i < n; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            GraphNode node = new GraphNode(x, y, i);
            nodes.add(node);
            disjointSet.makeSet(node);
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                edges.add(new GraphEdge(nodes.get(i), nodes.get(j)));
            }
        }
        
        Collections.sort(edges);
        
        double totalDistance = 0.0;
        for (GraphEdge edge : edges) {
            if (disjointSet.union(edge.node1, edge.node2)) {
                totalDistance += edge.distance;
            }
        }
        
        System.out.printf("%.2f\n", totalDistance);
    }
}