import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Zixiang Hu
 * @description 56. 合并区间
 * @create 2020-11-04-8:59
 */
public class LeetCode56 {
    static class Solution {
        public int[][] merge(int[][] arr) {
            if (arr == null || arr.length <= 1)
                return arr;
            List<int[]> list = new ArrayList<>();
            Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
            int i = 0;
            while (i < arr.length) {
                int left = arr[i][0];
                int right = arr[i][1];
                while (i + 1 < arr.length && right >= arr[i + 1][0]) {
                    right = Math.max(right, arr[i + 1][1]);
                    i++;
                }
                i++;
                list.add(new int[]{left, right});
            }
            return list.toArray(new int[list.size()][2]);
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 3}, {8, 10}, {15, 18}};
        new Solution().merge(arr);
    }
}
