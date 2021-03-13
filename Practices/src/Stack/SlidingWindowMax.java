package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMax {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length * k == 0) {
            return new int[0];
        }
        Deque<Integer> dq = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (dq.isEmpty()) {
                dq.offerLast(i);
            } else {
                while (!dq.isEmpty() && nums[dq.peekLast()] <= cur) {
                    dq.pollLast();
                }
                dq.offerLast(i);
            }

            if (i >= k && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            if (i >= k - 1) {
                res[i - k + 1] = nums[dq.peekFirst()];
            }


        }
        return res;
    }
}
