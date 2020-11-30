import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zixiang Hu
 * @description 18. 四数之和
 * @create 2020-10-05-9:57
 */
public class LeetCode18 {
    static class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> lists = new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1])
                    continue;
                int firstDiff = target - nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1])
                        continue;
                    int secondDiff = firstDiff - nums[j];
                    int left = j + 1;
                    int right = nums.length - 1;
                    while (left < right) {
                        if (nums[left] + nums[right] == secondDiff) {
                            lists.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            while (left < right && nums[left] == nums[left + 1])
                                left++;
                            while (left < right && nums[right] == nums[right - 1])
                                right--;
                            left++;
                            right--;
                        } else if (nums[left] + nums[right] > secondDiff)
                            right--;
                        else
                            left++;
                    }
                }
            }
            return lists;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fourSum(new int[]{0,0,0,0}, 0));
    }
}
