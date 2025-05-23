import java.io.*;
import java.util.*;
class GroupTest {
    static Scanner sc = new Scanner(System.in);
    static PrintWriter pw = new PrintWriter(System.out, true);
    static class Vertex {
        int friendCount, id, low;
        ArrayList<Integer> friends = new ArrayList<>();
        Vertex(int fc, ArrayList<Integer> fr) {
            friendCount = fc;
            friends.addAll(fr);
            id = -1;
            low = -1;
        }
    }
    static class Result {
        int scene, groupOf4, others;
        Result(int s) { scene = s; groupOf4 = 0; others = 0; }
        void addG4() { groupOf4++; }
        void addOther(int o) { others += o; }
    }
    static class Comp {
        Stack<Integer> comp = new Stack<>();
    }
    static class CustomStack {
        LinkedList<Integer> stk = new LinkedList<>();
        void push(int e) { stk.push(e); }
        int pop() { return stk.pop(); }
        int size() { return stk.size(); }
        boolean contains(int e) { return stk.contains(e); }
        boolean isEmpty() { return stk.isEmpty(); }
    }
    public static void main(String[] args) {
        int scnCount = sc.nextInt();
        for (int scn = 1; scn <= scnCount; scn++) {
            int studentCount = sc.nextInt();
            Vertex[] students = new Vertex[studentCount];
            for (int s = 0; s < studentCount; s++) {
                int vId = sc.nextInt() - 1;
                int fCount = sc.nextInt();
                ArrayList<Integer> frnds = new ArrayList<>();
                for (int f = 0; f < fCount; f++) frnds.add(sc.nextInt() - 1);
                students[vId] = new Vertex(fCount, frnds);
            }
            analyze(scn, students);
        }
    }
    static void analyze(int scn, Vertex[] students) {
        Result res = new Result(scn);
        boolean[] marked = new boolean[students.length];
        CustomStack stack = new CustomStack();
        ArrayList<Comp> comps = new ArrayList<>();
        for (int i = 0; i < students.length; i++) {
            if (!marked[i]) {
                explore(i, students, stack, comps, marked);
                res.addOther(stack.size());
                stack.stk.clear();
            }
        }
        pw.println("Scenario #" + res.scene + ": " + res.groupOf4 + ", " + res.others);
    }
    static void explore(int v, Vertex[] vertices, CustomStack stack, ArrayList<Comp> comps, boolean[] marked) {
        stack.push(v);
        marked[v] = true;
        for (int friend : vertices[v].friends) {
            if (!marked[friend]) explore(friend, vertices, stack, comps, marked);
        }
        Comp c = new Comp();
        c.comp.push(v);
        comps.add(c);
    }
}