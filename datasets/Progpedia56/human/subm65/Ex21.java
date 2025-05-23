import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
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
        int n = in.nextInt();
        double[][] list = new double[n + 1][2];
        Integer[] nodes = new Integer[n + 1];
        UndirectedGraph<Integer> graph = new Ex21().new UndirectedGraph<Integer>();
        for (int x = 0; x < n; x++) {
            list[x][0] = Double.parseDouble(in.next());
            list[x][1] = Double.parseDouble(in.next());
            nodes[x] = new Integer(x);
            graph.addNode(nodes[x]);
        }
        for (int x = 0; x < n; x++) {
            for (int y = x + 1; y < n; y++) {
                double length = Math.sqrt(Math.pow((list[y][0] - list[x][0]), 2) + Math.pow((list[y][1] - list[x][1]), 2));
                graph.addEdge(nodes[x], nodes[y], length);
            }
        }
        primed = Prim.mst(graph);
        visited[0] = true;
        Map<Integer, Double> map = primed.edgesFrom(nodes[0]);
        minimal(map);
        System.out.printf("%.2f", dou);
        System.out.println();
        in.close();
    }
    static void minimal(Map<Integer, Double> m) {
        if (m.isEmpty()) {
            return;
        } else {
            Set<Integer> keys = m.keySet();
            for (Integer key : keys) {
                if (visited[key.intValue()] == false) {
                    double a = m.get(key);
                    visited[key.intValue()] = true;
                    dou = dou + a;
                    minimal(primed.edgesFrom(key));
                }
            }
            return;
        }
    }
    public final static class Prim {
        public static <T> UndirectedGraph<T> mst(UndirectedGraph<T> graph) {
            FibonacciHeap<T> pq = new FibonacciHeap<T>();
            Map<T, FibonacciHeap.Entry<T>> entries = new HashMap<T, FibonacciHeap.Entry<T>>();
            UndirectedGraph<T> result = new Ex21().new UndirectedGraph<T>();
            if (graph.isEmpty())
                return result;
            T startNode = graph.iterator().next();
            result.addNode(startNode);
            addOutgoingEdges(startNode, graph, pq, result, entries);
            for (int i = 0; i < graph.size() - 1; ++i) {
                T toAdd = pq.dequeueMin().getValue();
                T endpoint = minCostEndpoint(toAdd, graph, result);
                result.addNode(toAdd);
                result.addEdge(toAdd, endpoint, graph.edgeCost(toAdd, endpoint));
                addOutgoingEdges(toAdd, graph, pq, result, entries);
            }
            return result;
        }
        private static <T> T minCostEndpoint(T node, UndirectedGraph<T> graph, UndirectedGraph<T> result) {
            T endpoint = null;
            double leastCost = Double.POSITIVE_INFINITY;
            for (Map.Entry<T, Double> entry : graph.edgesFrom(node).entrySet()) {
                if (!result.containsNode(entry.getKey()))
                    continue;
                if (entry.getValue() >= leastCost)
                    continue;
                endpoint = entry.getKey();
                leastCost = entry.getValue();
            }
            return endpoint;
        }
        private static <T> void addOutgoingEdges(T node, UndirectedGraph<T> graph, FibonacciHeap<T> pq, UndirectedGraph<T> result, Map<T, FibonacciHeap.Entry<T>> entries) {
            for (Map.Entry<T, Double> arc : graph.edgesFrom(node).entrySet()) {
                if (result.containsNode(arc.getKey()))
                    continue;
                if (!entries.containsKey(arc.getKey())) {
                    entries.put(arc.getKey(), pq.enqueue(arc.getKey(), arc.getValue()));
                } else if (entries.get(arc.getKey()).getPriority() > arc.getValue()) {
                    pq.decreaseKey(entries.get(arc.getKey()), arc.getValue());
                }
            }
        }
    }
    public final class UndirectedGraph<T> implements Iterable<T> {
        private final Map<T, Map<T, Double>> mGraph = new HashMap<T, Map<T, Double>>();
        public boolean addNode(T node) {
            if (mGraph.containsKey(node))
                return false;
            mGraph.put(node, new HashMap<T, Double>());
            return true;
        }
        public void addEdge(T one, T two, double length) {
            if (!mGraph.containsKey(one) || !mGraph.containsKey(two))
                throw new NoSuchElementException("Both nodes must be in the graph.");
            mGraph.get(one).put(two, length);
            mGraph.get(two).put(one, length);
        }
        public void removeEdge(T one, T two) {
            if (!mGraph.containsKey(one) || !mGraph.containsKey(two))
                throw new NoSuchElementException("Both nodes must be in the graph.");
            mGraph.get(one).remove(two);
            mGraph.get(two).remove(one);
        }
        public double edgeCost(T one, T two) {
            if (!mGraph.containsKey(one) || !mGraph.containsKey(two))
                throw new NoSuchElementException("Both nodes must be in the graph.");
            Double result = mGraph.get(one).get(two);
            if (result == null)
                throw new NoSuchElementException("Edge does not exist in the graph.");
            return result;
        }
        public Map<T, Double> edgesFrom(T node) {
            Map<T, Double> arcs = mGraph.get(node);
            if (arcs == null)
                throw new NoSuchElementException("Source node does not exist.");
            return Collections.unmodifiableMap(arcs);
        }
        public boolean containsNode(T node) {
            return mGraph.containsKey(node);
        }
        public Iterator<T> iterator() {
            return mGraph.keySet().iterator();
        }
        public int size() {
            return mGraph.size();
        }
        public boolean isEmpty() {
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
                return mElem;
            }
            public void setValue(T value) {
                mElem = value;
            }
            public double getPriority() {
                return mPriority;
            }
            private Entry(T elem, double priority) {
                mNext = mPrev = this;
                mElem = elem;
                mPriority = priority;
            }
        }
        private Entry<T> mMin = null;
        private int mSize = 0;
        public Entry<T> enqueue(T value, double priority) {
            checkPriority(priority);
            Entry<T> result = new Entry<T>(value, priority);
            mMin = mergeLists(mMin, result);
            ++mSize;
            return result;
        }
        public Entry<T> min() {
            if (isEmpty())
                throw new NoSuchElementException("Heap is empty.");
            return mMin;
        }
        public boolean isEmpty() {
            return mMin == null;
        }
        public int size() {
            return mSize;
        }
        public static <T> FibonacciHeap<T> merge(FibonacciHeap<T> one, FibonacciHeap<T> two) {
            FibonacciHeap<T> result = new FibonacciHeap<T>();
            result.mMin = mergeLists(one.mMin, two.mMin);
            result.mSize = one.mSize + two.mSize;
            one.mSize = two.mSize = 0;
            one.mMin = null;
            two.mMin = null;
            return result;
        }
        public Entry<T> dequeueMin() {
            if (isEmpty())
                throw new NoSuchElementException("Heap is empty.");
            --mSize;
            Entry<T> minElem = mMin;
            if (mMin.mNext == mMin) {
                mMin = null;
            } else {
                mMin.mPrev.mNext = mMin.mNext;
                mMin.mNext.mPrev = mMin.mPrev;
                mMin = mMin.mNext;
            }
            if (minElem.mChild != null) {
                Entry<?> curr = minElem.mChild;
                do {
                    curr.mParent = null;
                    curr = curr.mNext;
                } while (curr != minElem.mChild);
            }
            mMin = mergeLists(mMin, minElem.mChild);
            if (mMin == null)
                return minElem;
            List<Entry<T>> treeTable = new ArrayList<Entry<T>>();
            List<Entry<T>> toVisit = new ArrayList<Entry<T>>();
            for (Entry<T> curr = mMin; toVisit.isEmpty() || toVisit.get(0) != curr; curr = curr.mNext)
                toVisit.add(curr);
            for (Entry<T> curr : toVisit) {
                while (true) {
                    while (curr.mDegree >= treeTable.size())
                        treeTable.add(null);
                    if (treeTable.get(curr.mDegree) == null) {
                        treeTable.set(curr.mDegree, curr);
                        break;
                    }
                    Entry<T> other = treeTable.get(curr.mDegree);
                    treeTable.set(curr.mDegree, null);
                    Entry<T> min = (other.mPriority < curr.mPriority) ? other : curr;
                    Entry<T> max = (other.mPriority < curr.mPriority) ? curr : other;
                    max.mNext.mPrev = max.mPrev;
                    max.mPrev.mNext = max.mNext;
                    max.mNext = max.mPrev = max;
                    min.mChild = mergeLists(min.mChild, max);
                    max.mParent = min;
                    max.mIsMarked = false;
                    ++min.mDegree;
                    curr = min;
                }
                if (curr.mPriority <= mMin.mPriority)
                    mMin = curr;
            }
            return minElem;
        }
        public void decreaseKey(Entry<T> entry, double newPriority) {
            checkPriority(newPriority);
            if (newPriority > entry.mPriority)
                throw new IllegalArgumentException("New priority exceeds old.");
            decreaseKeyUnchecked(entry, newPriority);
        }
        public void delete(Entry<T> entry) {
            decreaseKeyUnchecked(entry, Double.NEGATIVE_INFINITY);
            dequeueMin();
        }
        private void checkPriority(double priority) {
            if (Double.isNaN(priority))
                throw new IllegalArgumentException(priority + " is invalid.");
        }
        private static <T> Entry<T> mergeLists(Entry<T> one, Entry<T> two) {
            if (one == null && two == null) {
                return null;
            } else if (one != null && two == null) {
                return one;
            } else if (one == null && two != null) {
                return two;
            } else {
                Entry<T> oneNext = one.mNext;
                one.mNext = two.mNext;
                one.mNext.mPrev = one;
                two.mNext = oneNext;
                two.mNext.mPrev = two;
                return one.mPriority < two.mPriority ? one : two;
            }
        }
        private void decreaseKeyUnchecked(Entry<T> entry, double priority) {
            entry.mPriority = priority;
            if (entry.mParent != null && entry.mPriority <= entry.mParent.mPriority)
                cutNode(entry);
            if (entry.mPriority <= mMin.mPriority)
                mMin = entry;
        }
        private void cutNode(Entry<T> entry) {
            entry.mIsMarked = false;
            if (entry.mParent == null)
                return;
            if (entry.mNext != entry) {
                entry.mNext.mPrev = entry.mPrev;
                entry.mPrev.mNext = entry.mNext;
            }
            if (entry.mParent.mChild == entry) {
                if (entry.mNext != entry) {
                    entry.mParent.mChild = entry.mNext;
                } else {
                    entry.mParent.mChild = null;
                }
            }
            --entry.mParent.mDegree;
            entry.mPrev = entry.mNext = entry;
            mMin = mergeLists(mMin, entry);
            if (entry.mParent.mIsMarked)
                cutNode(entry.mParent);
            else
                entry.mParent.mIsMarked = true;
            entry.mParent = null;
        }
    }
}
