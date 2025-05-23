import java.io.*;
import java.util.*;

class TestGrupos {
    static void displayStudents(int scenario, int totalStudents, Vertex[] students) {
        System.out.print("\n\n\nScenario " + scenario);
        for (int currentStudent = 0; currentStudent < totalStudents; currentStudent++) {
            int friendsCount = students[currentStudent].getFriendsCount();
            if (friendsCount > 0) {
                System.out.print("\n\n Student: " + (currentStudent + 1) + " has " + friendsCount + " friend(s) which are: ");
                for (int friendIndex = 0; friendIndex < friendsCount; friendIndex++)
                    System.out.print("\n\t" + (students[currentStudent].getFriend(friendIndex) + 1));
            } else
                System.out.print("\n\n Student: " + (currentStudent + 1) + " has no friends.");
        }
        System.out.print("\n\n");
    }

    static void listSCC(int scenario, SCCList sccList) {
        System.out.print("\n\n\nScenario: " + scenario);
        for (SCC scc = sccList.getFirst(); scc != null; scc = scc.getNext())
            showStack(scc.getStack());
    }

    static void showStack(Stack<Integer> stack) {
        System.out.print("\n\n\t Stack:");
        if (!stack.isEmpty())
            for (Integer element : stack)
                System.out.print("\n\t\t" + (element + 1));
        else
            System.out.println("\n\tEmpty");
        System.out.print("\n\n");
    }
}

class Vertex {
    private int friendsCount;
    private int[] friends;
    private int index = -1;
    private int lowLink = -1;

    Vertex(int count, int[] friendsArray) {
        friendsCount = count;
        friends = friendsArray;
    }

    int getFriendsCount() {
        return friendsCount;
    }

    int getFriend(int index) {
        return friends[index];
    }

    void setIndex(int idx) {
        index = idx;
    }

    int getIndex() {
        return index;
    }

    void setLowLink(int link) {
        lowLink = link;
    }

    int getLowLink() {
        return lowLink;
    }
}

class SCC {
    Stack<Integer> component;
    SCC next;

    SCC(Stack<Integer> comp) {
        component = comp;
    }

    Stack<Integer> getStack() {
        return component;
    }

    void setNext(SCC node) {
        next = node;
    }

    SCC getNext() {
        return next;
    }
}

class SCCList {
    private SCC first, last;

    void addSCC(Stack<Integer> stack) {
        SCC newSCC = new SCC(stack);
        if (first == null)
            first = last = newSCC;
        else {
            last.setNext(newSCC);
            last = newSCC;
        }
    }

    SCC getFirst() {
        return first;
    }
}

class Grupos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scenariosCount = scanner.nextInt();
        for (int scenario = 1; scenario <= scenariosCount; scenario++) {
            int totalStudents = scanner.nextInt();
            Vertex[] students = new Vertex[totalStudents];
            for (int studentNum = 0; studentNum < totalStudents; studentNum++) {
                int studentId = scanner.nextInt() - 1; // Adjusting for indexed array
                int friendsCount = scanner.nextInt();
                int[] friends = new int[friendsCount];
                for (int friend = 0; friend < friendsCount; friend++) {
                    friends[friend] = scanner.nextInt() - 1; // Also adjusting for indexed array
                }
                students[studentId] = new Vertex(friendsCount, friends);
            }
            TestGrupos.displayStudents(scenario, totalStudents, students);
        }
    }
}