import java.util.Arrays;
import java.util.Random;

/**
 * @author Zixiang Hu
 * @description 75. 颜色分类
 * @create 2020-10-07-11:08
 */
public class LeetCode75 {
    static class Solution {
        // 快速排序
/*        public void sortColors(int[] nums) {
            helper(nums, 0, nums.length - 1);
        }

        private void helper(int[] nums, int left, int right) {
            int start = left, end = right;

            while (left < right) {
                while (right > left && nums[right] >= nums[start])
                    right--;
                while (right > left && nums[left] <= nums[start])
                    left++;
                if (right > left) {
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                }
            }
            if (start < end) {
                int temp = nums[start];
                nums[start] = nums[left];
                nums[left] = temp;
                helper(nums, start, left - 1);
                helper(nums, left + 1, end);
            }
        }*/

        // 双指针
        public void sortColors(int[] nums) {
            if (nums == null || nums.length <= 1)
                return;
            int start = 0, end = nums.length - 1;
            for (int i = 0; i <= end; i++) {
                if (nums[i] == 0) {
                    swap(nums, i, start);
                    start++;
                }
                if (nums[i] == 2) {
                    swap(nums, i, end);
                    end--;
                    i--;
                }
            }
            System.out.println(Arrays.toString(nums));
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        new Solution().sortColors(new int[]{2, 1, 2});
    }
}
