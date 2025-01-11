// TC: O(m*n)
// SC: O(1)

class LC289 {
    int[] neighboursX = { -1, -1, -1, 0, 0, 1, 1, 1 };
    int[] neighboursY = { -1, 0, 1, -1, 1, -1, 0, 1 };

    private int getNeighbours(int board[][], int i, int j, int m, int n) {
        int liveNeighbours = 0;
        for (int x = 0; x < 8; x++) {
            if (i + neighboursX[x] >= 0 && i + neighboursX[x] < m && j + neighboursY[x] >= 0 && j + neighboursY[x] < n
                    && (board[i + neighboursX[x]][j + neighboursY[x]] % 2) == 1)
                liveNeighbours++;
        }
        return liveNeighbours;
    }

    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbours = getNeighbours(board, i, j, m, n);
                if (board[i][j] == 1 && (liveNeighbours < 2 || liveNeighbours > 3))
                    board[i][j] = 3;
                else if (board[i][j] == 0 && liveNeighbours == 3)
                    board[i][j] = 2;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cs = board[i][j];
                if (cs == 2 || cs == 3)
                    board[i][j] = 3 - cs;
            }
        }
    }
}