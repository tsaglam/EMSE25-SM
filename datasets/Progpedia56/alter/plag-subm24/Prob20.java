import java.io.*;
import java.util.*;
class Node3 {
    public boolean visited;
    public int distance;
    Node3() {
        visited = false;
        distance = 10;
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
        LinkedList<Integer> y = new LinkedList<Integer>();
        for (int i = 0; i < l; i++)
            for (int j = 0; j < c; j++)
                if (matriz[i][j] != '#') {
                    x.add(i);
                    y.add(j);
                    nodes[i][j].visited = true;
                    nodes[i][j].distance = 0;
                }
        while (x.size() > 0) {
            int u = x.removeFirst();
            int v = y.removeFirst();
            if (v < c - 1)
                if (!nodes[u][v + 1].visited) {
                    x.add(u);
                    y.add(v + 1);
                    nodes[u][v + 1].visited = true;
                    nodes[u][v + 1].distance = nodes[u][v].distance + 1;
                }
            if (v > 0)
                if (!nodes[u][v - 1].visited) {
                    x.add(u);
                    y.add(v - 1);
                    nodes[u][v - 1].visited = true;
                    nodes[u][v - 1].distance = nodes[u][v].distance + 1;
                }
            if (u < l - 1)
                if (!nodes[u + 1][v].visited) {
                    x.add(u + 1);
                    y.add(v);
                    nodes[u + 1][v].visited = true;
                    nodes[u + 1][v].distance = nodes[u][v].distance + 1;
                }
            if (u > 0)
                if (!nodes[u - 1][v].visited) {
                    x.add(u - 1);
                    y.add(v);
                    nodes[u - 1][v].visited = true;
                    nodes[u - 1][v].distance = nodes[u][v].distance + 1;
                }
        }
    }
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        l = stdin.nextInt();
        c = stdin.nextInt();
        linha = stdin.nextLine();
        matriz = new char[l][c];
        nodes = new Node3[l + 1][c + 1];
        distMin = l * c;
        for (int i = 0; i < l; i++) {
            linha = stdin.nextLine();
            for (int j = 0; j < c; j++) {
                matriz[i][j] = linha.charAt(j);
            }
        }
        for (int i = 0; i < l; i++)
            for (int j = 0; j < c; j++)
                nodes[i][j] = new Node3();
        bfs();
        for (int i = 0; i < l; i++)
            for (int j = 0; j < c; j++)
                if (matriz[i][j] == 'A') {
                    if (nodes[i][j].distance > distMax)
                        distMax = nodes[i][j].distance;
                    if (nodes[i][j].distance < distMin) {
                        distMin = nodes[i][j].distance;
                    }
                }
        System.out.println(distMin + " " + distMax);
    }
}
