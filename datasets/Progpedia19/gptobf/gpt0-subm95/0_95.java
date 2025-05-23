import java.io.*;
import java.util.Scanner;

class MainRefactored {
    private static void resetBooleanArray(boolean[] array) {
        java.util.Arrays.fill(array, false);
    }

    private static void resetIntArray(int[] array) {
        java.util.Arrays.fill(array, 0);
    }

    private static void fillRelationCountMatrix(boolean[][] matrix, int[] relationCount) {
        for (int i = 0; i < matrix.length; i++) {
            for (boolean relation : matrix[i]) {
                if (relation) relationCount[i]++;
            }
        }
    }

    private static void displayRelationCount(int[] relationCount) {
        for (int count : relationCount) System.out.print("[" + count + "]");
        System.out.println();
    }

    private static void linkMatrix(boolean[][] matrix) {
        int size = matrix.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j]) {
                    for (int k = 0; k < size; k++) {
                        if (matrix[j][k]) matrix[i][k] = true;
                        if (matrix[k][i]) matrix[k][j] = true;
                    }
                }
            }
        }
    }

    private static void resetMatrix(boolean[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = i == j;
            }
        }
    }

    private static void displayMatrix(boolean[][] matrix) {
        System.out.print("|||");
        for (int i = 1; i <= matrix.length; i++) System.out.print("|" + i + "|");
        System.out.println();
        int rowNumber = 1;
        for (boolean[] row : matrix) {
            System.out.print("|" + (rowNumber++) + "|");
            for (boolean element : row) {
                System.out.print("[" + (element ? 1 : 0) + "]");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int scenarios = scanner.nextInt();

        for (int scenario = 1; scenario <= scenarios; scenario++) {
            int dimension = scanner.nextInt();
            boolean[][] matrix = new boolean[dimension][dimension];
            resetMatrix(matrix);
            for (int i = 0; i < dimension; i++) {
                int index = scanner.nextInt() - 1;
                int relations = scanner.nextInt();
                for (int j = 0; j < relations; j++) {
                    int relatedIndex = scanner.nextInt() - 1;
                    matrix[index][relatedIndex] = true;
                }
            }
            linkMatrix(matrix);

            int[] relationCount = new int[dimension];
            boolean[] checked = new boolean[dimension];
            resetIntArray(relationCount);
            resetBooleanArray(checked);
            fillRelationCountMatrix(matrix, relationCount);

            int groups = 0, outliers = 0;
            for (int i = 0; i < dimension; i++) {
                if (checked[i]) continue;
                int relations = relationCount[i], elements = 1;
                for (int j = 0; j < dimension; j++) {
                    if (!checked[j] && i != j && relationCount[j] == relations && java.util.Arrays.equals(matrix[i], matrix[j])) {
                        checked[i] = checked[j] = true;
                        elements++;
                    }
                }
                if (elements < 4) outliers += elements;
                else groups++;
            }

            System.out.println("Caso #" + scenario + "\n" + groups + " " + outliers);
        }
    }
}