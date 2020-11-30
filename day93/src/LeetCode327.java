/**
 * @author Zixiang Hu
 * @description 327. 区间和的个数
 * @create 2020-11-07-18:30
 */
public class LeetCode327 {
    class Solution {
        public int countRangeSum(int[] nums, int lower, int upper) {
            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                long sum = 0L;
                for (int j = i; j < nums.length; j++) {
                    sum += nums[j];
                    if (sum >= lower && sum <= upper)
                        ans += 1;
                }
            }
            return ans;
        }
    }
}
