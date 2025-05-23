import java.util.*;

class SociologyExperiment {

    private static List<Set<Integer>> groups = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scenarios = scanner.nextInt(); // Number of scenarios

        for (int scenario = 1; scenario <= scenarios; scenario++) {
            int students = scanner.nextInt(); // Number of students
            List<List<Integer>> relations = new ArrayList<>();
            for (int i = 0; i < students; i++) {
                int studentId = scanner.nextInt() - 1;
                int count = scanner.nextInt();
                List<Integer> list = new ArrayList<>();
                list.add(studentId);
                for (int j = 0; j < count; j++) {
                    list.add(scanner.nextInt() - 1);
                }
                relations.add(list);
            }
            
            findGroups(relations);
            int largeGroups = 0;
            int peopleOutside = students;

            for (Set<Integer> group : groups) {
                if (group.size() >= 4) {
                    largeGroups++;
                    peopleOutside -= group.size();
                }
            }
            
            System.out.println("Caso #" + scenario);
            System.out.println(largeGroups + " " + peopleOutside);
            groups.clear(); // Clear groups for the next scenario
        }
        scanner.close();
    }
    
    private static void findGroups(List<List<Integer>> relations) {
        for (List<Integer> relation : relations) {
            boolean isNewGroup = true;
            Set<Integer> newGroup = new HashSet<>(relation);
            for (Set<Integer> group : groups) {
                // If the new relation has any common member with an existing group, merge them.
                if (!Collections.disjoint(group, newGroup)) {
                    group.addAll(newGroup);
                    isNewGroup = false;
                    break;
                }
            }
            // If the relation does not fit into any existing group, create a new one.
            if (isNewGroup) {
                groups.add(newGroup);
            } else {
                // After merging, check for overlaps between groups and merge them too.
                mergeOverlappingGroups();
            }
        }
    }
    
    private static void mergeOverlappingGroups() {
        boolean merged = true;
        while (merged) {
            merged = false;
            for (int i = 0; i < groups.size(); i++) {
                for (int j = i + 1; j < groups.size(); j++) {
                    if (!Collections.disjoint(groups.get(i), groups.get(j))) {
                        groups.get(i).addAll(groups.get(j));
                        groups.remove(j);
                        merged = true;
                        break;
                    }
                }
                if (merged) {
                    break;
                }
            }
        }
    }
}