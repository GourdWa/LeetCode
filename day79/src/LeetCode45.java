/**
 * @author Zixiang Hu
 * @description 45. 跳跃游戏 II
 * @create 2020-09-07-9:48
 */
public class LeetCode45 {
    static class Solution {
        public int jump(int[] nums) {
            if (nums == null || nums.length == 1)
                return 0;
            int cnt = 1;
            int maxStep = nums[0];
            for (int i = 0; i < nums.length; ) {
                if (maxStep >= nums.length - 1)
                    return cnt;
                int maxN = i;
                //在第i个点能跳的范围内，找到【i,nums[i]+i】中能跳跃的最远的点，也就是j+nums[j]最大的点，下次从这个点起跳
                for (int j = i + 1; j <= i + nums[i]; j++) {
                    if (j + nums[j] >= nums.length - 1)
                        return ++cnt;
                    if (j + nums[j] > maxStep) {
                        maxStep = j + nums[j];
                        maxN = j;
                    }
                }
                cnt++;
                i = maxN;
            }
            return cnt;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().jump(new int[]{1, 1, 1, 1}));
    }
}
