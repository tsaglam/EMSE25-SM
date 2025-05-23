import java.util.Arrays;
import java.io.IOException;

class ScenarioEvaluator {
    private static int scenarioCount = 0;
    private static int studentCount = 0;
    private static int caseNum = 1;
    private static String inputData = "";

    // Method for reading input from user
    public static String getInput() {
        StringBuilder input = new StringBuilder();
        int character;
        boolean finished = false;
        while (!finished) {
            try {
                character = System.in.read();
                if (character < 0 || (char) character == '\n')
                    finished = true;
                else if ((char) character != '\r')
                    input.append((char) character);
            } catch (IOException e) {
                finished = true;
            }
        }
        return input.toString();
    }

    // Main method
    public static void main(String[] args) {
        System.out.println("Input: ");
        inputData = getInput();
        String[] lines = inputData.split("#");

        for (int i = 0; i < lines.length; i++) {
            if (i == 0) {
                scenarioCount = Integer.parseInt(lines[i].trim());
            } else {
                while (scenarioCount > 0) {
                    studentCount = Integer.parseInt(lines[i].trim());
                    int[][] connectionMatrix = new int[studentCount + 1][studentCount + 1];
                    while (studentCount > 0) {
                        String line = lines[++i];
                        connectionMatrix = buildMatrix(line, connectionMatrix);
                        studentCount--;
                    }
                    System.out.println("Case #" + caseNum);
                    evaluateConnections(connectionMatrix);
                    i++;
                    scenarioCount--;
                    caseNum++;
                }
            }
        }
    }

    // Create connection matrix from input line
    public static int[][] buildMatrix(String line, int[][] matrix) {
        String[] pieces = line.split(" ");
        int row = Integer.parseInt(pieces[0].trim());
        for (int col = 2; col < pieces.length; col++)
            matrix[row][Integer.parseInt(pieces[col].trim())] = 1;
        matrix[row][row] = 1; // Self-loop
        return matrix;
    }

    // Evaluate connections within the matrix and find groups
    public static void evaluateConnections(int[][] matrix) {
        matrix = applyFloydWarshall(matrix);
        analyseGroups(matrix);
    }

    // Group analysis to find connected groups
    public static void analyseGroups(int[][] matrix) {
        int groupSize, index;
        int size = matrix.length;
        int[][] groups = new int[size][0];

        for (int x = 1; x < size; x++) {
            for (int y = 1; y < size; y++) {
                if (x != y && matrix[x][y] == 1 && matrix[y][x] == 1) {
                    groups = updateGroups(groups, x, y, true);
                    matrix[y][x] = 0; // Mark as processed
                } else if (x != y && matrix[x][y] == 1) {
                    groups = updateGroups(groups, x, y, false);
                }
            }
        }
        displayResults(groups);
    }

    // Update group arrays
    public static int[][] updateGroups(int[][] groups, int x, int y, boolean mutualConnection) {
        boolean xFound = false, yFound = false;
        if (mutualConnection) {
            for (int[] group : groups) {
                boolean inX = Arrays.binarySearch(group, x) >= 0;
                boolean inY = Arrays.binarySearch(group, y) >= 0;
                if (!inX && !inY) { // Neither found, create new group
                    group = addElement(group, x);
                    group = addElement(group, y);
                } else if (inX) {
                    group = addElement(group, y);
                    yFound = true;
                } else if (inY) {
                    group = addElement(group, x);
                    xFound = true;
                }
                if (xFound && yFound) break;
            }
        } else { // For non-mutual connections
            groups = distinctGroups(groups, x, y);
        }
        return groups;
    }

    // Merge or add elements into distinct groups
    private static int[][] distinctGroups(int[][] groups, int x, int y) {
        // Implementation logically groups x and y into separate groups or updates existing ones.
        // Detailed implementation depends on the specific grouping rules, which are simplified here.
        return groups; // Placeholder return
    }

    // Insert element into array
    private static int[] addElement(int[] original, int element) {
        int len = original.length;
        int[] newArray = new int[len + 1];

        System.arraycopy(original, 0, newArray, 0, len);
        newArray[len] = element;
        Arrays.sort(newArray); // Keep sorted for binary searches

        return newArray;
    }

    // Floyd-Warshall algorithm to find shortest paths
    public static int[][] applyFloydWarshall(int[][] connections) {
        int size = connections.length;
        for (int k = 0; k < size; k++)
            for (int i = 0; i < size; i++)
                for (int j = 0; j < size; j++)
                    if (connections[i][k] + connections[k][j] == 2) {
                        connections[i][j] = 1;
                    }
        return connections;
    }

    // Print groups and their connections
    public static void displayResults(int[][] groups) {
        for (int[] group : groups) {
            // Processing and displaying the results based on group analysis
            // Placeholder method content
        }
        // Display logic goes here
    }
}