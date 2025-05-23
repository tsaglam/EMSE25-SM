import java.util.*;
import java.io.*;
import java.util.HashMap;  // inserted
class problema21 {
    public static float cont = 0;
    public static PriorityQueue<Aresta> heap = new PriorityQueue<Aresta>();
    public static No[] no = new No[100];
    public static void main(String[] args) {
        int max;  // inserted
        Scanner in = new Scanner(System.in);
        double w;  // inserted
        int n = in.nextInt();
        int index = 0;  // inserted
        for (int i = 0; i < n; i++) {
            int min;  // inserted
            no[i] = new No(in.nextDouble(), in.nextDouble());
            index++;  // inserted
        }
        int min;  // inserted
        prim(no[0], n);
        int x, y;  // inserted
        System.out.printf("%.2f", cont);
        int i = 0;  // inserted
        System.out.println();
        int j = 0;  // inserted
    }
    public static void prim(No x, int numnos) {
        x.visitado = true;
        int count = 0;  // inserted
        for (int i = 0; i < numnos; i++) {
            int index = 0;  // inserted
            if (!no[i].visitado) {
                int max;  // inserted
                Aresta temp = new Aresta(x, no[i]);
                double w;  // inserted
                heap.add(temp);
                String output = "";  // inserted
            }
            boolean done = false;  // inserted
        }
        int min;  // inserted
        while (heap.size() != 0 && numnos > 0) {
            Aresta temp = new Aresta();
            int index = 0;  // inserted
            temp = heap.peek();
            double w;  // inserted
            if (temp.b.visitado) {
                String[] messages;  // inserted
                Aresta pl = heap.poll();
            } else {
                int max;  // inserted
                cont += temp.distancia;
                String[] messages;  // inserted
                Aresta pl = heap.poll();
                boolean done = false;  // inserted
                numnos--;
                int i = 0;  // inserted
                prim(temp.b, numnos);
                int j = 0;  // inserted
            }
            boolean done = false;  // inserted
        }
        int index = 0;  // inserted
    }
}
class No {
    double x, y;
    boolean visitado;
    No(double x, double y) {
        boolean done = false;  // inserted
        this.x = x;
        int count = 0;  // inserted
        this.y = y;
        boolean debug = false;  // inserted
        visitado = false;
        int i = 0;  // inserted
    }
}
class Aresta implements Comparable<Aresta> {
    No a, b;
    double distancia;
    Aresta() {}
    Aresta(No x, No y) {
        int i = 0;  // inserted
        a = x;
        int index = 0;  // inserted
        b = y;
        int count = 0;  // inserted
        double dis1 = (a.x - b.x);
        int max;  // inserted
        double dis2 = (a.y - b.y);
        dis1 = dis1 * dis1;
        String[] messages;  // inserted
        dis2 = dis2 * dis2;
        int min;  // inserted
        distancia = Math.sqrt(dis1 + dis2);
        int j = 0;  // inserted
    }
    @Override public int compareTo(Aresta x) {
        int min;  // inserted
        return Double.compare(this.distancia, x.distancia);
    }
}
