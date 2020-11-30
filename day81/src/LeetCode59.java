/**
 * @author Zixiang Hu
 * @description 59. 螺旋矩阵 II
 * @create 2020-09-11-10:36
 */
public class LeetCode59 {
   /* class Solution {
        public int[][] generateMatrix(int n) {
            int[][] ans = new int[n][n];
            int left = 0, right = n - 1, top = 0, bottom = n - 1;
            int i = 1;
            int len = n * n;
            while (i <= len) {
                for (int j = left; i <= len && j <= right; j++) {
                    ans[top][j] = i++;
                }
                top++;
                for (int j = top; i <= len && j <= bottom; j++) {
                    ans[j][right] = i++;
                }
                right--;
                for (int j = right; i <= len && j >= left; j--) {
                    ans[bottom][j] = i++;
                }
                bottom--;
                for (int j = bottom; i <= len && j >= top; j--) {
                    ans[j][left] = i++;
                }
                left++;
            }
            return ans;
        }
    }*/
   class Solution {
       String ans;
       boolean recursion;
       int cnt;

       public String getPermutation(int n, int k) {
           boolean[] visited = new boolean[n];
           dfs(visited, new StringBuilder(), n, k);
           return ans;
       }

       private void dfs(boolean[] visited, StringBuilder sb, int n, int k) {
           if (sb.length() == n) {
               cnt++;
               if (cnt == k) {
                   ans = sb.toString();
                   recursion = true;
                   return;
               }
           } else {
               for (int j = 1; j <= n; j++) {
                   if (!visited[j - 1] && !recursion) {
                       sb.append(j);
                       visited[j - 1] = true;
                       dfs(visited, sb, n, k);
                       sb.deleteCharAt(sb.length() - 1);
                       visited[j - 1] = false;
                   }
               }
           }
       }
   }
}
