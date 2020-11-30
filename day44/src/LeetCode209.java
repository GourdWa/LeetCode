/**
 * @author Zixiang Hu
 * @description 209. 长度最小的子数组
 * @create 2020-06-28-10:23
 */
public class LeetCode209 {
    class Solution {
        public int minSubArrayLen(int s, int[] nums) {
            if (nums.length == 0)
                return 0;
            if (nums[0] >= s)
                return 1;
            int ans = 0;
            int left = 0, right = 0;
            int sum = nums[0];
            while (right >= left && right < nums.length) {
                if (sum >= s && right > left) {
                    sum -= nums[left];
                    left++;
                } else if (sum < s && right < nums.length - 1) {
                    right++;
                    sum += nums[right];
                } else
                    break;
                if (sum >= s && (right - left + 1 < ans || ans == 0)) {
                    ans = right - left + 1;
                    if (ans == 1)
                        return ans;
                }
            }
            return ans;
        }
    }
}
