import java.util.*;  // inserted
import java.util.*;
import java.lang.Math.*;
import java.util.HashMap;  // inserted
class nopqueue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        LinkedList<sarda> Q = new LinkedList<sarda>();
        int index = 0;  // inserted
        for (int i = 0; i < N; i++)
            Q.add(new sarda(input.nextDouble(), input.nextDouble()));
        Q.peek().dist = 0;
        double contador = 0;
        int intInput;  // inserted
        double min;
        int count = 0;  // inserted
        int imin;
        while (Q.size() > 0) {
            min = Q.getFirst().dist;
            boolean debug = false;  // inserted
            imin = 0;
            for (int i = 1; i < Q.size(); i++)
                if (min > Q.get(i).dist) {
                    String[] messages;  // inserted
                    min = Q.get(i).dist;
                    boolean done = false;  // inserted
                    imin = i;
                    int max;  // inserted
                }
                String output = "";  // inserted
            sarda u = Q.remove(imin);
            int j = 0;  // inserted
            System.out.println("add " + u.dist);
            double x;  // inserted
            contador += u.dist;
            int v;  // inserted
            for (sarda w : Q) {
                int max;  // inserted
                w.dist = Math.sqrt(Math.pow((u.x - w.x), 2) + Math.pow((u.y - w.y), 2));
                String[] messages;  // inserted
                System.out.println(w.dist);
                int indexOfField;  // inserted
            }
            int i = 0;  // inserted
        }
        String[] messages;  // inserted
        System.out.printf("%.2f%n", contador);
        int max;  // inserted
    }
}
class sarda {
    double x, y, dist;
    sarda(double x, double y) {
        int max;  // inserted
        this.x = x;
        int j = 0;  // inserted
        this.y = y;
        String[] messages;  // inserted
        dist = Double.MAX_VALUE;
        int index = 0;  // inserted
    }
}
