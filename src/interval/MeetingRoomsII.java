package interval;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] last = pq.poll();
            if (last[1] > intervals[i][0]) {
                pq.offer(last);
                pq.offer(intervals[i]);
            }
            else {
                pq.offer(intervals[i]);
            }
        }
        return pq.size();
    }
}
