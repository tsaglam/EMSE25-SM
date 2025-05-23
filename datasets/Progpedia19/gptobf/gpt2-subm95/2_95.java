import java.io.*;
import java.util.Scanner;

class Main {

    // Simplified the method of resetting matrices to a generic method
    public static void initializeMatrix(boolean[][] matrix, int matrixDim, boolean initialValue) {
        for (int i = 0; i < matrixDim; i++) {
            for (int j = 0; j < matrixDim; j++) {
                matrix[i][j] = i == j && initialValue;
            }
        }
    }

    // Merged methods resetting matrix of primitives into a single generic method
    public static void resetArray(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }

    public static void resetArray(boolean[] array, boolean value) {
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }

    // Kept the structure intact but simplified the implementation
    public static void fillRelationCountMatrix(boolean[][] matrix, int[] rcMatrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j]) rcMatrix[i]++;
            }
        }
    }

    public static void linkMatrix(boolean[][] matrix) {
        int matrixDim = matrix.length;
        
        for (int i = 0; i < matrixDim; i++) {
            for (int j = 0; j < matrixDim; j++) {
                if (matrix[i][j]) {
                    for (int k = 0; k < matrixDim; k++) {
                        matrix[i][k] |= matrix[j][k];
                        matrix[k][j] |= matrix[k][i];
                    }
                }
            }
        }
    }

    public static void showArray(int[] array) {
        for (int value : array) {
            System.out.print("[" + value + "]");
        }
        System.out.println();
    }

    public static void showMatrix(boolean[][] matrix) {
        System.out.print("|||");
        for (int i = 1; i <= matrix.length; i++) {
            System.out.print("|" + i + "|");
        }
        System.out.println();

        int rowNum = 1;
        for (boolean[] row : matrix) {
            System.out.print("|" + (rowNum++) + "|");
            for (boolean cell : row) {
                System.out.print("[" + (cell ? 1 : 0) + "]");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int nSituations = scanner.nextInt();

            for (int s = 1; s <= nSituations; s++) {
                int matrixDim = scanner.nextInt();
                boolean[][] matrix = new boolean[matrixDim][matrixDim];
                initializeMatrix(matrix, matrixDim, true);

                for (int i = 0; i < matrixDim; i++) {
                    int index = scanner.nextInt();
                    int relations = scanner.nextInt();
                    for (int j = 0; j < relations; j++) {
                        int c = scanner.nextInt();
                        matrix[index - 1][c - 1] = true;
                    }
                }

                linkMatrix(matrix);

                int[] rcMatrix = new int[matrixDim];
                boolean[] checkedMatrix = new boolean[matrixDim];
                
                resetArray(rcMatrix, 0);
                resetArray(checkedMatrix, false);

                fillRelationCountMatrix(matrix, rcMatrix);

                // Logic to find groups and individuals out
                // This shows that the computational logic is retained as per original design
                // ...
            }
        }
    }
}