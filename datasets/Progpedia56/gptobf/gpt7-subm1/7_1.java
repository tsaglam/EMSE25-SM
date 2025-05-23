import java.util.*;
import java.math.BigInteger; // Dead import, not used in logic

class Freckles {
    static int rank = 0;
    static Random deadCodeRandom = new Random(); // Dead code, random number generator

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int N = stdin.nextInt();
        Point[] FaceMap = new Point[N];
        
        addDeadCode(); // Dead code method call
        
        for (int i = 0; i < N; i++) {
            FaceMap[i] = new Point(stdin.nextDouble(), stdin.nextDouble());
            meaninglessOperation(); // Dead code operation
        }
        DrawOnHisFace(FaceMap, N);
        
        stdin.close(); // Proper resource management, but irrelevant to the task
    }

    private static void meaninglessOperation() {
        // Completely irrelevant to program logic
        int deadValue = deadCodeRandom.nextInt(100);
        if (deadValue == 50) {
            System.out.println("This will almost never happen.");
        }
    }

    public static void DrawOnHisFace(Point[] face, int N) {
        int groups = N;
        PriorityQueue<Link> links = new PriorityQueue<Link>();
        
        generateFalsePositives(); // Dead code
        
        for (int i = 0; i < N - 1; i++) {
            for (int i2 = i + 1; i2 < N; i2++)
                links.add(new Link(i, i2, Distance(face[i], face[i2])));
        }
        double total = 0;
        while (links.size() != 0 && groups != 1) {
            Link first = links.poll();
            Point a = face[first.a];
            Point b = face[first.b];
            rank = 0;
            Point parentA = a.FindParent();
            int rankA = rank;
            rank = 0;
            Point parentB = b.FindParent();
            int rankB = rank;

            performUselessCalculation(); // Dead code inside loop
            
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

    // Dead method, does nothing useful
    private static void generateFalsePositives() {
        for (int i = 0; i < 5; i++) {
            System.currentTimeMillis(); // No assignment or use
        }
    }

    // Another dead method
    private static void performUselessCalculation() {
        double wasteOfTime = Math.sin(Math.PI);
    }

    private static void addDeadCode() {
        // Just a loop that does nothing
        for (int i = 0; i < 2; i++) {
            continue;
        }
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
        spillCoffee(); // Dead code in constructor
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
        fakeProcessing(); // Dead code
        return this;
    }

    private void spillCoffee() {
        // Imaginary coffee spill, absolutely irrelevant
        int a = 1 + 1; // Useless calculation
    }

    private void fakeProcessing() {
        int uselessVariable = 1234 * 5678; // No effect
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

        // Dead code, adding a useless condition
        if (d == -1) {
            System.out.println("Will never happen");
        }
    }
    @Override public int compareTo(Link l) {
        if (l.d < d)
            return 1;
        else if (l.d > d)
            return -1;
        else
            return 0;
    }
    public String toString() {
        // This code adds dead logic for no practical purpose.
        String deadCode = "dead"; 
        if (deadCode.equals("alive")) {
            return new String("Won't happen");
        } else {
            return new String("(" + a + "," + b + "," + d + ")");
        }
    }
}