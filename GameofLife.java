// Time Complexity : O(n*m) where n is the number of rows and m is the number of columns in the board
// Space Complexity :  O(N*M) for the new board to store the next state of the cells
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// The problem is to implement the Game of Life, which is a cellular automaton.
// The board is a 2D grid where each cell can be either alive (1) or dead (0).
// The next state of each cell is determined by the number of live neighbors it has.
// We define the 8 possible directions to check for neighbors.
// We iterate through each cell in the board and count the number of live neighbors for that cell.
// Based on the count of live neighbors and the current state of the cell, we apply the rules of the Game of Life to determine the next state of the cell.
// We store the next state in a new board to avoid modifying the original board while we are still counting neighbors.
// After processing all cells, we copy the new board back to the original board to update it with the next state.
// This is O(N *M) time complexity because we are iterating through each cell and checking its neighbors, and O(N) space complexity because we are using an additional board to store the next state of the cells.
    public void gameOfLife(int[][] board) {

        int[][] dir = new int[][] {
            {-1, -1}, {-1, 0}, {-1, 1},
            { 0, -1},          { 0, 1},
            { 1, -1}, { 1, 0}, { 1, 1}
        };

        int row = board.length;
        int col = board[0].length;

        int[][] newBoard = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                int count = 0;

                // count live neighbors
                for (int[] d : dir) {
                    int p = i + d[0];
                    int q = j + d[1];

                    if (p >= 0 && q >= 0 && p < row && q < col && board[p][q] == 1) {
                        count++;
                    }
                }

                // Game of Life rules
                if (board[i][j] == 1) {
                    if (count == 2 || count == 3) {
                        newBoard[i][j] = 1;
                    }
                } else {
                    if (count == 3) {
                        newBoard[i][j] = 1;
                    }
                }
            }
        }

        // copy back
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = newBoard[i][j];
            }
        }
    }
}