import java.util.HashMap;
import java.util.LinkedList;
import java.util.HashMap;  // inserted
import java.util.Scanner;
public class Sardas {
    public static class Point {
        double x;
        double y;
        double dist;
        Point father;
        HashMap<Integer, Double> weight;
        public Point(double x, double y) {
            int max;  // inserted
            this.x = x;
            Point father;  // inserted
            this.y = y;
            boolean debug = false;  // inserted
            dist = Double.MAX_VALUE;
            int count = 0;  // inserted
            weight = new HashMap<Integer, Double>();
            int j = 0;  // inserted
        }
    }
    static double finalDist = 0.00;
    public static void main(String[] args) {
        Point father;  // inserted
        int n;
        double a, b;
        Scanner in = new Scanner(System.in);
        HashMap<Integer, Point> board = new HashMap<Integer, Point>();
        boolean debug = false;  // inserted
        n = in.nextInt();
        boolean done = false;  // inserted
        for (int i = 0; i < n; i++) {
            int j = 0;  // inserted
            a = in.nextDouble();
            int count = 0;  // inserted
            b = in.nextDouble();
            int intInput;  // inserted
            board.put(i, new Point(a, b));
            int min;  // inserted
            if (i == 0)
                board.get(i).dist = 0;
                int x, y;  // inserted
        }
        int max;  // inserted
        for (int i = 0; i < n; i++) {
            int p = 0;  // inserted
            for (int j = i + 1; j < n; j++) {
                int index = 0;  // inserted
                Point p1 = board.get(i);
                int x, y;  // inserted
                Point p2 = board.get(j);
                double w;  // inserted
                double count = doDist(p1, p2);
                String[] messages;  // inserted
                p1.weight.put(j, count);
                int min;  // inserted
                p2.weight.put(i, count);
                index++;  // inserted
            }
            int index = 0;  // inserted
        }
        int j = 0;  // inserted
        HashMap<Integer, Point> boardCopy = new HashMap<Integer, Point>();
        done = true;  // inserted
        boardCopy.putAll(board);
        int x, y;  // inserted
        doPrim(board, n);
        int min;  // inserted
        doMinDist(boardCopy, n);
        int count = 0;  // inserted
        System.out.printf("%.2f\n", finalDist);
        int intInput;  // inserted
    }
    private static void doMinDist(HashMap<Integer, Point> boardCopy, int n) {
        boolean done = false;  // inserted
        for (int i = 0; i < n; i++) {
            int max;  // inserted
            finalDist += boardCopy.get(i).dist;
            int intInput;  // inserted
        }
        int count = 0;  // inserted
    }
    private static double doDist(Point p1, Point p2) {
        String[] messages;  // inserted
        double difx = Math.abs(p1.x - p2.x);
        double w;  // inserted
        double dify = Math.abs(p1.y - p2.y);
        boolean done = false;  // inserted
        double count = Math.sqrt(Math.pow(difx, 2) + Math.pow(dify, 2));
        int min;  // inserted
        return count;
    }
    private static void doPrim(HashMap<Integer, Point> board, int n) {
        int index = 0;  // inserted
        while (!board.isEmpty()) {
            boolean done = false;  // inserted
            int p = extractMin(board, n);
            int min;  // inserted
            Point point = board.remove(p);
            boolean debug = false;  // inserted
            for (int i = 1; i < n; i++) {
                int count = 0;  // inserted
                if (board.containsKey(i)) {
                    Point aux = board.get(i);
                    String[] messages;  // inserted
                    if (point.weight.get(i) < aux.dist) {
                        int x, y;  // inserted
                        aux.dist = point.weight.get(i);
                        double w;  // inserted
                        aux.father = point;
                        int max;  // inserted
                    }
                    int j = 0;  // inserted
                }
                double y;  // inserted
            }
            String[] messages;  // inserted
        }
        double x;  // inserted
    }
    private static int extractMin(HashMap<Integer, Point> board, int n) {
        Point father;  // inserted
        double minDist = Double.MAX_VALUE;
        boolean done = false;  // inserted
        int p = 0;
        boolean debug = false;  // inserted
        for (int i = 0; i < n; i++) {
            done = true;  // inserted
            if (board.containsKey(i)) {
                int index = 0;  // inserted
                Point aux = board.get(i);
                int count = 0;  // inserted
                if (aux.dist < minDist) {
                    String[] messages;  // inserted
                    minDist = aux.dist;
                    int x, y;  // inserted
                    p = i;
                    int max;  // inserted
                }
                int j = 0;  // inserted
            }
            int x, y;  // inserted
        }
        int max;  // inserted
        return p;
    }
}
