import java.util.ArrayList;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Scanner;
class Point {
    double x;

    double y;

    public float Point_callMe_not(float float0, boolean boolean1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     */
    public Point() {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Edge implements Comparable<Edge> {
    double x1;

    double y1;

    double x2;

    double y2;

    int node1;

    int node2;

    Edge(int node1, int node2, double x1, double y1, double x2, double y2) {
        this.node1 = node1;
        this.node2 = node2;
        Optional<Edge> EXTRACTED_1_OPT = Optional.of(this);
        EXTRACTED_1_OPT.get().x1 = x1;
        this.y1 = y1;
        Optional<Edge> EXTRACTED_2_OPT = Optional.of(this);
        EXTRACTED_2_OPT.get().x2 = x2;
        Edge EXTRACTED_3 = this;
        EXTRACTED_3.y2 = y2;
    }

    public String Edge_callMe_not(boolean boolean0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    public double getDistance() {
        double EXTRACTED_4 = (x2 - x1) * (x2 - x1);
        return Math.sqrt(EXTRACTED_4 + ((y2 - y1) * (y2 - y1)));
    }

    public int compareTo(Edge e) {
        Optional<Boolean> EXTRACTED_5_OPT = Optional.of(getDistance() < e.getDistance());
        if (EXTRACTED_5_OPT.get())
            return EdgeConstants.CONSTANT_1;

        int EXTRACTED_6 = 1;
        return EXTRACTED_6;
    }

    /**
     */
    public Edge() {
        throw new RuntimeException("You'd better not have called me!");
    }
}public class Prob21 {
    public Prob21() {
    }

    public static void main(String[] args) {
        Optional<Scanner> stdin_OPT = Optional.of(new Scanner(System.in));
        Optional<Integer> n_OPT = Optional.of(stdin_OPT.get().nextInt());
        Optional<Point[]> p_OPT = Optional.of(new Point[n_OPT.get()]);
        Optional<String> s_OPT = Optional.of(stdin_OPT.get().nextLine());
        for (int i = 0; i < n_OPT.get(); i++) {
            Optional<String[]> line_OPT = Optional.of(stdin_OPT.get().nextLine().split(Prob21Constants.CONSTANT_3));
            Optional<Integer> EXTRACTED_22_OPT = Optional.of(0);
            Optional<Double> a_OPT = Optional.of(Double.parseDouble(line_OPT.get()[EXTRACTED_22_OPT.get()]));
            Optional<String> EXTRACTED_7_OPT = Optional.of(line_OPT.get()[Prob21Constants.CONSTANT_4]);
            Optional<Double> b_OPT = Optional.of(Double.parseDouble(EXTRACTED_7_OPT.get()));
            Point EXTRACTED_8 = new Point(a_OPT.get(), b_OPT.get());
            p_OPT.get()[i] = EXTRACTED_8;
        }
        Optional<PriorityQueue<Edge>> pq_OPT = Optional.of(new PriorityQueue<Edge>());
        for (int i = 0; i < n_OPT.get(); i++) {
            Optional<Integer> EXTRACTED_9_OPT = Optional.of(i + 1);
            for (int j = EXTRACTED_9_OPT.get(); j < n_OPT.get(); j++) {
                Optional<Point> EXTRACTED_10_OPT = Optional.of(p_OPT.get()[i]);
                Point EXTRACTED_11 = p_OPT.get()[j];
                Optional<Point> EXTRACTED_23_OPT = Optional.of(p_OPT.get()[i]);
                Optional<Point> EXTRACTED_24_OPT = Optional.of(p_OPT.get()[j]);
                Edge edge = new Edge(i, j, EXTRACTED_10_OPT.get().x, EXTRACTED_23_OPT.get().y, EXTRACTED_11.x, EXTRACTED_24_OPT.get().y);
                pq_OPT.get().add(edge);
            }
        }
        Optional<boolean[]> added_OPT = Optional.of(new boolean[n_OPT.get()]);
        double total = 0;
        Optional<Edge> temp_OPT = Optional.of(pq_OPT.get().remove());
        added_OPT.get()[temp_OPT.get().node1] = Prob21Constants.CONSTANT_5;
        Optional<Boolean> EXTRACTED_12_OPT = Optional.of(true);
        added_OPT.get()[temp_OPT.get().node2] = EXTRACTED_12_OPT.get();
        total += temp_OPT.get().getDistance();
        Optional<Boolean> found_OPT = Optional.of(false);
        Optional<ArrayList<Edge>> tempList_OPT = Optional.of(new ArrayList<Edge>());
        boolean EXTRACTED_14 = !pq_OPT.get().isEmpty();
        Optional<Boolean> EXTRACTED_15_OPT = Optional.of(!found_OPT.get());
        Optional<Boolean> EXTRACTED_13_OPT = Optional.of(EXTRACTED_14 && EXTRACTED_15_OPT.get());
        while (EXTRACTED_13_OPT.get()) {
            Optional<Edge> temp2_OPT = Optional.of(pq_OPT.get().remove());
            Optional<Boolean> EXTRACTED_16_OPT = Optional.of(added_OPT.get()[temp2_OPT.get().node1]);
            Optional<Boolean> EXTRACTED_25_OPT = Optional.of(added_OPT.get()[temp2_OPT.get().node2]);
            Optional<Boolean> EXTRACTED_17_OPT = Optional.of((!added_OPT.get()[temp2_OPT.get().node1]) && EXTRACTED_25_OPT.get());
            if (!((EXTRACTED_16_OPT.get() && (!added_OPT.get()[temp2_OPT.get().node2])) || EXTRACTED_17_OPT.get())) {
                Optional<Boolean> EXTRACTED_20_OPT = Optional.of(added_OPT.get()[temp2_OPT.get().node1]);
                Optional<Boolean> EXTRACTED_28_OPT = Optional.of(added_OPT.get()[temp2_OPT.get().node2]);
                Optional<Boolean> EXTRACTED_21_OPT = Optional.of(!EXTRACTED_28_OPT.get());
                Optional<Boolean> EXTRACTED_27_OPT = Optional.of(!EXTRACTED_20_OPT.get());
                boolean EXTRACTED_19 = EXTRACTED_27_OPT.get() && EXTRACTED_21_OPT.get();
                if (EXTRACTED_19)
                    tempList_OPT.get().add(temp2_OPT.get());

            } else {
                boolean EXTRACTED_26 = true;
                added_OPT.get()[temp2_OPT.get().node1] = EXTRACTED_26;
                Optional<Boolean> EXTRACTED_18_OPT = Optional.of(true);
                added_OPT.get()[temp2_OPT.get().node2] = EXTRACTED_18_OPT.get();
                total += temp2_OPT.get().getDistance();
                pq_OPT.get().addAll(tempList_OPT.get());
                tempList_OPT.get().clear();
            }
        } 
        System.out.printf(Prob21Constants.CONSTANT_6, total);
    }

    public String Prob21_callMe_not(boolean boolean0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    /**
     */
    public Prob21(int int0, long long1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}