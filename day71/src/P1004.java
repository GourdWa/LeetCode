import java.util.Scanner;

/**
 * @author Zixiang Hu
 * @description P1004 方格取数
 * @create 2020-08-14-15:38
 */
public class P1004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        这里加2，相当于在原来矩阵外面铺了一圈0，这样的好处是避免越界
        int n = sc.nextInt();
        int[][] matrix = new int[n + 2][n + 2];
        int[][][][] dp = new int[n + 2][n + 2][n + 2][n + 2];
        while (true) {
            int x = sc.nextInt(), y = sc.nextInt(), val = sc.nextInt();
            if (x == 0 && y == 0 && val == 0)
                break;
            matrix[x][y] = val;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    for (int l = 1; l <= n; l++) {
                        int temp1 = Math.max(dp[i - 1][j][k - 1][l], dp[i][j - 1][k - 1][l]);
                        int temp2 = Math.max(dp[i - 1][j][k][l - 1], dp[i][j - 1][k][l - 1]);
                        dp[i][j][k][l] = Math.max(temp1, temp2) + matrix[i][j] + matrix[k][l];
                        if (i == k && j == l)
                            dp[i][j][k][l] -= matrix[k][l];
                    }
                }
            }
        }
        System.out.println(dp[n][n][n][n]);
    }
}
