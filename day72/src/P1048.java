import java.util.Scanner;

/**
 * @author Zixiang Hu
 * @description P1048 采药
 * @create 2020-08-17-20:42
 */
public class P1048 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); //t代表背包容量
        int m = sc.nextInt(); //m代表物品种类，每种物品只有一个
        // 这里多填充一行一列是为了方便处理越界问题
        int[] price = new int[m + 1];
        int[] weight = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            weight[i] = sc.nextInt();
            price[i] = sc.nextInt();
        }
        // 初始版
       /* int[][] dp = new int[m + 1][t + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= t; j++) {
                if (j >= weight[i])
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + price[i]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        System.out.println(dp[m][t]);*/

        // 中间版
        int[][] dp = new int[2][t + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= t; j++) {
                if (j >= weight[i]) {
                    dp[1][j] = Math.max(dp[0][j], dp[0][j - weight[i]] + price[i]);
                } else {
                    dp[1][j] = dp[0][j];
                }
            }
            for (int j = 1; j <= t; j++) {
                dp[0][j] = dp[1][j];
            }
        }
        System.out.println(dp[1][t]);
        // 终极版
      /*  int[] dp = new int[t + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = t; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j],dp[j-weight[i]] + price[i]);
            }
        }
        System.out.println(dp[t]);*/
    }
}
