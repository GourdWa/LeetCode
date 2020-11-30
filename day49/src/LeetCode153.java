/**
 * @author Zixiang Hu
 * @description 153. 寻找旋转排序数组中的最小值
 * @create 2020-07-03-18:16
 */
public class LeetCode153 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (nums[left] > nums[right] && left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] >= nums[left])
                left = mid + 1;
            else
                right = mid;
        }
        return nums[left];
    }

    public static void main(String[] args) {
        new LeetCode153().findMin(new int[]{3, 4, 5, 1, 2});
    }
}
