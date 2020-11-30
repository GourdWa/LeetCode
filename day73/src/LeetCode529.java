/**
 * @author Zixiang Hu
 * @description 529. 扫雷游戏
 * @create 2020-08-20-9:46
 */
public class LeetCode529 {
    class Solution {
        int[][] dir = new int[][]{{-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};

        public char[][] updateBoard(char[][] board, int[] click) {
            if (board[click[0]][click[1]] == 'M') {
                board[click[0]][click[1]] = 'X';
                return board;
            }
            dfs(board, click[0], click[1]);
            return board;
        }

        private void dfs(char[][] board, int x, int y) {
            //用于统计四周的地雷数量
            int cnt = 0;
            for (int[] ele : dir) {
                int xx = ele[0] + x;
                int yy = ele[1] + y;
                if (xx >= 0 && xx < board.length && yy >= 0 && yy < board[0].length) {
                    if (board[xx][yy] == 'M')
                        cnt++;
                }
            }
            if (cnt != 0) {
                board[x][y] = (char) (cnt + '0');
            } else {
                board[x][y] = 'B';
                for (int[] ele : dir) {
                    int xx = ele[0] + x;
                    int yy = ele[1] + y;
                    if (xx >= 0 && xx < board.length && yy >= 0 && yy < board[0].length) {
                        if (board[xx][yy] == 'E')
                            dfs(board, xx, yy);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
