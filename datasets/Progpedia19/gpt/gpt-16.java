import java.util.*;

class SociologyExperiment {
    static List<List<Integer>> adjList;
    static boolean[] visited;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scenarios = scanner.nextInt();

        for (int scenarioNum = 1; scenarioNum <= scenarios; scenarioNum++) {
            int numOfStudents = scanner.nextInt();
            adjList = new ArrayList<>();
            
            for (int i = 0; i <= numOfStudents; i++) {
                adjList.add(new ArrayList<>());
            }

            for (int i = 1; i <= numOfStudents; i++) {
                int studentID = scanner.nextInt();
                int numOfFriends = scanner.nextInt();

                for (int j = 0; j < numOfFriends; j++) {
                    int friendID = scanner.nextInt();
                    adjList.get(studentID).add(friendID);
                    adjList.get(friendID).add(studentID);
                }
            }

            visited = new boolean[numOfStudents + 1];
            int groupCount = 0;
            int outsiders = 0;
            for (int i = 1; i <= numOfStudents; i++) {
                if (!visited[i]) {
                    int groupSize = dfs(i);
                    if (groupSize >= 4) {
                        groupCount++;
                    } else {
                        outsiders += groupSize;
                    }
                }
            }

            System.out.println("Caso #" + scenarioNum);
            System.out.println(groupCount + " " + outsiders);
        }
        scanner.close();
    }
    
    public static int dfs(int start) {
        int count = 1;
        visited[start] = true;

        for (int neighbor : adjList.get(start)) {
            if (!visited[neighbor]) {
                count += dfs(neighbor);
            }
        }

        return count;
    }
}