import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

class GruposRefactored {
    public static PrintWriter pw = new PrintWriter(System.out, true);
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        processInput();
    }

    private static void processInput() {
        int numberOfScenarios = scanner.nextInt();
        for (int scenario = 1; scenario <= numberOfScenarios; scenario++) {
            int numberOfStudents = scanner.nextInt();
            Student[] students = new Student[numberOfStudents];
            for (int i = 0; i < numberOfStudents; i++) {
                int studentId = scanner.nextInt() - 1;
                int numberOfFriends = scanner.nextInt();
                int[] friends = new int[numberOfFriends];
                for (int j = 0; j < numberOfFriends; j++) {
                    friends[j] = scanner.nextInt() - 1;
                }
                students[studentId] = new Student(numberOfFriends, friends);
            }
            displayStudentFriends(scenario, students);
            pw.println("Scenario #" + scenario + ": " + analyzeGroups(students));
        }
    }

    private static void displayStudentFriends(int scenario, Student[] students) {
        pw.println("Scenario " + scenario);
        for (int i = 0; i < students.length; i++) {
            int numberOfFriends = students[i].getNumberOfFriends();
            if (numberOfFriends > 0) {
                pw.println("Student " + (i + 1) + " has " + numberOfFriends + " friend(s)");
                for (int j = 0; j < numberOfFriends; j++) {
                    pw.println("\tFriend: " + (students[i].getFriend(j) + 1));
                }
            } else {
                pw.println("Student " + (i + 1) + " has no friends");
            }
        }
    }

    private static String analyzeGroups(Student[] students) {
        // Simulate some analysis process and return a string as placeholder
        // This method would ideally implement the analysis logic similar to the original code's intent.
        return "Analysis result here";
    }
}

class Student {
    private int numberOfFriends;
    private int[] friends;

    public Student(int numberOfFriends, int[] friends) {
        this.numberOfFriends = numberOfFriends;
        this.friends = friends;
    }

    public int getNumberOfFriends() {
        return numberOfFriends;
    }

    public int getFriend(int index) {
        return friends[index];
    }
}