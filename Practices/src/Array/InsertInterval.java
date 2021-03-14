package Array;

import java.util.ArrayDeque;
import java.util.Deque;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        if (newInterval.length == 0) {
            return intervals;
        }
        Deque<int[]> stk = new ArrayDeque<>();

        int i = 0;

        // add those finish before new interval start
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            stk.offerFirst(intervals[i]);
            i++;
        }
        // add those overlap with new interval
        int start = newInterval[0];
        int end = newInterval[1];
        while (i < intervals.length && intervals[i][0] <= end) {
            start = Math.min(intervals[i][0], start);
            end = Math.max(intervals[i][1], end);
            i++;
        }

        stk.offerFirst(new int[]{start, end});


        while (i < intervals.length) {
            stk.offerFirst(intervals[i]);
            i++;
        }



        int[][] res = new int[stk.size()][];
        for (int j = stk.size() - 1; j >= 0; j--) {
            res[j] = stk.pollFirst();
        }
        return res;
    }
}