import sun.misc.Unsafe;

/**
 * @author Zixiang Hu
 * @description 63. 不同路径 II
 * @create 2020-07-06-14:02
 */
public class LeetCode63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] != 1)
                dp[0][i] = 1;
            else
                break;
        }
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] != 1)
                dp[i][0] = 1;
            else
                break;
        }
        for (int row = 1; row < obstacleGrid.length; row++) {
            for (int col = 1; col < obstacleGrid[0].length; col++) {
                if (obstacleGrid[row][col] != 1) {
                    dp[row][col] = dp[row][col - 1] + dp[row - 1][col];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {
//        Unsafe.getUnsafe()
    }
}
