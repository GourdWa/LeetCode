/**
 * @author Zixiang Hu
 * @description 130. 被围绕的区域
 * @create 2020-08-11-8:51
 */
public class LeetCode130 {
    static class Solution {
        int[][] pos = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        public void solve(char[][] board) {
            if (board == null || board.length == 0)
                return;
            boolean[][] visited = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    //如果是第一行、最后一行、第一列或者最后一列
                    if (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) {
                        //标记为访问过
                        visited[i][j] = true;
                        //如果这个元素是X，那么将其相邻的X全部访问一遍并标记为true
                        //如果这个元素是O，同样，将其相邻的O全部访问一边并标记为true
                        dfs(board, visited, i, j, board[i][j] == 'X');
                    }
                }
            }
            //最后剩下的未标记的O就是带反转的区域
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (!visited[i][j] && board[i][j] == 'O')
                        board[i][j] = 'X';
                }
            }
        }

        private void dfs(char[][] board, boolean[][] visited, int x, int y, boolean isX) {
            for (int[] ele : pos) {
                int xx = x + ele[0];
                int yy = y + ele[1];
                if (xx >= 0 && xx < visited.length && yy >= 0 && yy < visited[0].length && !visited[xx][yy]) {
                    if (isX && board[xx][yy] == 'X') {
                        visited[xx][yy] = true;
                        dfs(board, visited, xx, yy, true);
                    } else if (!isX && board[xx][yy] == 'O') {
                        visited[xx][yy] = true;
                        dfs(board, visited, xx, yy, false);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] chs = new char[][]
                {{'X', 'O', 'X', 'O', 'X', 'O'},
                        {'O', 'X', 'O', 'X', 'O', 'X'},
                        {'X', 'O', 'X', 'O', 'X', 'O'},
                        {'O', 'X', 'O', 'X', 'O', 'X'}};
        new Solution().solve(chs);
    }

}
