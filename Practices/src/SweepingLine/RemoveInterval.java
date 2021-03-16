package SweepingLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveInterval {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {

        int n = intervals.length;
        int i = 0;
        List<List<Integer>> res = new ArrayList<>();
        int[] interval = intervals[i];
        int start = toBeRemoved[0];
        int end = toBeRemoved[1];
        while (true) {
            // if intersect
            if (interval[0] < start) res.add(Arrays.asList(interval[0], Math.min(start, interval[1])));
            // update interval if there is more after end
            if (interval[0] < end && interval[1] > end) interval = new int[]{end, interval[1]};

            // if not intersect, add to res
            if (interval[0] >= end) {
                res.add(Arrays.asList(interval[0], interval[1]));
            }


            if (i + 1 < n) {
                interval = intervals[++i];
            } else {
                break;
            }

        }
        return res;

    }
}