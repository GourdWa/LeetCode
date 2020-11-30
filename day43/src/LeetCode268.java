/**
 * @author Zixiang Hu
 * @description 268. 缺失数字
 * @create 2020-06-27-19:01
 */
public class LeetCode268 {
    class Solution {
        public int missingNumber(int[] nums) {
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                int ele = nums[i];
                while (i != ele && ele >= 0 && ele < len) {
                    swap(nums, i, ele);
                    ele = nums[i];
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (i != nums[i])
                    return i;
            }
            return len;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
