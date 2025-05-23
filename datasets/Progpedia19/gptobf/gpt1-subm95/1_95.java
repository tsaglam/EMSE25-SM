import java.io.*;
import java.util.Scanner;

class RelationAnalyzer {
    
    private boolean[][] matrix;
    private int matrixSize;
    
    public RelationAnalyzer(int size) {
        this.matrixSize = size;
        this.matrix = new boolean[size][size];
    }
    
    public void initializeRelationMatrix(Scanner scanner) {
        for (int i = 0; i < matrixSize; i++) {
            int index = scanner.nextInt() - 1;
            int relations = scanner.nextInt();
            for (int j = 0; j < relations; j++) {
                int relatedIndex = scanner.nextInt() - 1;
                this.matrix[index][relatedIndex] = true;
            }
        }
    }
    
    public void applyLinkRelations() {
        for (int row = 0; row < matrixSize; row++) {
            for (int col = 0; col < matrixSize; col++) {
                if (matrix[row][col]) {
                    linkRelationForCell(row, col);
                }
            }
        }
    }

    private void linkRelationForCell(int row, int col) {
        for (int i = 0; i < matrixSize; i++) {
            if (matrix[col][i]) {
                matrix[row][i] = true;
            }
            if (matrix[i][row]) {
                matrix[i][col] = true;
            }
        }
    }
    
    public int[] computeRelationCounts() {
        int[] relationCounts = new int[matrixSize];
        for (int row = 0; row < matrixSize; row++) {
            for (int col = 0; col < matrixSize; col++) {
                if (matrix[row][col]) {
                    relationCounts[row]++;
                }
            }
        }
        return relationCounts;
    }
    
    public int analyzeAndComputeResults() {
        boolean[] checkedMatrix = new boolean[matrixSize];
        int[] relationCounts = computeRelationCounts();
        int groups = 0;
        int outliers = 0;
        
        for (int i = 0; i < matrixSize; i++) {
            if (!checkedMatrix[i]) {
                int matchCount = findMatchesAndUpdate(checkedMatrix, relationCounts, i);
                if (matchCount < 4) {
                    outliers += matchCount;
                } else {
                    groups++;
                }
            }
        }
        return groups * 10 + outliers; // Encode results: groups*10 + outliers to avoid multiple return types.
    }

    private int findMatchesAndUpdate(boolean[] checkedMatrix, int[] relationCounts, int currentIndex) {
        int matches = 1;
        checkedMatrix[currentIndex] = true;
        
        for (int i = 0; i < matrixSize; i++) {
            if (i != currentIndex && !checkedMatrix[i] && relationCounts[currentIndex] == relationCounts[i] && matricesEqual(currentIndex, i)) {
                checkedMatrix[i] = true;
                matches++;
            }
        }
        return matches;
    }
    
    private boolean matricesEqual(int rowA, int rowB) {
        for (int i = 0; i < matrixSize; i++) {
            if (matrix[rowA][i] != matrix[rowB][i]) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int s = 1; s <= testCases; s++) {
                int matrixSize = scanner.nextInt();
                RelationAnalyzer analyzer = new RelationAnalyzer(matrixSize);
                analyzer.initializeRelationMatrix(scanner);
                analyzer.applyLinkRelations();
                int result = analyzer.analyzeAndComputeResults();
                int groups = result / 10;
                int outliers = result % 10;
                System.out.println("Case #" + s + "\n" + groups + " " + outliers);
            }
        }
    }
}