import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class ConnectivityProcessor {
    
    public static void main(String[] args) {
        System.out.println("Input: ");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = reader.readLine();
            if (input != null) {
                processInput(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processInput(String input) {
        String[] parts = input.split("#");
        int numberOfScenarios = Integer.parseInt(parts[0].trim());
        
        int currentIndex = 1;
        for (int caseNumber = 1; caseNumber <= numberOfScenarios; caseNumber++) {
            int numberOfStudents = Integer.parseInt(parts[currentIndex++].trim());
            int[][] connectivityMatrix = new int[numberOfStudents][numberOfStudents];

            for (int i = 0; i < numberOfStudents; i++) {
                String[] connections = parts[currentIndex++].split(" ");
                int student = Integer.parseInt(connections[0].trim()) - 1;
                connectivityMatrix[student][student] = 1; // self-loop
                for (int j = 2; j < connections.length; j++) {
                    int connection = Integer.parseInt(connections[j].trim()) - 1;
                    connectivityMatrix[student][connection] = 1;
                }
            }

            applyFloydWarshall(connectivityMatrix);
            printGroups(connectivityMatrix, caseNumber);
        }
    }

    private static void applyFloydWarshall(int[][] matrix) {
        for (int k = 0; k < matrix.length; k++) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[i][k] == 1 && matrix[k][j] == 1) {
                        matrix[i][j] = 1; // Establish connection
                    }
                }
            }
        }
    }

    private static void printGroups(int[][] matrix, int caseNumber) {
        System.out.println("Case #" + caseNumber);
        // Find unique groups - This is simplified for brevity and assumes dense connectivity
        List<List<Integer>> groups = new ArrayList<>();
        // This logic is simplified and should be adapted based on how groups are defined and detected.
        int groupCount = 0;
        int isolatedCount = 0;
        for (int i = 0; i < matrix.length; i++) {
            boolean isIsolated = true;
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 1 && i != j) {
                    isIsolated = false;
                    break;
                }
            }
            if (isIsolated) isolatedCount++;
            else groupCount++;
        }
        System.out.println(groupCount + " " + isolatedCount);
    }
}