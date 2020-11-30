import java.util.Scanner;

/**
 * @author Zixiang Hu
 * @description 0-1口袋问题
 * @create 2020-08-19-17:13
 */
public class Pocket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] weight = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            weight[i] = sc.nextInt();
        }
        // dp[i][j]代表前i种物品装满容量为j口袋有多少种组合
        // 对于第i个物品，有装或者不装。如果不装，那么dp[i][j] = dp[i-1][j]
        // 如果装，dp[i][j] = dp[i-1][j-weight[i]]（也就是前i-1种物品刚好装了j-weight[i]的空间，第i种物品装进去后刚好装满空间j）
        // 对于前0种物品装满容量为0的方法只有1种；对于前x种物品，装满空间为0的方法也只有1种，就是什么都不装，因此dp数组第一列为1
        int[][] dp = new int[n + 1][41];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 40; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= weight[i])
                    dp[i][j] += dp[i - 1][j - weight[i]];
            }
        }
        System.out.println(dp[n][40]);
    }
}
