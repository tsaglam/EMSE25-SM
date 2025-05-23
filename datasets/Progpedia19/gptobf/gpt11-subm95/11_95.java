import java.util.Scanner;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nSituations = scanner.nextInt();
        for (int s = 1; s <= nSituations; s++) {
            int matrixDim = scanner.nextInt();
            boolean[][] matrix = new boolean[matrixDim][matrixDim];
            int[] rcMatrix = new int[matrixDim];
            boolean[] checkedMatrix = new boolean[matrixDim];

            initializeMatrices(matrix, rcMatrix, checkedMatrix, matrixDim, scanner);
            processMatrices(matrix, rcMatrix, checkedMatrix, matrixDim, s);
        }
    }

    private static void initializeMatrices(boolean[][] matrix, int[] rcMatrix, boolean[] checkedMatrix, int matrixDim, Scanner scanner) {
        resetMatrix(matrix, matrixDim);
        fillMatrix(matrix, matrixDim, scanner);
        resetRelationCountMatrix(rcMatrix, matrixDim);
        resetCheckedMatrix(checkedMatrix, matrixDim);
        linkMatrix(matrix, matrixDim);
    }

    private static void fillMatrix(boolean[][] matrix, int matrixDim, Scanner scanner) {
        for (int i = 0; i < matrixDim; i++) {
            int index = scanner.nextInt();
            for (int j = scanner.nextInt(); j > 0; j--) {
                matrix[index - 1][scanner.nextInt() - 1] = true;
            }
        }
    }

    private static void processMatrices(boolean[][] matrix, int[] rcMatrix, boolean[] checkedMatrix, int matrixDim, int s) {
        fillRelationCountMatrix(matrix, rcMatrix, matrixDim);
        analyzeMatrices(matrix, rcMatrix, checkedMatrix, matrixDim, s);
    }

    private static void analyzeMatrices(boolean[][] matrix, int[] rcMatrix, boolean[] checkedMatrix, int matrixDim, int s) {
        int nGroups = 0, nOut = 0;
        for (int c = 0; c < matrixDim; c++) {
            if (!checkedMatrix[c]) {
                int nElements = calculateGroup(matrix, rcMatrix, checkedMatrix, matrixDim, c);
                if (nElements < 4) nOut += nElements;
                else nGroups++;
            }
        }
        System.out.println("Caso #" + s + "\n" + nGroups + " " + nOut);
    }

    private static int calculateGroup(boolean[][] matrix, int[] rcMatrix, boolean[] checkedMatrix, int matrixDim, int c) {
        int nElements = 1;
        checkedMatrix[c] = true;
        for (int c1 = 0; c1 < matrixDim; c1++) {
            if (!checkedMatrix[c1]) {
                boolean equal = areEquals(matrix, matrixDim, c, c1, rcMatrix[c], rcMatrix[c1]);
                if (equal) {
                    checkedMatrix[c1] = true;
                    nElements++;
                }
            }
        }
        return nElements;
    }

    private static boolean areEquals(boolean[][] matrix, int matrixDim, int c, int c1, int nRelationsC, int nRelationsC1) {
        if (nRelationsC == nRelationsC1) {
            for (int l = 0; l < matrixDim; l++) {
                if (matrix[c][l] != matrix[c1][l]) return false;
            }
            return true;
        }
        return false;
    }

    public static void resetCheckedMatrix(boolean[] checkedMatrix, int matrixDim) {
        for (int i = 0; i < matrixDim; i++) checkedMatrix[i] = false;
    }

    public static void resetRelationCountMatrix(int[] rcMatrix, int matrixDim) {
        for (int i = 0; i < matrixDim; i++) rcMatrix[i] = 0;
    }

    public static void resetMatrix(boolean[][] matrix, int matrixDim) {
        for (int c = 0; c < matrixDim; c++) {
            for (int l = 0; l < matrixDim; l++) matrix[c][l] = l == c;
        }
    }

    public static void fillRelationCountMatrix(boolean[][] matrix, int[] rcMatrix, int matrixDim) {
        for (int c = 0; c < matrixDim; c++) {
            for (int l = 0; l < matrixDim; l++) {
                if (matrix[c][l]) rcMatrix[c]++;
            }
        }
    }

    public static void linkMatrix(boolean[][] matrix, int matrixDim) {
        for (int c = 0; c < matrixDim; c++) {
            for (int l = 0; l < matrixDim; l++) {
                if (matrix[c][l]) {
                    for (int colSearch = 0; colSearch < matrixDim; colSearch++) {
                        matrix[c][colSearch] |= matrix[l][colSearch];
                        matrix[colSearch][l] |= matrix[colSearch][c];
                    }
                }
            }
        }
    }
}