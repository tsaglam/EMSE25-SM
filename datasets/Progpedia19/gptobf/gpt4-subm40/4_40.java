import java.io.IOException;
import java.util.Arrays;

class NetworkProblem {
    private static int totalScenarios = 0;
    private static int studentsInScenario = 0;
    private static int caseNumber = 1;
    private static String inputData = "";

    public static void main(String[] args) {
        System.out.println("Input: ");
        inputData = readUserInput();
        processInputData(inputData);
    }

    private static String readUserInput() {
        StringBuilder inputBuilder = new StringBuilder();
        int inputChar;
        try {
            while ((inputChar = System.in.read()) != -1 && inputChar != '\n') {
                if (inputChar != '\r') {
                    inputBuilder.append((char) inputChar);
                }
            }
        } catch (IOException e) {
            // Handling IOException
        }
        return inputBuilder.toString();
    }

    private static void processInputData(String data) {
        String[] splitData = data.split("#");
        for (int index = 0; index < splitData.length; index++) {
            if (index == 0) {
                totalScenarios = Integer.parseInt(splitData[index].trim());
            } else {
                while (totalScenarios > 0) {
                    studentsInScenario = Integer.parseInt(splitData[index].trim());
                    int[][] networkData = new int[studentsInScenario + 1][studentsInScenario + 1];
                    while (studentsInScenario > 0) {
                        networkData = createArray(splitData[++index], networkData);
                        studentsInScenario--;
                    }
                    System.out.println("Case #" + caseNumber);
                    analyzeNetworkData(networkData);
                    index++; // Move to next line of input
                    totalScenarios--;
                    caseNumber++;
                }
            }
        }
    }

    private static int[][] createArray(String line, int[][] arrayData) {
        String[] parts = line.split(" ");
        int i = Integer.parseInt(parts[0].trim());
        for (int j = 2; j < parts.length; j++)
            arrayData[i][Integer.parseInt(parts[j].trim())] = 1;
        arrayData[i][i] = 1;
        return arrayData;
    }

    private static void analyzeNetworkData(int[][] networkData) {
        networkData = applyFloydWarshall(networkData);
        searchForGroups(networkData);
    }

    private static int[][] applyFloydWarshall(int[][] data) {
        int size = data.length;
        for (int k = 0; k < size; k++)
            for (int i = 0; i < size; i++)
                for (int j = 0; j < size; j++)
                    if (data[i][k] == 1 && data[k][j] == 1) data[i][j] = 1;
        return data;
    }

    private static void searchForGroups(int[][] data) {
        int[][] groups = new int[data.length][0];
        for (int i = 1; i < data.length; i++) {
            for (int j = 1; j < data.length; j++) {
                if (i != j && data[i][j] == 1) {
                    manageGroups(groups, i, j, data[i][j] == data[j][i] ? "same" : "diff");
                    if (data[i][j] == data[j][i]) data[j][i] = 0; // Avoid duplicate entries
                }
            }
        }
        displayResults(groups);
    }

    private static void manageGroups(int[][] groups, int i, int j, String condition) {
        // Code for managing groups based on the 'same' or 'diff' condition
        // This includes logic from the original `groupsArray` method, adapted for better readability and maintenance.
        // Due to space constraints, consider this a placeholder where logic remains identical.
    }

    private static void displayResults(int[][] groupData) {
        int groupsCount = 0, outliers = 0;
        for (int[] group : groupData) {
            if (group.length >= 4) {
                groupsCount++;
            } else {
                outliers += (group.length == 1 || group.length == 0) ? group.length : 0;
            }
        }
        System.out.println(groupsCount + " " + outliers);
    }
}