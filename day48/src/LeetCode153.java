/**
 * @author Zixiang Hu
 * @description 153. 寻找旋转排序数组中的最小值
 * @create 2020-07-03-14:05
 */
public class LeetCode153 {
    class Solution {
        public int findMin(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            int mid;
            while (left < right && nums[left] > nums[right]) {
                mid = left + (right - left) / 2;
                if (nums[mid] >= nums[left])
                    left = mid + 1;
                else
                    right = mid;
            }
            return nums[left];
        }
    }
}
