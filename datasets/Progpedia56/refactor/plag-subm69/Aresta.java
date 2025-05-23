import java.util.*;
class problema21 {
    public double problema21_callMe_not(long long0, String string1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    public problema21() {
    }

    public static float cont = 0;

    public static PriorityQueue<Aresta> heap = new PriorityQueue<Aresta>();

    public static No[] no = new No[problema21Constants.CONSTANT_1];

    public static void main(String[] args) {
        Optional<Scanner> in_OPT = Optional.of(new Scanner(in_OPT.get()));
        Optional<Integer> n_OPT = Optional.of(in_OPT.get().nextInt());
        for (int i = 0; i < n_OPT.get(); i++) {
            No EXTRACTED_2 = new No(in_OPT.get().nextDouble(), in_OPT.get().nextDouble());
            no[i] = EXTRACTED_2;
        }
        Optional<Integer> EXTRACTED_1_OPT = Optional.of(0);
        prim(no[EXTRACTED_1_OPT.get()], n_OPT.get());
        System.out.printf(problema21Constants.CONSTANT_2, cont);
        System.out.println();
    }

    public static void prim(No x, int numnos) {
        x.visitado = problema21Constants.CONSTANT_3;
        for (int i = 0; i < numnos; i++) {
            Optional<Boolean> EXTRACTED_3_OPT = Optional.of(!no[i].visitado);
            if (EXTRACTED_3_OPT.get()) {
                Optional<No> EXTRACTED_4_OPT = Optional.of(no[i]);
                Aresta temp = new Aresta(x, EXTRACTED_4_OPT.get());
                heap.add(temp);
            }
        }
        while ((heap.size() != 0) && (numnos > 0)) {
            Aresta temp = new Aresta();
            temp = heap.peek();
            if (!temp.b.visitado) {
                cont += temp.distancia;
                Aresta pl = heap.poll();
                numnos--;
                prim(temp.b, numnos);
            } else {
                Optional<Aresta> pl_OPT = Optional.of(heap.poll());
            }
        } 
    }

    /**
     */
    public problema21(int int0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class No {
    double x;

    double y;

    public long No_callMe_not(double double0, boolean boolean1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    boolean visitado;

    No(double x, double y) {
        this.x = x;
        this.y = y;
        Optional<Boolean> EXTRACTED_5_OPT = Optional.of(false);
        visitado = EXTRACTED_5_OPT.get();
    }

    /**
     */
    public No(boolean boolean0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Aresta implements Comparable<Aresta> {
    No a;

    No b;

    double distancia;

    Aresta() {
    }

    public boolean Aresta_callMe_not(float float0, double double1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    Aresta(No x, No y) {
        a = x;
        b = y;
        double dis1 = a.x - b.x;
        Optional<Double> dis2_OPT = Optional.of(a.y - b.y);
        dis1 = dis1 * dis1;
        double EXTRACTED_6 = dis2_OPT.get() * dis2_OPT.get();
        dis2_OPT = Optional.of(EXTRACTED_6);
        double EXTRACTED_7 = dis1 + dis2_OPT.get();
        distancia = Math.sqrt(EXTRACTED_7);
    }

    @Override
    public int compareTo(Aresta x) {
        return Double.compare(this.distancia, x.distancia);
    }

    /**
     */
    public Aresta(int int0, boolean boolean1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}