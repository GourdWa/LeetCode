import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Zixiang Hu
 * @description 452. 用最少数量的箭引爆气球
 * @create 2020-11-23-10:56
 */
public class LeetCode452 {
    class Solution {
        public int findMinArrowShots(int[][] points) {
            int ans = 0;
            //按照左边升序排列
            Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
            for (int i = 0; i < points.length; ) {
                int end = points[i][1];
                ans++;
                int j = i + 1;
                for (; j < points.length; j++) {
                    if (points[j][0] <= end) {
                        end = Math.min(end, points[j][1]);
                    } else {
                        break;
                    }
                }
                i = j;
            }
            return ans;
        }
    }
}
