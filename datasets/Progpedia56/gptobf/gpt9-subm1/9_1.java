import java.util.*; 

class SpeckleArtistry {
    static int hierarchyLevel = 0; 

    public static void main(String[] args) {
        Scanner scannerObj = new Scanner(System.in); 
        int pointCount = scannerObj.nextInt(); 
        ArtPoint[] canvasMap = new ArtPoint[pointCount]; 
        for (int index = 0; index < pointCount; index++) {
            canvasMap[index] = new ArtPoint(scannerObj.nextDouble(), scannerObj.nextDouble());
        }
        sketchArtwork(canvasMap, pointCount); 
    }

    public static void sketchArtwork(ArtPoint[] artwork, int totalPoints) {
        int clusterCount = totalPoints; 
        PriorityQueue<Connection> connectionsQueue = new PriorityQueue<Connection>();
        for (int first = 0; first < totalPoints - 1; first++) {
            for (int second = first + 1; second < totalPoints; second++)
                connectionsQueue.add(new Connection(first, second, calcDistance(artwork[first], artwork[second])));
        }
        double sumDistance = 0; 
        while (connectionsQueue.size() > 0 && clusterCount > 1) {
            Connection closest = connectionsQueue.poll(); 
            ArtPoint pointA = artwork[closest.pointA];
            ArtPoint pointB = artwork[closest.pointB];
            hierarchyLevel = 0;
            ArtPoint rootA = pointA.locateRoot(); 
            int rootLevelA = hierarchyLevel; 
            hierarchyLevel = 0;
            ArtPoint rootB = pointB.locateRoot(); 
            int rootLevelB = hierarchyLevel;
            if (rootA != rootB) {
                if (rootLevelA > rootLevelB) rootA.mergeRoots(rootB);
                else rootB.mergeRoots(rootA);
                clusterCount--; 
                sumDistance += closest.distance;
            }
        }
        System.out.printf("%.2f%n", sumDistance); 
    }

    public static double calcDistance(ArtPoint pointOne, ArtPoint pointTwo) {
        double deltaX = Math.abs(pointOne.xCoordinate - pointTwo.xCoordinate);
        double deltaY = Math.abs(pointOne.yCoordinate - pointTwo.yCoordinate);
        return Math.sqrt((deltaX * deltaX) + (deltaY * deltaY));
    }
}

class ArtPoint {
    ArtPoint ancestor; 
    double xCoordinate; 
    double yCoordinate; 

    ArtPoint(double x, double y) {
        ancestor = this; 
        xCoordinate = x; 
        yCoordinate = y; 
    }

    public ArtPoint locateRoot() {
        if (ancestor == this) return this;
        else {
            SpeckleArtistry.hierarchyLevel++;
            ancestor = ancestor.locateRoot();
        }
        if (ancestor != this) {
            SpeckleArtistry.hierarchyLevel++;
            ArtPoint root = ancestor.locateRoot();
            ancestor = root;
            return root;
        }
        return this;
    }

    public void mergeRoots(ArtPoint other) {
        other.ancestor = this;
    }
}

class Connection implements Comparable<Connection> {
    int pointA;
    int pointB;
    double distance;

    Connection(int start, int end, double dist) {
        pointA = start;
        pointB = end;
        distance = dist;
    }

    @Override
    public int compareTo(Connection conn) {
        return Double.compare(distance, conn.distance);
    }

    @Override
    public String toString() {
        return String.format("(%d,%d,%.2f)", pointA, pointB, distance);
    }
}