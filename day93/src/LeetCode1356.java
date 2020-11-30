import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zixiang Hu
 * @description 1356. 根据数字二进制下 1 的数目排序
 * @create 2020-11-06-18:24
 */
public class LeetCode1356 {
    static class Solution {
        class Helper implements Comparable<Helper> {
            private int value;
            private int count;

            public Helper(int value, int count) {
                this.value = value;
                this.count = count;
            }

            @Override
            public int compareTo(Helper o) {
                if (this.count > o.count)
                    return 1;
                else if (this.count == o.count && this.value > o.value)
                    return 1;
                else if (this.count == o.count && this.value == o.value)
                    return 0;
                return -1;
            }
        }

        public int[] sortByBits(int[] arr) {
            if (arr == null || arr.length == 0)
                return new int[0];
            Helper[] helpers = new Helper[arr.length];
            for (int i = 0; i < arr.length; i++) {
                helpers[i] = new Helper(arr[i], countOne(arr[i]));
            }
            Arrays.sort(helpers);
            int[] ans = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                ans[i] = helpers[i].value;
            }
            return ans;
        }

        private int countOne(int num) {
            int count = 0;
            while (num != 0) {
                if ((num & 1) == 1)
                    count += 1;
                num >>= 1;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        new Solution().sortByBits(new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1});
    }
}
