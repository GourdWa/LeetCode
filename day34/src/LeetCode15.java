import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zixiang Hu
 * @description 15. 三数之和
 * @create 2020-06-12-16:17
 */
public class LeetCode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i])
                continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                if (nums[left] + nums[right] == -nums[i]) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (right > left && nums[right - 1] == nums[right])
                        right--;
                    while (right > left && nums[left + 1] == nums[left])
                        left++;
                    left++;
                    right--;
                }
                while (right > left && nums[left] + nums[right] > -nums[i])
                    right--;
                while (right > left && nums[left] + nums[right] < -nums[i])
                    left++;

            }
        }
        return ans;
    }
}
