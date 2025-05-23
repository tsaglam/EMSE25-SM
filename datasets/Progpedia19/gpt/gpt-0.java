import java.util.*;

class SociologyExperiment {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int scenarios = Integer.parseInt(scanner.nextLine());
        
        for (int s = 1; s <= scenarios; s++) {
            int students = Integer.parseInt(scanner.nextLine());
            
            List<List<Integer>> relations = new ArrayList<>();
            for (int i = 0; i < students; i++) {
                String[] input = scanner.nextLine().split(" ");
                List<Integer> current = new ArrayList<>();
                for (int j = 1; j < input.length; j++) {
                    current.add(Integer.parseInt(input[j]) - 1);
                }
                relations.add(current);
            }
            
            System.out.println("Caso #" + s);
            analyzeGroups(relations);
        }
        scanner.close();
    }

    private static void analyzeGroups(List<List<Integer>> relations) {
        int groupCount = 0;
        int outsideCount = relations.size();
        
        boolean[] visited = new boolean[relations.size()];
        for (int i = 0; i < relations.size(); i++) {
            if (!visited[i]) {
                Set<Integer> group = new HashSet<>();
                dfs(relations, i, group, visited);
                if (group.size() >= 4) {
                    groupCount++;
                    outsideCount -= group.size();
                }
            }
        }
        
        System.out.println(groupCount + " " + outsideCount);
    }

    private static void dfs(List<List<Integer>> relations, int current, Set<Integer> group, boolean[] visited) {
        visited[current] = true;
        group.add(current);
        for (int neighbour : relations.get(current)) {
            if (!visited[neighbour]) {
                dfs(relations, neighbour, group, visited);
            } else {
                group.add(neighbour);
            }
            for (int back : relations.get(neighbour)) {
                if (!visited[back]) {
                    dfs(relations, back, group, visited);
                }
            }
        }
    }
}