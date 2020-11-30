import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Zixiang Hu
 * @description 1365. 有多少小于当前数字的数字
 * @create 2020-10-26-14:08
 */
public class LeetCode1365 {
    class Solution {
        public int[] smallerNumbersThanCurrent(int[] nums) {
            int n = nums.length;
            int[][] data = new int[n][2];
            for (int i = 0; i < n; i++) {
                data[i][0] = nums[i];
                data[i][1] = i;
            }
            Arrays.sort(data, new Comparator<int[]>() {
                public int compare(int[] data1, int[] data2) {
                    return data1[0] - data2[0];
                }
            });

            int[] ret = new int[n];
            int prev = -1;
            for (int i = 0; i < n; i++) {
                if (prev == -1 || data[i][0] != data[i - 1][0]) {
                    prev = i;
                }
                ret[data[i][1]] = prev;
            }
            return ret;
        }
    }
}
