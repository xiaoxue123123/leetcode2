import java.util.*;

public class StackWithMin {

        private Deque<Integer> stack;
        private int min;
        public StackWithMin() {
            // write your solution here
            stack = new LinkedList<>();
            min = 100000;
        }

        public int pop() {
            if (stack.isEmpty()) {
                return -1;
            }
            int poped = stack.pollFirst();
            if (stack.isEmpty()) {
                min = 100000;
            } else if (poped == min) {
                updateMin();
            }
            return poped;
        }

        public void push(int element) {
            stack.offerFirst(element);
            if (element < min) {
                min = element;
            }
        }

        public int top() {
            if (stack.isEmpty()){
                return -1;
            }
            return stack.peekFirst();
        }

        public int min() {
            if (min == 100000) {
                return -1;
            }
            return min;
        }

        private void updateMin() {
            // create stack2 to traverse stack
            Deque<Integer> stack2 = new LinkedList<>();
            // if stack is empty, return
            if (stack.isEmpty()) {
                return;
            }
            // initialize min as first poped element
            min = stack.pollFirst();
            if (stack.isEmpty()) {
                stack.offerFirst(min);
                return;
            }
            // initialize poped
            int poped = min;

            // stop while loop when stack is empty
            while (!stack.isEmpty()) {
                // add poped elment to stack2
                stack2.offerFirst(poped);
                // update min if poped is smaller than min
                if (poped < min) {
                    min = poped;
                }
                poped = stack.pollFirst();
            }
            stack2.offerFirst(poped);

            // add elements in stack2 back to stack
            int poped2 = stack2.pollFirst();
            while (!stack2.isEmpty()) {
                stack.offerFirst(poped2);
                poped2 = stack2.pollFirst();
            }
            stack.offerFirst(poped2);
        }

        public static void main(String[] args) {
            StackWithMin a = new StackWithMin();
            a.push(6);
            System.out.println(a.min());
            a.push(5);
            a.push(5);
            System.out.println(a.top());
            System.out.println(a.min());
            a.push(5);
            a.push(6);
            System.out.println(a.min());
            a.push(6);
            System.out.println(a.min());
            System.out.println(a.pop());
            System.out.println(a.min());
            System.out.println(a.pop());
            System.out.println(a.min());
            System.out.println(a.pop());
            System.out.println(a.min());
            System.out.println(a.pop());
            System.out.println(a.top());
            System.out.println(a.min());
        }
}
