import java.io.*;
import java.util.Scanner;

class Main {

    public static void resetCheckedMatrix(boolean[] checkedMatrix) {
        java.util.Arrays.fill(checkedMatrix, false);
    }

    public static void resetRelationCountMatrix(int[] rcMatrix) {
        java.util.Arrays.fill(rcMatrix, 0);
    }

    public static void fillRelationCountMatrix(boolean[][] matrix, int[] rcMatrix) {
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                if (matrix[i][j]) rcMatrix[i]++;
    }

    public static void showRelationCountMatrix(int[] rcMatrix) {
        for (int num : rcMatrix)
            System.out.print("[" + num + "]");
        System.out.println();
    }

    public static void linkMatrix(boolean[][] matrix) {
        int matrixDim = matrix.length;
        for (int i = 0; i < matrixDim; i++) {
            for (int j = 0; j < matrixDim; j++) {
                if (matrix[i][j]) {
                    for (int k = 0; k < matrixDim; k++) {
                        if (matrix[j][k]) matrix[i][k] = true;
                        if (matrix[k][i]) matrix[k][j] = true;
                    }
                }
            }
        }
    }

    public static void resetMatrix(boolean[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            java.util.Arrays.fill(matrix[i], false);
            matrix[i][i] = true; // Simplifies the resetting and diagonal true setting
        }
    }

    public static void showMatrix(boolean[][] matrix) {
        System.out.print("|||");
        for (int i = 1; i <= matrix.length; i++)
            System.out.print("|" + i + "|");
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("|" + (i + 1) + "|");
            for (boolean cell : matrix[i]) {
                System.out.print("[" + (cell ? 1 : 0) + "]");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nSituations = scanner.nextInt();
        for (int s = 1; s <= nSituations; s++) {
            int matrixDim = scanner.nextInt();
            boolean[][] matrix = new boolean[matrixDim][matrixDim];
            resetMatrix(matrix);
            for (int i = 0; i < matrixDim; i++) {
                int index = scanner.nextInt();
                int relations = scanner.nextInt();
                while (relations-- > 0) {
                    int c = scanner.nextInt();
                    matrix[index - 1][c - 1] = true;
                }
            }
            linkMatrix(matrix);
            int[] rcMatrix = new int[matrixDim];
            boolean[] checkedMatrix = new boolean[matrixDim];
            resetRelationCountMatrix(rcMatrix);
            resetCheckedMatrix(checkedMatrix);
            fillRelationCountMatrix(matrix, rcMatrix);
            int nGroups = 0, nOut = 0;
            for (int i = 0; i < matrixDim; i++) {
                if (!checkedMatrix[i]) {
                    boolean uniqueGroup = true;
                    for (int j = 0; j < matrixDim; j++) {
                        if (!checkedMatrix[j] && i != j && areEqual(matrix[i], matrix[j])) {
                            checkedMatrix[i] = checkedMatrix[j] = true;
                            uniqueGroup = false;
                            break;
                        }
                    }
                    if (uniqueGroup) nOut++;
                    else nGroups++;
                }
            }
            System.out.println("Caso #" + s + "\n" + nGroups + " " + nOut);
        }
    }

    private static boolean areEqual(boolean[] a, boolean[] b) {
        for (int i = 0; i < a.length; i++)
            if (a[i] != b[i]) return false;
        return true;
    }
}