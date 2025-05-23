import java.io.*;
import java.util.*;

class GroupAnalysis {
    static PrintWriter output = new PrintWriter(System.out, true);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scenarios = scanner.nextInt();
        
        for (int scenarioNumber = 1; scenarioNumber <= scenarios; scenarioNumber++) {
            int numStudents = scanner.nextInt();
            Student[] students = new Student[numStudents];
            for (int i = 0; i < numStudents; i++) {
                int studentId = scanner.nextInt() - 1;
                int numFriends = scanner.nextInt();
                int[] friends = new int[numFriends];
                for (int j = 0; j < numFriends; j++) {
                    friends[j] = scanner.nextInt() - 1; // Adjust for zero-based indexing
                }
                students[studentId] = new Student(friends);
            }
            
            displayStudentFriendships(scenarioNumber, students);
            Result result = analyzeGroups(students);
            outputResults(scenarioNumber, result);
        }
    }

    private static void displayStudentFriendships(int scenario, Student[] students) {
        output.println("\nScenario " + scenario);
        for (int i = 0; i < students.length; i++) {
            Student student = students[i];
            if (student != null && student.friends.length > 0) {
                output.println("Student " + (i + 1) + " has " + student.friends.length + " friend(s): " + Arrays.toString(student.friends));
            } else {
                output.println("Student " + (i + 1) + " has no friends.");
            }
        }
    }

    private static Result analyzeGroups(Student[] students) {
        int groupsOfFour = 0;
        int others = 0;
        
        // Your analysis logic goes here. The original code seems to involve DFS and grouping logic.
        // This is a placeholder for the actual analysis logic you'd implement.
        
        return new Result(groupsOfFour, others);
    }

    private static void outputResults(int scenario, Result result) {
        output.println("Scenario #" + scenario + ": " + result.groupsOf4 + " groups of four, " + result.others + " others.");
    }
}

class Student {
    int[] friends;

    public Student(int[] friends) {
        this.friends = friends;
    }
}

class Result {
    int groupsOf4;
    int others;

    public Result(int groupsOf4, int others) {
        this.groupsOf4 = groupsOf4;
        this.others = others;
    }
}