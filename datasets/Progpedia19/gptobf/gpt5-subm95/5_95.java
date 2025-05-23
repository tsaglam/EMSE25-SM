import java.io.*;
import java.util.*;

class RelationAnalyzer {
    
    private static void clearCheckFlags(boolean[] checkFlags, int dimension) {
        Arrays.fill(checkFlags, false);
    }
    
    private static void initializeRelationCounts(int[] relationCounts, int dimension) {
        Arrays.fill(relationCounts, 0);
    }
    
    private static void populateRelationCounts(boolean[][] relations, int[] counts, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (relations[i][j]) counts[i]++;
            }
        }
    }
    
    private static void printRelationCounts(int[] counts) {
        Arrays.stream(counts).forEach(count -> System.out.print("[" + count + "]"));
        System.out.println();
    }
    
    private static void establishLinks(boolean[][] network, int dimensions) {
        for (int i = 0; i < dimensions; i++) {
            for (int j = 0; j < dimensions; j++) {
                if (network[i][j]) {
                    for (int k = 0; k < dimensions; k++) {
                        network[i][k] |= network[j][k];
                        network[k][j] |= network[k][i];
                    }
                }
            }
        }
    }
    
    private static void blankSlate(boolean[][] slate, int size) {
        for (int i = 0; i < size; i++) {
            Arrays.fill(slate[i], false);
            slate[i][i] = true;
        }
    }
    
    private static void displayMatrix(boolean[][] matrix, int size) {
        System.out.print("|||");
        for (int i = 1; i <= size; i++) System.out.print("|" + i + "|");
        System.out.println();
        
        for (int i = 0; i < size; i++) {
            System.out.print("|" + (i + 1) + "|");
            for (boolean b : matrix[i]) {
                System.out.print("[" + (b ? 1 : 0) + "]");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int testCases = inputScanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int dimension = inputScanner.nextInt();
            boolean[][] network = new boolean[dimension][dimension];
            
            blankSlate(network, dimension);
            
            for (int row = 0; row < dimension; row++) {
                int rowIndex = inputScanner.nextInt() - 1;
                int totalRelations = inputScanner.nextInt();
                for (int rel = 0; rel < totalRelations; rel++) {
                    int colIndex = inputScanner.nextInt() - 1;
                    network[rowIndex][colIndex] = true;
                }
            }
            
            establishLinks(network, dimension);
            
            int[] relationCounts = new int[dimension];
            boolean[] checked = new boolean[dimension];
            
            initializeRelationCounts(relationCounts, dimension);
            clearCheckFlags(checked, dimension);
            populateRelationCounts(network, relationCounts, dimension);
            
            int groupCount = 0, outliers = 0;
            for (int i = 0; i < dimension; i++) {
                if (checked[i]) continue;
                int relationCount = relationCounts[i];
                int elementCount = 1;
                
                for (int j = 0; j < dimension; j++) {
                    if (i != j && !checked[j] && relationCounts[j] == relationCount) {
                        boolean identical = true;
                        for (int k = 0; k < dimension && identical; k++) {
                            identical = network[i][k] == network[j][k];
                        }
                        if (identical) {
                            checked[i] = checked[j] = true;
                            elementCount++;
                        }
                    }
                }
                
                if (elementCount < 4) outliers += elementCount;
                else groupCount++;
            }
            System.out.println("Scenario #" + testCase + "\n" + groupCount + " " + outliers);
        }
    }
}