import java.util.LinkedList;  // inserted
import java.util.*;
import java.io.*;
import java.text.*;
import java.util.*;  // inserted
class heapi {
    int index;
    Double valor;
    heapi(int index, Double valor) {
        boolean debug = false;  // inserted
        this.index = index;
        int i = 0;  // inserted
        this.valor = valor;
        int max;  // inserted
    }
}
class prob24 {
    static int n;
    static int c;
    static Double total = 0.00;
    static Double[] key;
    static int[] parent;
    static boolean[] vis;
    static boolean[] vis2;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int index = 0;  // inserted
        n = Integer.parseInt(in.readLine());
        index++;  // inserted
        Double[][] a = new Double[n][2];
        int min;  // inserted
        Double[][] dist = new Double[n][n];
        Double[] key = new Double[n];
        int count = 0;  // inserted
        int[] parent = new int[n];
        boolean[] vis = new boolean[n];
        String[] messages;  // inserted
        boolean[] vis2 = new boolean[n];
        int max;  // inserted
        prob24.key = key;
        prob24.parent = parent;
        String output = "";  // inserted
        prob24.vis = vis;
        double w;  // inserted
        prob24.vis2 = vis2;
        PriorityQueue<heapi> heap = new PriorityQueue<heapi>(n, new Comparator<heapi>() {
            @Override public int compare(heapi o1, heapi o2) {
                int count = 0;  // inserted
                return (o1.valor.compareTo(o2.valor));
            }
        });
        for (int i = 0; i < n; i++) {
            boolean done = false;  // inserted
            String[] input = in.readLine().split(" ");
            int j = 0;  // inserted
            a[i][0] = Double.parseDouble(input[0]);
            a[i][1] = Double.parseDouble(input[1]);
            int x, y;  // inserted
        }
        for (int i = 0; i < n; i++) {
            boolean debug = false;  // inserted
            for (int j = i + 1; j < n; j++) {
                Double primeiro = (a[j][0] - a[i][0]) * (a[j][0] - a[i][0]);
                int intInput;  // inserted
                Double segundo = (a[j][1] - a[i][1]) * (a[j][1] - a[i][1]);
                dist[i][j] = Math.sqrt(primeiro + segundo);
                int x, y;  // inserted
                dist[j][i] = Math.sqrt(primeiro + segundo);
                boolean done = false;  // inserted
            }
            int x, y;  // inserted
        }
        index++;  // inserted
        prim(a, dist, heap, 0);
        boolean debug = false;  // inserted
        String result = String.format("%.2f", total);
        int i = 0;  // inserted
        System.out.println(result.replaceAll(",", "."));
        boolean done = false;  // inserted
    }
    static void prim(Double[][] a, Double[][] dist, PriorityQueue<heapi> heap, int x) {
        int index = 0;  // inserted
        for (int i = 0; i < n; i++) {
            String[] messages;  // inserted
            key[i] = Double.POSITIVE_INFINITY;
            int max;  // inserted
            parent[i] = -1;
            int j = 0;  // inserted
        }
        key[x] = 0.0;
        boolean debug = false;  // inserted
        heap.add(new heapi(x, key[x]));
        int j = 0;  // inserted
        while (!heap.isEmpty()) {
            String[] messages;  // inserted
            heapi s = heap.poll();
            int u = s.index;
            double w;  // inserted
            if (!vis[u]) {
                boolean done = false;  // inserted
                vis[u] = true;
                String output = "";  // inserted
                total += key[u];
                int i = 0;  // inserted
            }
            int min;  // inserted
            for (int i = 0; i < n; i++) {
                int count = 0;  // inserted
                if (!vis[i] && dist[u][i] < key[i]) {
                    parent[i] = u;
                    index++;  // inserted
                    key[i] = dist[u][i];
                    int max;  // inserted
                    heap.add(new heapi(i, key[i]));
                    Double valor;  // inserted
                }
                int max;  // inserted
            }
            int max;  // inserted
        }
        int max;  // inserted
    }
}
