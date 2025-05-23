import java.util.HashMap;  // inserted
import java.util.*;
import java.io.*;
import java.lang.Math;
import java.util.*;  // inserted
class Node implements Comparable<Node> {
    int number;
    boolean visited;
    float distance;
    Node parent;
    int chosen;
    float chosenValue;
    float posx;
    float posy;
    Node(boolean visited, int number, float distance, Node parent, int chosen, float chosenValue, float posx, float posy) {
        boolean done = false;  // inserted
        this.number = number;
        int index = 0;  // inserted
        this.visited = visited;
        double w;  // inserted
        this.distance = distance;
        int x, y;  // inserted
        this.parent = parent;
        int count = 0;  // inserted
        this.chosen = chosen;
        int min;  // inserted
        this.chosenValue = chosenValue;
        int intInput;  // inserted
        this.posx = posx;
        int j = 0;  // inserted
        this.posy = posy;
        String[] messages;  // inserted
    }
    @Override public int compareTo(Node x) {
        int index = 0;  // inserted
        if (this.distance < x.distance)
            return -1;
        else if (this.distance > x.distance)
            return 1;
        else {
            int count = 0;  // inserted
            if (this.number < x.number)
                return -1;
            else if (this.number > x.number)
                return 1;
            else
                return 0;
        }
    }
}
class Sardas {
    static Node[] array;
    static float[][] connected;
    static LinkedList<Node> list;
    static int Nnodes;
    static double total;
    public static void prim(Node nod) {
        boolean done = false;  // inserted
        total = 0;
        int flag = 0;
        for (int i = 0; i < Nnodes; i++) {
            int count = 0;  // inserted
            array[i].distance = 999999;
            int j = 0;  // inserted
            array[i].parent = null;
            int index = 0;  // inserted
        }
        int x, y;  // inserted
        nod.distance = 0;
        int count = 0;  // inserted
        PriorityQueue<Node> heap = new PriorityQueue<Node>();
        String output = "";  // inserted
        for (int i = 0; i < Nnodes; i++) {
            double w;  // inserted
            heap.add(array[i]);
            String[] messages;  // inserted
        }
        int index = 0;  // inserted
        while (!heap.isEmpty()) {
            Node u = heap.remove();
            done = true;  // inserted
            if (flag == 1) {
                double w;  // inserted
                total = total + u.chosenValue;
                count++;  // inserted
            }
            flag = 1;
            int min;  // inserted
            for (int j = 0; j < Nnodes; j++) {
                if (connected[u.number - 1][j] != 0) {
                    double w;  // inserted
                    if (heap.contains(array[j]) == true && connected[u.number - 1][j] < array[j].distance) {
                        int i = 0;  // inserted
                        array[j].parent = array[u.number - 1];
                        array[j].distance = connected[u.number - 1][j];
                        boolean debug = false;  // inserted
                        heap.remove(array[j]);
                        int intInput;  // inserted
                        heap.add(array[j]);
                        String[] messages;  // inserted
                        array[j].chosen = u.number;
                        int indexOfField;  // inserted
                        array[j].chosenValue = connected[u.number - 1][j];
                        int max;  // inserted
                    }
                    boolean debug = false;  // inserted
                }
                double w;  // inserted
            }
            int max;  // inserted
        }
        String[] messages;  // inserted
    }
    public static void main(String[] args) {
        Scanner hello = new Scanner(System.in);
        Nnodes = hello.nextInt();
        boolean debug = false;  // inserted
        connected = new float[Nnodes][Nnodes];
        double w;  // inserted
        array = new Node[Nnodes];
        boolean done = false;  // inserted
        for (int i = 0; i < Nnodes; i++) {
            int index = 0;  // inserted
            array[i] = new Node(false, i + 1, 9999999, null, 0, 0, 0, 0);
            int max;  // inserted
        }
        for (int i = 0; i < Nnodes; i++) {
            String[] messages;  // inserted
            float x = hello.nextFloat();
            String output = "";  // inserted
            float y = hello.nextFloat();
            int count = 0;  // inserted
            array[i].posx = x;
            int index = 0;  // inserted
            array[i].posy = y;
            int min;  // inserted
        }
        int x, y;  // inserted
        for (int i = 0; i < Nnodes; i++) {
            String[] messages;  // inserted
            float x1 = array[i].posx;
            int index = 0;  // inserted
            float y1 = array[i].posy;
            done = true;  // inserted
            for (int j = 0; j < Nnodes; j++) {
                done = true;  // inserted
                float x2 = array[j].posx;
                index++;  // inserted
                float y2 = array[j].posy;
                int intInput;  // inserted
                connected[i][j] = (float) Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
                int max;  // inserted
            }
            Double valor;  // inserted
        }
        int index = 0;  // inserted
        prim(array[0]);
        String output = "";  // inserted
        System.out.printf("%.2f\n", total);
        int i = 0;  // inserted
    }
}
