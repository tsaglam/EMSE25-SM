import java.io.*;
import java.util.*;

class GroupChecker {
    static class Vertex {
        int friendCount;
        int[] friends;
        int index = -1;
        int lowLink = -1;

        Vertex(int numberOfFriends, int[] friendsList) {
            this.friendCount = numberOfFriends;
            this.friends = friendsList;
        }

        int getFriendCount() {
            return friendCount;
        }

        int getFriend(int index) {
            return friends[index];
        }

        void setIndex(int index) {
            this.index = index;
        }

        int getIndex() {
            return index;
        }

        void setLowLink(int lowLink) {
            this.lowLink = lowLink;
        }

        int getLowLink() {
            return lowLink;
        }

        boolean hasFriend(int friendID) {
            for (int friend : friends) {
                if (friend == friendID) return true;
            }
            return false;
        }
    }

    static class AnalysisResult {
        int scenario;
        int groupOfFourCount;
        int otherElementsCount;
        AnalysisResult next;

        AnalysisResult(int scenario, int groupOfFourCount, int otherElementsCount) {
            this.scenario = scenario;
            this.groupOfFourCount = groupOfFourCount;
            this.otherElementsCount = otherElementsCount;
        }

        AnalysisResult next() {
            return next;
        }

        void linkNext(AnalysisResult result) {
            this.next = result;
        }

        void incrementGroupOfFour() {
            groupOfFourCount++;
        }

        void addOtherElements(int count) {
            otherElementsCount += count;
        }
    }

    static class ResultsList {
        AnalysisResult head;
        AnalysisResult tail;

        void addResult(AnalysisResult result) {
            if (head == null) {
                head = tail = result;
            } else {
                tail.linkNext(result);
                tail = result;
            }
        }
    }

    static class ComponentsList {
        StronglyConnectedComponent head, tail;

        void addComponent(StronglyConnectedComponent scc) {
            if (head == null) {
                head = tail = scc;
            } else {
                tail.next(scc);
                tail = scc;
            }
        }

        StronglyConnectedComponent getFirst() {
            return head;
        }
    }

    static class StronglyConnectedComponent {
        CustomStack component;
        StronglyConnectedComponent next;

        StronglyConnectedComponent(CustomStack componentStack) {
            this.component = componentStack;
        }

        void next(StronglyConnectedComponent nextComponent) {
            this.next = nextComponent;
        }

        CustomStack getComponent() {
            return component;
        }

        StronglyConnectedComponent getNext() {
            return next;
        }
    }

    static class CustomStack {
        int size = 0;
        StackNode top;

        void push(int value) {
            StackNode newNode = new StackNode(value);
            newNode.next(top);
            top = newNode;
            size++;
        }

        int pop() {
            if (top == null) throw new EmptyStackException();
            int value = top.getValue();
            top = top.next();
            size--;
            return value;
        }

        boolean contains(int value) {
            for (StackNode node = top; node != null; node = node.next()) {
                if (node.getValue() == value) return true;
            }
            return false;
        }

        int[] getElements() {
            int[] elements = new int[size];
            int i = size - 1;
            for (StackNode node = top; node != null; node = node.next(), i--) {
                elements[i] = node.getValue();
            }
            return elements;
        }

        int getSize() {
            return size;
        }

        boolean isEmpty() {
            return size == 0;
        }

        CustomStack retrieveStackUntil(int value) {
            CustomStack resultStack = new CustomStack();
            int val;
            do {
                val = this.pop();
                resultStack.push(val);
            } while (val != value && !this.isEmpty());
            return resultStack;
        }
    }

    static class StackNode {
        private final int value;
        private StackNode next;

        StackNode(int value) {
            this.value = value;
        }

        void next(StackNode nextNode) {
            this.next = nextNode;
        }

        int getValue() {
            return value;
        }

        StackNode next() {
            return next;
        }
    }

    public static void main(String[] args) {
        PrintWriter printWriter = new PrintWriter(System.out, true);
        Scanner scanner = new Scanner(System.in);
        // Implementation for the logic to process input and display output
    }

    // Further implementation of utility and processing methods
}