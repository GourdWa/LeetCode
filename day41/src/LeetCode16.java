import java.util.Arrays;

/**
 * @author Zixiang Hu
 * @description 16. 最接近的三数之和
 * @create 2020-06-24-18:34
 */
public class LeetCode16 {
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int ans = nums[0] + nums[1] + nums[2];
            int minAbs = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i - 1] == nums[i])
                    continue;
                int left = i + 1;
                int right = nums.length - 1;
                while (right > left) {
                    int sum = nums[i] + nums[left] + nums[right];
                    int absVal = sum - target > 0 ? sum - target : target - sum;
                    if (absVal == 0)
                        return target;
                    if (absVal < minAbs) {
                        ans = sum;
                        minAbs = absVal;
                    }
                    if (sum - target > 0)
                        right--;
                    else
                        left++;
                }
            }
            return ans;
        }
    }
}
