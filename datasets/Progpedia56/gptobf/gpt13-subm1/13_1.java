import java.util.*;
class Freckles {
    static int rank = 0;

    // Reordered methods within the Freckles class
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        // Statement reordering within the main method
        int N = stdin.nextInt();
        Point[] FaceMap = new Point[N];
        for (int i = 0; i < N; i++) {
            FaceMap[i] = new Point(stdin.nextDouble(), stdin.nextDouble());
        }

        // Unused code insertion: unused variable declarations
        int unusedInt = 42;
        double unusedDouble = 3.14;
        String unusedString = "Hello, World!";
        
        DrawOnHisFace(FaceMap, N);
        
        // Unused code: assignments that doesn't impact the functionality
        unusedInt++;
        unusedDouble /= 2;
        unusedString = null;
    }

    // Unused methods
    public static void unusedMethod1() {
        System.out.println("This is an unused method 1.");
    }

    public static void unusedMethod2() {
        System.out.println("This method is not used 2.");
    }

    public static void unusedMethod3() {
        System.out.println("Another unused method 3.");
    }

    public static void DrawOnHisFace(Point[] face, int N) {
        int groups = N;
        PriorityQueue<Link> links = new PriorityQueue<>();
        for (int i = 0; i < N - 1; i++) {
            for (int i2 = i + 1; i2 < N; i2++) {
                links.add(new Link(i, i2, Distance(face[i], face[i2])));
            }
        }

        // Unused variables within the DrawOnHisFace method
        double unusedTotal = 0.0;
        int unusedCounter = 0;

        double total = 0;
        while (!links.isEmpty() && groups != 1) {
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

        // Additional unused assignments
        unusedTotal = Math.PI;
        unusedCounter++;
    }

    // Shifted Distance method up according to the reorder request
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

    public int compareTo(Point a) {
        if (a.x == x && a.y == y)
            return 0;
        else if (a.x > x)
            return -1;
        else
            return 1;
    }

    public Point FindParent() {
        if (prev == this)
            return this;
        else {
            Freckles.rank++;
            prev = prev.FindParent();
        }
        if (prev != this) {
            Freckles.rank++;
            Point parent = prev.FindParent();
            prev = parent;
            return parent;
        }
        return this;
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

    @Override
    public int compareTo(Link l) {
        if (l.d < d)
            return 1;
        else if (l.d > d)
            return -1;
        else
            return 0;
    }

    public String toString() {
        return "(" + a + "," + b + "," + d + ")";
    }
}