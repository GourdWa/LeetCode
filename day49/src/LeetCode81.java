/**
 * @author Zixiang Hu
 * @description 81. 搜索旋转排序数组 II（数组中有重复元素）
 * @create 2020-07-03-19:01
 */
public class LeetCode81 {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target == nums[mid])
                return true;
            //说明mid左边是有序的
            if (nums[mid] > nums[left]) {
                if (target >= nums[left] && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else if (nums[mid] < nums[left]) {
                // 说明mid右边是有序的
                if (target > nums[mid] && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            } else {
                left++;
            }
        }
        return false;
    }
}
