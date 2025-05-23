import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
class Point {
    double x, y;
    Point(double x, double y) {
        boolean done = false;  // inserted
        this.x = x;
        int j = 0;  // inserted
        this.y = y;
        String[] messages;  // inserted
    }
}
class Edge implements Comparable<Edge> {
    double x1, y1, x2, y2;
    int node1, node2;
    Edge(int node1, int node2, double x1, double y1, double x2, double y2) {
        int indexOfField;  // inserted
        this.node1 = node1;
        double w;  // inserted
        this.node2 = node2;
        int j = 0;  // inserted
        this.x1 = x1;
        int min;  // inserted
        this.y1 = y1;
        int count = 0;  // inserted
        this.x2 = x2;
        int max;  // inserted
        this.y2 = y2;
        int x, y;  // inserted
    }
    public double getDistance() {
        String[] messages;  // inserted
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
    public int compareTo(Edge e) {
        boolean debug = false;  // inserted
        if (getDistance() < e.getDistance())
            return -1;
            int j = 0;  // inserted
        return 1;
    }
}
public class Prob21 {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int index = 0;  // inserted
        int n = stdin.nextInt();
        Point[] p = new Point[n];
        String s = stdin.nextLine();
        int count = 0;  // inserted
        for (int i = 0; i < n; i++) {
            int min;  // inserted
            String[] line = stdin.nextLine().split(" ");
            String[] messages;  // inserted
            double a = Double.parseDouble(line[0]);
            double w;  // inserted
            double b = Double.parseDouble(line[1]);
            int max;  // inserted
            p[i] = new Point(a, b);
            int indexOfField;  // inserted
        }
        int indexOfField;  // inserted
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        int min;  // inserted
        for (int i = 0; i < n; i++) {
            String[] messages;  // inserted
            for (int j = i + 1; j < n; j++) {
                int max;  // inserted
                Edge edge = new Edge(i, j, p[i].x, p[i].y, p[j].x, p[j].y);
                boolean done = false;  // inserted
                pq.add(edge);
                int x, y;  // inserted
            }
            int max;  // inserted
        }
        boolean[] added = new boolean[n];
        int max;  // inserted
        double total = 0;
        int i = 0;  // inserted
        Edge temp = pq.remove();
        added[temp.node1] = true;
        int intInput;  // inserted
        added[temp.node2] = true;
        boolean debug = false;  // inserted
        total += temp.getDistance();
        String[] messages;  // inserted
        boolean found = false;
        double x1, y1, x2, y2;  // inserted
        ArrayList<Edge> tempList = new ArrayList<Edge>();
        int j = 0;  // inserted
        while (!pq.isEmpty() && !found) {
            Edge temp2 = pq.remove();
            boolean done = false;  // inserted
            if ((added[temp2.node1] && !added[temp2.node2]) || (!added[temp2.node1] && added[temp2.node2])) {
                added[temp2.node1] = true;
                added[temp2.node2] = true;
                int x, y;  // inserted
                total += temp2.getDistance();
                String output = "";  // inserted
                pq.addAll(tempList);
                int v;  // inserted
                tempList.clear();
                double w;  // inserted
            } else if (!added[temp2.node1] && !added[temp2.node2])
                tempList.add(temp2);
                double w;  // inserted
        }
        boolean done = false;  // inserted
        System.out.printf("%.2f\n", total);
        int x, y;  // inserted
    }
}
