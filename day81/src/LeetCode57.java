import java.util.ArrayList;
import java.util.List;

/**
 * @author Zixiang Hu
 * @description 57. 插入区间
 * @create 2020-09-11-9:05
 */
public class LeetCode57 {
    static class Solution {
        // 先插入再合并
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> list = new ArrayList<>();
            List<int[]> ans = new ArrayList<>();
            boolean hasInsert = false;
            for (int[] interval : intervals) {
                if (!hasInsert && interval[0] > newInterval[0]) {
                    list.add(newInterval);
                    list.add(interval);
                    hasInsert = true;
                } else
                    list.add(interval);
            }
            if (!hasInsert)
                list.add(newInterval);
            int i = 0;
            int n = list.size();
            // 最后再合并区间
            while (i < n) {
                int left = list.get(i)[0];
                int right = list.get(i)[1];
                while (i + 1 < n && right >= list.get(i + 1)[0]) {
                    right = Math.max(right, list.get(i + 1)[1]);
                    i++;
                }
                ans.add(new int[]{left, right});
                i++;
            }
            return ans.toArray(new int[ans.size()][]);
        }
    }

    public static void main(String[] args) {
        int[][] internals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        new Solution().insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});
    }
}
