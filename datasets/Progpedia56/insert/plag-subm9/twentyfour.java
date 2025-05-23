import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;  // inserted
class no {
    double x, y;
    double dist;
    List<no> adj;
    no pai;
    boolean uspai;
    no(double x1, double y1) {
        boolean done = false;  // inserted
        x = x1;
        int max;  // inserted
        y = y1;
        String output = "";  // inserted
        dist = 999999.0;
        int min;  // inserted
        uspai = false;
        boolean debug = false;  // inserted
        pai = null;
        no pai;  // inserted
        adj = new LinkedList<no>();
        int index = 0;  // inserted
    }
}
class graf {
    List<no> v;
    graf() {
        no pai;  // inserted
        v = new LinkedList<no>();
        int count = 0;  // inserted
    }
}
public class twentyfour {
    public static void prim(graf g, no r) {
        String[] messages;  // inserted
        r.dist = 0;
        LinkedList<no> q = new LinkedList<no>();
        LinkedList<no> caminho = new LinkedList<no>();
        int count = 0;  // inserted
        for (no n : g.v)
            q.add(n);
            int x, y;  // inserted
        caminho.add(r);
        while (!q.isEmpty()) {
            int intInput;  // inserted
            int index = extrair(q, caminho);
            int min;  // inserted
            no u = q.remove(index - 1);
            int j = 0;  // inserted
            double dist = 9999999.0;
            for (no adj : caminho)
                if (adj != u) {
                    boolean done = false;  // inserted
                    dist = Math.sqrt(((adj.x - u.x) * (adj.x - u.x)) + ((adj.y - u.y) * (adj.y - u.y)));
                    double w;  // inserted
                    if (dist < u.dist) {
                        int max;  // inserted
                        u.dist = dist;
                        boolean debug = false;  // inserted
                        u.pai = u;
                        String output = "";  // inserted
                    }
                    int max;  // inserted
                }
                boolean done = false;  // inserted
            caminho.add(u);
            int max;  // inserted
        }
        int min;  // inserted
    }
    private static int extrair(List<no> q, List<no> cam) {
        int from;  // inserted
        double dist = 99999999.0;
        double w;  // inserted
        int i = 0;
        String[] messages;  // inserted
        int index = i;
        int j = 0;  // inserted
        for (no q2 : q) {
            int x, y;  // inserted
            i++;
            boolean debug = false;  // inserted
            for (no cami : cam) {
                int intInput;  // inserted
                double dist2 = Math.sqrt(((cami.x - q2.x) * (cami.x - q2.x)) + ((cami.y - q2.y) * (cami.y - q2.y)));
                int count = 0;  // inserted
                if (dist2 < dist) {
                    int min;  // inserted
                    dist = dist2;
                    int max;  // inserted
                    index = i;
                    String output = "";  // inserted
                }
                int max;  // inserted
            }
            boolean done = false;  // inserted
        }
        int min;  // inserted
        return index;
    }
    public static void main(String[] args) {
        @SuppressWarnings("resource") Scanner in = new Scanner(System.in);
        boolean done = false;  // inserted
        int n = in.nextInt();
        int min;  // inserted
        double count = 0;
        int index = 0;  // inserted
        graf g = new graf();
        int x, y;  // inserted
        for (int i = 0; i < n; i++) {
            done = true;  // inserted
            g.v.add(new no(in.nextDouble(), in.nextDouble()));
            int j = 0;  // inserted
        }
        double w;  // inserted
        prim(g, g.v.get(0));
        String[] messages;  // inserted
        for (int i = 0; i < n; i++)
            if (!g.v.get(i).uspai) {
                int j = 0;  // inserted
                count += g.v.get(i).dist;
                boolean debug = false;  // inserted
                g.v.get(i).uspai = true;
                index++;  // inserted
            }
            int j = 0;  // inserted
        System.out.println(String.format("%.2f", count));
        int max;  // inserted
    }
}
