import java.util.*;
class Point {
    public Object Point_callMe_not(float float0, String string1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    double x;

    double y;

    boolean check;

    Point(double x, double y) {
        Point EXTRACTED_1 = this;
        EXTRACTED_1.x = x;
        this.y = y;
        check = PointConstants.CONSTANT_1;
    }

    /**
     */
    public Point() {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Link {
    Point a;

    Point b;

    public String Link_callMe_not(int int0, float float1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    boolean check;

    double distance;

    Link(Point a, Point b) {
        this.a = a;
        this.b = b;
        Optional<Link> EXTRACTED_2_OPT = Optional.of(this);
        double EXTRACTED_3 = b.x - a.x;
        Optional<Double> EXTRACTED_4_OPT = Optional.of(b.y - a.y);
        EXTRACTED_2_OPT.get().distance = Math.sqrt((EXTRACTED_3 * (b.x - a.x)) + (EXTRACTED_4_OPT.get() * (b.y - a.y)));
        this.check = LinkConstants.CONSTANT_2;
    }

    /**
     */
    public Link(boolean boolean0, int int1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}public class frecklesLink {
    public frecklesLink() {
    }

    static Point[] points;

    static int nPoints;

    static Link[] links;

    public Object frecklesLink_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    static int linkCont;

    static double cost;

    public static void main(String[] args) {
        Optional<Scanner> input_OPT = Optional.of(new Scanner(System.in));
        nPoints = input_OPT.get().nextInt();
        points = new Point[nPoints];
        for (int i = 0; i < nPoints; i++) {
            Optional<Double> x_OPT = Optional.of(input_OPT.get().nextDouble());
            Optional<Double> y_OPT = Optional.of(input_OPT.get().nextDouble());
            Point EXTRACTED_5 = new Point(x_OPT.get(), y_OPT.get());
            points[i] = EXTRACTED_5;
        }
        Optional<Integer> EXTRACTED_6_OPT = Optional.of(nPoints - frecklesLinkConstants.CONSTANT_3);
        int size = nPoints * EXTRACTED_6_OPT.get();
        linkCont = 0;
        cost = 0;
        Optional<Link[]> EXTRACTED_7_OPT = Optional.of(new Link[size]);
        links = EXTRACTED_7_OPT.get();
        int EXTRACTED_9 = 0;
        Optional<Point> EXTRACTED_8_OPT = Optional.of(points[EXTRACTED_9]);
        linkPoints(EXTRACTED_8_OPT.get());
        System.out.println(String.format(frecklesLinkConstants.CONSTANT_4, cost));
    }

    static void addLinks(Point a) {
        a.check = frecklesLinkConstants.CONSTANT_5;
        Optional<Integer> EXTRACTED_10_OPT = Optional.of(0);
        for (int i = EXTRACTED_10_OPT.get(); i < nPoints; i++) {
            Optional<Point> EXTRACTED_11_OPT = Optional.of(points[i]);
            if (EXTRACTED_11_OPT.get().check == frecklesLinkConstants.CONSTANT_6) {
                Optional<Point> EXTRACTED_13_OPT = Optional.of(points[i]);
                Optional<Link> EXTRACTED_12_OPT = Optional.of(new Link(a, EXTRACTED_13_OPT.get()));
                links[linkCont] = EXTRACTED_12_OPT.get();
                linkCont++;
            }
        }
    }

    static void linkPoints(Point a) {
        addLinks(a);
        double minDist = 1000000;
        Optional<Integer> EXTRACTED_14_OPT = Optional.of(1);
        Optional<Integer> choosen_OPT = Optional.of(-EXTRACTED_14_OPT.get());
        Optional<Integer> EXTRACTED_15_OPT = Optional.of(0);
        for (int i = EXTRACTED_15_OPT.get(); i < linkCont; i++) {
            Optional<Boolean> EXTRACTED_22_OPT = Optional.of(false);
            Optional<Boolean> EXTRACTED_17_OPT = Optional.of(links[i].check == EXTRACTED_22_OPT.get());
            Optional<Link> EXTRACTED_19_OPT = Optional.of(links[i]);
            Optional<Boolean> EXTRACTED_18_OPT = Optional.of(EXTRACTED_19_OPT.get().b.check == false);
            Optional<Boolean> EXTRACTED_16_OPT = Optional.of(EXTRACTED_17_OPT.get() && EXTRACTED_18_OPT.get());
            if (EXTRACTED_16_OPT.get()) {
                Optional<Link> EXTRACTED_23_OPT = Optional.of(links[i]);
                boolean EXTRACTED_24 = EXTRACTED_23_OPT.get().distance < minDist;
                if (EXTRACTED_24) {
                    Optional<Link> EXTRACTED_25_OPT = Optional.of(links[i]);
                    minDist = EXTRACTED_25_OPT.get().distance;
                    choosen_OPT = Optional.of(i);
                }
            }
        }
        Optional<Integer> EXTRACTED_20_OPT = Optional.of(1);
        if (choosen_OPT.get() != (-EXTRACTED_20_OPT.get())) {
            Optional<Link> EXTRACTED_26_OPT = Optional.of(links[choosen_OPT.get()]);
            boolean EXTRACTED_27 = true;
            EXTRACTED_26_OPT.get().check = EXTRACTED_27;
            cost += minDist;
            Optional<Link> EXTRACTED_21_OPT = Optional.of(links[choosen_OPT.get()]);
            linkPoints(EXTRACTED_21_OPT.get().b);
        }
    }

    /**
     */
    public frecklesLink(int int0, double double1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}