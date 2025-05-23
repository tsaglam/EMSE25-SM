import java.util.*;

class SociologyExperiment {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scenarios = scanner.nextInt();
        for (int i = 1; i <= scenarios; i++) {
            int students = scanner.nextInt();
            List<Set<Integer>> friendships = new ArrayList<>();
            for (int j = 0; j < students; j++) {
                friendships.add(new HashSet<>());
            }
            // Reading and storing relationships
            for (int j = 0; j < students; j++) {
                int student = scanner.nextInt() - 1; // Adjusting to 0 index
                int friendsCount = scanner.nextInt();
                for (int k = 0; k < friendsCount; k++) {
                    int friend = scanner.nextInt() - 1; // Adjusting to 0 index
                    friendships.get(student).add(friend);
                    friendships.get(friend).add(student); // Mutual friendship
                }
            }
            // Solve the problem
            Solution solution = solve(friendships);
            System.out.println("Caso #" + i);
            System.out.println(solution.groupsOfFourOrMore + " " + solution.individualsOutsideGroups);
        }
        scanner.close();
    }

    private static Solution solve(List<Set<Integer>> friendships) {
        int groupsOfFourOrMore = 0;
        int individualsOutsideGroups = 0;
        boolean[] visited = new boolean[friendships.size()];
        
        for (int i = 0; i < friendships.size(); i++) {
            if (!visited[i]) {
                int groupSize = dfs(i, friendships, visited);
                if (groupSize >= 4) {
                    groupsOfFourOrMore++;
                } else {
                    individualsOutsideGroups += groupSize;
                }
            }
        }
        
        return new Solution(groupsOfFourOrMore, individualsOutsideGroups);
    }

    private static int dfs(int student, List<Set<Integer>> friendships, boolean[] visited) {
        visited[student] = true;
        int count = 1; // Counting the current student
        for (int friend : friendships.get(student)) {
            if (!visited[friend]) {
                count += dfs(friend, friendships, visited);
            }
        }
        return count;
    }
    
    static class Solution {
        int groupsOfFourOrMore;
        int individualsOutsideGroups;

        Solution(int groupsOfFourOrMore, int individualsOutsideGroups) {
            this.groupsOfFourOrMore = groupsOfFourOrMore;
            this.individualsOutsideGroups = individualsOutsideGroups;
        }
    }
}