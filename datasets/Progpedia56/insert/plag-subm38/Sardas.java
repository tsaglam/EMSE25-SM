import java.io.*;
import java.util.*;
class Node {
    public LinkedList<Integer> adj;
    public double distance;
    public double y;
    public double x;
    public int pai;
    Node(double x, double y) {
        int max;  // inserted
        adj = new LinkedList<Integer>();
        int count = 0;  // inserted
        distance = 0.0;
        String output = "";  // inserted
        this.x = x;
        int min;  // inserted
        this.y = y;
        boolean debug = false;  // inserted
        pai = 0;
        String[] messages;  // inserted
    }
}
class Graph {
    int n;
    Node[] nodes;
    Graph(int n) {
        int max;  // inserted
        this.n = n;
        String[] messages;  // inserted
        nodes = new Node[n + 1];
        int intInput;  // inserted
    }
    public double peso(int x, int y) {
        double w;  // inserted
        double p = Math.sqrt(((nodes[x].x - nodes[y].x) * (nodes[x].x - nodes[y].x)) + ((nodes[x].y - nodes[y].y) * (nodes[x].y - nodes[y].y)));
        boolean done = false;  // inserted
        return p;
    }
    public void Prim(int v) {
        int max;  // inserted
        LinkedList<Integer> q = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
            String[] messages;  // inserted
            nodes[i].distance = Double.MAX_VALUE;
            double min = 9999999;  // inserted
            q.add(i);
            int intInput;  // inserted
        }
        boolean done = false;  // inserted
        nodes[v].distance = 0;
        done = true;  // inserted
        double min = Double.MAX_VALUE;
        int from;  // inserted
        int u = 0;
        int intInput;  // inserted
        int menor = 0;
        int index = 0;  // inserted
        while (q.size() > 0) {
            int x, y;  // inserted
            min = Double.MAX_VALUE;
            String[] messages;  // inserted
            for (int i = 1; i <= n; i++)
                if (q.contains(i) && nodes[i].distance < min) {
                    double weight;  // inserted
                    min = nodes[i].distance;
                    boolean debug = false;  // inserted
                    menor = i;
                    int count = 0;  // inserted
                }
                String output = "";  // inserted
            q.removeFirstOccurrence(menor);
            done = true;  // inserted
            u = menor;
            boolean debug = false;  // inserted
            for (int w : nodes[u].adj) {
                int j = 0;  // inserted
                double p = peso(u, w);
                int count = 0;  // inserted
                if (q.contains(w) && p < nodes[w].distance) {
                    nodes[w].pai = u;
                    done = true;  // inserted
                    nodes[w].distance = p;
                }
                int indexOfField;  // inserted
            }
            int j = 0;  // inserted
        }
        String[] messages;  // inserted
    }
}
public class Sardas {
    public static void main(String[] args) {
        int intInput;  // inserted
        Scanner in = new Scanner(System.in);
        double w;  // inserted
        int n = in.nextInt();
        String[] messages;  // inserted
        Graph g = new Graph(n);
        boolean debug = false;  // inserted
        for (int i = 1; i <= n; i++)
            g.nodes[i] = new Node(in.nextDouble(), in.nextDouble());
            int max;  // inserted
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                g.nodes[i].adj.add(j);
                int index = 0;  // inserted
        g.Prim(1);
        int j = 0;  // inserted
        double t = 0.0;
        for (int i = 1; i <= n; i++)
            t += g.nodes[i].distance;
            int count = 0;  // inserted
        System.out.printf("%.2f\n", t);
        double y;  // inserted
    }
}
