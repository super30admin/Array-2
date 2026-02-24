//We update the board in-place using state encoding so we don’t need an extra grid.
//
//Encoding:
//0 = dead → dead
//1 = alive → alive
//2 = alive → dead (was alive originally)
//3 = dead → alive (was dead originally)

//Pass 1: mark transitions using these codes (while still being able to read original state)
//Pass 2: convert 2 → 0 and 3 → 1
//To count live neighbors, treat cells as originally alive if value is 1 or 2.

//Time: O(m × n)
//Space: O(1) extra

class Solution {

    // 8 possible directions around a cell (neighbors)
    int[][] dirs;

    // Board dimensions
    int m, n;

    public void gameOfLife(int[][] board) {

        // All 8 neighbor directions (row delta, col delta)
        this.dirs = new int[][]{
                {-1, -1}, {-1,  0}, {-1,  1},
                { 0, -1},          { 0,  1},
                { 1, -1}, { 1,  0}, { 1,  1}
        };

        // Store dimensions for boundary checks
        this.m = board.length;
        this.n = board[0].length;

        // PASS 1: Decide next state, but store it using encoded values
        // We must preserve "original state" info while updating in-place.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // Count number of alive neighbors around (i, j)
                int count = getCount(board, i, j);

                // Rule: Dead cell with exactly 3 live neighbors becomes alive
                if (board[i][j] == 0 && count == 3) {
                    board[i][j] = 3; // 0 -> 1 transition (dead -> alive)
                }

                // Rule: Live cell dies if <2 or >3 live neighbors
                else if (board[i][j] == 1 && (count < 2 || count > 3)) {
                    board[i][j] = 2; // 1 -> 0 transition (alive -> dead)
                }

                // Otherwise:
                // - dead stays dead
                // - alive stays alive
                // and we keep the cell as 0 or 1 as-is
            }
        }

        // PASS 2: Finalize the board by converting transitional states
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // If it was alive and should become dead
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                }

                // If it was dead and should become alive
                else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    // Count how many live neighbors exist around cell (i, j)
    private int getCount(int[][] board, int i, int j) {

        int count = 0;

        // Check all 8 directions
        for (int[] dir : dirs) {

            int r = i + dir[0];
            int c = j + dir[1];

            // Boundary check to ensure neighbor is inside the board
            if (r >= 0 && c >= 0 && r < m && c < n) {

                // IMPORTANT:
                // 1 = originally alive and stays alive
                // 2 = originally alive but will die
                // Both should be counted as "alive" for neighbor counting
                if (board[r][c] == 1 || board[r][c] == 2) {
                    count++;
                }
            }
        }

        return count;
    }
}