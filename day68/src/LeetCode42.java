/**
 * @author Zixiang Hu
 * @description 42. 接雨水
 * @create 2020-08-07-18:49
 */
public class LeetCode42 {
    class Solution {
        public int trap(int[] height) {
            int ans = 0;
            int maxLeft;
            int maxRight;
            for (int i = 1; i < height.length - 1; i++) {
                maxLeft = height[i];
                maxRight = height[i];
                //获得当前列左边最高的列的高度
                for (int j = i - 1; j >= 0; j--) {
                    maxLeft = Math.max(height[j], maxLeft);
                }
                //获得当前列右边最高的列
                for (int j = i + 1; j < height.length; j++) {
                    maxRight = Math.max(height[j], maxRight);
                }
                //当前列能够积水
                ans += Math.min(maxLeft, maxRight) - height[i];
            }
            return ans;
        }
    }
}
