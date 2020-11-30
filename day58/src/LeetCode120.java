import java.util.List;

/**
 * @author Zixiang Hu
 * @description 120. 三角形最小路径和
 * @create 2020-07-14-10:48
 */
public class LeetCode120 {
    // 思路1：简单的二维dp，dp[i][j]代表从顶点到i,j这个位置时最小的路径和
    //初始条件dp[0][0]=triangle.get(0).get(0)；
    //边界条件：如果j=0，dp[i][j]=dp[i-1][j]+ele（ele代表当前位置的值）；如果j=i，说明位于最左边的列，此时dp[i-1][j]应该是不存在的
    //因此dp[i][j]=dp[i-1][j-1]+ele
    //除了上述初始条件和边界条件，dp[i][j]=Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + ele;
    //返回值是最后一行的最小值
  /*  public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m][m];
        dp[0][0] = triangle.get(0).get(0);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j <= i; j++) {
                int ele = triangle.get(i).get(j);
                //说明位于最左边一列
                if (j == 0)
                    dp[i][j] = dp[i - 1][j] + ele;
                //说明位于最右边一列
                else if (j == i)
                    dp[i][j] = ele + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + ele;
            }
        }
        for (int ele : dp[dp.length - 1]) {
            ans = Math.min(ans, ele);
        }
        return ans;
    }*/

    //从最下面一列开始dp
/*    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m + 1][m + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }*/
    //从下面开始dp，使用空间优化策略
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[] dp = new int[m + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
