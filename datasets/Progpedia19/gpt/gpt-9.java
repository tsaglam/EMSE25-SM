import java.util.ArrayList;
import java.util.Scanner;

class SociologyExperiment {
    private static ArrayList<ArrayList<Integer>> graph;
    private static boolean[] visited;
    private static int numberOfPeopleInCurrentGroup;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scenarios = scanner.nextInt(); // Reading the number of scenarios

        for (int scenario = 1; scenario <= scenarios; scenario++) {
            int studentsNumber = scanner.nextInt(); // Reading the number of students for the current scenario

            // Initialize the graph for this scenario
            graph = new ArrayList<>();
            for (int i = 0; i <= studentsNumber; i++) {
                graph.add(new ArrayList<>());
            }

            // Read the relationships
            for (int i = 0; i < studentsNumber; i++) {
                int studentID = scanner.nextInt();
                int numberOfFriends = scanner.nextInt();
                
                while (numberOfFriends-- > 0) {
                    int friendID = scanner.nextInt();
                    graph.get(studentID).add(friendID);
                    graph.get(friendID).add(studentID); // Since it's a mutual relationship
                }
            }
            
            // Initialize visited array
            visited = new boolean[studentsNumber + 1];

            int countLargeGroups = 0;
            int peopleOutside = studentsNumber;

            for (int i = 1; i <= studentsNumber; i++) {
                if (!visited[i]) {
                    numberOfPeopleInCurrentGroup = 0;
                    dfs(i);

                    if (numberOfPeopleInCurrentGroup >= 4) {
                        countLargeGroups++;
                        peopleOutside -= numberOfPeopleInCurrentGroup;
                    }
                }
            }
            System.out.println("Caso #" + scenario);
            System.out.println(countLargeGroups + " " + peopleOutside);
        }
        scanner.close();
    }

    // Depth First Search to count members in the current group
    private static void dfs(int student) {
        visited[student] = true;
        numberOfPeopleInCurrentGroup++;

        for (Integer neighbor : graph.get(student)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }
}