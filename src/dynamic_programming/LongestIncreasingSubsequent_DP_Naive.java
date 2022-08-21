package dynamic_programming;

public class LongestIncreasingSubsequent_DP_Naive {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = nums[i] > nums[j] ? Math.max(dp[i], dp[j] + 1) : Math.max(dp[i], 1);
                res = Math.max(dp[i], res);
            }
        }
        return res;
    }
}

