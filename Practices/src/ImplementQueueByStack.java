import java.util.Deque;
import java.util.LinkedList;

public class ImplementQueueByStack {
        private Deque<Integer> s1;
        private Deque<Integer> s2;

        public ImplementQueueByStack() {
            // Write your solution here.
            s1 = new LinkedList<>();
            s2 = new LinkedList<>();
            //int size = 0;
        }

        public Integer poll() {
            if (s1.size() >= 1) {
                for (int i = 0;i < s1.size() - 1;i++) {
                    s2.offerFirst(s1.pollFirst());
                }
                int ret = s1.pollFirst();
                for (int i = 0;i < s2.size(); i++) {
                    s1.offerFirst(s2.pollFirst());
                }
                return ret;
            } else {
                return null;
            }

        }

        public void offer(int element) {
            s1.offerFirst(element);
        }

        public Integer peek() {
            if (s1.isEmpty()) {
                return null;
            } else {
                for (int i = 0;i < s1.size() - 1;i++) {
                    s2.offerFirst(s1.pollFirst());
                }
                int ret = s1.peekFirst();
                for (int i = 0;i < s2.size(); i++) {
                    s1.offerFirst(s2.pollFirst());
                }
                return ret;
            }
        }

        public int size() {
            return s1.size();
        }

        public boolean isEmpty() {
            return s1.isEmpty();
        }


        public static void main(String[] args) {
            ImplementQueueByStack solution = new ImplementQueueByStack();
            solution.offer(2);
            solution.offer(5);
            System.out.println(solution.peek());
            solution.offer(1);
            System.out.println(solution.poll());

        }


}
