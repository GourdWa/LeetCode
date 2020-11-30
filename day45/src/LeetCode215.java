import java.util.Arrays;

/**
 * @author Zixiang Hu
 * @description
 * @create 2020-06-29-11:16
 */
public class LeetCode215 {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            k = nums.length - k;//注意这里的k已经变了
            int lo = 0, hi = nums.length - 1;
            while (lo <= hi) {
                int i = quickSort(nums, lo, hi);
                if (k == i)
                    return nums[i];
                else if (k < i)
                    hi = i - 1;
                else
                    lo = i + 1;
            }
            return -1;
        }

        public int quickSort(int[] arr, int left, int right) {
/*            if (left > right)
                return;*/
            int start = left;
            int end = right;
            int t;
            while (right > left) {
                while (right > left && arr[right] >= arr[start])
                    right--;
                while (right > left && arr[left] <= arr[start])
                    left++;
                if (right > left) {
                    t = arr[left];
                    arr[left] = arr[right];
                    arr[right] = t;
                }
            }
            //退出循环时说明left等于right
            t = arr[start];
            arr[start] = arr[left];
            arr[left] = t;
/*            quickSort(arr, start, left);
            quickSort(arr, left + 1, end);*/
            return left;
        }
    }
}
