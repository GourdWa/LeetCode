/**
 * @author Zixiang Hu
 * @description 200. 岛屿数量
 * @create 2020-09-18-9:49
 */
public class LeetCode200 {
    static class Solution {
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public int numIslands(char[][] grid) {
            if (grid==null||grid.length==0)
                return 0;
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            int ans = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (!visited[i][j] && grid[i][j] == '1') {
                        ans++;
                        dfs(grid, visited, i, j);
                    } else {
                        visited[i][j] = true;
                    }
                }
            }
            return ans;
        }

        private void dfs(char[][] grid, boolean[][] visited, int x, int y) {
            visited[x][y] = true;
            for (int[] ele : dir) {
                int xx = x + ele[0];
                int yy = y + ele[1];
                if (xx >= 0 && xx < visited.length && yy >= 0 && yy < visited[0].length
                        && !visited[xx][yy] && grid[xx][yy] == '1') {
                    dfs(grid, visited, xx, yy);
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] chs = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        new LeetCode200.Solution().numIslands(chs);
    }
}
