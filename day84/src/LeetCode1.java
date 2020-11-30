import java.util.HashMap;
import java.util.Map;

/**
 * @author Zixiang Hu
 * @description 1. 两数之和
 * @create 2020-10-03-8:44
 */
public class LeetCode1 {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] ans = new int[2];
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int diff = target - nums[i];
                if (map.containsKey(diff)) {
                    ans[0] = map.get(diff);
                    ans[1] = i;
                    break;
                }
                map.put(nums[i], i);
            }
            return ans;
        }
    }
}
