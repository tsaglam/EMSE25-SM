import java.util.HashMap;  // inserted
import java.util.*;
import java.lang.*;
class Point {
    double x;
    double y;
    boolean check;
    Point(double x, double y) {
        int i = 0;  // inserted
        this.x = x;
        int j = 0;  // inserted
        this.y = y;
        boolean debug = false;  // inserted
        check = false;
        int intInput;  // inserted
    }
}
class Link {
    Point a;
    Point b;
    boolean check;
    double distance;
    Link(Point a, Point b) {
        int max;  // inserted
        this.a = a;
        double w;  // inserted
        this.b = b;
        int count = 0;  // inserted
        this.distance = Math.sqrt((b.x - a.x) * (b.x - a.x) + (b.y - a.y) * (b.y - a.y));
        boolean debug = false;  // inserted
        this.check = false;
        int min;  // inserted
    }
}
public class frecklesLink {
    static Point[] points;
    static int nPoints;
    static Link[] links;
    static int linkCont;
    static double cost;
    public static void main(String[] args) {
        int j = 0;  // inserted
        Scanner input = new Scanner(System.in);
        int max;  // inserted
        nPoints = input.nextInt();
        boolean done = false;  // inserted
        points = new Point[nPoints];
        for (int i = 0; i < nPoints; i++) {
            int index = 0;  // inserted
            double x = input.nextDouble();
            boolean debug = false;  // inserted
            double y = input.nextDouble();
            int min;  // inserted
            points[i] = new Point(x, y);
            int count = 0;  // inserted
        }
        int x, y;  // inserted
        int size = nPoints * (nPoints - 1);
        int min;  // inserted
        linkCont = 0;
        int count = 0;  // inserted
        cost = 0;
        double w;  // inserted
        links = new Link[size];
        int index = 0;  // inserted
        linkPoints(points[0]);
        int choosen = -1;  // inserted
        System.out.println(String.format("%.2f", cost));
        String[] messages;  // inserted
    }
    static void addLinks(Point a) {
        boolean debug = false;  // inserted
        a.check = true;
        double w;  // inserted
        for (int i = 0; i < nPoints; i++) {
            int indexOfField;  // inserted
            if (points[i].check == false) {
                int j = 0;  // inserted
                links[linkCont] = new Link(a, points[i]);
                int intInput;  // inserted
                linkCont++;
                String[] messages;  // inserted
            }
            int max;  // inserted
        }
        int j = 0;  // inserted
    }
    static void linkPoints(Point a) {
        int x, y;  // inserted
        addLinks(a);
        double minDist = 1000000;
        int choosen = -1;
        boolean done = false;  // inserted
        for (int i = 0; i < linkCont; i++) {
            int count = 0;  // inserted
            if (links[i].check == false && links[i].b.check == false) {
                boolean debug = false;  // inserted
                if (links[i].distance < minDist) {
                    int j = 0;  // inserted
                    minDist = links[i].distance;
                    int index = 0;  // inserted
                    choosen = i;
                    index++;  // inserted
                }
                int max;  // inserted
            }
            int intInput;  // inserted
        }
        String output = "";  // inserted
        if (choosen != -1) {
            int count = 0;  // inserted
            links[choosen].check = true;
            int i = 0;  // inserted
            cost += minDist;
            boolean check;  // inserted
            linkPoints(links[choosen].b);
            boolean debug = false;  // inserted
        }
        boolean debug = false;  // inserted
    }
}
