import java.util.HashMap;
import java.util.Map;

/**
 * @author Zixiang Hu
 * @description 1. 两数之和
 * @create 2020-06-14-15:35
 */
public class LeetCode1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff))
                return new int[]{map.get(diff), i};
            else
                map.put(nums[i], i);
        }
        return null;
    }
}
