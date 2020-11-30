import java.util.Scanner;

/**
 * @author Zixiang Hu
 * @description P1616 疯狂的采药
 * @create 2020-08-17-21:16
 */
public class P1616 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); //t代表背包容量
        int m = sc.nextInt(); //m代表物品种类，每种物品只有一个
        int[] price = new int[m + 1];
        int[] weight = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            weight[i] = sc.nextInt();
            price[i] = sc.nextInt();
        }

/*        long[][] dp = new long[m + 1][t + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= t; j++) {
                dp[i][j] = dp[i - 1][j];
                for (int k = 0; k * weight[i] <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * weight[i]] + k * price[i]);
                }
            }
        }
        System.out.println(dp[m][t]);*/
       /* long[] dp = new long[t + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = t; j >= weight[i]; j--) {
                for (int k = 0; k * weight[i] <= j; k++) {
                    dp[j] = Math.max(dp[j], dp[j - k * weight[i]] + k * price[i]);
                }
            }
        }*/
        long[] dp = new long[t + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= t; j++) {
                if (j >= weight[i])
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + price[i]);
            }
        }
        System.out.println(dp[t]);
    }
}
