/**
 * @author Zixiang Hu
 * @description 55. 跳跃游戏
 * @create 2020-08-15-20:34
 */
public class LeetCode55 {
    static class Solution {
   /*     public boolean canJump(int[] nums) {
            if (nums.length == 1)
                return true;
            int len = nums.length - 1;
            int cnt = 0;
            for (int i = 0; i <= len; ) {
                //从i位置能达到的最大的位置
                int iMax = i + nums[i];
                if (iMax >= len)
                    return true;
                cnt = iMax;
                for (int j = i; j < iMax; j++) {
                    if (j + nums[j] > cnt) {
                        cnt = j + nums[j];
                        if (cnt >= len)
                            return true;
                    }
                }
                if (iMax == cnt)
                    return false;
                i = cnt;
            }
            return false;
        }*/
        //
        public boolean canJump(int[] nums) {
            int maxLoc = 0;
            for (int i = 0; i < nums.length; i++) {
                if (maxLoc >= nums.length)
                    return true;
                if (i > maxLoc)
                    return false;
                maxLoc = Math.max(maxLoc, i + nums[i]);
            }
            return true;
        }

    }

    public static void main(String[] args) {
        new Solution().canJump(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0});
    }
}
