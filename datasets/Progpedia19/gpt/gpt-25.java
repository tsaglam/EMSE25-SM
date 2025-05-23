import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class SociologyExperiment {
    public static void main(String[] args) {
        List<Scenario> scenarios = List.of(
            new Scenario(
                List.of(
                    new int[]{1, 2, 4, 3},
                    new int[]{4, 0},
                    new int[]{2, 2, 1, 3},
                    new int[]{3, 2, 2, 1}
                )
            ),
            new Scenario(
                List.of(
                    new int[]{1, 2, 3, 5},
                    new int[]{2, 2, 3, 4},
                    new int[]{4, 1, 2},
                    new int[]{3, 2, 2, 1},
                    new int[]{6, 1, 5},
                    new int[]{5, 2, 6, 1}
                )
            ),
            new Scenario(
                List.of(
                    new int[]{1, 4, 6, 2, 4, 5},
                    new int[]{3, 1, 2},
                    new int[]{2, 2, 3, 4},
                    new int[]{4, 1, 5},
                    new int[]{6, 0},
                    new int[]{5, 3, 4, 8, 7},
                    new int[]{7, 1, 5},
                    new int[]{8, 2, 5, 3}
                )
            ),
            new Scenario(
                List.of(
                    new int[]{1, 4, 6, 2, 4, 5},
                    new int[]{3, 2, 2, 1},
                    new int[]{9, 0},
                    new int[]{2, 2, 3, 4},
                    new int[]{4, 2, 5, 9},
                    new int[]{6, 1, 1},
                    new int[]{5, 3, 4, 8, 7},
                    new int[]{7, 1, 5},
                    new int[]{8, 1, 5},
                    new int[]{10, 1, 9}
                )
            )
        );

        for (int i = 0; i < scenarios.size(); i++) {
            scenarios.get(i).calculateGroups();
            System.out.printf("Caso #%d%n", i + 1);
            System.out.printf("%d %d%n", scenarios.get(i).getLargeGroups(), scenarios.get(i).getIndividualsOut());
        }
    }

    static class Scenario {
        private final List<int[]> studentsRelations;
        private int largeGroups;
        private int individualsOut;

        public Scenario(List<int[]> studentsRelations) {
            this.studentsRelations = studentsRelations;
            this.largeGroups = 0;
            this.individualsOut = 0;
        }

        public void calculateGroups() {
            Map<Integer, Set<Integer>> groups = new HashMap<>();
            for (int[] student : studentsRelations) {
                for (int i = 1; i < student.length; i++) {
                    groups.computeIfAbsent(student[0], k -> new HashSet<>()).add(student[i]);
                    groups.computeIfAbsent(student[i], k -> new HashSet<>()).add(student[0]);
                }
            }

            HashSet<Integer> visited = new HashSet<>();
            for (Integer student : groups.keySet()) {
                if (!visited.contains(student)) {
                    Set<Integer> group = new HashSet<>();
                    dfs(groups, student, visited, group);

                    if (group.size() >= 4) {
                        largeGroups++;
                    }
                    else {
                        individualsOut += group.size();
                    }
                }
            }
        }

        private void dfs(Map<Integer, Set<Integer>> graph, int node, Set<Integer> visited, Set<Integer> group) {
            visited.add(node);
            group.add(node);
            for (Integer neighbour : graph.get(node)) {
                if (!visited.contains(neighbour)) {
                    dfs(graph, neighbour, visited, group);
                }
            }
        }

        public int getLargeGroups() {
            return largeGroups;
        }

        public int getIndividualsOut() {
            return individualsOut;
        }
    }
}