import java.util.Scanner;

class Main {

    // Resets each element in a boolean array to false
    private static void clearCheckedMatrix(boolean[] checked) {
        java.util.Arrays.fill(checked, false); // Utilizes Arrays.fill for simplicity
    }

    // Resets each element in an integer array to 0
    private static void clearRelationCountMatrix(int[] relationCounts) {
        java.util.Arrays.fill(relationCounts, 0); // Utilizing Arrays.fill for simplicity
    }

    // Populates the relation count matrix based on the presence of relationships in the matrix
    private static void populateRelationCounts(boolean[][] matrix, int[] relationCounts) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]) {
                    relationCounts[i]++;
                }
            }
        }
    }

    // Prints the relationship count for each element
    private static void printRelationCounts(int[] relationCounts) {
        for (int count : relationCounts)
            System.out.print("[" + count + "]");
        System.out.println();
    }
    
    // Processes links between matrix elements, enhancing interconnectivity based on existing links
    private static void processLinks(boolean[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]) {
                    for (int k = 0; k < matrix.length; k++) {
                        if (matrix[j][k]) matrix[i][k] = true;
                        if (matrix[k][i]) matrix[k][j] = true;
                    }
                }
            }
        }
    }
    
    // Initializes the matrix to a default state before loading specific links
    private static void initializeMatrix(boolean[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            java.util.Arrays.fill(matrix[i], false); // Filling the row with false
            matrix[i][i] = true; // Setting diagonal to true indicating self relation
        }
    }

    // Displays the matrix with 1s and 0s for better visualization
    private static void displayMatrix(boolean[][] matrix) {
        System.out.print("|||");
        for (int i = 0; i < matrix.length; i++)
            System.out.print("|" + (i + 1) + "|");
        System.out.println();

        for (int i = 0; i < matrix.length; i++) {
            System.out.print("|" + (i + 1) + "|");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("[" + (matrix[i][j] ? 1 : 0) + "]");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Main method to execute the program logic
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= totalCases; caseNum++) {
            int dimension = scanner.nextInt();
            boolean[][] matrix = new boolean[dimension][dimension];
            initializeMatrix(matrix);
            
            for (int i = 0; i < dimension; i++) {
                int index = scanner.nextInt() - 1;
                int relations = scanner.nextInt();
                for (int j = 0; j < relations; j++) {
                    int connectedIndex = scanner.nextInt() - 1;
                    matrix[index][connectedIndex] = true; // Setting relationship
                }
            }

            processLinks(matrix);
            
            int[] relationCounts = new int[dimension];
            boolean[] checked = new boolean[dimension];
            
            clearRelationCountMatrix(relationCounts);
            clearCheckedMatrix(checked);
            populateRelationCounts(matrix, relationCounts);
            
            int groups = 0, outliers = 0;
            
            for (int i = 0; i < dimension; i++) {
                if (!checked[i]) {
                    int count = 1;
                    for (int j = i + 1; j < dimension; j++) {
                        if (!checked[j] && areRowsEqual(matrix, i, j)) {
                            checked[j] = true;
                            count++;
                        }
                    }
                    if (count >= 4) groups++;
                    else outliers += count;
                }
            }
            
            System.out.println("Caso #" + caseNum + "\n" + groups + " " + outliers);
        }
    }

    // Method to compare if two rows in the matrix are equal
    private static boolean areRowsEqual(boolean[][] matrix, int row1, int row2) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[row1][i] != matrix[row2][i]) return false;
        }
        return true;
    }
}