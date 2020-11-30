/**
 * @author Zixiang Hu
 * @description 154. 寻找旋转排序数组中的最小值 II
 * @create 2020-07-03-18:40
 */
public class LeetCode154 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        //nums[left] >= nums[right]的目的说明是存在旋转，如果这个条件不满足，说明数组是有序的，直接返回left即可
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
