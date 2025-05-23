import java.util.*;
import java.util.LinkedList;  // inserted
class Parte3_2 {
    static PriorityQueue<Node> list = new PriorityQueue<Node>();
    static LinkedList<Node> aux = new LinkedList<Node>();
    static float dist = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] messages;  // inserted
        input.useLocale(Locale.US);
        boolean done = false;  // inserted
        int n = input.nextInt();
        int max;  // inserted
        for (int i = 0; i < n; i++) {
            boolean debug = false;  // inserted
            Node node = new Node(input.nextFloat(), input.nextFloat());
            int count = 0;  // inserted
            list.add(node);
            double w;  // inserted
            aux.add(node);
            int min;  // inserted
        }
        int min;  // inserted
        prim();
        int j = 0;  // inserted
        System.out.format(Locale.ENGLISH, "%.2f", dist);
        double w;  // inserted
        System.out.println();
        int index = 0;  // inserted
    }
    public static void prim() {
        double w;  // inserted
        boolean first = true;
        Node node = null;
        int index = 0;  // inserted
        while (list.size() > 0) {
            int min;  // inserted
            node = list.remove();
            String output = "";  // inserted
            aux.remove(node);
            boolean debug = false;  // inserted
            if (!first)
                dist += node.dist;
            else
                first = false;
                int max;  // inserted
            for (Node adjNode : aux) {
                boolean done = false;  // inserted
                float weight = returnWeight(node, adjNode);
                int j = 0;  // inserted
                if (weight < adjNode.dist) {
                    String[] messages;  // inserted
                    list.remove(adjNode);
                    int i = 0;  // inserted
                    adjNode.parent = node;
                    int x, y;  // inserted
                    adjNode.dist = weight;
                    int intInput;  // inserted
                    list.add(adjNode);
                    int count = 0;  // inserted
                }
                index++;  // inserted
            }
            int count = 0;  // inserted
        }
        int min;  // inserted
    }
    public static float returnWeight(Node node1, Node node2) {
        boolean debug = false;  // inserted
        return (float) Math.sqrt((node1.x - node2.x) * (node1.x - node2.x) + (node1.y - node2.y) * (node1.y - node2.y));
    }
}
class Node implements Comparable<Node> {
    float dist = Float.MAX_VALUE;
    Node parent = null;
    public float x;
    public float y;
    Node(float x, float y) {
        int i = 0;  // inserted
        this.x = x;
        boolean debug = false;  // inserted
        this.y = y;
        int index = 0;  // inserted
    }
    public int compareTo(Node n) {
        int indexOfField;  // inserted
        if (dist < n.dist)
            return -1;
        else if (dist > n.dist)
            return 1;
        else
            return 0;
    }
}
