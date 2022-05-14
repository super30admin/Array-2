class Solution {
    // 1 less than 2 or greater than 3 1's dies
    // 1 1 with 2 or 3 1's lives
    // 0 with 3 1's live
    public void gameOfLife(int[][] board) {
        //edge
        if (board == null || board.length == 0) {
            return;
        }
        int r = board.length;
        int c = board[0].length;
        // 1-> 0 => 2
        // 0-> 1 => 3
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int liveNear = findLiveNeighbors(board, i, j);

                if (board[i][j] == 0 && liveNear == 3) {
                    board[i][j] = 3;
                }

                if ((board[i][j] == 1 || board[i][j] == 2)
                        && (liveNear < 2 || liveNear > 3)) {
                    board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int findLiveNeighbors(int[][] board, int i, int j) {
        int[][] dirs = {{0, 1}, {1, 0}, {1, 1}, {1, -1},
                {-1, 1}, {-1, -1}, {-1, 0}, {0, -1}};
        int count = 0;
        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            if (r < board.length && c < board[0].length &&
                    r >= 0 && c >= 0 && (board[r][c] == 1 || board[r][c] == 2)) {
                count++;
            }
        }
        return count;
    }
}
