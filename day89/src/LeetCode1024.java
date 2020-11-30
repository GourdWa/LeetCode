import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Zixiang Hu
 * @description 1024. 视频拼接
 * @create 2020-10-24-13:01
 */
public class LeetCode1024 {
    static class Solution {
        public int videoStitching(int[][] clips, int T) {
            if (clips.length == 1 && clips[0][1] < T)
                return -1;
            //首先将clips按clips[i][0]从小到大开始排序；
            //如果clips[i][0]相同，则按照clips[i][1]排序
            Arrays.sort(clips, (o1, o2) -> {
                if (o1[0] == o2[0])
                    return o2[1] - o1[1];
                return o1[0] - o2[0];
            });
            int ans = 0;
            int end = 0;
            for (int i = 0; i < clips.length; ) {
                //如果当前遍历的片段的开始时间已经大于上一个片段的结束时间，这说明这个视频无法连续剪辑
                if (clips[i][0] > end)
                    return -1;
                //如果当前遍历的片段的结束时间已经大于需要的总时间T，说明可以结束剪辑了
                if (clips[i][1] >= T)
                    return ++ans;
                //得到一个新的片段[0,end]
                end = clips[i][1];
                ans++;
                //下面的目的是在[0,end]这个时间内，找出起始时间在[0,end]之间，但是结束时间最迟的片段作为下一次剪辑
                int j = i + 1;
                int maxEnd = end;
                int nextI = i + 1;
                while (j < clips.length) {
                    if (clips[j][0] > end)
                        break;
                    if (clips[j][1] > maxEnd) {
                        maxEnd = clips[j][1];
                        nextI = j;
                    }
                    j++;
                }
                i = nextI;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        int[][] clips = {{0, 1}, {6, 8}, {0, 2}, {5, 6}, {0, 4}, {0, 3}, {6, 7}, {1, 3}, {4, 7}, {1, 4}, {2, 5}, {2, 6}, {3, 4}, {4, 5}, {5, 7}, {6, 9}};
        System.out.println(new Solution().videoStitching(clips, 9));
    }
}
