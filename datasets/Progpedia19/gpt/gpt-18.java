import java.util.*;

class SociologyExperiment {
    static int numberOfGroups;
    static int numberOfOutsiders;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading the number of scenarios
        int scenarios = scanner.nextInt();
        for (int scenario = 1; scenario <= scenarios; scenario++) {
            // Reading the number of students in the current scenario
            int numOfStudents = scanner.nextInt();
            ArrayList<ArrayList<Integer>> relationships = new ArrayList<>();

            for (int i = 0; i <= numOfStudents; i++) {
                relationships.add(new ArrayList<>());
            }

            for (int i = 1; i <= numOfStudents; i++) {
                int student = scanner.nextInt(); // Student ID, not used as index directly
                int count = scanner.nextInt(); // Number of students they relate better with
                for (int j = 0; j < count; j++) {
                    int friend = scanner.nextInt();
                    // Because this is a mutual relation, we add both sides
                    relationships.get(student).add(friend);
                    relationships.get(friend).add(student);
                }
            }

            numberOfGroups = 0;
            numberOfOutsiders = 0;
            boolean[] visited = new boolean[numOfStudents + 1];
            
            // Counting the groups and outsiders based on the relationships
            for (int i = 1; i <= numOfStudents; i++) {
                if (!visited[i]) {
                    int count = dfs(i, visited, relationships);
                    if (count >= 4) {
                        numberOfGroups++;
                    } else {
                        numberOfOutsiders += count;
                    }
                }
            }

            System.out.println("Caso #" + scenario);
            System.out.println(numberOfGroups + " " + numberOfOutsiders);
        }
        scanner.close();
    }

    // Depth-first search to find the size of a connected component (group)
    public static int dfs(int current, boolean[] visited, ArrayList<ArrayList<Integer>> relationships) {
        visited[current] = true;
        int count = 1; // Counting the current student

        for (int i = 0; i < relationships.get(current).size(); i++) {
            int friend = relationships.get(current).get(i);
            if (!visited[friend]) {
                count += dfs(friend, visited, relationships);
            }
        }
        return count;
    }
}