package array;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int frontIndex = 0;
        int backIndex = height.length - 1;
        int ans = 0;
        while (frontIndex < backIndex) {
            int front = height[frontIndex];
            int back = height[backIndex];
            int area = (backIndex - frontIndex ) * Math.min(front, back);
            ans = Math.max(area, ans);
            if (front < back) {
                int curFront = height[frontIndex];
                while (frontIndex < backIndex && curFront >= height[frontIndex]) {
                    frontIndex++;
                }
            }
            else {
                int curBack = height[backIndex];
                while (frontIndex < backIndex && curBack >= height[backIndex]) {
                    backIndex--;
                }
            }
        }
        return ans;
    }
}
