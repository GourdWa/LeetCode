/**
 * @author Zixiang Hu
 * @description 154. 寻找旋转排序数组中的最小值 II
 * @create 2020-07-22-14:04
 */
public class LeetCode154 {
    class Solution {
        public int findMin(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            int mid;
            while (nums[left] >= nums[right] && left < right) {
                mid = left + (right - left) / 2;
                if (nums[mid] > nums[left])
                    left = mid + 1;
                else if(nums[mid] < nums[left])
                    right = mid;
                else
                    left++;
            }
            return nums[left];
        }
    }
}























