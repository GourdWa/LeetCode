/**
 * @author Zixiang Hu
 * @description 287. 寻找重复数
 * @create 2020-06-27-17:25
 */
public class LeetCode287 {
    class Solution {
        public int findDuplicate(int[] nums) {
            int len = nums.length;
            int right = len - 1;
            int left = 1;
            int mid;
            while (right > left) {
                int cnt = 0;
                mid = left + (right - left) / 2;
                for (int num : nums) {
                    if (num <= mid)
                        cnt++;
                }
                if (cnt > mid) {
                    right = mid;
                } else
                    left = mid + 1;
            }
            return left;
        }
    }
}
