/**
 * @author ZixiangHu
 * @create 2020-06-10  16:44
 * @description
 */
public class LeetCode36 {
    public void solveSudoku(char[][] board) {
        dfs(board, 0, 0);
    }

    public boolean dfs(char[][] board, int row, int col) {
        //如果已经到了第9行，则说明结束
        if (row == 9)
            return true;
        //如果到了第9列，则换行
        if (col == 9)
            return dfs(board, row + 1, 0);
        if (board[row][col] != '.')
            return dfs(board, row, col + 1);
        for (char ch = '1'; ch <= '9'; ch++) {
            if (isValid(board, row, col, ch)) {
                board[row][col] = ch;
                if (!dfs(board, row, col + 1))
                    board[row][col] = '.';
                else
                    return true;
            }
        }
        return false;
    }

    public boolean isValid(char[][] board, int row, int col, char ch) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == ch)
                return false;
            if (board[row][i] == ch)
                return false;
            if (board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3] == ch)
                return false;
        }
        int startX = row / 3 * 3, startY = col / 3 * 3;
        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if (board[i][j] == ch)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        new LeetCode36().solveSudoku(board);
    }
}
