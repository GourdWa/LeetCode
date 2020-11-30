/**
 * @author Zixiang Hu
 * @description 79. 单词搜索
 * @create 2020-09-13-13:55
 */
public class LeetCode79 {
    static class Solution {
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean[][] visited;

        public boolean exist(char[][] board, String word) {
            visited = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        visited[i][j] = true;
                        if (dfs(board, word, i, j, 1))
                            return true;
                        visited[i][j] = false;
                    }

                }
            }
            return false;
        }

        private boolean dfs(char[][] board, String word, int x, int y, int i) {
            if (i == word.length())
                return true;
            for (int[] ele : dir) {
                int xx = x + ele[0];
                int yy = y + ele[1];
                if (xx >= 0 && xx < board.length && yy >= 0 && yy < board[0].length
                        && !visited[xx][yy] && board[xx][yy] == word.charAt(i)) {
                    visited[xx][yy] = true;
                    if (dfs(board, word, xx, yy, i + 1))
                        return true;
                    visited[xx][yy] = false;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        char[][] bord = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        System.out.println(new Solution().exist(bord, "ABCCED"));
    }
}
