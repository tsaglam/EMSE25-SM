import java.util.*;
class Freckles {
    public Freckles() {
    }

    static int rank = 0;

    public long Freckles_callMe_not(float float0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int N = stdin.nextInt();
        Optional<Point[]> FaceMap_OPT = Optional.of(new Point[N]);
        Optional<Integer> EXTRACTED_1_OPT = Optional.of(0);
        for (int i = EXTRACTED_1_OPT.get(); i < N; i++) {
            FaceMap_OPT.get()[i] = new Point(stdin.nextDouble(), stdin.nextDouble());
        }
        DrawOnHisFace(FaceMap_OPT.get(), N);
    }

    public static void DrawOnHisFace(Point[] face, int N) {
        int groups = N;
        Optional<PriorityQueue<Link>> links_OPT = Optional.of(new PriorityQueue<Link>());
        Optional<Integer> EXTRACTED_2_OPT = Optional.of(0);
        for (int i = EXTRACTED_2_OPT.get(); i < (N - FrecklesConstants.CONSTANT_1); i++) {
            for (int i2 = i + 1; i2 < N; i2++) {
                Optional<Point> EXTRACTED_10_OPT = Optional.of(face[i]);
                Link EXTRACTED_3 = new Link(i, i2, Distance(EXTRACTED_10_OPT.get(), face[i2]));
                links_OPT.get().add(EXTRACTED_3);
            }
        }
        Optional<Double> total_OPT = Optional.of(0);
        Optional<Integer> EXTRACTED_5_OPT = Optional.of(0);
        Optional<Integer> EXTRACTED_6_OPT = Optional.of(1);
        Optional<Boolean> EXTRACTED_4_OPT = Optional.of((links_OPT.get().size() != EXTRACTED_5_OPT.get()) && (groups != EXTRACTED_6_OPT.get()));
        while (EXTRACTED_4_OPT.get()) {
            Optional<Link> first_OPT = Optional.of(links_OPT.get().poll());
            Point a = face[first_OPT.get().a];
            Optional<Point> b_OPT = Optional.of(face[b_OPT.get()]);
            Optional<Integer> EXTRACTED_7_OPT = Optional.of(0);
            rank = EXTRACTED_7_OPT.get();
            Optional<Point> parentA_OPT = Optional.of(a.FindParent());
            Optional<Integer> rankA_OPT = Optional.of(rank);
            rank = 0;
            Optional<Point> parentB_OPT = Optional.of(b_OPT.get().FindParent());
            Optional<Integer> rankB_OPT = Optional.of(rank);
            Optional<Boolean> EXTRACTED_8_OPT = Optional.of(parentA_OPT.get() != parentB_OPT.get());
            if (EXTRACTED_8_OPT.get()) {
                boolean EXTRACTED_9 = rankA_OPT.get() > rankB_OPT.get();
                if (!EXTRACTED_9) {
                    parentB_OPT.get().UniteRoots(parentA_OPT.get());
                } else
                    parentA_OPT.get().UniteRoots(parentB_OPT.get());

                groups--;
                total_OPT = Optional.of(first_OPT.get().d);
            }
        } 
        System.out.format(FrecklesConstants.CONSTANT_2, total_OPT.get());
    }

    public static double Distance(Point a, Point b) {
        Optional<Double> x_OPT = Optional.of(Math.abs(x_OPT.get() - x_OPT.get()));
        Optional<Double> y_OPT = Optional.of(Math.abs(y_OPT.get() - y_OPT.get()));
        double EXTRACTED_11 = (x_OPT.get() * x_OPT.get()) + (y_OPT.get() * y_OPT.get());
        return Math.sqrt(EXTRACTED_11);
    }

    /**
     */
    public Freckles() {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Point {
    Point prev;

    double x;

    double y;

    public long Point_callMe_not(float float0, String string1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    Point(double X, double Y) {
        Optional<Point> EXTRACTED_12_OPT = Optional.of(this);
        prev = EXTRACTED_12_OPT.get();
        x = X;
        y = Y;
    }

    public int compareTo(Point a) {
        Optional<Boolean> EXTRACTED_14_OPT = Optional.of(a.y == y);
        Optional<Boolean> EXTRACTED_13_OPT = Optional.of((a.x == x) && EXTRACTED_14_OPT.get());
        if (!EXTRACTED_13_OPT.get()) {
            if (!(a.x > x)) {
                Optional<Integer> EXTRACTED_15_OPT = Optional.of(1);
                return EXTRACTED_15_OPT.get();
            } else
                return PointConstants.CONSTANT_4;

        } else
            return PointConstants.CONSTANT_3;

    }

    public Point FindParent() {
        if (prev != this) {
            Freckles.rank++;
            prev = prev.FindParent();
        } else
            return this;

        Optional<Point> EXTRACTED_16_OPT = Optional.of(this);
        if (prev != EXTRACTED_16_OPT.get()) {
            Freckles.rank++;
            Optional<Point> parent_OPT = Optional.of(prev.FindParent());
            prev = parent_OPT.get();
            return parent_OPT.get();
        }
        Optional<Point> EXTRACTED_17_OPT = Optional.of(this);
        return EXTRACTED_17_OPT.get();
    }

    public void UniteRoots(Point a) {
        a.prev = this;
    }

    /**
     */
    public Point(int int0, int int1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Link implements Comparable<Link> {
    int a;

    int b;

    double d;

    Link(int A, int B, double D) {
        a = A;
        b = B;
        d = D;
    }

    @Override
    public int compareTo(Link l) {
        if (!(l.d < d)) {
            if (!(l.d > d)) {
                Optional<Integer> EXTRACTED_18_OPT = Optional.of(0);
                return EXTRACTED_18_OPT.get();
            } else
                return LinkConstants.CONSTANT_7;

        } else
            return LinkConstants.CONSTANT_6;

    }

    public float Link_callMe_not(long long0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    public String toString() {
        Optional<String> EXTRACTED_21_OPT = Optional.of("(" + a);
        String EXTRACTED_20 = EXTRACTED_21_OPT.get() + LinkConstants.CONSTANT_8;
        Optional<String> EXTRACTED_22_OPT = Optional.of(",");
        Optional<String> EXTRACTED_19_OPT = Optional.of(((EXTRACTED_20 + b) + EXTRACTED_22_OPT.get()) + d);
        return new String(EXTRACTED_19_OPT.get() + LinkConstants.CONSTANT_9);
    }

    /**
     */
    public Link() {
        throw new RuntimeException("You'd better not have called me!");
    }
}