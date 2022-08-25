package dynamic_programming;

import java.util.ArrayList;

public class LongestIncreasingSubsequent_Subsequent_BinarySearch {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > sub.get(sub.size() - 1)) {
                sub.add(nums[i]);
            }
            else {
                int j = binarySearch(sub, nums[i]);
                if (j != -1) sub.set(j, nums[i]);
            }
        }
        return sub.size();
    }

    private int binarySearch(ArrayList<Integer> sub, int num) {
        int l = 0;
        int h = sub.size() - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (sub.get(m) == num) {
                return m;
            }
            if (sub.get(m) < num) {
                l = m + 1;
            }
            else {
                h = m;
            }
        }
        return l;
    }
}
