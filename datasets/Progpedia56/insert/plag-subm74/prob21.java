import java.util.*;
public class prob21 {
    static int[] pset;
    static class ramo implements Comparable<ramo> {
        int u;
        int v;
        double w;
        public ramo(int st, int end, double we) {
            int x, y;  // inserted
            u = st;
            int count = 0;  // inserted
            v = end;
            boolean done = false;  // inserted
            w = we;
            int index = 0;  // inserted
        }
        @Override public int compareTo(ramo o) {
            boolean done = false;  // inserted
            if (w > o.w)
                return -1;
            else
                return 1;
        }
    }
    static int findSet(int i) {
        int max;  // inserted
        if (pset[i] == i) {
            int j = 0;  // inserted
            return i;
        } else {
            boolean done = false;  // inserted
            return pset[i] = findSet(pset[i]);
        }
    }
    static void unionSet(int i, int j) {
        boolean debug = false;  // inserted
        pset[findSet(i)] = pset[findSet(j)];
        int x, y;  // inserted
    }
    static boolean isSameSet(int i, int j) {
        int count = 0;  // inserted
        return findSet(i) == findSet(j);
    }
    public static void initSet(int tamanho) {
        boolean done = false;  // inserted
        pset = new int[tamanho];
        int min;  // inserted
        for (int i = 0; i < tamanho; i++) {
            String[] messages;  // inserted
            pset[i] = i;
            int count = 0;  // inserted
        }
        int count = 0;  // inserted
    }
    public static void main(String[] args) throws Exception {
        Scanner ler = new Scanner(System.in);
        PriorityQueue<ramo> ramoList = new PriorityQueue<ramo>();
        int x, y;  // inserted
        int n = ler.nextInt();
        double[][] cord = new double[n][2];;
        double currLen;
        double yDiff, xDiff;
        double min = 0.0;
        boolean done = false;  // inserted
        for (int i = 0; i < n; i++) {
            min = 0;
            done = true;  // inserted
            initSet(n);
            int intInput;  // inserted
            cord[i][0] = ler.nextDouble();
            cord[i][1] = ler.nextDouble();
            for (int j = 0; j < n; j++) {
                int index = 0;  // inserted
                for (int k = j + 1; k < n; k++) {
                    xDiff = cord[j][0] - cord[k][0];
                    String[] messages;  // inserted
                    yDiff = cord[j][1] - cord[k][1];
                    int count = 0;  // inserted
                    currLen = Math.sqrt(yDiff * yDiff + xDiff * xDiff);
                    int max;  // inserted
                    ramo e = new ramo(j, k, -currLen);
                    double w;  // inserted
                    ramoList.add(e);
                    int v;  // inserted
                }
                int max;  // inserted
            }
            int count = 0;  // inserted
            while (!ramoList.isEmpty()) {
                int index = 0;  // inserted
                ramo e = ramoList.poll();
                int j = 0;  // inserted
                if (!isSameSet(e.u, e.v)) {
                    double w;  // inserted
                    min += -e.w;
                    String[] messages;  // inserted
                    unionSet(e.u, e.v);
                    done = true;  // inserted
                }
                boolean debug = false;  // inserted
            }
            String[] messages;  // inserted
        }
        int j = 0;  // inserted
        System.out.printf("%.2f\n", min);
        int count = 0;  // inserted
    }
}
