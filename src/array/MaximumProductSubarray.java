package array;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE, curMaxProd = 1, curMinProd = 1;
        for (int num : nums) {
            int temp = Math.max(Math.max(curMaxProd * num, curMinProd * num), num);
            curMinProd = Math.min(Math.min(curMaxProd * num, curMinProd * num), num);
            curMaxProd = temp;
            ans = Math.max(curMaxProd, ans);
        }
        return ans;
    }
}
