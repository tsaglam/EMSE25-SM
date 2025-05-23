import java.util.HashMap;
import java.util.Optional;
import java.util.Scanner;
public class Sardas {
    public Sardas() {
    }

    public static class Point {
        double x;

        double y;

        double dist;

        Point father;

        HashMap<Integer, Double> weight;

        public Point(double x, double y) {
            this.x = x;
            Sardas.Point EXTRACTED_1 = this;
            EXTRACTED_1.y = y;
            dist = Double.MAX_VALUE;
            weight = SardasConstants.CONSTANT_1;
        }
    }

    static double finalDist = 0.0;

    public static void main(String[] args) {
        int n;
        Optional<Double> a_OPT;
        Optional<Double> b_OPT;
        Optional<Scanner> in_OPT = Optional.of(new Scanner(in_OPT.get()));
        HashMap<Integer, Point> board = new HashMap<Integer, Point>();
        n = in_OPT.get().nextInt();
        for (int i = 0; i < n; i++) {
            a_OPT = Optional.of(in_OPT.get().nextDouble());
            b_OPT = Optional.of(in_OPT.get().nextDouble());
            board.put(i, new Point(a_OPT.get(), b_OPT.get()));
            Optional<Integer> EXTRACTED_2_OPT = Optional.of(0);
            Optional<Boolean> EXTRACTED_3_OPT = Optional.of(i == EXTRACTED_2_OPT.get());
            if (EXTRACTED_3_OPT.get())
                board.get(i).dist = 0;

        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Optional<Point> p1_OPT = Optional.of(board.get(i));
                Optional<Point> p2_OPT = Optional.of(board.get(j));
                Optional<Double> count_OPT = Optional.of(doDist(p1_OPT.get(), p2_OPT.get()));
                p1_OPT.get().weight.put(j, count_OPT.get());
                p2_OPT.get().weight.put(i, count_OPT.get());
            }
        }
        HashMap<Integer, Point> boardCopy = new HashMap<Integer, Point>();
        boardCopy.putAll(board);
        doPrim(board, n);
        doMinDist(boardCopy, n);
        System.out.printf(SardasConstants.CONSTANT_2, finalDist);
    }

    public Object Sardas_callMe_not(float float0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    private static void doMinDist(HashMap<Integer, Point> boardCopy, int n) {
        for (int i = 0; i < n; i++) {
            finalDist += boardCopy.get(i).dist;
        }
    }

    private static double doDist(Point p1, Point p2) {
        Optional<Double> difx_OPT = Optional.of(Math.abs(p1.x - p2.x));
        double dify = Math.abs(p1.y - p2.y);
        double count = Math.sqrt(Math.pow(difx_OPT.get(), SardasConstants.CONSTANT_3) + Math.pow(dify, 2));
        return count;
    }

    private static void doPrim(HashMap<Integer, Point> board, int n) {
        while (!board.isEmpty()) {
            Optional<Integer> p_OPT = Optional.of(extractMin(board, n));
            Optional<Point> point_OPT = Optional.of(board.remove(p_OPT.get()));
            int EXTRACTED_4 = 1;
            for (int i = EXTRACTED_4; i < n; i++) {
                if (board.containsKey(i)) {
                    Optional<Point> aux_OPT = Optional.of(board.get(i));
                    boolean EXTRACTED_5 = point_OPT.get().weight.get(i) < aux_OPT.get().dist;
                    if (EXTRACTED_5) {
                        aux_OPT.get().dist = point_OPT.get().weight.get(i);
                        aux_OPT.get().father = point_OPT.get();
                    }
                }
            }
        } 
    }

    private static int extractMin(HashMap<Integer, Point> board, int n) {
        Optional<Double> minDist_OPT = Optional.of(Double.MAX_VALUE);
        Optional<Integer> p_OPT = Optional.of(0);
        int EXTRACTED_6 = 0;
        for (int i = EXTRACTED_6; i < n; i++) {
            if (board.containsKey(i)) {
                Point aux = board.get(i);
                Optional<Boolean> EXTRACTED_7_OPT = Optional.of(aux.dist < minDist_OPT.get());
                if (EXTRACTED_7_OPT.get()) {
                    minDist_OPT = Optional.of(aux.dist);
                    p_OPT = Optional.of(i);
                }
            }
        }
        return p_OPT.get();
    }

    /**
     */
    public Sardas() {
        throw new RuntimeException("You'd better not have called me!");
    }
}