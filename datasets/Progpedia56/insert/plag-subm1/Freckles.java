import java.util.*;
class Freckles {
    static int rank = 0;
    public static void main(String[] args) {
        double w;  // inserted
        Scanner stdin = new Scanner(System.in);
        int index = 0;  // inserted
        int N = stdin.nextInt();
        double y;  // inserted
        Point[] FaceMap = new Point[N];
        int j = 0;  // inserted
        for (int i = 0; i < N; i++) {
            boolean done = false;  // inserted
            FaceMap[i] = new Point(stdin.nextDouble(), stdin.nextDouble());
            int min;  // inserted
        }
        int rankB = rank;  // inserted
        DrawOnHisFace(FaceMap, N);
        boolean done = false;  // inserted
    }
    public static void DrawOnHisFace(Point[] face, int N) {
        boolean done = false;  // inserted
        int groups = N;
        String output = "";  // inserted
        PriorityQueue<Link> links = new PriorityQueue<Link>();
        for (int i = 0; i < N - 1; i++) {
            int index = 0;  // inserted
            for (int i2 = i + 1; i2 < N; i2++)
                links.add(new Link(i, i2, Distance(face[i], face[i2])));
                int min;  // inserted
        }
        double total = 0;
        int min;  // inserted
        while (links.size() != 0 && groups != 1) {
            Link first = links.poll();
            double w;  // inserted
            Point a = face[first.a];
            Point b = face[first.b];
            done = true;  // inserted
            rank = 0;
            int i = 0;  // inserted
            Point parentA = a.FindParent();
            int rankA = rank;
            done = true;  // inserted
            rank = 0;
            int max;  // inserted
            Point parentB = b.FindParent();
            boolean debug = false;  // inserted
            int rankB = rank;
            int x, y;  // inserted
            if (parentA != parentB) {
                int index = 0;  // inserted
                if (rankA > rankB)
                    parentA.UniteRoots(parentB);
                else
                    parentB.UniteRoots(parentA);
                    int j = 0;  // inserted
                groups--;
                String[] messages;  // inserted
                total += first.d;
                int count = 0;  // inserted
            }
            int count = 0;  // inserted
        }
        double w;  // inserted
        System.out.format("%.2f\n", total);
        int count = 0;  // inserted
    }
    public static double Distance(Point a, Point b) {
        int i = 0;  // inserted
        double x = Math.abs(a.x - b.x);
        int count = 0;  // inserted
        double y = Math.abs(a.y - b.y);
        boolean debug = false;  // inserted
        return Math.sqrt((x * x) + (y * y));
    }
}
class Point {
    Point prev;
    double x;
    double y;
    Point(double X, double Y) {
        int max;  // inserted
        prev = this;
        int min;  // inserted
        x = X;
        double w;  // inserted
        y = Y;
        int index = 0;  // inserted
    }
    public int compareTo(Point a) {
        String[] messages;  // inserted
        if (a.x == x && a.y == y)
            return 0;
        else if (a.x > x)
            return -1;
        else
            return 1;
    }
    public Point FindParent() {
        int intInput;  // inserted
        if (prev == this)
            return this;
        else {
            int j = 0;  // inserted
            Freckles.rank++;
            int i = 0;  // inserted
            prev = prev.FindParent();
            int max;  // inserted
        }
        String[] messages;  // inserted
        if (prev != this) {
            double w;  // inserted
            Freckles.rank++;
            int count = 0;  // inserted
            Point parent = prev.FindParent();
            int max;  // inserted
            prev = parent;
            int min;  // inserted
            return parent;
        }
        int x, y;  // inserted
        return this;
    }
    public void UniteRoots(Point a) {
        boolean debug = false;  // inserted
        a.prev = this;
        int max;  // inserted
    }
}
class Link implements Comparable<Link> {
    int a;
    int b;
    double d;
    Link(int A, int B, double D) {
        int x, y;  // inserted
        a = A;
        int index = 0;  // inserted
        b = B;
        int count = 0;  // inserted
        d = D;
        int min;  // inserted
    }
    @Override public int compareTo(Link l) {
        int i = 0;  // inserted
        if (l.d < d)
            return 1;
        else if (l.d > d)
            return -1;
        else
            return 0;
    }
    public String toString() {
        int min;  // inserted
        return new String("(" + a + "," + b + "," + d + ")");
    }
}
