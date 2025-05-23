import java.util.*;

class Freckles {
    static int rank = 0;

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int N = stdin.nextInt();
        Point[] faceMap = new Point[N];
        for (int i = 0; i < N; i++) {
            faceMap[i] = new Point(stdin.nextDouble(), stdin.nextDouble());
        }
        drawOnHisFace(faceMap);
    }

    public static void drawOnHisFace(Point[] face) {
        int groups = face.length;
        PriorityQueue<Link> links = new PriorityQueue<>();
        for (int i = 0; i < face.length - 1; i++) {
            for (int j = i + 1; j < face.length; j++)
                links.add(new Link(i, j, distance(face[i], face[j])));
        }
        double total = 0;
        while (!links.isEmpty() && groups > 1) {
            Link first = links.poll();
            Point parentA = face[first.a].findParent();
            Point parentB = face[first.b].findParent();
            if (parentA != parentB) {
                if (Freckles.rank > 0) // Technically checking logic previously influenced by FindParent() indirectly
                    parentA.uniteRoots(parentB);
                else
                    parentB.uniteRoots(parentA);
                groups--;
                total += first.d;
            }
        }
        System.out.format("%.2f%n", total);
    }

    public static double distance(Point a, Point b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }
}

class Point {
    Point prev;
    double x;
    double y;

    public Point(double x, double y) {
        this.prev = this;
        this.x = x;
        this.y = y;
    }

    public Point findParent() {
        Freckles.rank = 0; // Reset rank for this operation
        if (this.prev != this) {
            Freckles.rank++;
            this.prev = prev.findParent();
        }
        return this.prev;
    }

    public void uniteRoots(Point other) {
        other.prev = this;
    }
}

class Link implements Comparable<Link> {
    int a;
    int b;
    double d;

    public Link(int a, int b, double d) {
        this.a = a;
        this.b = b;
        this.d = d;
    }

    @Override
    public int compareTo(Link other) {
        return Double.compare(this.d, other.d);
    }

    @Override
    public String toString() {
        return "(" + a + "," + b + "," + d + ")";
    }
}