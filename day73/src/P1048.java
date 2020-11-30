import java.util.Scanner;

/**
 * @author Zixiang Hu
 * @description 0-1背包问题
 * @create 2020-08-19-16:45
 */
public class P1048 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//背包的容量
        int m = sc.nextInt();//物品的种类
        int[] value = new int[m + 1];
        int[] weight = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }
        // 二维 最好理解
/*        int[][] dp = new int[m + 1][t + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= t; j++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        System.out.println(dp[m][t]);*/

        // 一维
        int[] dp = new int[t + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = t; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        System.out.println(dp[t]);
    }
}
