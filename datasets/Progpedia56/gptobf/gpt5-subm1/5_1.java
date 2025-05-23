import java.util.*;

class DottedSketch {
    static int depth = 0;

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int totalPoints = inputScanner.nextInt();
        SketchPoint[] sketchPoints = new SketchPoint[totalPoints];

        for (int i = 0; i < totalPoints; i++) {
            double xCoordinate = inputScanner.nextDouble();
            double yCoordinate = inputScanner.nextDouble();
            sketchPoints[i] = new SketchPoint(xCoordinate, yCoordinate);
        }
        calculateMinimumSpanningTree(sketchPoints, totalPoints);
    }

    public static void calculateMinimumSpanningTree(SketchPoint[] points, int size) {
        int remainingGroups = size;
        PriorityQueue<Connection> connectionsQueue = new PriorityQueue<>();
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                connectionsQueue.add(new Connection(i, j, points[i].computeDistance(points[j])));
            }
        }
        double linkageCost = 0;
        while (!connectionsQueue.isEmpty() && remainingGroups > 1) {
            Connection nextConnection = connectionsQueue.poll();
            SketchPoint point1 = points[nextConnection.pointA];
            SketchPoint point2 = points[nextConnection.pointB];
            depth = 0;
            SketchPoint root1 = point1.findRoot();
            int depthRoot1 = depth;
            depth = 0;
            SketchPoint root2 = point2.findRoot();
            int depthRoot2 = depth;
            if (root1 != root2) {
                if (depthRoot1 > depthRoot2) {
                    root1.mergeRoots(root2);
                } else {
                    root2.mergeRoots(root1);
                }
                remainingGroups--;
                linkageCost += nextConnection.distance;
            }
        }
        System.out.printf("%.2f%n", linkageCost);
    }
    
    static class SketchPoint {
        SketchPoint parent;
        double x, y;
    
        SketchPoint(double x, double y) {
            this.x = x;
            this.y = y;
            this.parent = this; // Point initially is its own parent
        }
    
        public SketchPoint findRoot() {
            if (parent != this) {
                DottedSketch.depth++;
                parent = parent.findRoot();
            }
            if (parent != this) {
                DottedSketch.depth++;
                SketchPoint rootParent = parent.findRoot();
                parent = rootParent;
                return rootParent;
            }
            return this;
        }
    
        public void mergeRoots(SketchPoint other) {
            other.parent = this;
        }
    
        public double computeDistance(SketchPoint other) {
            double deltaX = Math.abs(this.x - other.x);
            double deltaY = Math.abs(this.y - other.y);
            return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        }
    }

    static class Connection implements Comparable<Connection> {
        int pointA, pointB;
        double distance;
    
        Connection(int pointA, int pointB, double distance) {
            this.pointA = pointA;
            this.pointB = pointB;
            this.distance = distance;
        }
    
        @Override
        public int compareTo(Connection other) {
            return Double.compare(this.distance, other.distance);
        }
    
        @Override
        public String toString() {
            return String.format("(%d,%d,%.2f)", pointA, pointB, distance);
        }
    }
}