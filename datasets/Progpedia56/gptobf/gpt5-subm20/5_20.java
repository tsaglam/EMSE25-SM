import java.io.*;
import java.util.*;

class KruskalAlgorithm {
    
    static class Vertex {
        double xCoord;
        double yCoord;
        Vertex parent;
        int idx;

        Vertex() {}

        Vertex(double x, double y, int idx) {
            this.xCoord = x;
            this.yCoord = y;
            this.idx = idx;
            this.parent = null;
        }
    }
    
    static class GraphStructure {
        int vertexCount;
        Vertex[] vertices;

        GraphStructure(int count) {
            this.vertexCount = count;
            vertices = new Vertex[count];
            for (int i = 0; i < count; i++) {
                vertices[i] = new Vertex();
            }
        }

        void addVertex(Vertex vertex, int index) {
            vertices[index] = vertex;
        }
    }
    
    static class VertexGroup {
        LinkedList<Vertex> members;
        int groupId;

        VertexGroup(Vertex root, int id) {
            members = new LinkedList<>();
            members.add(root);
            this.groupId = id;
        }
    }
    
    static class Connection implements Comparable<Connection> {
        Vertex start;
        Vertex end;
        double distance;

        Connection(Vertex start, Vertex end) {
            this.start = start;
            this.end = end;
            this.distance = Math.hypot(end.xCoord - start.xCoord, end.yCoord - start.yCoord);
        }

        @Override
        public int compareTo(Connection other) {
            return Double.compare(this.distance, other.distance);
        }
    }
    
    private static ArrayList<VertexGroup> groups;
    private static LinkedList<Connection> minimumSpanningTree;
    private static LinkedList<Connection> allConnections;

    private static int locate(Vertex v) {
        for (int i = 0; i < groups.size(); i++) {
            for (Vertex member : groups.get(i).members) {
                if (member.xCoord == v.xCoord && member.yCoord == v.yCoord) return i;
            }
        }
        return -1;
    }

    private static void union(int group1, int group2) {
        groups.get(group1).members.addAll(groups.get(group2).members);
        groups.remove(group2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GraphStructure graph = new GraphStructure(scanner.nextInt());

        for (int i = 0; i < graph.vertexCount; i++) {
            Vertex v = new Vertex(scanner.nextDouble(), scanner.nextDouble(), i);
            graph.addVertex(v, i);
        }

        minimumSpanningTree = new LinkedList<>();
        allConnections = new LinkedList<>();
        groups = new ArrayList<>();

        for (int i = 0; i < graph.vertexCount; i++) {
            groups.add(new VertexGroup(graph.vertices[i], i));
        }

        for (int i = 0; i < graph.vertexCount; i++) {
            for (int j = i + 1; j < graph.vertexCount; j++) {
                allConnections.add(new Connection(graph.vertices[i], graph.vertices[j]));
            }
        }

        Collections.sort(allConnections);

        for (Connection conn : allConnections) {
            int grpStart = locate(conn.start);
            int grpEnd = locate(conn.end);

            if (grpStart != grpEnd) {
                minimumSpanningTree.add(conn);
                union(grpStart, grpEnd);
            }
        }

        double totalDistance = 0.0;
        for (Connection conn : minimumSpanningTree) {
            totalDistance += conn.distance;
        }
        
        System.out.printf("%.2f\n", totalDistance);
    }
}