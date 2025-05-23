import java.io.*;
import java.util.*;
class Aresta {
    int node;
    double weight;
    Aresta(int n, double w) {
        this.node = n;
        this.weight = w;
    }
}
class Node {
    public LinkedList<Aresta> adj;
    public boolean visited;
    public double x;
    public double y;
    public double dist;
    Node() {
        adj = new LinkedList<Aresta>();
        visited = false;
        dist = 1500;
    }
}
class Graph {
    int n;
    Node[] nodes;
    Graph(int n) {
        this.n = n;
        this.nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++)
            nodes[i] = new Node();
    }
    public double distance(Node a, Node b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }
    public void addNode(int i, double a, double b) {
        this.nodes[i].x = a;
        this.nodes[i].y = b;
        this.nodes[i].visited = false;
    }
    public void Prim(int no) {
        nodes[no].dist = 0;
        double cost = 0;
        for (int i = 1; i <= n; i++) {
            double min = 1500;
            int min_node = 1500;
            for (int j = 1; j <= n; j++) {
                if (nodes[j].visited == false && nodes[j].dist < min) {
                    min = nodes[j].dist;
                    min_node = j;
                }
            }
            cost += min;
            nodes[min_node].visited = true;
            for (Aresta a : nodes[min_node].adj)
                if (!nodes[a.node].visited && a.weight < nodes[a.node].dist)
                    nodes[a.node].dist = a.weight;
        }
        System.out.printf("%1.2f\n", cost);
    }
}
public class Prim {
    static Graph g;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nos = in.nextInt();
        g = new Graph(nos);
        for (int i = 1; i <= nos; i++) {
            g.addNode(i, in.nextDouble(), in.nextDouble());
        }
        for (int i = 1; i <= nos; i++) {
            for (int j = 1; j <= nos; j++) {
                if (i != j) {
                    g.nodes[i].adj.add(new Aresta(j, g.distance(g.nodes[i], g.nodes[j])));
                }
            }
        }
        g.Prim(1);
    }
}
