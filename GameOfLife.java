// Time Complexity : O(m * n) where m is the number of rows, and n is the number of columns
// Space Complexity : O(1)

public class GameOfLife {
    public int check(int[][] board, int i, int j) {
        int r = board.length, c = board[0].length;
        if (i < 0 || i >= r || j < 0 || j >= c)
            return 0;
        if (Math.abs(board[i][j]) == 1)
            return 1;
        return 0;
    }

    public void gameOfLife(int[][] board) {
        int r = board.length, c = board[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int live = check(board, i, j + 1) + check(board, i, j - 1) + check(board, i + 1, j)
                        + check(board, i - 1, j) + check(board, i + 1, j + 1) + check(board, i - 1, j - 1)
                        + check(board, i - 1, j + 1) + check(board, i + 1, j - 1);

                if (board[i][j] > 0)
                    if (live < 2 || live > 3)
                        board[i][j] = -1;

                if (board[i][j] < 1)
                    if (live == 3)
                        board[i][j] = 2;
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                }
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }
    }
}
