import java.util.HashSet;
import java.util.Set;

/**
 * @author Zixiang Hu
 * @description 41. 缺失的第一个正数
 * @create 2020-06-27-10:49
 */
public class LeetCode41 {
    //使用一个set存储已经存在的正整数，因为数组的长度为len，如果有有正数缺失那么一定在1~len+1之间
    //所以只要把前len个数字遍历完，检查那个数字最先缺失即可
    //不过这种方法的空间复杂度不符合要求

    /*    class Solution {
        public int firstMissingPositive(int[] nums) {
            int len = nums.length;
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                if (num > 0)
                    set.add(num);
            }
            int i;
            for (i = 0; i < len; i++) {
                if (!set.contains(i + 1))
                    return i + 1;
            }
            return i + 1;
        }
    }*/

/*    class Solution {
        public int firstMissingPositive(int[] nums) {
            if (nums == null || nums.length == 0)
                return 1;
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                if (nums[i] <= 0)
                    nums[i] = len + 10;
            }

            for (int i = 0; i < nums.length; i++) {
                int ele = Math.abs(nums[i]);
                if (ele >= 1 && ele <= len) {
                    nums[ele - 1] = -Math.abs(nums[ele - 1]);
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= 0)
                    return i + 1;
            }
            return len + 1;
        }
    }*/

    //原地哈希
    class Solution {
        public int firstMissingPositive(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                int ele = nums[i];
                while (ele > 0 && ele <= nums.length && nums[ele - 1] != ele) {
                    swap(nums, i, ele - 1);
                    ele = nums[i];
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i + 1)
                    return i + 1;
            }
            return nums.length + 1;
        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        new LeetCode41().new Solution().firstMissingPositive(new int[]{3, 4, -1, 1});
    }
}
