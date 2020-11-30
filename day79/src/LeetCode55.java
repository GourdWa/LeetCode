/**
 * @author Zixiang Hu
 * @description 55. 跳跃游戏
 * @create 2020-09-07-9:32
 */
public class LeetCode55 {
    class Solution {
        public boolean canJump(int[] nums) {
            int maxJump = 0;
            for (int i = 0; i < nums.length; i++) {
                //如果已经遍历到的位置已经超出了能够跳跃的最大位置，那么直接返回false
                if (i > maxJump)
                    return false;
                maxJump = Math.max(maxJump, i + nums[i]);
                //如果能跳跃的最大位置已经能够到达最后，直接返回true
                if (maxJump >= nums.length - 1)
                    return true;
            }
            return maxJump >= nums.length - 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode55().new Solution().canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
