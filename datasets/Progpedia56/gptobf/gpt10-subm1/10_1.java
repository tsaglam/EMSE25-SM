import java.util.*;
class Freckles {
    static int rank = 0;
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int N = stdin.nextInt();
        Point[] FaceMap = new Point[N];
        for (int i = 0; i < N; i++) {
            FaceMap[i] = new Point(stdin.nextDouble(), stdin.nextDouble());
        }
        DrawOnHisFace(FaceMap, N);
    }
    public static void DrawOnHisFace(Point[] face, int N) {
        int groups = N;
        PriorityQueue<Link> links = new PriorityQueue<Link>();
        for (int i = 0; i < N - 1; i++) {
            for (int i2 = i + 1; i2 < N; i2++) {
                links.add(new Link(i, i2, Distance(face[i], face[i2])));
            }
        }
        double total = 0;
        while (groups != 1 && links.size() != 0) {
            Link first = links.poll();
            Point a = face[first.a];
            Point b = face[first.b];
            rank = 0;
            Point parentA = a.FindParent();
            int rankA = rank;
            rank = 0;
            Point parentB = b.FindParent();
            int rankB = rank;
            if (parentA != parentB) {
                if (rankA > rankB)
                    parentA.UniteRoots(parentB);
                else
                    parentB.UniteRoots(parentA);
                groups--;
                total += first.d;
            }
        }
        System.out.format("%.2f\n", total);
    }
    public static double Distance(Point a, Point b) {
        double x = Math.abs(a.x - b.x);
        double y = Math.abs(a.y - b.y);
        return Math.sqrt((x * x) + (y * y));
    }
}
class Point {
    Point prev;
    double x;
    double y;
    Point(double X, double Y) {
        prev = this;
        x = X;
        y = Y;
    }
    public Point FindParent() {
        if (prev != this) {
            Freckles.rank++;
        }
        if (prev == this)
            return this;
        else {
            prev = prev.FindParent();
            return prev.FindParent();
        }
    }
    public void UniteRoots(Point a) {
        a.prev = this;
    }
}
class Link implements Comparable<Link> {
    int a;
    int b;
    double d;
    Link(int A, int B, double D) {
        a = A;
        b = B;
        d = D;
    }
    @Override public int compareTo(Link l) {
        if (d < l.d)
            return -1;
        else if (d > l.d)
            return 1;
        else
            return 0;
    }
    public String toString() {
        return "(" + a + "," + b + "," + d + ")";
    }
}