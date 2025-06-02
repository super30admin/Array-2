// Approach:
// Use bit manipulation to store both the current and next state in each cell.
// The least significant bit (LSB) represents the current state,
// and the second least significant bit stores the next state.
// After computing all states, right shift to update the board.

// Time Complexity : O(m * n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;

        int m = board.length, n = board[0].length;

        // First pass: determine next state and encode it in the 2nd bit
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = liveNeighbors(board, m, n, i, j);

                // If currently alive and has 2 or 3 live neighbors, stay alive
                if (board[i][j] == 1 && lives >= 2 && lives <= 3) {
                    board[i][j] = 3; // Binary 11: current=1, next=1
                }

                // If currently dead and has exactly 3 live neighbors, become alive
                if (board[i][j] == 0 && lives == 3) {
                    board[i][j] = 2; // Binary 10: current=0, next=1
                }
            }
        }

        // Second pass: update board by shifting bits to set the new state
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1; // Shift to make next state the current state
            }
        }
    }

    // Helper method to count live neighbors (only consider LSB)
    public int liveNeighbors(int[][] board, int m, int n, int i, int j) {
        int lives = 0;

        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
                lives += board[x][y] & 1;
            }
        }

        lives -= board[i][j] & 1; // Exclude the cell itself
        return lives;
    }
}
