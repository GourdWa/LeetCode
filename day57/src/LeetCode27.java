/**
 * @author Zixiang Hu
 * @description 27. 移除元素
 * @create 2020-07-12-20:24
 */
public class LeetCode27 {
    class Solution {
        public int removeElement(int[] nums, int val) {
            int i = -1;
            int j;
            for (j = 0; j < nums.length; j++) {
                if (nums[j] != val) {
                    nums[++i] = nums[j];
                }
            }
            return i + 1;
        }
    }
}
