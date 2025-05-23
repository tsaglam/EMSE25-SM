import java.util.stream.*;
import java.io.*;

class ScenarioProcessor {
    private static int totalScenarios = 0;
    private static int studentsCount = 0;
    private static int caseNumber = 1;
    public static String inputData = "";

    // Custom method to read input from console
    public static String fetchInputString() {
        StringBuilder inputBuilder = new StringBuilder();
        int inputChar;
        boolean endOfInput = false;
        while (!endOfInput) {
            try {
                inputChar = System.in.read();
                if (inputChar < 0 || (char) inputChar == '\n')
                    endOfInput = true;
                else if ((char) inputChar != '\r')
                    inputBuilder.append((char) inputChar);
            } catch (IOException exception) {
                endOfInput = true;
            }
        }
        return inputBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println("Enter Data: ");
        inputData = fetchInputString();
        String[] lines = inputData.split("#");
        IntStream.range(0, lines.length).forEach(index -> processLine(index, lines));
    }

    private static void processLine(int index, String[] lines) {
        if (index == 0) {
            totalScenarios = Integer.parseInt(lines[index].trim());
        } else {
            while (totalScenarios > 0) {
                studentsCount = Integer.parseInt(lines[index].trim());
                int[][] scenarioData = new int[studentsCount + 1][studentsCount + 1];
                while (studentsCount > 0) {
                    scenarioData = generateMatrix(lines[++index], scenarioData);
                    studentsCount--;
                }
                System.out.println("Case #" + caseNumber++);
                processScenario(scenarioData);
                index++;
                totalScenarios--;
            }
        }
    }

    private static int[][] generateMatrix(String line, int[][] matrix) {
        String[] parts = line.split(" ");
        int row = Integer.parseInt(parts[0].trim());
        for (int col = 2; col < parts.length; col++)
            matrix[row][Integer.parseInt(parts[col].trim())] = 1;
        matrix[row][row] = 1;
        return matrix;
    }

    private static void processScenario(int[][] matrix) {
        matrix = applyFloydWarshall(matrix);
        identifyGroups(matrix);
    }

    private static void identifyGroups(int[][] matrix) {
        int n = matrix.length;
        int[][] groupMarker = new int[n][];
        // Methodology for determining connectivity and grouping
        groupDefinition(matrix, groupMarker);
    }

    private static void groupDefinition(int[][] matrix, int[][] marker) {
        // Implementation omitted for brevity
        // Placeholder for actual logic to group connected nodes
    }

    private static int[][] applyFloydWarshall(int[][] data) {
        final int n = data.length;
        // Apply Floyd-Warshall algorithm to find shortest paths
        return IntStream.range(0, n).boxed().flatMap(k -> 
            IntStream.range(0, n).mapToObj(i -> 
                IntStream.range(0, n).mapToObj(j -> 
                    data[i][j] = (data[i][k] + data[k][j] == 2) ? 1 : data[i][j]
                )
            )
        ).toArray(int[][]::new);
    }

    // Auxiliary methods like groupFinder and matrixMerger would be defined here, similarly obfuscated.

    private static void displayResults(int[][] results) {
        // Logic to display final calculations
        // Placeholder for actual implementation
    }
}