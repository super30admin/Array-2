public class GameOfLife {
    // TC: O(M * N) where M is number of rows and N is number of cols
    // SC: O(1)
    int LIVE_TO_DEAD = 2, DEAD_TO_LIVE = 3;
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = getLiveNeighbors(board, i, j);
                if (board[i][j] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[i][j] = LIVE_TO_DEAD;
                    }
                } else {
                    if (liveNeighbors == 3) {
                        board[i][j] = DEAD_TO_LIVE;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == DEAD_TO_LIVE) {
                    board[i][j] = 1;
                } else if (board[i][j] == LIVE_TO_DEAD) {
                    board[i][j] = 0;
                }
            }
        }
    }

    private int getLiveNeighbors(int[][] board, int i, int j) {
        int m = board.length, n = board[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
        int count = 0;
        for (int[] dir : directions) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];
            if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n &&
                    (board[nextI][nextJ] == 1 || board[nextI][nextJ] == LIVE_TO_DEAD)) {
                count++;
            }
        }
        return count;
    }
}