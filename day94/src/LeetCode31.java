import java.util.Arrays;

/**
 * @author Zixiang Hu
 * @description 31. 下一个排列
 * @create 2020-11-10-15:29
 */
public class LeetCode31 {
   static class Solution {
        //应该尽量改变最低位
        /*public void nextPermutation(int[] nums) {
            if (nums.length == 0 || nums.length == 1)
                return;
            int i, j, t;
            for (i = nums.length - 2; i >= 0; i--) {
                if (nums[i] < nums[i + 1]) {
                    break;
                }
            }
            j = nums.length - 1;
            if (i != -1) {
                while (nums[j] <= nums[i])
                    j--;
                t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                Arrays.sort(nums, i + 1, nums.length);
            } else {
                for (i = 0; i < nums.length / 2; i++) {
                    t = nums[i];
                    nums[i] = nums[nums.length - i - 1];
                    nums[nums.length - i - 1] = t;
                }
            }
        }*/
        public void nextPermutation(int[] nums) {
            int i;
            for (i = nums.length - 2; i >= 0; i--) {
                //i称为异常点
                if (nums[i] < nums[i + 1]) {
                    break;
                }
            }
            //说明没有异常点，直接反转即可
            if (i == -1) {
                for (int j = 0; j < nums.length / 2; j++) {
                    int temp = nums[j];
                    nums[j] = nums[nums.length - 1 - j];
                    nums[nums.length - 1 - j] = temp;
                }
            } else {
                //说明有异常点，且[i+1,len)之间的数都是递减排序，此时只要找到[i+1,n]之间一个大于nums[i]的数，二者交换再逆序即可
                int j = nums.length - 1;
                //不用担心越界，这个数肯定存在，再不济也是i+1
                while (nums[j] <= nums[i])
                    j--;
                //交换
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                //交换完之后，[i+1,n)之间必然是递减排列，再逆序即可
                for (int k = i + 1, l = 0; k < (nums.length + i + 1) / 2; k++, l++) {
                    temp = nums[k];
                    nums[k] = nums[nums.length - 1 - l];
                    nums[nums.length - 1 - l] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        new Solution().nextPermutation(new int[]{5,4,7,5,3,2});
    }
}
