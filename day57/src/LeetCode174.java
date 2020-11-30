import java.util.Map;

/**
 * @author Zixiang Hu
 * @description 174. 地下城游戏
 * @create 2020-07-12-10:30
 */
public class LeetCode174 {

    public static int calculateMinimumHP(int[][] dungeon) {
        /*
            dp[i][j]表示在[i][j]位置上扣完血之后剩余的最少血量

        */

        //
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];

        dp[m - 1][n - 1] = 1;
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.max(dp[i + 1][n - 1] - dungeon[i + 1][n - 1], 1);
        }

        for (int i = n - 2; i >= 0; i--) {
            dp[m - 1][i] = Math.max(dp[m - 1][i + 1] - dungeon[m - 1][i + 1], 1);
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                //走右边的话需要血量
                int right = Math.max(dp[i][j + 1] - dungeon[i][j + 1], 1);
                //走下面的话需要血量
                int down = Math.max(dp[i + 1][j] - dungeon[i + 1][j], 1);
                dp[i][j] = Math.min(right, down);
            }
        }

        return Math.max(dp[0][0] - dungeon[0][0], 1);

    }


    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {-2, -3, 3},
                {-5, -10, -2},
                {10, 30, -5}
        };
        calculateMinimumHP(arr);
    }
}
