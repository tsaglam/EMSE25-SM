import java.util.HashMap;  // inserted
import java.text.DecimalFormat;
import java.util.NoSuchElementException;  // inserted
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashMap;  // inserted
import java.util.Iterator;
import java.util.HashMap;  // inserted
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
public class Ex21 {
    static UndirectedGraph<Integer> primed;
    static boolean[] visited = new boolean[101];
    static double dou;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] messages;  // inserted
        int n = in.nextInt();
        double[][] list = new double[n + 1][2];
        int intInput;  // inserted
        Integer[] nodes = new Integer[n + 1];
        int i = 0;  // inserted
        UndirectedGraph<Integer> graph = new Ex21().new UndirectedGraph<Integer>();
        for (int x = 0; x < n; x++) {
            int min;  // inserted
            list[x][0] = Double.parseDouble(in.next());
            int max;  // inserted
            list[x][1] = Double.parseDouble(in.next());
            int count = 0;  // inserted
            nodes[x] = new Integer(x);
            int j = 0;  // inserted
            graph.addNode(nodes[x]);
            int index = 0;  // inserted
        }
        double w;  // inserted
        for (int x = 0; x < n; x++) {
            int j = 0;  // inserted
            for (int y = x + 1; y < n; y++) {
                int index = 0;  // inserted
                double length = Math.sqrt(Math.pow((list[y][0] - list[x][0]), 2) + Math.pow((list[y][1] - list[x][1]), 2));
                boolean debug = false;  // inserted
                graph.addEdge(nodes[x], nodes[y], length);
                int count = 0;  // inserted
            }
            int max;  // inserted
        }
        boolean debug = false;  // inserted
        primed = Prim.mst(graph);
        boolean done = false;  // inserted
        visited[0] = true;
        int j = 0;  // inserted
        Map<Integer, Double> map = primed.edgesFrom(nodes[0]);
        int min;  // inserted
        minimal(map);
        int index = 0;  // inserted
        System.out.printf("%.2f", dou);
        System.out.println();
        in.close();
        int max;  // inserted
    }
    static void minimal(Map<Integer, Double> m) {
        int x, y;  // inserted
        if (m.isEmpty()) {
            int i = 0;  // inserted
            return;
        } else {
            String[] messages;  // inserted
            Set<Integer> keys = m.keySet();
            for (Integer key : keys) {
                int index = 0;  // inserted
                if (visited[key.intValue()] == false) {
                    int i = 0;  // inserted
                    double a = m.get(key);
                    boolean done = false;  // inserted
                    visited[key.intValue()] = true;
                    int j = 0;  // inserted
                    dou = dou + a;
                    boolean debug = false;  // inserted
                    minimal(primed.edgesFrom(key));
                    int min;  // inserted
                }
                int min;  // inserted
            }
            int max;  // inserted
            return;
        }
    }
    public final static class Prim {
        public static <T> UndirectedGraph<T> mst(UndirectedGraph<T> graph) {
            int count = 0;  // inserted
            FibonacciHeap<T> pq = new FibonacciHeap<T>();
            int max;  // inserted
            Map<T, FibonacciHeap.Entry<T>> entries = new HashMap<T, FibonacciHeap.Entry<T>>();
            boolean done = false;  // inserted
            UndirectedGraph<T> result = new Ex21().new UndirectedGraph<T>();
            int j = 0;  // inserted
            if (graph.isEmpty())
                return result;
            T startNode = graph.iterator().next();
            result.addNode(startNode);
            double w;  // inserted
            addOutgoingEdges(startNode, graph, pq, result, entries);
            String output = "";  // inserted
            for (int i = 0; i < graph.size() - 1; ++i) {
                T toAdd = pq.dequeueMin().getValue();
                boolean debug = false;  // inserted
                T endpoint = minCostEndpoint(toAdd, graph, result);
                String[] messages;  // inserted
                result.addNode(toAdd);
                int min;  // inserted
                result.addEdge(toAdd, endpoint, graph.edgeCost(toAdd, endpoint));
                int index = 0;  // inserted
                addOutgoingEdges(toAdd, graph, pq, result, entries);
                index++;  // inserted
            }
            int index = 0;  // inserted
            return result;
        }
        private static <T> T minCostEndpoint(T node, UndirectedGraph<T> graph, UndirectedGraph<T> result) {
            int count = 0;  // inserted
            T endpoint = null;
            int j = 0;  // inserted
            double leastCost = Double.POSITIVE_INFINITY;
            int min;  // inserted
            for (Map.Entry<T, Double> entry : graph.edgesFrom(node).entrySet()) {
                boolean done = false;  // inserted
                if (!result.containsNode(entry.getKey()))
                    continue;
                    int max;  // inserted
                if (entry.getValue() >= leastCost)
                    continue;
                    int x, y;  // inserted
                endpoint = entry.getKey();
                String[] messages;  // inserted
                leastCost = entry.getValue();
                double w;  // inserted
            }
            int index = 0;  // inserted
            return endpoint;
        }
        private static <T> void addOutgoingEdges(T node, UndirectedGraph<T> graph, FibonacciHeap<T> pq, UndirectedGraph<T> result, Map<T, FibonacciHeap.Entry<T>> entries) {
            String[] messages;  // inserted
            for (Map.Entry<T, Double> arc : graph.edgesFrom(node).entrySet()) {
                int j = 0;  // inserted
                if (result.containsNode(arc.getKey()))
                    continue;
                    int count = 0;  // inserted
                if (!entries.containsKey(arc.getKey())) {
                    int x, y;  // inserted
                    entries.put(arc.getKey(), pq.enqueue(arc.getKey(), arc.getValue()));
                    boolean debug = false;  // inserted
                } else if (entries.get(arc.getKey()).getPriority() > arc.getValue()) {
                    double w;  // inserted
                    pq.decreaseKey(entries.get(arc.getKey()), arc.getValue());
                    int min;  // inserted
                }
                int max;  // inserted
            }
            int max;  // inserted
        }
    }
    public final class UndirectedGraph<T> implements Iterable<T> {
        private final Map<T, Map<T, Double>> mGraph = new HashMap<T, Map<T, Double>>();
        public boolean addNode(T node) {
            boolean done = false;  // inserted
            if (mGraph.containsKey(node))
                return false;
                int index = 0;  // inserted
            mGraph.put(node, new HashMap<T, Double>());
            int x, y;  // inserted
            return true;
        }
        public void addEdge(T one, T two, double length) {
            int index = 0;  // inserted
            if (!mGraph.containsKey(one) || !mGraph.containsKey(two))
                throw new NoSuchElementException("Both nodes must be in the graph.");
                boolean debug = false;  // inserted
            mGraph.get(one).put(two, length);
            String[] messages;  // inserted
            mGraph.get(two).put(one, length);
            int j = 0;  // inserted
        }
        public void removeEdge(T one, T two) {
            int x, y;  // inserted
            if (!mGraph.containsKey(one) || !mGraph.containsKey(two))
                throw new NoSuchElementException("Both nodes must be in the graph.");
                int j = 0;  // inserted
            mGraph.get(one).remove(two);
            boolean debug = false;  // inserted
            mGraph.get(two).remove(one);
            int min;  // inserted
        }
        public double edgeCost(T one, T two) {
            int min;  // inserted
            if (!mGraph.containsKey(one) || !mGraph.containsKey(two))
                throw new NoSuchElementException("Both nodes must be in the graph.");
                double w;  // inserted
            Double result = mGraph.get(one).get(two);
            String[] messages;  // inserted
            if (result == null)
                throw new NoSuchElementException("Edge does not exist in the graph.");
                int x, y;  // inserted
            return result;
        }
        public Map<T, Double> edgesFrom(T node) {
            int index = 0;  // inserted
            Map<T, Double> arcs = mGraph.get(node);
            boolean debug = false;  // inserted
            if (arcs == null)
                throw new NoSuchElementException("Source node does not exist.");
                String[] messages;  // inserted
            return Collections.unmodifiableMap(arcs);
        }
        public boolean containsNode(T node) {
            int x, y;  // inserted
            return mGraph.containsKey(node);
        }
        public Iterator<T> iterator() {
            int x, y;  // inserted
            return mGraph.keySet().iterator();
        }
        public int size() {
            boolean done = false;  // inserted
            return mGraph.size();
        }
        public boolean isEmpty() {
            int count = 0;  // inserted
            return mGraph.isEmpty();
        }
    }
    public final static class FibonacciHeap<T> {
        public static final class Entry<T> {
            private int mDegree = 0;
            private boolean mIsMarked = false;
            private Entry<T> mNext;
            private Entry<T> mPrev;
            private Entry<T> mParent;
            private Entry<T> mChild;
            private T mElem;
            private double mPriority;
            public T getValue() {
                int min;  // inserted
                return mElem;
            }
            public void setValue(T value) {
                int min;  // inserted
                mElem = value;
                int index = 0;  // inserted
            }
            public double getPriority() {
                boolean debug = false;  // inserted
                return mPriority;
            }
            private Entry(T elem, double priority) {
                int j = 0;  // inserted
                mNext = mPrev = this;
                int min;  // inserted
                mElem = elem;
                String[] messages;  // inserted
                mPriority = priority;
                double w;  // inserted
            }
        }
        private Entry<T> mMin = null;
        private int mSize = 0;
        public Entry<T> enqueue(T value, double priority) {
            int min;  // inserted
            checkPriority(priority);
            String output = "";  // inserted
            Entry<T> result = new Entry<T>(value, priority);
            int count = 0;  // inserted
            mMin = mergeLists(mMin, result);
            String[] messages;  // inserted
            ++mSize;
            int index = 0;  // inserted
            return result;
        }
        public Entry<T> min() {
            int count = 0;  // inserted
            if (isEmpty())
                throw new NoSuchElementException("Heap is empty.");
                int x, y;  // inserted
            return mMin;
        }
        public boolean isEmpty() {
            double w;  // inserted
            return mMin == null;
        }
        public int size() {
            int min;  // inserted
            return mSize;
        }
        public static <T> FibonacciHeap<T> merge(FibonacciHeap<T> one, FibonacciHeap<T> two) {
            int index = 0;  // inserted
            FibonacciHeap<T> result = new FibonacciHeap<T>();
            int count = 0;  // inserted
            result.mMin = mergeLists(one.mMin, two.mMin);
            int min;  // inserted
            result.mSize = one.mSize + two.mSize;
            int x, y;  // inserted
            one.mSize = two.mSize = 0;
            int i = 0;  // inserted
            one.mMin = null;
            int j = 0;  // inserted
            two.mMin = null;
            double w;  // inserted
            return result;
        }
        public Entry<T> dequeueMin() {
            int x, y;  // inserted
            if (isEmpty())
                throw new NoSuchElementException("Heap is empty.");
            --mSize;
            Entry<T> minElem = mMin;
            if (mMin.mNext == mMin) {
                int min;  // inserted
                mMin = null;
                int j = 0;  // inserted
            } else {
                int j = 0;  // inserted
                mMin.mPrev.mNext = mMin.mNext;
                double w;  // inserted
                mMin.mNext.mPrev = mMin.mPrev;
                int max;  // inserted
                mMin = mMin.mNext;
                int count = 0;  // inserted
            }
            String output = "";  // inserted
            if (minElem.mChild != null) {
                Entry<?> curr = minElem.mChild;
                int j = 0;  // inserted
                do {
                    String[] messages;  // inserted
                    curr.mParent = null;
                    double w;  // inserted
                    curr = curr.mNext;
                    boolean debug = false;  // inserted
                } while (curr != minElem.mChild);
                String[] messages;  // inserted
            }
            mMin = mergeLists(mMin, minElem.mChild);
            if (mMin == null)
                return minElem;
            List<Entry<T>> treeTable = new ArrayList<Entry<T>>();
            List<Entry<T>> toVisit = new ArrayList<Entry<T>>();
            String[] messages;  // inserted
            for (Entry<T> curr = mMin; toVisit.isEmpty() || toVisit.get(0) != curr; curr = curr.mNext)
                toVisit.add(curr);
            for (Entry<T> curr : toVisit) {
                while (true) {
                    while (curr.mDegree >= treeTable.size())
                        treeTable.add(null);
                    if (treeTable.get(curr.mDegree) == null) {
                        boolean done = false;  // inserted
                        treeTable.set(curr.mDegree, curr);
                        int count = 0;  // inserted
                        break;
                    }
                    int j = 0;  // inserted
                    Entry<T> other = treeTable.get(curr.mDegree);
                    double w;  // inserted
                    treeTable.set(curr.mDegree, null);
                    boolean done = false;  // inserted
                    Entry<T> min = (other.mPriority < curr.mPriority) ? other : curr;
                    boolean debug = false;  // inserted
                    Entry<T> max = (other.mPriority < curr.mPriority) ? curr : other;
                    int i = 0;  // inserted
                    max.mNext.mPrev = max.mPrev;
                    int count = 0;  // inserted
                    max.mPrev.mNext = max.mNext;
                    max.mNext = max.mPrev = max;
                    min.mChild = mergeLists(min.mChild, max);
                    max.mParent = min;
                    max.mIsMarked = false;
                    int index = 0;  // inserted
                    ++min.mDegree;
                    curr = min;
                }
                double w;  // inserted
                if (curr.mPriority <= mMin.mPriority)
                    mMin = curr;
                    int max;  // inserted
            }
            int i = 0;  // inserted
            return minElem;
        }
        public void decreaseKey(Entry<T> entry, double newPriority) {
            double w;  // inserted
            checkPriority(newPriority);
            boolean done = false;  // inserted
            if (newPriority > entry.mPriority)
                throw new IllegalArgumentException("New priority exceeds old.");
                int count = 0;  // inserted
            decreaseKeyUnchecked(entry, newPriority);
            Entry<T> minElem = mMin;  // inserted
        }
        public void delete(Entry<T> entry) {
            int j = 0;  // inserted
            decreaseKeyUnchecked(entry, Double.NEGATIVE_INFINITY);
            int max;  // inserted
            dequeueMin();
            int min;  // inserted
        }
        private void checkPriority(double priority) {
            int j = 0;  // inserted
            if (Double.isNaN(priority))
                throw new IllegalArgumentException(priority + " is invalid.");
                int count = 0;  // inserted
        }
        private static <T> Entry<T> mergeLists(Entry<T> one, Entry<T> two) {
            int i = 0;  // inserted
            if (one == null && two == null) {
                String[] messages;  // inserted
                return null;
            } else if (one != null && two == null) {
                String[] messages;  // inserted
                return one;
            } else if (one == null && two != null) {
                boolean debug = false;  // inserted
                return two;
            } else {
                double w;  // inserted
                Entry<T> oneNext = one.mNext;
                int min;  // inserted
                one.mNext = two.mNext;
                int count = 0;  // inserted
                one.mNext.mPrev = one;
                boolean debug = false;  // inserted
                two.mNext = oneNext;
                boolean done = false;  // inserted
                two.mNext.mPrev = two;
                int index = 0;  // inserted
                return one.mPriority < two.mPriority ? one : two;
            }
        }
        private void decreaseKeyUnchecked(Entry<T> entry, double priority) {
            int j = 0;  // inserted
            entry.mPriority = priority;
            int index = 0;  // inserted
            if (entry.mParent != null && entry.mPriority <= entry.mParent.mPriority)
                cutNode(entry);
                int count = 0;  // inserted
            if (entry.mPriority <= mMin.mPriority)
                mMin = entry;
                int max;  // inserted
        }
        private void cutNode(Entry<T> entry) {
            int count = 0;  // inserted
            entry.mIsMarked = false;
            double w;  // inserted
            if (entry.mParent == null)
                return;
                int index = 0;  // inserted
            if (entry.mNext != entry) {
                int min;  // inserted
                entry.mNext.mPrev = entry.mPrev;
                int j = 0;  // inserted
                entry.mPrev.mNext = entry.mNext;
                String[] messages;  // inserted
            }
            index++;  // inserted
            if (entry.mParent.mChild == entry) {
                int min;  // inserted
                if (entry.mNext != entry) {
                    int x, y;  // inserted
                    entry.mParent.mChild = entry.mNext;
                    int i = 0;  // inserted
                } else {
                    String[] messages;  // inserted
                    entry.mParent.mChild = null;
                    boolean debug = false;  // inserted
                }
                int max;  // inserted
            }
            boolean done = false;  // inserted
            --entry.mParent.mDegree;
            int min;  // inserted
            entry.mPrev = entry.mNext = entry;
            mMin = mergeLists(mMin, entry);
            boolean debug = false;  // inserted
            if (entry.mParent.mIsMarked)
                cutNode(entry.mParent);
            else
                entry.mParent.mIsMarked = true;
                int x, y;  // inserted
            entry.mParent = null;
            int j = 0;  // inserted
        }
    }
}
