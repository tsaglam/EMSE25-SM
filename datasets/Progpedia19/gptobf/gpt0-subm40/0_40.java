import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SimplifiedProblemA {

    private static List<Set<Integer>> studentGroups = new ArrayList<>();
    private static int caseNumber = 1;
    
    public static void main(String[] args) {
        System.out.println("Input: ");
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String inputData = reader.readLine();
            processInput(inputData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void processInput(String data) {
        String[] parts = data.split("#");
        int numberOfScenarios = Integer.parseInt(parts[0].trim());
        
        for (int i = 1; i < parts.length && numberOfScenarios > 0; i++, numberOfScenarios--) {
            int numberOfStudents = Integer.parseInt(parts[i].trim());
            boolean[][] connections = new boolean[numberOfStudents + 1][numberOfStudents + 1];
            
            for (int student = 0; student < numberOfStudents; student++) {
                String line = parts[++i];
                String[] connectionData = line.split(" ");
                int studentId = Integer.parseInt(connectionData[0].trim());
                for (int j = 2; j < connectionData.length; j++) {
                    int friendId = Integer.parseInt(connectionData[j].trim());
                    connections[studentId][friendId] = true;
                }
            }
            
            calculateGroups(connections, numberOfStudents);
            System.out.println("Caso #" + caseNumber++);
            printGroups();
            studentGroups.clear();
        }
    }
    
    private static void calculateGroups(boolean[][] connections, int numberOfStudents) {
        for (int i = 1; i <= numberOfStudents; i++) {
            boolean added = false;
            for (Set<Integer> group : studentGroups) {
                if (group.contains(i)) {
                    addConnections(group, connections, i);
                    added = true;
                    break;
                }
            }
            if (!added) {
                Set<Integer> newGroup = new HashSet<>();
                newGroup.add(i);
                addConnections(newGroup, connections, i);
                studentGroups.add(newGroup);
            }
        }
    }
    
    private static void addConnections(Set<Integer> group, boolean[][] connections, int studentId) {
        for (int i = 1; i < connections.length; i++) {
            if (connections[studentId][i]) {
                group.add(i);
                for (int j = 1; j < connections[studentId].length; j++) {
                    if (connections[i][j]) {
                        group.add(j);
                    }
                }
            }
        }
    }
    
    private static void printGroups() {
        int groupCount = 0;
        int isolatedStudents = 0;
        for (Set<Integer> group : studentGroups) {
            if (group.size() > 2) {
                groupCount++;
            } else {
                isolatedStudents += group.size();
            }
        }
        System.out.println(groupCount + " " + isolatedStudents);
    }

}