import java.util.HashMap;
import java.util.Map;

/**
 * @author Zixiang Hu
 * @description 167. 两数之和 II - 输入有序数组
 * @create 2020-07-20-17:54
 */
public class LeetCode167 {
    class Solution {
        //
/*        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap();
            for (int i = 0; i < nums.length; i++) {
                int diff = target - nums[i];
                if (map.containsKey(diff))
                    return new int[]{map.get(diff)+1, i+1};
                else
                    map.put(nums[i], i);
            }
            return null;
        }*/
        public int[] twoSum(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (right > left) {
                int sum = nums[left] + nums[right];
                if (sum == target)
                    return new int[]{left + 1, right + 1};
                else if (sum > target)
                    left--;
                else
                    right++;
            }
            return null;
        }
    }
}
