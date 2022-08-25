package interval;

import java.util.Arrays;

public class NonoverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int[] helper = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        int res = 0;
        for (int[] interval : intervals) {
            if (interval[0] >= helper[1]) {
                helper = interval;
            }
            else if (helper[1] == interval[1]) {
                helper[0] = Math.min(interval[0], helper[0]);
                res++;
            }
            else {
                res++;
            }
        }
        return res;
    }
}
