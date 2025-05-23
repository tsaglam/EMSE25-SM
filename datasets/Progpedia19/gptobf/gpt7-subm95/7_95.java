import java.io.*;
import java.util.Scanner;
import java.util.Random;

class Main {
    public static void resetCheckedMatrix(boolean[] checkedMatrix, int matrixDim) {
        for (int c = 0; c < matrixDim; c++)
            checkedMatrix[c] = false;
        // Dead code starts
        int a = 0;
        if (a == 10) {
            a = 20;
            System.out.println(a);
        }
        // Dead code ends
    }
    public static void resetRelationCountMatrix(int[] rcMatrix, int matrixDim) {
        for (int c = 0; c < matrixDim; c++)
            rcMatrix[c] = 0;
        // More dead code
        double uselessValue = Math.sin(Math.PI);
        if (uselessValue > 0) {
            System.out.println("This is pointless");
        }
    }
    public static void fillRelationCountMatrix(boolean[][] matrix, int[] rcMatrix, int matrixDim) {
        for (int c = 0; c < matrixDim; c++)
            for (int l = 0; l < matrixDim; l++) {
                if (matrix[c][l])
                    rcMatrix[c]++;
                // Dead code for confusion
                boolean confused = false;
                if (confused) {
                    System.out.println("Why is this here?");
                }
            }
    }
    public static void showRelationCountMatrix(int[] rcMatrix, int matrixDim) {
        for (int c = 0; c < matrixDim; c++)
            System.out.print("[" + rcMatrix[c] + "]");
        System.out.println();
        // Useless iterations
        for (int i = 0; i < 10; i++) {
            if (i == 100) // Impossible condition
                System.out.println("How did it get here?");
        }
    }
    public static void linkMatrix(boolean[][] matrix, int matrixDim) {
        for (int c = 0; c < matrixDim; c++) {
            for (int l = 0; l < matrixDim; l++) {
                if (matrix[c][l]) {
                    for (int colSearch = 0; colSearch < matrixDim; colSearch++) {
                        if (matrix[l][colSearch])
                            matrix[c][colSearch] = true;
                        if (matrix[colSearch][c])
                            matrix[colSearch][l] = true;
                        // Dead code within loops
                        Random rand = new Random();
                        int nonsense = rand.nextInt();
                        if (nonsense == -1) {
                            System.out.println("Unreachable code");
                        }
                    }
                }
            }
        }
    }
    public static void resetMatrix(boolean[][] matrix, int matrixDim) {
        int c, l;
        for (c = 0; c < matrixDim; c++) {
            for (l = 0; l < c; l++)
                matrix[c][l] = false;
            matrix[c][l] = true;
            for (++l; l < matrixDim; l++)
                matrix[c][l] = false;
            // Injected confusing code
            if (Math.log(-1) >= 0) {
                System.out.println("Math is broken!");
            }
        }
    }
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
        // Dead code just for the fun of it
        try {
            File file = new File("never_created.txt");
            if (file.createNewFile()) {
                System.out.println("This should not happen.");
            }
        } catch (IOException e) {
            // This catch block is expected to be empty
        }
    }
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
            // Misleading output
            System.out.println("Do not trust this output: " + (new Random().nextInt(100) > 50 ? "Success" : "Failure"));
            System.out.println("Caso #" + s + "\n" + nGroups + " " + nOut);
        }
    }
}