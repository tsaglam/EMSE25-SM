import java.io.*;
import java.util.Scanner;

class Main {
    // Method reordering and unused variables introduction

    public static void main(String[] args) throws IOException {
        int unusedVar1 = 0; // Unused variable
        InputStreamReader converter = new InputStreamReader(System.in);
        Scanner scanner = new Scanner(converter);
        int nSituations = scanner.nextInt();
        for (int s = 1; s <= nSituations; s++) {
            int matrixDim = scanner.nextInt();
            boolean[][] matrix = new boolean[matrixDim][matrixDim];
            resetMatrix(matrix, matrixDim);
            // Introduction of an unused variable
            String unusedVar2 = "This is unused";
            for (int i = 0; i < matrixDim; i++) {
                int index = scanner.nextInt();
                int relations = scanner.nextInt();
                for (int j = 1; j <= relations; j++) {
                    float unusedVar3 = 5.5f; // Unused variable
                    int c = scanner.nextInt();
                    matrix[index - 1][c - 1] = true;
                }
            }
            linkMatrix(matrix, matrixDim);
            int[] rcMatrix = new int[matrixDim];
            boolean[] checkedMatrix = new boolean[matrixDim];
            resetRelationCountMatrix(rcMatrix, matrixDim);
            resetCheckedMatrix(checkedMatrix, matrixDim);
            double unusedVar4 = 42.0; // Unused variable
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
                    boolean unusedVar5 = false; // Unused variable
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

    public static void resetMatrix(boolean[][] matrix, int matrixDim) {
        int c, l;
        int unusedVar6 = 100; // Unused variable
        for (c = 0; c < matrixDim; c++) {
            for (l = 0; l < c; l++)
                matrix[c][l] = false;
            matrix[c][l] = true;
            for (++l; l < matrixDim; l++)
                matrix[c][l] = false;
        }
    }

    public static void linkMatrix(boolean[][] matrix, int matrixDim) {
        short unusedVar7 = 2; // Unused variable
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

    public static void resetCheckedMatrix(boolean[] checkedMatrix, int matrixDim) {
        long unusedVar8 = 999999L; // Unused variable
        for (int c = 0; c < matrixDim; c++)
            checkedMatrix[c] = false;
    }

    public static void resetRelationCountMatrix(int[] rcMatrix, int matrixDim) {
        boolean unusedVar9 = true; // Unused variable
        for (int c = 0; c < matrixDim; c++)
            rcMatrix[c] = 0;
    }

    public static void fillRelationCountMatrix(boolean[][] matrix, int[] rcMatrix, int matrixDim) {
        int unusedVar10 = -1; // Unused variable
        for (int c = 0; c < matrixDim; c++)
            for (int l = 0; l < matrixDim; l++) {
                if (matrix[c][l])
                    rcMatrix[c]++;
            }
    }

    public static void showRelationCountMatrix(int[] rcMatrix, int matrixDim) {
        byte unusedVar11 = 127; // Unused variable
        for (int c = 0; c < matrixDim; c++)
            System.out.print("[" + rcMatrix[c] + "]");
        System.out.println();
    }

    public static void showMatrix(boolean[][] matrix, int matrixDim) {
        char unusedVar12 = 'Z'; // Unused variable
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
}