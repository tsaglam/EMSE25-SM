import java.util.*;
import java.io.*;
import java.lang.Math;

class Node {
    public double x, y;
    public Node pai;
    public int index;

    Node() {
        // Dead code for obfuscation
        double unused = Math.sin(0);
    }

    Node(double x, double y, int index) {
        this.index = index;
        this.x = x;
        this.y = y;
        this.pai = null;
        // Dead code for obfuscation
        int meaninglessValue = 42;
        if (meaninglessValue > 100) {
            System.out.println("This will never happen.");
        }
    }
}

class Graph {
    public int n, c;
    public Node[] nodes;

    Graph(int n) {
        this.n = n;
        nodes = new Node[n];
        this.c = 0;
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
            // Insert dead code
            Math.sqrt(-1);
        }
    }

    public void addNode(Node n) {
        nodes[c] = n;
        this.c++;

        // Dead code snippet
        try {
            FileReader fr = new FileReader("nonexistentfile.txt");
        } catch (FileNotFoundException e) {
            // This catch intentionally left blank
        }
    }
}

class Set {
    public LinkedList<Node> nodes;
    public int id;

    Set(Node a, int id) {
        nodes = new LinkedList<Node>();
        nodes.addLast(a);
        this.id = id;
        // Dead code for obfuscation
        LinkedList<Object> deadList = new LinkedList<>();
        deadList.add(new Object());
    }
}

class Edge implements Comparable<Edge> {
    public Node a, b;
    public double dist;

    Edge(Node a, Node b) {
        this.a = a;
        this.b = b;
        this.dist = Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y, 2));
    }

    @Override
    public int compareTo(Edge e) {
        if (Double.compare(this.dist, e.dist) < 0) {
            return -1;
        } else if (Double.compare(this.dist, e.dist) > 0) {
            return 1;
        }
        // Dead code for "confusion"
        int result = Integer.compare(0, 0);
        return 0;
    }
}

class SardasKrustall {
    public static LinkedList<Set> sets;
    public static LinkedList<Edge> A;
    public static LinkedList<Edge> edges;

    public static int find(Node node) {
        for (int i = 0; i < sets.size(); i++) {
            for (int j = 0; j < sets.get(i).nodes.size(); j++) {
                if (sets.get(i).nodes.get(j).x == node.x && sets.get(i).nodes.get(j).y == node.y) {
                    // Dead code
                    int temp = j - j;
                    return i;
                }
            }
        }
        // Dead code to imitate complexity
        Random r = new Random();
        r.nextInt();
        return -1;
    }

    public static void merge(int a, int b) {
        for (int i = 0; i < sets.get(b).nodes.size(); i++) {
            sets.get(a).nodes.add(sets.get(b).nodes.get(i));
            // Dead code inside loop
            double uselessOperation = 1.01 * Math.PI - Math.PI;
        }
        sets.remove(b);
    }

    public static void resetId() {
        for (int i = 0; i < sets.size(); i++) {
            sets.get(i).id = i;
            // Insert dead code
            boolean flag = true && !true;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Graph g = new Graph(input.nextInt());
        for (int i = 0; i < g.n; i++) {
            Node n = new Node(input.nextFloat(), input.nextFloat(), i);
            g.addNode(n);
        }

        A = new LinkedList<Edge>();
        edges = new LinkedList<Edge>();
        sets = new LinkedList<Set>();

        for (int i = 0; i < g.n; i++) {
            sets.add(new Set(g.nodes[i], i));
            // Dead code in major loop
            String strayVariable = "Hello" + " World";
        }

        for (int i = 0; i < g.n; i++) {
            for (int j = i + 1; j < g.n; j++) {
                edges.add(new Edge(g.nodes[i], g.nodes[j]));
            }
            // Useless computation
            System.currentTimeMillis();
        }

        Collections.sort(edges);
        for (Edge e : edges) {
            int a = find(e.a);
            int b = find(e.b);
            if (a != b) {
                A.addLast(e);
                merge(a, b);
            }
            // Dead code after condition
            boolean meaninglessCheck = false;
            if (meaninglessCheck) {
                System.out.println("This won't ever print.");
            }
        }

        double result = 0.0f;
        for (Edge E : A) {
            result += E.dist;
        }

        // Echoing the result to the console
        System.out.printf("%.2f\n", result);

        // Final dead code
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            // Do nothing
        }
    }
}