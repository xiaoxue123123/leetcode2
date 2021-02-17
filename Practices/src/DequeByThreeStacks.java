import java.util.Deque;
import java.util.ArrayDeque;
import java.util.LinkedList;

public class DequeByThreeStacks {
    private Deque<Integer> s1;
    private Deque<Integer> s2;
    private Deque<Integer> s3;

    public DequeByThreeStacks() {
        // Write your solution here.
        s1 = new LinkedList<>();
        s2 = new LinkedList<>();
        s3 = new LinkedList<>();
    }

    public void offerFirst(int element) {
        s1.offerFirst(element);
    }

    public void offerLast(int element) {
        s3.offerFirst(element);
    }

    public Integer pollFirst() {
        if (s1.isEmpty()) {
            while (!s3.isEmpty()) {
                s2.offerFirst(s3.pollFirst());
            }
            return s2.pollFirst();
        }
        return s1.pollFirst();
    }

    public Integer pollLast() {
        if (s3.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.offerFirst(s1.pollFirst());
            }
            return s2.pollFirst();
        }
        return s3.pollFirst();
    }

    public Integer peekFirst() {
        Integer first = pollFirst();
        if (first == null) {
            return null;
        }
        s1.offerFirst(first);
        return first;
    }

    public Integer peekLast() {
        Integer last = pollLast();
        if (last == null) {
            return null;
        }
        s3.offerFirst(last);
        return last;
    }

    public int size() {
        return s1.size() + s2.size() + s3.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public static void main(String[] args) {
        DequeByThreeStacks solution = new DequeByThreeStacks();
        solution.offerLast(217);
        solution.peekFirst();
        solution.offerFirst(188);
        solution.pollLast();
        solution.isEmpty();
        solution.offerLast(77);
        solution.offerLast(234);
        solution.peekLast();
        solution.pollFirst();
    }
}
