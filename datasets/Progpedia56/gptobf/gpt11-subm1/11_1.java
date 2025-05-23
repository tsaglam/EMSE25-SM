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
        PriorityQueue<Link> links = createLinks(face, N);
        double total = connectGroups(face, links, N);
        System.out.format("%.2f\n", total);
    }
    
    private static PriorityQueue<Link> createLinks(Point[] face, int N) {
        PriorityQueue<Link> links = new PriorityQueue<Link>();
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                links.add(new Link(i, j, Distance(face[i], face[j])));
            }
        }
        return links;
    }
    
    private static double connectGroups(Point[] face, PriorityQueue<Link> links, int groups) {
        double total = 0;
        while (!links.isEmpty() && groups > 1) {
            Link first = links.poll();
            if (linkPoints(face[first.a], face[first.b])) groups--;
            total += first.d;
        }
        return total;
    }
    
    private static boolean linkPoints(Point a, Point b) {
        rank = 0;
        Point parentA = a.FindParent();
        int rankA = rank;
        rank = 0;
        Point parentB = b.FindParent();
        int rankB = rank;
        if (parentA != parentB) {
            if (rankA > rankB) parentB.UniteRoots(parentA);
            else parentA.UniteRoots(parentB);
            return true;
        }
        return false;
    }

    public static double Distance(Point a, Point b) {
        double xDiff = a.x - b.x;
        double yDiff = a.y - b.y;
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }
}

class Point {
    Point prev;
    double x, y;

    Point(double X, double Y) {
        this.prev = this;
        this.x = X;
        this.y = Y;
    }

    public Point FindParent() {
        if (this.prev != this) {
            Freckles.rank++;
            this.prev = this.prev.FindParent();
        }
        return this.prev;
    }

    public void UniteRoots(Point a) {
        a.prev = this;
    }
}

class Link implements Comparable<Link> {
    int a, b;
    double d;

    Link(int A, int B, double D) {
        this.a = A;
        this.b = B;
        this.d = D;
    }

    @Override
    public int compareTo(Link other) {
        return Double.compare(this.d, other.d);
    }
}