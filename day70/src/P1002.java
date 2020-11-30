import java.util.Scanner;

/**
 * @author Zixiang Hu
 * @description P1002 过河卒
 * @create 2020-08-13-20:15
 */
public class P1002 {
    public static void main(String[] args) {
        int[][] pos = {{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}};
        Scanner sc = new Scanner(System.in);
//        终点位置
        int m = sc.nextInt() + 1, n = sc.nextInt() + 1;
        int x = sc.nextInt(), y = sc.nextInt();
        long[][] matrix = new long[m][n];
        matrix[x][y] = -1;
        for (int[] ele : pos) {
            int xx = ele[0] + x;
            int yy = ele[1] + y;
            if (xx >= 0 && xx < m && yy >= 0 && y < n)
                matrix[xx][yy] = -1;
        }
        matrix[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != -1) {
                    if (i - 1 >= 0 && matrix[i - 1][j] > 0)
                        matrix[i][j] += matrix[i - 1][j];
                    if (j - 1 >= 0 && matrix[i][j - 1] > 0)
                        matrix[i][j] += matrix[i][j - 1];
                }
            }
        }
        System.out.println(matrix[m - 1][n - 1]);
    }
}
