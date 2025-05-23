import java.util.*;
import java.io.*;
import java.lang.Math;

class Point {
    double x, y;
    Point parent;
    int id;

    Point() {}

    Point(double x, double y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.parent = null;
    }
}

class Graph {
    Point[] vertices;
    int size, count;

    Graph(int size) {
        this.size = size;
        this.count = 0;
        this.vertices = new Point[size];
        for (int i = 0; i < size; i++) {
            vertices[i] = new Point();
        }
    }

    void addVertex(Point vertex) {
        vertices[count++] = vertex;
    }
}

class UnionFind {
    List<PointGroup> groups;

    UnionFind() {
        groups = new ArrayList<>();
    }

    int locate(Point p) {
        for (int i = 0; i < groups.size(); i++) {
            for (Point point : groups.get(i).points) {
                if (point.x == p.x && point.y == p.y) return i;
            }
        }
        return -1;
    }

    void union(int idx1, int idx2) {
        groups.get(idx1).points.addAll(groups.get(idx2).points);
        groups.remove(idx2);
    }
}

class PointGroup {
    LinkedList<Point> points;
    int groupId;

    PointGroup(Point start, int groupId) {
        points = new LinkedList<>();
        points.add(start);
        this.groupId = groupId;
    }
}

class Connection implements Comparable<Connection> {
    Point start, end;
    double distance;

    Connection(Point start, Point end) {
        this.start = start;
        this.end = end;
        this.distance = Math.hypot(end.x - start.x, end.y - start.y);
    }

    @Override
    public int compareTo(Connection other) {
        return Double.compare(this.distance, other.distance);
    }
}

class MSTKruskal {
    static List<Connection> selectedEdges, allEdges;
    static UnionFind uf;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Graph graph = new Graph(scanner.nextInt());

        for (int i = 0; i < graph.size; i++) {
            Point vertex = new Point(scanner.nextDouble(), scanner.nextDouble(), i);
            graph.addVertex(vertex);
        }

        selectedEdges = new LinkedList<>();
        allEdges = new LinkedList<>();
        uf = new UnionFind();

        for (int i = 0; i < graph.size; i++) {
            uf.groups.add(new PointGroup(graph.vertices[i], i));
        }

        for (int i = 0; i < graph.size; i++) {
            for (int j = i + 1; j < graph.size; j++) {
                allEdges.add(new Connection(graph.vertices[i], graph.vertices[j]));
            }
        }

        Collections.sort(allEdges);

        for (Connection conn : allEdges) {
            int groupStart = uf.locate(conn.start);
            int groupEnd = uf.locate(conn.end);

            if (groupStart != groupEnd) {
                selectedEdges.add(conn);
                uf.union(groupStart, groupEnd);
            }
        }

        double totalDistance = 0.0;
        for (Connection conn : selectedEdges) {
            totalDistance += conn.distance;
        }

        System.out.printf("%.2f\n", totalDistance);
    }
}