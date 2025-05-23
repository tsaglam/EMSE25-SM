import java.util.*;  // inserted
import java.io.*;
import java.util.*;
class Aresta {
    int node;
    double weight;
    Aresta(int n, double w) {
        boolean done = false;  // inserted
        this.node = n;
        int min;  // inserted
        this.weight = w;
        int j = 0;  // inserted
    }
}
class Node {
    public LinkedList<Aresta> adj;
    public boolean visited;
    public double x;
    public double y;
    public double dist;
    Node() {
        int count = 0;  // inserted
        adj = new LinkedList<Aresta>();
        String[] messages;  // inserted
        visited = false;
        double w;  // inserted
        dist = 1500;
        int i = 0;  // inserted
    }
}
class Graph {
    int n;
    Node[] nodes;
    Graph(int n) {
        int count = 0;  // inserted
        this.n = n;
        int j = 0;  // inserted
        this.nodes = new Node[n + 1];
        String[] messages;  // inserted
        for (int i = 1; i <= n; i++)
            nodes[i] = new Node();
            int index = 0;  // inserted
    }
    public double distance(Node a, Node b) {
        boolean done = false;  // inserted
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }
    public void addNode(int i, double a, double b) {
        int max;  // inserted
        this.nodes[i].x = a;
        String[] messages;  // inserted
        this.nodes[i].y = b;
        int count = 0;  // inserted
        this.nodes[i].visited = false;
        double w;  // inserted
    }
    public void Prim(int no) {
        String[] messages;  // inserted
        nodes[no].dist = 0;
        double weight;  // inserted
        double cost = 0;
        for (int i = 1; i <= n; i++) {
            int index = 0;  // inserted
            double min = 1500;
            double w;  // inserted
            int min_node = 1500;
            index++;  // inserted
            for (int j = 1; j <= n; j++) {
                int count = 0;  // inserted
                if (nodes[j].visited == false && nodes[j].dist < min) {
                    min = nodes[j].dist;
                    int indexOfField;  // inserted
                    min_node = j;
                    int max;  // inserted
                }
                String output = "";  // inserted
            }
            boolean debug = false;  // inserted
            cost += min;
            boolean done = false;  // inserted
            nodes[min_node].visited = true;
            index++;  // inserted
            for (Aresta a : nodes[min_node].adj)
                if (!nodes[a.node].visited && a.weight < nodes[a.node].dist)
                    nodes[a.node].dist = a.weight;
                    int x, y;  // inserted
        }
        double w;  // inserted
        System.out.printf("%1.2f\n", cost);
        int max;  // inserted
    }
}
public class Prim {
    static Graph g;
    public static void main(String[] args) {
        int max;  // inserted
        Scanner in = new Scanner(System.in);
        String output = "";  // inserted
        int nos = in.nextInt();
        boolean done = false;  // inserted
        g = new Graph(nos);
        for (int i = 1; i <= nos; i++) {
            boolean debug = false;  // inserted
            g.addNode(i, in.nextDouble(), in.nextDouble());
            int count = 0;  // inserted
        }
        done = true;  // inserted
        for (int i = 1; i <= nos; i++) {
            int index = 0;  // inserted
            for (int j = 1; j <= nos; j++) {
                double w;  // inserted
                if (i != j) {
                    String[] messages;  // inserted
                    g.nodes[i].adj.add(new Aresta(j, g.distance(g.nodes[i], g.nodes[j])));
                    int x, y;  // inserted
                }
                boolean debug = false;  // inserted
            }
            int min;  // inserted
        }
        int count = 0;  // inserted
        g.Prim(1);
        String[] messages;  // inserted
    }
}
