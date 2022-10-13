package array;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int h = nums.length - 1;
        int l = 0;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] > nums[m + 1]) {
                return nums[m + 1];
            }
            else if (nums[m] < nums[nums.length - 1]) {
                h = m;
            }
            else  {
                l = m + 1;
            }
        }
        return nums[0];
    }
}
