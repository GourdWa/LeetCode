import java.util.*;

/**
 * @author Zixiang Hu
 * @description 56. 合并区间
 * @create 2020-09-08-17:33
 */
public class LeetCode56 {
    static class Solution {
        /*       public int[][] merge(int[][] intervals) {
                 List<int[]> list = new LinkedList<>();
                 for (int[] interval : intervals) {
                     list.add(interval);
                 }
                 Collections.sort(list, Comparator.comparingInt(o -> o[0]));
                 int i = 0;
                 while (i < list.size()) {
                     int[] ints1 = list.get(i);
                     if (i + 1 < list.size()) {
                         int[] ints2 = list.get(i + 1);
                         if (ints2[0] >= ints1[0] && ints2[0] <= ints1[1]) {
                             int[] ints3 = new int[]{ints1[0], Math.max(ints2[1], ints1[1])};
                             list.remove(i);
                             list.remove(i);
                             list.add(i, ints3);
                         } else
                             i++;
                     } else
                         break;
                 }
                 int[][] ans = new int[list.size()][2];
                 for (int j = 0; j < list.size(); j++) {
                     ans[j] = list.get(j);
                 }
                 return ans;
             }*/
        public int[][] merge(int[][] arr) {
            if (arr == null || arr.length <= 1)
                return arr;
            List<int[]> list = new ArrayList<>();
            Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
            int i = 0;
            int n = arr.length;
            while (i < n) {
                int left = arr[i][0];
                int right = arr[i][1];
                while (i < n - 1 && right >= arr[i + 1][0]) {
                    right = Math.max(right, arr[i + 1][1]);
                    i++;
                }
                list.add(new int[]{left, right});
                i++;
            }
            return list.toArray(new int[list.size()][2]);
        }
    }

    public static void main(String[] args) {
        new Solution().merge(new int[][]{{1, 3}, {8, 10}, {2, 6}, {15, 18}});
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Integer[] integers = new Integer[list.size()];
        list.toArray(integers);
        System.out.println();
    }
}
