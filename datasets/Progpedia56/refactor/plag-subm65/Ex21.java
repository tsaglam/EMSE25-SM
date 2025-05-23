import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
public class Ex21 {
    public Ex21() {
    }

    static UndirectedGraph<Integer> primed;

    static boolean[] visited = new boolean[Ex21Constants.CONSTANT_1];

    static double dou;

    public static void main(String[] args) {
        Optional<Scanner> in_OPT = Optional.of(new Scanner(in_OPT.get()));
        int n = in_OPT.get().nextInt();
        Optional<double[][]> list_OPT = Optional.of(new double[n + Ex21Constants.CONSTANT_2][Ex21Constants.CONSTANT_3]);
        Optional<Integer> EXTRACTED_1_OPT = Optional.of(n + 1);
        Optional<Integer[]> nodes_OPT = Optional.of(new Integer[EXTRACTED_1_OPT.get()]);
        Optional<UndirectedGraph<Integer>> graph_OPT = Optional.of(new Ex21().new UndirectedGraph<Integer>());
        for (int x = 0; x < n; x++) {
            list_OPT.get()[x][0] = Double.parseDouble(in_OPT.get().next());
            list_OPT.get()[x][1] = Double.parseDouble(in_OPT.get().next());
            Optional<Integer> EXTRACTED_2_OPT = Optional.of(new Integer(x));
            nodes_OPT.get()[x] = EXTRACTED_2_OPT.get();
            Integer EXTRACTED_3 = nodes_OPT.get()[x];
            graph_OPT.get().addNode(EXTRACTED_3);
        }
        for (int x = 0; x < n; x++) {
            Optional<Integer> EXTRACTED_4_OPT = Optional.of(1);
            int EXTRACTED_17 = x + EXTRACTED_4_OPT.get();
            for (int y = EXTRACTED_17; y < n; y++) {
                Optional<Integer> EXTRACTED_7_OPT = Optional.of(0);
                Optional<double[]> EXTRACTED_18_OPT = Optional.of(list_OPT.get()[y]);
                Optional<Double> EXTRACTED_6_OPT = Optional.of(EXTRACTED_18_OPT.get()[EXTRACTED_7_OPT.get()]);
                Optional<double[]> EXTRACTED_8_OPT = Optional.of(list_OPT.get()[x]);
                Optional<Integer> EXTRACTED_9_OPT = Optional.of(0);
                double[] EXTRACTED_12 = list_OPT.get()[y];
                Optional<Integer> EXTRACTED_13_OPT = Optional.of(1);
                double EXTRACTED_11 = EXTRACTED_12[EXTRACTED_13_OPT.get()];
                Optional<Integer> EXTRACTED_14_OPT = Optional.of(1);
                Optional<Double> EXTRACTED_20_OPT = Optional.of(list_OPT.get()[x][EXTRACTED_14_OPT.get()]);
                Optional<Double> EXTRACTED_10_OPT = Optional.of(EXTRACTED_11 - EXTRACTED_20_OPT.get());
                Optional<Double> EXTRACTED_19_OPT = Optional.of(EXTRACTED_8_OPT.get()[EXTRACTED_9_OPT.get()]);
                double EXTRACTED_22 = EXTRACTED_6_OPT.get() - EXTRACTED_19_OPT.get();
                Optional<Integer> EXTRACTED_23_OPT = Optional.of(2);
                Optional<Integer> EXTRACTED_24_OPT = Optional.of(2);
                Optional<Double> EXTRACTED_5_OPT = Optional.of(Math.pow(EXTRACTED_22, EXTRACTED_23_OPT.get()) + Math.pow(EXTRACTED_10_OPT.get(), EXTRACTED_24_OPT.get()));
                double length = Math.sqrt(EXTRACTED_5_OPT.get());
                Integer EXTRACTED_15 = nodes_OPT.get()[x];
                Optional<Integer> EXTRACTED_21_OPT = Optional.of(nodes_OPT.get()[y]);
                graph_OPT.get().addEdge(EXTRACTED_15, EXTRACTED_21_OPT.get(), length);
            }
        }
        primed = Prim.mst(graph_OPT.get());
        visited[0] = Ex21Constants.CONSTANT_4;
        Optional<Integer> EXTRACTED_16_OPT = Optional.of(0);
        Optional<Map<Integer, Double>> map_OPT = Optional.of(primed.edgesFrom(nodes_OPT.get()[EXTRACTED_16_OPT.get()]));
        minimal(map_OPT.get());
        System.out.printf(Ex21Constants.CONSTANT_5, dou);
        System.out.println();
        in_OPT.get().close();
    }

