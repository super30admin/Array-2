// Time Complexity - O(2mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {

    private int[][] dirs;

    public void gameOfLife(int[][] board) {

        int m = board.length; // Rows
        int n = board[0].length; // Columns

        // Directions - Behind, Forward, Up, Down, Diagonals
        this.dirs = new int[][] { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 }, { -1, -1 }, { -1, 1 }, { 1, 1 },
                { 1, -1 } };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int countAlive = countAlive(board, i, j);
                if (board[i][j] == 1 && (countAlive < 2 || countAlive > 3)) {
                    // it dies
                    board[i][j] = -1;
                } else if (board[i][j] == 0 && countAlive == 3) {
                    // Becomes alive
                    board[i][j] = -2;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                }

                if (board[i][j] == -2) {
                    board[i][j] = 1;
                }
            }
        }

    }

    private int countAlive(int[][] board, int row, int column) {

        int aliveCount = 0;

        // Iterate
        for (int[] dir : dirs) {

            int nr = row + dir[0];
            int nc = column + dir[1];

            // bounds check
            if (nr >= 0 && nc >= 0 && nr < board.length
                    && nc < board[0].length
                    && (board[nr][nc] == 1 || board[nr][nc] == -1)) {
                aliveCount++;
            }
        }

        return aliveCount;
    }
}