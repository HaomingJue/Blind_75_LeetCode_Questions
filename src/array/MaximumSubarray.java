package array;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int curSum = 0;
        for (int num : nums) {
            curSum = Math.max(curSum + num, num);
            ans = Math.max(ans, curSum);
        }
        return ans;
    }
}