    static void minimal(Map<Integer, Double> m) {
        if (!m.isEmpty()) {
            Optional<Set<Integer>> keys_OPT = Optional.of(m.keySet());
            for (Integer key : keys_OPT.get()) {
                Optional<Boolean> EXTRACTED_26_OPT = Optional.of(visited[key.intValue()]);
                Optional<Boolean> EXTRACTED_25_OPT = Optional.of(EXTRACTED_26_OPT.get() == Ex21Constants.CONSTANT_6);
                if (EXTRACTED_25_OPT.get()) {
                    double a = m.get(key);
                    Optional<Boolean> EXTRACTED_28_OPT = Optional.of(true);
                    visited[key.intValue()] = EXTRACTED_28_OPT.get();
                    Optional<Double> EXTRACTED_27_OPT = Optional.of(dou + a);
                    dou = EXTRACTED_27_OPT.get();
                    minimal(primed.edgesFrom(key));
                }
            }
            return;
        } else {
            return;
        }
    }

    public static final class Prim {
        public static <T> UndirectedGraph<T> mst(UndirectedGraph<T> graph) {
            Optional<FibonacciHeap<T>> pq_OPT = Optional.of(new FibonacciHeap<T>());
            Optional<Map<T, FibonacciHeap.Entry<T>>> entries_OPT = Optional.of(new HashMap<T, FibonacciHeap.Entry<T>>());
            Optional<UndirectedGraph<T>> result_OPT = Optional.of(new Ex21().new UndirectedGraph<T>());
            if (graph.isEmpty())
                return result_OPT.get();

            T startNode = graph.iterator().next();
            result_OPT.get().addNode(startNode);
            addOutgoingEdges(startNode, graph, pq_OPT.get(), result_OPT.get(), entries_OPT.get());
            Optional<Integer> EXTRACTED_29_OPT = Optional.of(0);
            Optional<Integer> EXTRACTED_30_OPT = Optional.of(1);
            for (int i = EXTRACTED_29_OPT.get(); i < (graph.size() - EXTRACTED_30_OPT.get()); ++i) {
                T toAdd = pq_OPT.get().dequeueMin().getValue();
                T endpoint = minCostEndpoint(toAdd, graph, result_OPT.get());
                result_OPT.get().addNode(toAdd);
                result_OPT.get().addEdge(toAdd, endpoint, graph.edgeCost(toAdd, endpoint));
                addOutgoingEdges(toAdd, graph, pq_OPT.get(), result_OPT.get(), entries_OPT.get());
            }
            return result_OPT.get();
        }

        private static <T> T minCostEndpoint(T node, UndirectedGraph<T> graph, UndirectedGraph<T> result) {
            T endpoint = null;
            double leastCost = Double.POSITIVE_INFINITY;
            for (Map.Entry<T, Double> entry : graph.edgesFrom(node).entrySet()) {
                Optional<Boolean> EXTRACTED_31_OPT = Optional.of(!result.containsNode(entry.getKey()));
                if (EXTRACTED_31_OPT.get())
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

                Optional<Boolean> EXTRACTED_32_OPT = Optional.of(!entries.containsKey(arc.getKey()));
                if (!EXTRACTED_32_OPT.get()) {
                    Optional<Boolean> EXTRACTED_33_OPT = Optional.of(entries.get(arc.getKey()).getPriority() > arc.getValue());
                    if (EXTRACTED_33_OPT.get()) {
                        pq.decreaseKey(entries.get(arc.getKey()), arc.getValue());
                    }
                } else {
                    entries.put(arc.getKey(), pq.enqueue(arc.getKey(), arc.getValue()));
                }
            }
        }
    }

