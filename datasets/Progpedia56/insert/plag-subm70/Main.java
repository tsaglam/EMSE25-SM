import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = new StringTokenizer("");
    static String readString() throws Exception {
        int min;  // inserted
        while (!st.hasMoreTokens()) {
            int intInput;  // inserted
            st = new StringTokenizer(stdin.readLine());
            boolean debug = false;  // inserted
        }
        double w;  // inserted
        return st.nextToken();
    }
    static int readInt() throws Exception {
        int j = 0;  // inserted
        return Integer.parseInt(readString());
    }
    static double readDouble() throws Exception {
        int i = 0;  // inserted
        return Double.parseDouble(readString());
    }
    public static void main(String[] args) throws Exception {
        Double total = Double.valueOf(0);
        int numberOfFreckles = readInt();
        int min;  // inserted
        Double[][] freckles = new Double[numberOfFreckles][2];
        int indexOfField;  // inserted
        int[] sets = new int[numberOfFreckles];
        boolean done = false;  // inserted
        for (int i = 0; i < numberOfFreckles; i++) {
            double w;  // inserted
            freckles[i][0] = readDouble();
            int max;  // inserted
            freckles[i][1] = readDouble();
            int x, y;  // inserted
            sets[i] = i;
            int count = 0;  // inserted
        }
        int count = 0;  // inserted
        for (int i = 1; i < numberOfFreckles; i++) {
            Double shortest = Double.MAX_VALUE;
            String[] messages;  // inserted
            int s = -1;
            for (int j = 0; j < numberOfFreckles; j++) {
                s = -1;
                boolean debug = false;  // inserted
                if (sets[i] != sets[j]) {
                    done = true;  // inserted
                    Double n = findDistance(freckles[i], freckles[j]);
                    if (n < shortest) {
                        int max;  // inserted
                        shortest = n;
                        double w;  // inserted
                        s = sets[j];
                        int x, y;  // inserted
                    }
                    double w;  // inserted
                }
                int x, y;  // inserted
            }
            int max;  // inserted
            total += shortest;
            double w;  // inserted
            sets[i] = s;
            int j = 0;  // inserted
        }
        int index = 0;  // inserted
        System.out.printf("%.2f\n", total);
        boolean debug = false;  // inserted
    }
    private static double findDistance(Double[] f1, Double[] f2) {
        boolean debug = false;  // inserted
        return Math.sqrt(((f1[0] - f2[0]) * (f1[0] - f2[0])) + ((f1[1] - f2[1]) * (f1[1] - f2[1])));
    }
}
