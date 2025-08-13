// Time Complexity : O(m * n) // m = number of rows, n = number of columns
// Space Complexity : O(1)    // In-place updates, only directions array used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Understanding how to update the board
// without affecting neighbor counts in the same round; solved it by using markers 2 and 3.
//
// Approach :
// 1. Iterate through each cell, count its alive neighbors using the directions array.
// 2. Use markers (2 = dead→alive, 3 = alive→dead) to store transitions without affecting counts.
// 3. In a second pass, replace markers with their final states (1 or 0).

class Solution {
    int[][] directions; // 8 directions to check neighbors
    int m, n;           // dimensions of the board
    
    public void gameOfLife(int[][] board) {
        this.directions = new int[][]{
            {-1, -1}, {-1, 0}, {-1, 1}, // top row
            { 0, -1},          { 0, 1}, // left & right
            { 1, -1}, { 1, 0}, { 1, 1}  // bottom row
        };
        
        this.m = board.length;
        this.n = board[0].length;

        // First pass: mark cells with transitional states
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = getCount(board, i, j); // alive neighbor count

                // Rule 4: Dead cell with exactly 3 alive neighbors → will become alive
                if (board[i][j] == 0 && count == 3) {
                    board[i][j] = 2; // 2 means dead → alive
                }
                // Rule 1 & 3: Live cell with <2 or >3 alive neighbors → will die
                else if (board[i][j] == 1 && (count < 2 || count > 3)) {
                    board[i][j] = 3; // 3 means alive → dead
                }
            }
        }

        // Second pass: finalize states by replacing markers with final values
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1; // dead→alive
                } else if (board[i][j] == 3) {
                    board[i][j] = 0; // alive→dead
                }
            }
        }
    }

    // Helper method to count alive neighbors (original state)
    private int getCount(int[][] board, int i, int j) {
        int count = 0;

        for (int[] dir : directions) {
            int r = i + dir[0]; // neighbor's row
            int c = j + dir[1]; // neighbor's col

            // Check bounds and count if originally alive (1 or 3)
            if (r >= 0 && c >= 0 && r < m && c < n &&
                (board[r][c] == 1 || board[r][c] == 3)) {
                count++;
            }
        }

        return count;
    }
}
