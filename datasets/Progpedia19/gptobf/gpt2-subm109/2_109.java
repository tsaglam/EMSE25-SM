import java.io.*;
import java.util.*;

class GroupTest {

    static void displayStudents(int scenario, int numStudents, Vertex[] students) {
        System.out.println("\n\n\nScenario " + scenario);
        
        for (int studentNum = 0; studentNum < numStudents; studentNum++) {
            int numFriends = students[studentNum].getNumberOfFriends();
            
            if (numFriends > 0) {
                System.out.println("\n\n Student: " + (studentNum + 1) + " has " + numFriends + " friend(s) who are: ");
                for (int friend = 0; friend < numFriends; friend++) {
                    System.out.println("\t" + (students[studentNum].getFriend(friend) + 1));
                }
            } else {
                System.out.println("\n\n Student: " + (studentNum + 1) + " has no friends.");
            }
        }
        System.out.println("\n\n");
        checkPrintWriterError();
    }
    
    static void checkPrintWriterError() {
        if (System.out.checkError()) {
            System.err.println("An output error occurred!");
        }
    }

    // Other methods (such as listSCC) have been omitted for conciseness.
}

class Vertex {
    private int numFriends;
    int[] friends;
    int index = -1;
    int lowlink = -1;

    Vertex(int numFriends, int[] friends) {
        this.numFriends = numFriends;
        this.friends = friends;
    }

    int getNumberOfFriends() {
        return numFriends;
    }

    int getFriend(int index) {
        return friends[index];
    }

    // Other getters and setters have been omitted for brevity.
}

// Omitted other classes like Result, GroupList, etc., for conciseness.

class Groups {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numScenarios = scanner.nextInt();
        
        for (int scenario = 1; scenario <= numScenarios; scenario++) {
            // Scenario handling code.
        }
        
        // Other program logic.
    }
}