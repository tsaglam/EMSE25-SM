import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

class Vertex {
    double x, y;
    Vertex parent;
    int id;

    Vertex() {
    }

    Vertex(double x, double y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.parent = null;
    }
}

class Network {
    Vertex[] vertices;
    int vertexCount = 0;

    Network(int size) {
        vertices = new Vertex[size];
        for (int i = 0; i < size; i++) {
            vertices[i] = new Vertex();
        }
    }

    void addVertex(Vertex vertex) {
        if (vertexCount < vertices.length) {
            vertices[vertexCount++] = vertex;
        }
    }
}

class Group {
    LinkedList<Vertex> members;
    int identifier;

    Group(Vertex vertex, int id) {
        this.members = new LinkedList<>();
        this.members.add(vertex);
        this.identifier = id;
    }
}

class Connection implements Comparable<Connection> {
    Vertex start, end;
    double distance;

    Connection(Vertex start, Vertex end) {
        this.start = start;
        this.end = end;
        this.distance = Math.hypot(end.x - start.x, end.y - start.y);
    }

    @Override
    public int compareTo(Connection other) {
        return Double.compare(this.distance, other.distance);
    }
}

class MinimalSpanningTree {
    static LinkedList<Group> groups;
    static LinkedList<Connection> mstEdges, allEdges;

    static int locate(Vertex vertex) {
        for (int i = 0; i < groups.size(); i++) {
            for (Vertex v : groups.get(i).members) {
                if (v.x == vertex.x && v.y == vertex.y) return i;
            }
        }
        return -1;
    }

    static void union(int idx1, int idx2) {
        groups.get(idx1).members.addAll(groups.get(idx2).members);
        groups.remove(idx2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Network network = new Network(scanner.nextInt());
        for (int i = 0; i < network.vertices.length; i++) {
            Vertex v = new Vertex(scanner.nextDouble(), scanner.nextDouble(), i);
            network.addVertex(v);
        }

        mstEdges = new LinkedList<>();
        allEdges = new LinkedList<>();
        groups = new LinkedList<>();

        for (Vertex v : network.vertices) {
            groups.add(new Group(v, v.id));
        }

        for (int i = 0; i < network.vertices.length; i++) {
            for (int j = i + 1; j < network.vertices.length; j++) {
                allEdges.add(new Connection(network.vertices[i], network.vertices[j]));
            }
        }

        Collections.sort(allEdges);

        for (Connection c : allEdges) {
            int groupStart = locate(c.start);
            int groupEnd = locate(c.end);
            if (groupStart != groupEnd) {
                mstEdges.add(c);
                union(groupStart, groupEnd);
            }
        }

        double totalDistance = 0;
        for (Connection conn : mstEdges) {
            totalDistance += conn.distance;
        }
        System.out.printf("%.2f\n", totalDistance);
    }
}