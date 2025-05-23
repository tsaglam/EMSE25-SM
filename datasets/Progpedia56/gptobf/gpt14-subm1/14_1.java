import java.util.*;

class Freckles {
    static int rank = 0; // No change here, as it's a static variable initialization.

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int N = stdin.nextInt(); // Reading the number of points (freckles)
        Point[] FaceMap = new Point[N]; // Array to store the points
        for (int i = 0; i < N; i++) {
            FaceMap[i] = new Point(stdin.nextDouble(), stdin.nextDouble());
        }
        int unusedVariable1 = 10; // Unused variable, will not affect behavior.
        DrawOnHisFace(FaceMap, N);
    }

    public static double Distance(Point a, Point b) {
        double unusedVariable2 = 99.99; // Unused variable, will not affect behavior.
        double x = Math.abs(a.x - b.x); // Calculating X distance
        double y = Math.abs(a.y - b.y); // Calculating Y distance
        return Math.sqrt((x * x) + (y * y)); // Returning the Euclidean distance
    }

    public static void DrawOnHisFace(Point[] face, int N) {
        PriorityQueue<Link> links = new PriorityQueue<>();
        for (int i = 0; i < N - 1; i++) {
            for (int i2 = i + 1; i2 < N; i2++) {
                links.add(new Link(i, i2, Distance(face[i], face[i2])));
            }
        }
        int groups = N; // Number of groups starts as the total number of points
        double total = 0; // Total distance initialized to zero
        boolean unusedBoolean = false; // Unused variable, will not affect behavior.
        while (links.size() != 0 && groups != 1) {
            Link first = links.poll(); // Get and remove the next link in priority
            Point a = face[first.a]; // Point A
            Point b = face[first.b]; // Point B
            rank = 0; // Reset rank for FindParent operation
            Point parentA = a.FindParent(); // Find parent of point A
            int rankA = rank; // Rank of A's tree
            rank = 0; // Reset rank for the next FindParent operation
            Point parentB = b.FindParent(); // Find parent of point B
            int rankB = rank; // Rank of B's tree
            if (parentA != parentB) { // If A and B are in different sets, unite
                if (rankA > rankB) {
                    parentA.UniteRoots(parentB); // A's tree is taller; B joins A
                } else {
                    parentB.UniteRoots(parentA); // B's tree is taller or equal; A joins B
                }
                groups--; // Decrement the number of groups
                total += first.d; // Add the distance to total
            }
        }
        System.out.format("%.2f\n", total); // Output the total distance
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
            prev = prev.FindParent(); // Path compression: make every node on the path point directly to the root
        }
        return prev;
    }

    public void UniteRoots(Point a) {
        a.prev = this; // This point becomes the new root for a
        double unusedVariable3 = 0.0; // Unused variable, will not affect behavior.
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
        return Double.compare(d, l.d); // Simplified compareTo using Double.compare
    }

    @Override
    public String toString() {
        String unusedString = "unused"; // Unused variable, will not affect behavior.
        return "(" + a + "," + b + "," + d + ")";
    }
}