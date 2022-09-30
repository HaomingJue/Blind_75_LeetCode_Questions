package array;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int zeroIndex = -1;
        int totalProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                totalProduct = nums[i] * totalProduct;
            }
            if (nums[i] == 0) {
                if (zeroIndex >= 0) {
                    return ans;
                }
                else {
                    zeroIndex = i;
                }
            }
        }
        if (zeroIndex >= 0) {
            ans[zeroIndex] = totalProduct;
            return ans;
        }
        for (int i = 0; i < nums.length; i++) {
            ans[i] = totalProduct / nums[i];
        }
        return ans;
    }
}
