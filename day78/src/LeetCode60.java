/**
 * @author Zixiang Hu
 * @description 60. 第k个排列
 * @create 2020-09-05-9:48
 */
public class LeetCode60 {
    static class Solution {
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

    public static void main(String[] args) {
        System.out.println(new Solution().getPermutation(3, 3));
        char[] chs = new char[2];
        chs[0] = (char) 2;
        System.out.println(chs[0]);
    }
}
