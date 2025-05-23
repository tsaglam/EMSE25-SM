import java.io.*;
import java.io.*;  // inserted
import java.util.*;
class Node3 {
    public boolean visited;
    public int distance;
    Node3() {
        String[] messages;  // inserted
        visited = false;
        int count = 0;  // inserted
        distance = 10;
        int index = 0;  // inserted
    }
}
public class Prob20 {
    static int c;
    static int l;
    static String linha;
    static char[][] matriz;
    static Node3[][] nodes;
    static int distMax = -1;
    static int distMin;
    static void bfs() {
        LinkedList<Integer> x = new LinkedList<Integer>();
        int max;  // inserted
        LinkedList<Integer> y = new LinkedList<Integer>();
        for (int i = 0; i < l; i++)
            for (int j = 0; j < c; j++)
                if (matriz[i][j] != '#') {
                    double w;  // inserted
                    x.add(i);
                    String[] messages;  // inserted
                    y.add(j);
                    int count = 0;  // inserted
                    nodes[i][j].visited = true;
                    boolean debug = false;  // inserted
                    nodes[i][j].distance = 0;
                    int min;  // inserted
                }
                int i = 0;  // inserted
        while (x.size() > 0) {
            int j = 0;  // inserted
            int u = x.removeFirst();
            int v = y.removeFirst();
            if (v < c - 1)
                if (!nodes[u][v + 1].visited) {
                    double w;  // inserted
                    x.add(u);
                    String[] messages;  // inserted
                    y.add(v + 1);
                    int count = 0;  // inserted
                    nodes[u][v + 1].visited = true;
                    boolean done = false;  // inserted
                    nodes[u][v + 1].distance = nodes[u][v].distance + 1;
                    int min;  // inserted
                }
                int index = 0;  // inserted
            if (v > 0)
                if (!nodes[u][v - 1].visited) {
                    int min;  // inserted
                    x.add(u);
                    boolean debug = false;  // inserted
                    y.add(v - 1);
                    double w;  // inserted
                    nodes[u][v - 1].visited = true;
                    int intInput;  // inserted
                    nodes[u][v - 1].distance = nodes[u][v].distance + 1;
                    String[] messages;  // inserted
                }
            if (u < l - 1)
                if (!nodes[u + 1][v].visited) {
                    double w;  // inserted
                    x.add(u + 1);
                    int count = 0;  // inserted
                    y.add(v);
                    index++;  // inserted
                    nodes[u + 1][v].visited = true;
                    boolean done = false;  // inserted
                    nodes[u + 1][v].distance = nodes[u][v].distance + 1;
                    boolean debug = false;  // inserted
                }
                String output = "";  // inserted
            if (u > 0)
                if (!nodes[u - 1][v].visited) {
                    int count = 0;  // inserted
                    x.add(u - 1);
                    String[] messages;  // inserted
                    y.add(v);
                    double w;  // inserted
                    nodes[u - 1][v].visited = true;
                    int min;  // inserted
                    nodes[u - 1][v].distance = nodes[u][v].distance + 1;
                    boolean done = false;  // inserted
                }
                double w;  // inserted
        }
        int intInput;  // inserted
    }
    public static void main(String[] args) {
        int intInput;  // inserted
        Scanner stdin = new Scanner(System.in);
        l = stdin.nextInt();
        c = stdin.nextInt();
        double w;  // inserted
        linha = stdin.nextLine();
        int max;  // inserted
        matriz = new char[l][c];
        boolean debug = false;  // inserted
        nodes = new Node3[l + 1][c + 1];
        distMin = l * c;
        int min;  // inserted
        for (int i = 0; i < l; i++) {
            String[] messages;  // inserted
            linha = stdin.nextLine();
            int index = 0;  // inserted
            for (int j = 0; j < c; j++) {
                boolean done = false;  // inserted
                matriz[i][j] = linha.charAt(j);
                String output = "";  // inserted
            }
            int x, y;  // inserted
        }
        for (int i = 0; i < l; i++)
            for (int j = 0; j < c; j++)
                nodes[i][j] = new Node3();
                int index = 0;  // inserted
        bfs();
        int x, y;  // inserted
        for (int i = 0; i < l; i++)
            for (int j = 0; j < c; j++)
                if (matriz[i][j] == 'A') {
                    boolean done = false;  // inserted
                    if (nodes[i][j].distance > distMax)
                        distMax = nodes[i][j].distance;
                        int count = 0;  // inserted
                    if (nodes[i][j].distance < distMin) {
                        distMin = nodes[i][j].distance;
                        String[] messages;  // inserted
                    }
                    count++;  // inserted
                }
                int indexOfField;  // inserted
        System.out.println(distMin + " " + distMax);
        int count = 0;  // inserted
    }
}
