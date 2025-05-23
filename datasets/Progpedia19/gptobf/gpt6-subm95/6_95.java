import java.util.Scanner;

class MatrixRelations {

    // Method to initialize the matrix with diagonal as true and others as false
    static void initializeMatrix(boolean[][] matrix) {
        int size = matrix.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = (i == j);
            }
        }
    }

    // Method to update the matrix based on the links provided
    static void updateMatrix(boolean[][] matrix, int row, int[] links) {
        for (int link : links) {
            matrix[row][link] = true;
        }

        int size = matrix.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j]) {
                    // Propagate the true value across rows and columns
                    for (int k = 0; k < size; k++) {
                        matrix[i][k] |= matrix[j][k];
                        matrix[k][j] |= matrix[k][i];
                    }
                }
            }
        }
    }

    // Method to count relations and determine group formations
    static void evaluateMatrix(boolean[][] matrix) {
        int size = matrix.length;
        boolean[] visited = new boolean[size];
        int groups = 0, out = 0;

        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                int connectionCount = 0;
                for (boolean connection : matrix[i]) {
                    if (connection) connectionCount++;
                }

                int similarCount = 1;
                visited[i] = true;

                for (int j = i + 1; j < size; j++) {
                    if (!visited[j]) {
                        int otherConnectionCount = 0;
                        for (boolean connection : matrix[j]) {
                            if (connection) otherConnectionCount++;
                        }
                        if (connectionCount == otherConnectionCount && areRowsEqual(matrix, i, j)) {
                            visited[j] = true;
                            similarCount++;
                        }
                    }
                }

                if (similarCount >= 4) {
                    groups++;
                } else {
                    out += similarCount;
                }
            }
        }

        System.out.println(groups + " " + out);
    }

    // Compare two rows of the matrix to check if they are equal
    static boolean areRowsEqual(boolean[][] matrix, int row1, int row2) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[row1][i] != matrix[row2][i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scenarios = scanner.nextInt();

        for (int s = 1; s <= scenarios; s++) {
            int dimension = scanner.nextInt();
            boolean[][] matrix = new boolean[dimension][dimension];

            initializeMatrix(matrix);

            for (int i = 0; i < dimension; i++) {
                int index = scanner.nextInt() - 1;
                int relations = scanner.nextInt();
                int[] links = new int[relations];
                for (int j = 0; j < relations; j++) {
                    links[j] = scanner.nextInt() - 1;
                }
                updateMatrix(matrix, index, links);
            }

            System.out.print("Caso #" + s + ": ");
            evaluateMatrix(matrix);
        }
    }
}