public class GameOfLife {

    // SC O(1)
    // TC // O(m*n) m is number of rows and n is number of columns
    int m, n;

    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int countAlive = count(board, i, j);
                // rule 1 and 3
                if (board[i][j] == 1 && (countAlive < 2 || countAlive > 3)) {
                    board[i][j] = 2;
                }
                // rule 4
                if (board[i][j] == 0 && (countAlive == 3)) {
                    board[i][j] = 3;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                }
                if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int count(int[][] board, int i, int j) {
        int[] neighbors = new int[] { -1, 0, 1 };
        int alive = 0;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                int nRow = i + neighbors[r];
                int nCol = j + neighbors[c];
                if (i != nRow || j != nCol) {
                    if ((nRow >= 0 && nRow < board.length) && (nCol >= 0 && nCol < board[0].length)) {
                        if (board[nRow][nCol] == 1 || board[nRow][nCol] == 2) {
                            alive++;
                        }
                    }
                }
            }
        }
        return alive;
    }
}
