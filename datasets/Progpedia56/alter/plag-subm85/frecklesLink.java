import java.util.*;
import java.lang.*;
class Point {
    double x;
    double y;
    boolean check;
    Point(double x, double y) {
        this.x = x;
        this.y = y;
        check = false;
    }
}
class Link {
    Point a;
    Point b;
    boolean check;
    double distance;
    Link(Point a, Point b) {
        this.a = a;
        this.b = b;
        this.distance = Math.sqrt((b.x - a.x) * (b.x - a.x) + (b.y - a.y) * (b.y - a.y));
        this.check = false;
    }
}
public class frecklesLink {
    static Point[] points;
    static int nPoints;
    static Link[] links;
    static int linkCont;
    static double cost;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        nPoints = input.nextInt();
        points = new Point[nPoints];
        for (int i = 0; i < nPoints; i++) {
            double x = input.nextDouble();
            double y = input.nextDouble();
            points[i] = new Point(x, y);
        }
        int size = nPoints * (nPoints - 1);
        linkCont = 0;
        cost = 0;
        links = new Link[size];
        linkPoints(points[0]);
        System.out.println(String.format("%.2f", cost));
    }
    static void addLinks(Point a) {
        a.check = true;
        for (int i = 0; i < nPoints; i++) {
            if (points[i].check == false) {
                links[linkCont] = new Link(a, points[i]);
                linkCont++;
            }
        }
    }
    static void linkPoints(Point a) {
        addLinks(a);
        double minDist = 1000000;
        int choosen = -1;
        for (int i = 0; i < linkCont; i++) {
            if (links[i].check == false && links[i].b.check == false) {
                if (links[i].distance < minDist) {
                    minDist = links[i].distance;
                    choosen = i;
                }
            }
        }
        if (choosen != -1) {
            links[choosen].check = true;
            cost += minDist;
            linkPoints(links[choosen].b);
        }
    }
}
