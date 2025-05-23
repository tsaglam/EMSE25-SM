import java.util.Locale;
import java.util.Scanner;
import java.util.LinkedList;

class DotClusters {
    private static double[][] edgeWeights;
    private static boolean[][] checkedNodes;
    private static double[] minDistances;
    private static int[] predecessors;
    private static int size;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        int numberOfPoints = size = scanner.nextInt();
        edgeWeights = new double[numberOfPoints][numberOfPoints];
        checkedNodes = new boolean[numberOfPoints][numberOfPoints];
        minDistances = new double[numberOfPoints];
        predecessors = new int[numberOfPoints];
        double[][] coords = new double[numberOfPoints][2];
        
        for (int point = 0; point < numberOfPoints; point++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            coords[point][0] = x;
            coords[point][1] = y;
        }
        
        for (int startPoint = 0; startPoint < numberOfPoints; startPoint++) {
            for (int endPoint = startPoint; endPoint < numberOfPoints; endPoint++) {
                if (startPoint != endPoint) {
                    edgeWeights[endPoint][startPoint] = edgeWeights[startPoint][endPoint] = computeDistance(coords[startPoint][0], coords[endPoint][0], coords[startPoint][1], coords[endPoint][1]);
                }
            }
        }
        
        implementPrimAlgorithm(edgeWeights, 0);
        
        double totalWeight = 0;
        for (double dist : minDistances) {
            totalWeight += dist;
        }
        System.out.printf(Locale.US, "%.2f\n", totalWeight);
    }

    private static double computeDistance(double x1, double x2, double y1, double y2) {
        return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    }
    
    private static void implementPrimAlgorithm(double[][] graphMatrix, int startNode) {
        int nodes = size;
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            predecessors[i] = -1;
            minDistances[i] = Double.MAX_VALUE;
            queue.add(i);
        }
        minDistances[startNode] = 0;
        
        while (!queue.isEmpty()) {
            int closest = findMinimumDistance(queue);
            for (int adjacent = 0; adjacent < size; adjacent++) {
                if (queue.contains(adjacent) && graphMatrix[closest][adjacent] < minDistances[adjacent]) {
                    predecessors[adjacent] = closest;
                    minDistances[adjacent] = graphMatrix[closest][adjacent];
                }
            }
        }
    }
    
    private static int findMinimumDistance(LinkedList<Integer> queue) {
        double minDist = Double.MAX_VALUE;
        int nearestIndex = -1;
        for (int i : queue) {
            if (minDistances[i] < minDist) {
                nearestIndex = i;
                minDist = minDistances[i];
            }
        }
        queue.removeFirstOccurrence(nearestIndex);
        return nearestIndex;
    }
}