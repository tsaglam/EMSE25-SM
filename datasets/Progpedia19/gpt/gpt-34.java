import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class SociologyExperiment {

    private static ArrayList<Integer>[] relationships;
    private static boolean[] visited;
    private static int groupSize;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scenarios = scanner.nextInt();

        for (int scenario = 1; scenario <= scenarios; scenario++) {
            int students = scanner.nextInt();
            relationships = new ArrayList[students + 1];
            visited = new boolean[students + 1];

            for (int i = 0; i <= students; i++) {
                relationships[i] = new ArrayList<>();
            }

            for (int i = 1; i <= students; i++) {
                int student = scanner.nextInt();
                int count = scanner.nextInt();
                for (int j = 0; j < count; j++) {
                    int friend = scanner.nextInt();
                    relationships[student].add(friend);
                    relationships[friend].add(student); // Since the friendship is mutual
                }
            }

            List<Integer> groupSizes = new ArrayList<>();
            for (int i = 1; i <= students; i++) {
                if (!visited[i]) {
                    groupSize = 0;
                    dfs(i);
                    groupSizes.add(groupSize);
                }
            }

            int groupsWithFourOrMore = 0;
            int outsiders = 0;
            for (int size : groupSizes) {
                if (size >= 4) {
                    groupsWithFourOrMore++;
                } else {
                    outsiders += size;
                }
            }

            System.out.println("Caso #" + scenario);
            System.out.println(groupsWithFourOrMore + " " + outsiders);
        }
        scanner.close();
    }

    private static void dfs(int at) {
        if (visited[at]) return;
        visited[at] = true;
        groupSize++;
        for (int to : relationships[at]) {
            if (!visited[to]) {
                dfs(to);
            }
        }
    }
}