/**
 * @author Zixiang Hu
 * @description 79. 单词搜索
 * @create 2020-07-04-16:12
 */
public class LeetCode79 {
    class Solution {
        int pos = 1;
        int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public boolean exist(char[][] board, String word) {
            boolean[][] visited = new boolean[board.length][board[0].length];
            for (int row = 0; row < board.length; row++)
                for (int col = 0; col < board[0].length; col++) {
                    if (board[row][col] == word.charAt(0)) {
                        visited[row][col] = true;
                        if (dfs(board, visited, word, row, col))
                            return true;
                        visited[row][col] = false;
                    }
                }
            return false;
        }

        private boolean dfs(char[][] board, boolean[][] visited, String word, int row, int col) {
            if (pos == word.length())
                return true;
            for (int[] dir : direction) {
                int x = row + dir[0];
                int y = col + dir[1];
                if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && !visited[x][y] && board[x][y] == word.charAt(pos)) {
                    pos++;
                    visited[x][y] = true;
                    if (dfs(board, visited, word, x, y))
                        return true;
                    pos--;
                    visited[x][y] = false;
                }
            }
            return false;
        }
    }

}
