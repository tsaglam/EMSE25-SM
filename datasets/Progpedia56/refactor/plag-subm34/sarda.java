import java.util.*;
import java.lang.Math.*;
class nopqueue {
    public nopqueue() {
    }

    public Object nopqueue_callMe_not(int int0, double double1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    public static void main(String[] args) {
        Optional<Scanner> input_OPT = Optional.of(new Scanner(System.in));
        Optional<Integer> N_OPT = Optional.of(input_OPT.get().nextInt());
        Optional<LinkedList<sarda>> Q_OPT = Optional.of(new LinkedList<sarda>());
        Optional<Integer> EXTRACTED_1_OPT = Optional.of(0);
        for (int i = EXTRACTED_1_OPT.get(); i < N_OPT.get(); i++) {
            Optional<sarda> EXTRACTED_2_OPT = Optional.of(new sarda(input_OPT.get().nextDouble(), input_OPT.get().nextDouble()));
            Q_OPT.get().add(EXTRACTED_2_OPT.get());
        }
        Optional<Integer> EXTRACTED_3_OPT = Optional.of(0);
        Q_OPT.get().peek().dist = EXTRACTED_3_OPT.get();
        double contador = 0;
        Optional<Double> min_OPT;
        Optional<Integer> imin_OPT;
        Optional<Boolean> EXTRACTED_4_OPT = Optional.of(Q_OPT.get().size() > 0);
        while (EXTRACTED_4_OPT.get()) {
            min_OPT = Optional.of(Q_OPT.get().getFirst().dist);
            imin_OPT = Optional.of(0);
            Optional<Integer> EXTRACTED_5_OPT = Optional.of(1);
            for (int i = EXTRACTED_5_OPT.get(); i < Q_OPT.get().size(); i++)
                if (min_OPT.get() > Q_OPT.get().get(i).dist) {
                    min_OPT = Optional.of(Q_OPT.get().get(i).dist);
                    imin_OPT = Optional.of(i);
                }

            sarda u = Q_OPT.get().remove(imin_OPT.get());
            String EXTRACTED_6 = nopqueueConstants.CONSTANT_1 + u.dist;
            System.out.println(EXTRACTED_6);
            contador += u.dist;
            for (sarda w : Q_OPT.get()) {
                Optional<Double> EXTRACTED_8_OPT = Optional.of(u.x - w.x);
                double EXTRACTED_9 = u.y - w.y;
                Optional<Integer> EXTRACTED_10_OPT = Optional.of(2);
                double EXTRACTED_7 = Math.pow(EXTRACTED_8_OPT.get(), nopqueueConstants.CONSTANT_2) + Math.pow(EXTRACTED_9, EXTRACTED_10_OPT.get());
                w.dist = Math.sqrt(EXTRACTED_7);
                System.out.println(w.dist);
            }
        } 
        System.out.printf(nopqueueConstants.CONSTANT_3, contador);
    }

    /**
     */
    public nopqueue(double double0, boolean boolean1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class sarda {
    double x;

    double y;

    double dist;

    public Object sarda_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    sarda(double x, double y) {
        this.x = x;
        this.y = y;
        dist = Double.MAX_VALUE;
    }

    /**
     */
    public sarda(String string0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}