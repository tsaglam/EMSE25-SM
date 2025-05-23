import java.util.*;
import java.io.*;
import java.lang.Math;

class Vertex {
    double coordX, coordY;
    Vertex parent;
    int identifier;
    Vertex() {}
    Vertex(double x, double y, int id) {
        this.coordX = x;
        this.coordY = y;
        this.identifier = id;
    }
}

class Mesh {
    Vertex[] vertexArray;
    int vertexCount, addTracker;
    Mesh(int count) {
        vertexCount = count;
        vertexArray = new Vertex[count];
        for (int i = 0; i < count; i++) {
            vertexArray[i] = new Vertex();
        }
    }
    void insertVertex(Vertex v) {
        if (addTracker < vertexCount) {
            vertexArray[addTracker++] = v;
        }
    }
}

class Cluster {
    LinkedList<Vertex> vertexList;
    int clusterId;
    Cluster(Vertex v, int id) {
        vertexList = new LinkedList<>();
        vertexList.add(v);
        clusterId = id;
    }
}

class Link implements Comparable<Link> {
    Vertex source, destination;
    double length;
    Link(Vertex source, Vertex dest) {
        this.source = source;
        this.destination = dest;
        length = Math.hypot(dest.coordX - source.coordX, dest.coordY - source.coordY);
    }
    @Override
    public int compareTo(Link l) {
        return Double.compare(this.length, l.length);
    }
}

class KruskalMST {
    static LinkedList<Cluster> clusterGroups = new LinkedList<>();
    static LinkedList<Link> minimumSpanningTree = new LinkedList<>(), allLinks = new LinkedList<>();

    static int locateCluster(Vertex v) {
        for (int i = 0; i < clusterGroups.size(); i++) {
            for (Vertex vertex : clusterGroups.get(i).vertexList) {
                if (vertex.coordX == v.coordX && vertex.coordY == v.coordY) return i;
            }
        }
        return -1;
    }

    static void combineClusters(int i, int j) {
        clusterGroups.get(i).vertexList.addAll(clusterGroups.get(j).vertexList);
        clusterGroups.remove(j);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Mesh mesh = new Mesh(sc.nextInt());
        for (int i = 0; i < mesh.vertexCount; i++) {
            Vertex vertex = new Vertex(sc.nextDouble(), sc.nextDouble(), i);
            mesh.insertVertex(vertex);
        }

        for (Vertex vertex : mesh.vertexArray) {
            clusterGroups.add(new Cluster(vertex, clusterGroups.size()));
        }

        for (int i = 0; i < mesh.vertexCount; i++) {
            for (int j = i + 1; j < mesh.vertexCount; j++) {
                allLinks.add(new Link(mesh.vertexArray[i], mesh.vertexArray[j]));
            }
        }

        Collections.sort(allLinks);
        for (Link link : allLinks) {
            int clusterI = locateCluster(link.source);
            int clusterJ = locateCluster(link.destination);
            if (clusterI != clusterJ) {
                minimumSpanningTree.add(link);
                combineClusters(clusterI, clusterJ);
            }
        }

        double totalDistance = 0.0;
        for (Link link : minimumSpanningTree) {
            totalDistance += link.length;
        }
        System.out.printf("%.2f\n", totalDistance);
    }
}