// Time Complexity : O(n*m) where n is the number of rows and m is the number of columns in the board
// Space Complexity :  O(1) for the in-place solution, as we are using the original board to store the next state of the cells
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// The problem is to implement the Game of Life, which is a cellular automaton.
// The board is a 2D grid where each cell can be either alive (1) or dead (0).
// The next state of each cell is determined by the number of live neighbors it has.
// We define the 8 possible directions to check for neighbors.
// We iterate through each cell in the board and count the number of live neighbors for that cell.
// Based on the count of live neighbors and the current state of the cell, we apply the rules of the Game of Life to determine the next state of the cell.
// We use the original board to mark the transitions of states. We use the following encoding for the transitions:
// 0 → 1 is marked as 3 (dead to live)
// 1 → 0 is marked as 2 (live to dead)
// After processing all cells, we iterate through the board again to finalize the states. We set cells marked as 1 or 3 to 1 (alive) and cells marked
class Solution {
    public void gameOfLife(int[][] board) {

        int[][] dir = new int[][] {
            {-1, -1}, {-1, 0}, {-1, 1},
            { 0, -1},          { 0, 1},
            { 1, -1}, { 1, 0}, { 1, 1}
        };

        int row = board.length;
        int col = board[0].length;

        // Step 1: mark transitions
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                int count = 0;

                // count live neighbors (1 or 2 means originally alive)
                for (int[] d : dir) {
                    int p = i + d[0];
                    int q = j + d[1];

                    if (p >= 0 && q >= 0 && p < row && q < col &&
                       (board[p][q] == 1 || board[p][q] == 2)) {
                        count++;
                    }
                }

                // live → dead
                if (board[i][j] == 1) {
                    if (count < 2 || count > 3) {
                        board[i][j] = 2;
                    }
                }
                // dead → live
                else {
                    if (count == 3) {
                        board[i][j] = 3;
                    }
                }
            }
        }

        // Step 2: finalize states
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (board[i][j] == 1 || board[i][j] == 3) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }
}