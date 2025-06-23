// Time Complexity : O(m * n) — where m = number of rows, n = number of columns
// Space Complexity : O(1) — in-place solution using encoded state values
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// Approach:
// 1. For each cell, count the number of live neighbors using direction array.
// 2. Use in-place encoding to represent state transitions:
//    - 0 → 1 (dead to live) is marked as 3
//    - 1 → 0 (live to dead) is marked as 2
// 3. After updating all cells, decode them back:
//    - 2 becomes 0
//    - 3 becomes 1

class Solution {
    int[][] dirs; // 8-direction movement
    int m, n;     // matrix dimensions

    public void gameOfLife(int[][] board) {
        this.m = board.length;
        this.n = board[0].length;

        // Direction array for 8 neighbors
        this.dirs = new int[][]{
                {-1,-1},{-1,0},{-1,1},
                {0,-1},       {0,1},
                {1,-1},{1,0},{1,1}
        };

        // First pass: compute new state using in-place encoding
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = getCount(board, i, j); // count live neighbors

                if (board[i][j] == 0 && count == 3) {
                    board[i][j] = 3; // dead → live
                } else if (board[i][j] == 1 && (count < 2 || count > 3)) {
                    board[i][j] = 2; // live → dead
                }
            }
        }

        // Second pass: decode final states
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) board[i][j] = 0; // was live, now dead
                if (board[i][j] == 3) board[i][j] = 1; // was dead, now live
            }
        }
    }

    // Helper function to count live neighbors of board[i][j]
    private int getCount(int[][] board, int i, int j) {
        int count = 0;
        for (int[] dir : dirs) {
            int r = dir[0] + i;
            int c = dir[1] + j;

            // Check boundaries
            if (r >= 0 && c >= 0 && r < m && c < n) {
                // Treat current live (1) and transitioning (2) as alive
                if (board[r][c] == 1 || board[r][c] == 2) {
                    count++;
                }
            }
        }
        return count;
    }
}