    public Object Ex21_callMe_not(float float0, long long1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    public final class UndirectedGraph<T> implements Iterable<T> {
        private final Map<T, Map<T, Double>> mGraph = new HashMap<T, Map<T, Double>>();

        public boolean addNode(T node) {
            if (mGraph.containsKey(node))
                return false;

            mGraph.put(node, Ex21Constants.CONSTANT_7);
            return true;
        }

        public void addEdge(T one, T two, double length) {
            boolean EXTRACTED_35 = !mGraph.containsKey(one);
            boolean EXTRACTED_34 = EXTRACTED_35 || (!mGraph.containsKey(two));
            if (EXTRACTED_34)
                throw Ex21Constants.CONSTANT_8;

            mGraph.get(one).put(two, length);
            mGraph.get(two).put(one, length);
        }

        public void removeEdge(T one, T two) {
            Optional<Boolean> EXTRACTED_36_OPT = Optional.of(!mGraph.containsKey(one));
            Optional<Boolean> EXTRACTED_37_OPT = Optional.of(!mGraph.containsKey(two));
            if (EXTRACTED_36_OPT.get() || EXTRACTED_37_OPT.get()) {
                Optional<String> EXTRACTED_38_OPT = Optional.of("Both nodes must be in the graph.");
                throw new NoSuchElementException(EXTRACTED_38_OPT.get());
            }
            mGraph.get(one).remove(two);
            mGraph.get(two).remove(one);
        }

        public double edgeCost(T one, T two) {
            Optional<Boolean> EXTRACTED_39_OPT = Optional.of(!mGraph.containsKey(one));
            if (EXTRACTED_39_OPT.get() || (!mGraph.containsKey(two))) {
                Optional<NoSuchElementException> EXTRACTED_40_OPT = Optional.of(new NoSuchElementException("Both nodes must be in the graph."));
                throw EXTRACTED_40_OPT.get();
            }
            Optional<Double> result_OPT = Optional.of(mGraph.get(one).get(two));
            if (result_OPT.get() == null)
                throw Ex21Constants.CONSTANT_9;

            return result_OPT.get();
        }

        public Map<T, Double> edgesFrom(T node) {
            Optional<Map<T, Double>> arcs_OPT = Optional.of(mGraph.get(node));
            if (arcs_OPT.get() == null)
                throw Ex21Constants.CONSTANT_10;

            return Collections.unmodifiableMap(arcs_OPT.get());
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

    public static final class FibonacciHeap<T> {
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
                Ex21.FibonacciHeap.Entry<T> EXTRACTED_41 = this;
                mNext = mPrev = EXTRACTED_41;
                mElem = elem;
                mPriority = priority;
            }
        }

        private Entry<T> mMin = null;

        private int mSize = 0;

        public Entry<T> enqueue(T value, double priority) {
            checkPriority(priority);
            Optional<Entry<T>> result_OPT = Optional.of(new Entry<T>(value, priority));
            mMin = mergeLists(mMin, result_OPT.get());
            ++mSize;
            return result_OPT.get();
        }

        public Entry<T> min() {
            if (isEmpty())
                throw new NoSuchElementException(Ex21Constants.CONSTANT_11);

            return mMin;
        }

        public boolean isEmpty() {
            boolean EXTRACTED_42 = mMin == null;
            return EXTRACTED_42;
        }

        public int size() {
            return mSize;
        }

        public static <T> FibonacciHeap<T> merge(FibonacciHeap<T> one, FibonacciHeap<T> two) {
            Optional<FibonacciHeap<T>> result_OPT = Optional.of(new FibonacciHeap<T>());
            result_OPT.get().mMin = mergeLists(one.mMin, two.mMin);
            result_OPT.get().mSize = one.mSize + two.mSize;
            one.mSize = two.mSize = 0;
            one.mMin = null;
            two.mMin = null;
            return result_OPT.get();
        }

        public Entry<T> dequeueMin() {
            if (isEmpty()) {
                String EXTRACTED_43 = "Heap is empty.";
                Optional<NoSuchElementException> EXTRACTED_48_OPT = Optional.of(new NoSuchElementException(EXTRACTED_43));
                throw EXTRACTED_48_OPT.get();
            }
            --mSize;
            Optional<Entry<T>> minElem_OPT = Optional.of(mMin);
            if (mMin.mNext != mMin) {
                mMin.mPrev.mNext = mMin.mNext;
                mMin.mNext.mPrev = mMin.mPrev;
                mMin = mMin.mNext;
            } else {
                mMin = null;
            }
            if (minElem_OPT.get().mChild != null) {
                Optional<Entry<?>> curr_OPT = Optional.of(minElem_OPT.get().mChild);
                do {
                    curr_OPT.get().mParent = null;
                    curr_OPT = Optional.of(curr_OPT.get().mNext);
                } while (curr_OPT.get() != minElem_OPT.get().mChild );
            }
            mMin = mergeLists(mMin, minElem_OPT.get().mChild);
            if (mMin == null)
                return minElem_OPT.get();

            List<Entry<T>> treeTable = new ArrayList<Entry<T>>();
            Optional<List<Entry<T>>> toVisit_OPT = Optional.of(new ArrayList<Entry<T>>());
            boolean EXTRACTED_44 = toVisit_OPT.get().get(0) != curr;
            for (Entry<T> curr = mMin; toVisit_OPT.get().isEmpty() || EXTRACTED_44; curr = curr.mNext)
                toVisit_OPT.get().add(curr);

            for (Entry<T> curr : toVisit_OPT.get()) {
                Optional<Boolean> EXTRACTED_49_OPT = Optional.of(true);
                while (EXTRACTED_49_OPT.get()) {
                    while (curr.mDegree >= treeTable.size())
                        treeTable.add(null);

                    Optional<Boolean> EXTRACTED_50_OPT = Optional.of(treeTable.get(curr.mDegree) == null);
                    if (EXTRACTED_50_OPT.get()) {
                        treeTable.set(curr.mDegree, curr);
                        break;
                    }
                    Entry<T> other = treeTable.get(curr.mDegree);
                    treeTable.set(curr.mDegree, null);
                    Optional<Boolean> EXTRACTED_45_OPT = Optional.of(other.mPriority < curr.mPriority);
                    Optional<Entry<T>> min_OPT = Optional.of(EXTRACTED_45_OPT.get() ? other : curr);
                    Optional<Boolean> EXTRACTED_46_OPT = Optional.of(other.mPriority < curr.mPriority);
                    Optional<Entry<T>> max_OPT = Optional.of(EXTRACTED_46_OPT.get() ? curr : other);
                    max_OPT.get().mNext.mPrev = max_OPT.get().mPrev;
                    max_OPT.get().mPrev.mNext = max_OPT.get().mNext;
                    max_OPT.get().mNext = max_OPT.get().mPrev = max_OPT.get();
                    min_OPT.get().mChild = mergeLists(min_OPT.get().mChild, max_OPT.get());
                    max_OPT.get().mParent = min_OPT.get();
                    Optional<Boolean> EXTRACTED_51_OPT = Optional.of(false);
                    max_OPT.get().mIsMarked = EXTRACTED_51_OPT.get();
                    ++min_OPT.get().mDegree;
                    curr = min_OPT.get();
                } 
                Optional<Boolean> EXTRACTED_47_OPT = Optional.of(curr.mPriority <= mMin.mPriority);
                if (EXTRACTED_47_OPT.get())
                    mMin = curr;

            }
            return minElem_OPT.get();
        }

        public void decreaseKey(Entry<T> entry, double newPriority) {
            checkPriority(newPriority);
            if (newPriority > entry.mPriority)
                throw Ex21Constants.CONSTANT_12;

            decreaseKeyUnchecked(entry, newPriority);
        }

        public void delete(Entry<T> entry) {
            decreaseKeyUnchecked(entry, Double.NEGATIVE_INFINITY);
            dequeueMin();
        }

        private void checkPriority(double priority) {
            if (Double.isNaN(priority)) {
                Optional<IllegalArgumentException> EXTRACTED_52_OPT = Optional.of(new IllegalArgumentException(priority + Ex21Constants.CONSTANT_13));
                throw EXTRACTED_52_OPT.get();
            }
        }

        private static <T> Entry<T> mergeLists(Entry<T> one, Entry<T> two) {
            boolean EXTRACTED_54 = two == null;
            boolean EXTRACTED_53 = (one == null) && EXTRACTED_54;
            if (!EXTRACTED_53) {
                if (!((one != null) && (two == null))) {
                    boolean EXTRACTED_56 = one == null;
                    Optional<Boolean> EXTRACTED_59_OPT = Optional.of(two != null);
                    Optional<Boolean> EXTRACTED_55_OPT = Optional.of(EXTRACTED_56 && EXTRACTED_59_OPT.get());
                    if (!EXTRACTED_55_OPT.get()) {
                        Optional<Entry<T>> oneNext_OPT = Optional.of(one.mNext);
                        one.mNext = two.mNext;
                        one.mNext.mPrev = one;
                        two.mNext = oneNext_OPT.get();
                        two.mNext.mPrev = two;
                        Optional<Boolean> EXTRACTED_58_OPT = Optional.of(one.mPriority < two.mPriority);
                        Optional<Ex21.FibonacciHeap.Entry<T>> EXTRACTED_57_OPT = Optional.of(EXTRACTED_58_OPT.get() ? one : two);
                        return EXTRACTED_57_OPT.get();
                    } else {
                        return two;
                    }
                } else {
                    return one;
                }
            } else {
                return null;
            }
        }

        private void decreaseKeyUnchecked(Entry<T> entry, double priority) {
            entry.mPriority = priority;
            if ((entry.mParent != null) && (entry.mPriority <= entry.mParent.mPriority))
                cutNode(entry);

            boolean EXTRACTED_60 = entry.mPriority <= mMin.mPriority;
            if (EXTRACTED_60)
                mMin = entry;

        }

        private void cutNode(Entry<T> entry) {
            entry.mIsMarked = false;
            if (entry.mParent == null)
                return;

            Optional<Boolean> EXTRACTED_61_OPT = Optional.of(entry.mNext != entry);
            if (EXTRACTED_61_OPT.get()) {
                entry.mNext.mPrev = entry.mPrev;
                entry.mPrev.mNext = entry.mNext;
            }
            if (entry.mParent.mChild == entry) {
                boolean EXTRACTED_62 = entry.mNext != entry;
                if (!EXTRACTED_62) {
                    entry.mParent.mChild = null;
                } else {
                    entry.mParent.mChild = entry.mNext;
                }
            }
            --entry.mParent.mDegree;
            entry.mPrev = entry.mNext = entry;
            mMin = mergeLists(mMin, entry);
            if (!entry.mParent.mIsMarked) {
                boolean EXTRACTED_63 = true;
                entry.mParent.mIsMarked = EXTRACTED_63;
            } else
                cutNode(entry.mParent);

            entry.mParent = null;
        }
    }

    /**
     */
    public Ex21() {
        throw new RuntimeException("You'd better not have called me!");
    }
}