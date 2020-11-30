/**
 * @author Zixiang Hu
 * @description 53. 最大子序和
 * @create 2020-09-04-17:32
 */
public class LeetCode53 {
    class Solution {
        public int maxSubArray(int[] nums) {
            int sum = nums[0];
            int maxSum = nums[0];
            for (int i = 1; i < nums.length; i++) {
                // 如果sum小于0就没有累加的必要了，直接清0，从新开始即可
                if (sum < 0)
                    sum = 0;
                sum += nums[i];
                if (sum > maxSum)
                    maxSum = sum;
            }
            return maxSum;
        }
    }
}
