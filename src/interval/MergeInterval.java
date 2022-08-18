package interval;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Deque<int[]> ans = new LinkedList<>();
        for (int[] interval : intervals) {
            if (ans.isEmpty()) {
                ans.offer(interval);
            }
            else {
                int[] prev = ans.getLast();
                if (prev[1] < interval[0]) {
                    ans.offer(interval);
                }
                else {
                    prev[1] = Math.max(interval[1], prev[1]);
                }
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}
