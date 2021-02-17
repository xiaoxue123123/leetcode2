import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class EvalRPN {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Deque<Integer> s1 = new LinkedList<>();

        for (String token: tokens) {
            if (!"+-*/".contains(token)) {
                s1.offer(Integer.valueOf(token));
            } else {
                int num1 = s1.poll();
                int num2 = s1.poll();

                if (token.equals("*")) {
                    s1.offer(num1 * num2);
                } else if (token.equals("/")) {
                    s1.offer(num2 / num1);
                } else if (token.equals("+")) {
                    s1.offer(num1 + num2);
                } else {
                    s1.offer(num2 - num1);
                }

            }
        }
        return s1.poll();


    }

    public static void main(String[] args) {
        EvalRPN solution = new EvalRPN();
        solution.evalRPN(new String[]{"0","12","4","+","-"});

    }
}
