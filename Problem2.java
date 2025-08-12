/*
Time Complexity:-O(m*n)
Space Complexity:-O(1)
Approach:-The game is played on a grid where:1 = alive, 0 = dead
You must compute the next state of each cell based on its 8 neighbors, in-place (without using extra space). To do this, we use temporary encoded values:
2 = was alive → now dead
3 = was dead → now alive
Final pass converts all encoded values to 0 or 1.
*/
class Problem2 {
    int[][] dirs; // direction vectors for 8 neighbors
    int m, n; // grid dimensions

    public void gameOfLife(int[][] board) {
        // Define 8 possible directions (top-left, top, top-right, etc.)
        this.dirs = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 },
                { 1, 1 } };

        this.m = board.length; // number of rows
        this.n = board[0].length; // number of columns
        // First pass: determine and encode the state transitions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = getCount(board, i, j); // number of alive cells around it
                // Rule: dead cell with exactly 3 live neighbors becomes alive
                if (board[i][j] == 0 && count == 3) {
                    board[i][j] = 3; // dead -> alive;
                } else if (board[i][j] == 1 && (count < 2 || count > 3)) { // Rule: live cell with <2 or >3 live
                                                                           // neighbors dies
                    board[i][j] = 2; // alive -> dead;
                }
            }
        }
        // Second pass: decode encoded values to final state
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;// cell died
                } else if (board[i][j] == 3) {
                    board[i][j] = 1;// cell became alive
                }
            }
        }
    }

    // Helper method to count live neighbors
    private int getCount(int[][] board, int i, int j) {
        int count = 0;

        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            // Check bounds
            if (r >= 0 && c >= 0 && r < m && c < n) {
                // Consider cells that were alive originally: 1 or 2
                if (board[r][c] == 1 || board[r][c] == 2)
                    count++;
            }
        }

        return count;
    }
}