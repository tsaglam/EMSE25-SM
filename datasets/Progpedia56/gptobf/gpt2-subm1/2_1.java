import java.util.*;

class Freckles {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int N = stdin.nextInt();
        Point[] faceMap = new Point[N];
        for (int i = 0; i < N; i++) {
            faceMap[i] = new Point(stdin.nextDouble(), stdin.nextDouble());
        }
        System.out.format("%.2f\n", calculateMinimumInk(faceMap));
    }

    public static double calculateMinimumInk(Point[] face) {
        int pointCount = face.length;
        PriorityQueue<Link> links = new PriorityQueue<>();
        for (int i = 0; i < pointCount - 1; i++) {
            for (int j = i + 1; j < pointCount; j++)
                links.add(new Link(i, j, Point.distance(face[i], face[j])));
        }

        double totalInk = 0.0;
        UnionFind unionFind = new UnionFind(pointCount);
        while (!links.isEmpty() && unionFind.getGroups() > 1) {
            Link closest = links.poll();
            if (unionFind.find(closest.a) != unionFind.find(closest.b)) {
                unionFind.union(closest.a, closest.b);
                totalInk += closest.distance;
            }
        }

        return totalInk;
    }
}

class UnionFind {
    private int[] parent;
    private int groups;

    public UnionFind(int size) {
        parent = new int[size];
        groups = size;
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            parent[rootX] = rootY;
            groups--;
        }
    }

    public int getGroups() {
        return groups;
    }
}

class Point {
    double x, y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static double distance(Point a, Point b) {
        double dx = a.x - b.x;
        double dy = a.y - b.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}

class Link implements Comparable<Link> {
    int a, b;
    double distance;

    Link(int a, int b, double distance) {
        this.a = a;
        this.b = b;
        this.distance = distance;
    }

    @Override
    public int compareTo(Link other) {
        return Double.compare(this.distance, other.distance);
    }
}