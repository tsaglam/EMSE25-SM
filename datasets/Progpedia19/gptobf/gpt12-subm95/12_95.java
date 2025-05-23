import java.io.*;
import java.util.Scanner;

class Main {
    // Moved resetMatrix to the top for method reordering
    public static void resetMatrix(boolean[][] matrix, int matrixDim) {
        int c, l;
        for (c = 0; c < matrixDim; c++) {
            for (l = 0; l < c; l++)
                matrix[c][l] = false;
            matrix[c][l] = true;
            for (++l; l < matrixDim; l++)
                matrix[c][l] = false;
        }
    }

    // Reordered resetRelationCountMatrix method next
    public static void resetRelationCountMatrix(int[] rcMatrix, int matrixDim) {
        for (int c = 0; c < matrixDim; c++)
            rcMatrix[c] = 0;
    }
    
    // Reordered resetCheckedMatrix method following resetRelationCountMatrix
    public static void resetCheckedMatrix(boolean[] checkedMatrix, int matrixDim) {
        for (int c = 0; c < matrixDim; c++)
            checkedMatrix[c] = false;
    }

    // Unused variable introduction
    private static int unusedVariable = 0;

    // fillRelationCountMatrix comes next according to new ordering
    public static void fillRelationCountMatrix(boolean[][] matrix, int[] rcMatrix, int matrixDim) {
        for (int c = 0; c < matrixDim; c++)
            for (int l = 0; l < matrixDim; l++) {
                if (matrix[c][l])
                    rcMatrix[c]++;
            }
    }

    // linkMatrix reordered here
    public static void linkMatrix(boolean[][] matrix, int matrixDim) {
        for (int c = 0; c < matrixDim; c++) {
            for (int l = 0; l < matrixDim; l++) {
                if (matrix[c][l]) {
                    for (int colSearch = 0; colSearch < matrixDim; colSearch++) {
                        if (matrix[l][colSearch])
                            matrix[c][colSearch] = true;
                        if (matrix[colSearch][c])
                            matrix[colSearch][l] = true;
                    }
                }
            }
        }
    }

    // showRelationCountMatrix method reordered here
    public static void showRelationCountMatrix(int[] rcMatrix, int matrixDim) {
        for (int c = 0; c < matrixDim; c++)
            System.out.print("[" + rcMatrix[c] + "]");
        System.out.println();
    }

    // showMatrix method comes next after showRelationCountMatrix
    public static void showMatrix(boolean[][] matrix, int matrixDim) {
        int c, l;
        System.out.print("|||");
        for (c = 0; c < matrixDim; c++)
            System.out.print("|" + (c + 1) + "|");
        System.out.print("\n");
        for (c = 0; c < matrixDim; c++) {
            System.out.print("|" + (c + 1) + "|");
            for (l = 0; l < matrixDim; l++) {
                System.out.print("[" + (matrix[c][l] ? 1 : 0) + "]");
            }
            System.out.print("\n");
        }
        System.out.println("\n");
    }

    // Introduction of an unused method
    public static void unusedMethod() {
        System.out.println("This is an unused method.");
    }

    // Main method is kept unchanged but is necessarily the last one due to constraints
    public static void main(String[] args) throws IOException {
        InputStreamReader converter = new InputStreamReader(System.in);
        Scanner scanner = new Scanner(converter);
        int nSituations = scanner.nextInt();
        for (int s = 1; s <= nSituations; s++) {
            int matrixDim = scanner.nextInt();
            boolean[][] matrix = new boolean[matrixDim][matrixDim];
            resetMatrix(matrix, matrixDim);
            for (int i = 0; i < matrixDim; i++) {
                int index = scanner.nextInt();
                int relations = scanner.nextInt();
                for (int j = 1; j <= relations; j++) {
                    int c = scanner.nextInt();
                    matrix[index - 1][c - 1] = true;
                }
            }
            linkMatrix(matrix, matrixDim);
            int[] rcMatrix = new int[matrixDim];
            boolean[] checkedMatrix = new boolean[matrixDim];
            resetRelationCountMatrix(rcMatrix, matrixDim);
            resetCheckedMatrix(checkedMatrix, matrixDim);
            fillRelationCountMatrix(matrix, rcMatrix, matrixDim);
            int nGroups = 0;
            int nOut = 0;
            for (int c = 0; c < matrixDim; c++) {
                if (checkedMatrix[c])
                    continue;
                int nRelationsC = rcMatrix[c];
                int c1;
                int nElements = 1;
                for (c1 = 0; c1 < matrixDim; c1++) {
                    if (!checkedMatrix[c1] && (c != c1)) {
                        int nRelationsC1 = rcMatrix[c1];
                        if (nRelationsC == nRelationsC1) {
                            boolean equal = true;
                            for (int l = 0; l < matrixDim; l++) {
                                equal &= (matrix[c][l] == matrix[c1][l]);
                                if (!equal)
                                    break;
                            }
                            if (equal) {
                                checkedMatrix[c] = true;
                                checkedMatrix[c1] = true;
                                nElements++;
                            }
                        }
                    }
                }
                if (nElements < 4)
                    nOut += nElements;
                else
                    nGroups++;
            }
            System.out.println("Caso #" + s + "\n" + nGroups + " " + nOut);
        }
    }
}