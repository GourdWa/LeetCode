/**
 * @author Zixiang Hu
 * @description 45. 跳跃游戏 II
 * @create 2020-08-26-16:42
 */
public class LeetCode45 {
    static class Solution {
        public int jump(int[] nums) {
            if (nums == null || nums.length == 1)
                return 0;
            int cnt = 1;
            for (int i = 0; i < nums.length; ) {
                if (nums[i] + i >= nums.length - 1)
                    break;
                int maxStep = nums[i] + i;
                int maxNum = i;
                //每次取在当前范围内能跳跃到的最远距离
                //最远距离为当前坐标加上能跳跃的距离
                for (int j = i + 1; j <= i + nums[i]; j++) {
                    if (nums[j] + j > maxStep) {
                        maxStep = nums[j] + j;
                        maxNum = j;
                    }
                }
                cnt += 1;
                i = maxNum;
            }
            return cnt;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().jump(new int[]{2, 3, 1, 1, 4}));
    }
}
