package Array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MergeInterval {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        Deque<int[]> stk = new ArrayDeque<>();
        stk.offerFirst(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] pre = stk.peekFirst();
            int[] cur = intervals[i];
            if (pre[1] >= cur[0]) {
                if (cur[1] <= pre[1]) {
                    continue;
                }
                stk.pollFirst();
                int[] newCur = new int[]{pre[0], cur[1]};
                stk.offerFirst(newCur);
            } else{
                stk.offerFirst(cur);
            }
        }

        int[][] res = new int[stk.size()][];
        for (int i = stk.size() - 1; i >= 0; i--) {
            res[i] = stk.pollFirst();
        }
        return res;
    }
}