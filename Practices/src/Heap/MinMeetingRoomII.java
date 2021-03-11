package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinMeetingRoomII {

    public int minMeetingRooms(int[][] intervals) {
        /**
         end time of pre meeting < start time of cur meeting

         startTimeArry to store intervals by ascending order of start time
         pq to store end time of meeting that is going on

         **/

        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(intervals[0][1]);

        int res = 1;
        // check if need more room
        for (int i = 1; i < intervals.length; i++) {
            if (pq.peek() <= intervals[i][0]) {
                pq.poll();
            } else {
                res++;
            }
            pq.offer(intervals[i][1]);
        }

        return res;


    }
}