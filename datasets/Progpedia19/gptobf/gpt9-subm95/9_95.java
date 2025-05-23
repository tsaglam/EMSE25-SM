import java.io.*;
import java.util.*;

class MatrixRelations {

    private static void clrBoolArr(boolean[] arr) {
        Arrays.fill(arr, false);
    }

    private static void zeroIntArr(int[] arr) {
        Arrays.fill(arr, 0);
    }

    private static void populateRcArray(boolean[][] mat, int[] countArr) {
        for (int i = 0; i < mat.length; i++) {
            for (boolean element : mat[i]) {
                if (element) {
                    countArr[i]++;
                }
            }
        }
    }

    private static void displayCounts(int[] arr) {
        Arrays.stream(arr).forEach(e -> System.out.print("[" + e + "]"));
        System.out.println();
    }

    private static void updateLinks(boolean[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j]) {
                    for (int k = 0; k < arr.length; k++) {
                        arr[i][k] |= arr[j][k];
                        arr[k][j] |= arr[k][i];
                    }
                }
            }
        }
    }

    private static void initializeMatrix(boolean[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = j == i;
            }
        }
    }

    private static void printMatrix(boolean[][] arr) {
        System.out.print("|||");
        for (int i = 1; i <= arr.length; i++) {
            System.out.print("|" + i + "|");
        }
        System.out.println();

        for (int i = 0; i < arr.length; i++) {
            System.out.print("|" + (i + 1) + "|");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("[" + (arr[i][j] ? 1 : 0) + "]");
            }
            System.out.print("\n");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();

        for (int t = 0; t < testCases; t++) {
            int size = in.nextInt();
            boolean[][] net = new boolean[size][size];
            initializeMatrix(net);

            for (int i = 0; i < size; i++) {
                int node = in.nextInt() - 1;
                int edgeCount = in.nextInt();
                for (int j = 0; j < edgeCount; j++) {
                    int connectedNode = in.nextInt() - 1;
                    net[node][connectedNode] = true;
                }
            }

            updateLinks(net);

            int[] relationsCount = new int[size];
            boolean[] checked = new boolean[size];
            zeroIntArr(relationsCount);
            clrBoolArr(checked);
            populateRcArray(net, relationsCount);

            int groupCount = 0, outlierCount = 0;

            for (int i = 0; i < size; i++) {
                if (!checked[i]) {
                    int connections = relationsCount[i], members = 1;
                    for (int j = 0; j < size; j++) {
                        if (i != j && !checked[j] && relationsCount[j] == connections) {
                            boolean identical = true;
                            for (int k = 0; k < size; k++) {
                                if (net[i][k] != net[j][k]) {
                                    identical = false;
                                    break;
                                }
                            }
                            if (identical) {
                                checked[i] = true;
                                checked[j] = true;
                                members++;
                            }
                        }
                    }
                    if (members < 4) outlierCount += members;
                    else groupCount++;
                }
            }

            System.out.println("Case #" + (t + 1) + "\n" + groupCount + " " + outlierCount);
        }
    }
}