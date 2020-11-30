import java.util.Arrays;

/**
 * @author Zixiang Hu
 * @description LCP 19. 秋叶收藏集
 * @create 2020-10-04-10:17
 */
public class LCP19 {
    class Solution {
        public int minimumOperations(String leaves) {
            if (leaves == null || leaves.length() == 0)
                return 0;
            int[][] f = new int[leaves.length()][3];
            for (int[] ff : f) {
                Arrays.fill(ff, Integer.MAX_VALUE);
            }
            f[0][0] = leaves.charAt(0) == 'r' ? 0 : 1;
            for (int i = 1; i < leaves.length(); i++) {
                char ch = leaves.charAt(i);
                f[i][0] = f[i - 1][0] + (ch == 'y' ? 1 : 0);
                f[i][1] = Math.min(f[i - 1][0], f[i - 1][1]) + (ch == 'r' ? 1 : 0);
                if (i >= 2)
                    f[i][2] = Math.min(f[i - 1][1], f[i - 1][2]) + (ch == 'y' ? 1 : 0);
            }
            return f[leaves.length() - 1][2];
        }
    }
}
