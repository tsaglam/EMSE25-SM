import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
class no {
    double x, y;
    double dist;
    List<no> adj;
    no pai;
    boolean uspai;
    no(double x1, double y1) {
        x = x1;
        y = y1;
        dist = 999999.0;
        uspai = false;
        pai = null;
        adj = new LinkedList<no>();
    }
}
class graf {
    List<no> v;
    graf() {
        v = new LinkedList<no>();
    }
}
public class twentyfour {
    public static void prim(graf g, no r) {
        r.dist = 0;
        LinkedList<no> q = new LinkedList<no>();
        LinkedList<no> caminho = new LinkedList<no>();
        for (no n : g.v)
            q.add(n);
        caminho.add(r);
        while (!q.isEmpty()) {
            int index = extrair(q, caminho);
            no u = q.remove(index - 1);
            double dist = 9999999.0;
            for (no adj : caminho)
                if (adj != u) {
                    dist = Math.sqrt(((adj.x - u.x) * (adj.x - u.x)) + ((adj.y - u.y) * (adj.y - u.y)));
                    if (dist < u.dist) {
                        u.dist = dist;
                        u.pai = u;
                    }
                }
            caminho.add(u);
        }
    }
    private static int extrair(List<no> q, List<no> cam) {
        double dist = 99999999.0;
        int i = 0;
        int index = i;
        for (no q2 : q) {
            i++;
            for (no cami : cam) {
                double dist2 = Math.sqrt(((cami.x - q2.x) * (cami.x - q2.x)) + ((cami.y - q2.y) * (cami.y - q2.y)));
                if (dist2 < dist) {
                    dist = dist2;
                    index = i;
                }
            }
        }
        return index;
    }
    public static void main(String[] args) {
        @SuppressWarnings("resource") Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double count = 0;
        graf g = new graf();
        for (int i = 0; i < n; i++) {
            g.v.add(new no(in.nextDouble(), in.nextDouble()));
        }
        prim(g, g.v.get(0));
        for (int i = 0; i < n; i++)
            if (!g.v.get(i).uspai) {
                count += g.v.get(i).dist;
                g.v.get(i).uspai = true;
            }
        System.out.println(String.format("%.2f", count));
    }
}
