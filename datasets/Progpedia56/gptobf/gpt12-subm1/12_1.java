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
        stdin.close(); // As an added good practice, closing the Scanner object
    }

    // Unused method with a print statement
    public static void unusedMethod() {
        System.out.println("This method is not used.");
    }

    public static void DrawOnHisFace(Point[] face, int N) {
        PriorityQueue<Link> links = new PriorityQueue<Link>();
        for (int i = 0; i < N - 1; i++) {
            for (int i2 = i + 1; i2 < N; i2++) {
                links.add(new Link(i, i2, Distance(face[i], face[i2])));
            }
        }
        int groups = N;
        double total = 0;
        while (links.size() != 0 && groups != 1) {
            Link first = links.poll();
            Point parentA = face[first.a].FindParent();
            int rankA = rank;
            rank = 0;
            Point parentB = face[first.b].FindParent();
            int rankB = rank;
            rank = 0;
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

    // Inserting an unused variable
    static void insertUnusedVariable() {
        int unusedVariable = 0; // the assignment doesn't impact the code's behavior
    }
}

class Point {
    double x, y;
    Point prev;
    Point(double X, double Y) {
        x = X;
        y = Y;
        prev = this;
    }

    public Point FindParent() {
        if (prev == this)
            return this;
        else {
            Freckles.rank++;
            return prev.FindParent();
        }
    }

    public void UniteRoots(Point a) {
        a.prev = this;
    }
}

class Link implements Comparable<Link> {
    int a, b;
    double d;
    Link(int A, int B, double D) {
        a = A;
        b = B;
        d = D;
    }

    @Override
    public int compareTo(Link l) {
        return Double.compare(l.d, d);
    }

    public String toString() {
        return String.format("(%d,%d,%.2f)", a, b, d);
    }
}