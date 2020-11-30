import java.util.Arrays;
import java.util.Random;

/**
 * @author Zixiang Hu
 * @description 493. 翻转对
 * @create 2020-11-28-14:38
 */
public class LeetCode493 {
    static class Solution {
        private int cnt = 0;

        public int reversePairs(int[] nums) {
            mergeSort(nums, 0, nums.length - 1);
            return cnt;
        }

        public void mergeSort(int[] arr, int left, int right) {
            if (right > left) {
                int mid = left + (right - left) / 2;
                mergeSort(arr, left, mid);
                mergeSort(arr, mid + 1, right);
                merge(arr, left, mid, right);
            }
        }
      /*  private void merge(int[] arr, int left, int mid, int right) {
            int[] temp = new int[right - left + 1];
            int l = left, r = mid + 1;
            int p = 0;
            while (l <= mid && r <= right) {
                if (arr[l] > arr[r]) {
                    if (arr[l] / 2.0 > arr[r])
                        cnt += (mid - l + 1);
                    temp[p++] = arr[r++];
                } else {
                    temp[p++] = arr[l++];
                }
            }
            while (l <= mid)
                temp[p++] = arr[l++];
            while (r <= right)
                temp[p++] = arr[r++];
            for (int i = left; i <= right; i++) {
                arr[i] = temp[i - left];
            }
        }*/
        private void merge(int[] arr, int left, int mid, int right) {
            int[] temp = new int[right - left + 1];
            int l = left, r = mid + 1;
            while (l <= mid && r <= right) {
                if (arr[l] / 2.0 > arr[r]) {
                    cnt += (mid - l + 1);
                    r++;
                } else
                    l++;
            }
            int p = 0;
            l = left;
            r = mid + 1;
            while (l <= mid && r <= right) {
                if (arr[l] > arr[r]) {
                    temp[p++] = arr[r++];
                } else {
                    temp[p++] = arr[l++];
                }
            }
            while (l <= mid)
                temp[p++] = arr[l++];
            while (r <= right)
                temp[p++] = arr[r++];
            for (int i = left; i <= right; i++) {
                arr[i] = temp[i - left];
            }
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.reversePairs(new int[]{3,2,1});

    }
}
