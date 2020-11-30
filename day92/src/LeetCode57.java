import java.util.ArrayList;
import java.util.List;

/**
 * @author Zixiang Hu
 * @description 57. 插入区间
 * @create 2020-11-04-15:39
 */
public class LeetCode57 {
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            if (intervals == null || intervals.length == 0)
                return new int[][]{newInterval};
            List<int[]> list = new ArrayList<>();
            //是否已经插入
            boolean hasInsert = false;
            int i = 0;
            while (i < intervals.length) {
                //如果没有插入，且新区间的右端点小于当前区间的左端点，则将新区间插入
                if (!hasInsert && newInterval[1] < intervals[i][0]) {
                    list.add(newInterval);
                    hasInsert = true;
                    continue;
                }
                //如果已经插入，或新区间的左端点大于当前区间的右端点，直接将当前区间插入
                if (newInterval[0] > intervals[i][1] || hasInsert) {
                    list.add(intervals[i]);
                    i++;
                } else {
                    //如果上面条件都未满足，也就是新区间的左端点小于等于当前区间的右端点，且区间还未插入
                    //类似合并区间操作
                    hasInsert = true;
                    int left = Math.min(newInterval[0], intervals[i][0]);
                    int right = Math.max(newInterval[1], intervals[i][1]);
                    i += 1;
                    while (i < intervals.length && right >= intervals[i][0]) {
                        right = Math.max(right, intervals[i][1]);
                        i++;
                    }
                    list.add(new int[]{left, right});
                    while (i < intervals.length) {
                        list.add(intervals[i]);
                        i++;
                    }
                }
            }
            if (!hasInsert)
                list.add(newInterval);
            return list.toArray(new int[list.size()][2]);
        }
    }
}
