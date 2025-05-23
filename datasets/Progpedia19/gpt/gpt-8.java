import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

class SociologyExperiment {

    private static ArrayList<HashSet<Integer>> groups = new ArrayList<>();
    private static HashMap<Integer, Integer> studentToGroupMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scenarios = scanner.nextInt();

        for (int scenario = 1; scenario <= scenarios; scenario++) {
            int studentsCount = scanner.nextInt();
            int[][] relationships = new int[studentsCount][];
            groups.clear();
            studentToGroupMap.clear();

            for (int i = 0; i < studentsCount; i++) {
                int student = scanner.nextInt() - 1; // array index adjustment
                int friendsCount = scanner.nextInt();
                relationships[student] = new int[friendsCount + 1];
                relationships[student][0] = student; // including self in the list
                for (int j = 1; j <= friendsCount; j++) {
                    relationships[student][j] = scanner.nextInt() - 1; // array index adjustment
                }
            }

            for (int[] relation : relationships) {
                HashSet<Integer> group = findOrCreateGroup(relation[0]);
                for (int friend : relation) {
                    if (studentToGroupMap.containsKey(friend)) {
                        if (studentToGroupMap.get(friend) != groups.indexOf(group)) {
                            mergeGroups(group, groups.get(studentToGroupMap.get(friend)));
                        }
                    } else {
                        group.add(friend);
                        studentToGroupMap.put(friend, groups.indexOf(group));
                    }
                }
            }

            int largeGroups = 0;
            int outliers = 0;
            for (HashSet<Integer> group : groups) {
                if (group.size() >= 4) {
                    largeGroups++;
                } else {
                    outliers += group.size();
                }
            }

            System.out.println("Caso #" + scenario);
            System.out.println(largeGroups + " " + outliers);
        }
    }

    private static HashSet<Integer> findOrCreateGroup(int student) {
        if (studentToGroupMap.containsKey(student)) {
            return groups.get(studentToGroupMap.get(student));
        } else {
            HashSet<Integer> newGroup = new HashSet<>();
            groups.add(newGroup);
            studentToGroupMap.put(student, groups.indexOf(newGroup));
            return newGroup;
        }
    }

    private static void mergeGroups(HashSet<Integer> group1, HashSet<Integer> group2) {
        if (group1 == group2) return;
        for (Integer member : group2) {
            group1.add(member);
            studentToGroupMap.put(member, groups.indexOf(group1));
        }
        groups.remove(group2);
    }
}