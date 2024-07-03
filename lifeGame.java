// Time Complexity : o(N*M)
// Space Complexity : o(1) // no additional space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    // Method to calculate the number of live neighbors for a given cell
    private int calculateLives(int row, int col, int[][] board, int[][] dir) {
        int lives = 0;
        // Loop through each direction to check for live neighbors
        for (int[] d : dir) {
            int currentRow = row + d[0];
            int currentCol = col + d[1];
            // Check if the neighbor is within bounds and is a live cell
            if ((currentCol >= 0 && currentCol < board[0].length && currentRow >= 0 && currentRow < board.length)
                    && (board[currentRow][currentCol] == 1 || board[currentRow][currentCol] == 3)) {
                lives++;
            }
        }
        return lives;
    }

    // Method to apply the Game of Life rules to the board
    public void gameOfLife(int[][] board) {
        // Define the number of rows and columns
        int totalRows = board.length - 1;
        int totalCols = board[0].length - 1;
        // Define all 8 possible directions
        int[][] dir = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
        
        // First pass: Apply the rules of the game and mark cells with temporary values
        for (int row = 0; row <= totalRows; row++) {
            for (int col = 0; col <= totalCols; col++) {
                // Calculate the number of live neighbors
                int lives = calculateLives(row, col, board, dir);
                
                // Rule 1 or Rule 3: Any live cell with fewer than two live neighbors dies (underpopulation)
                // Any live cell with more than three live neighbors dies (overpopulation)
                if (board[row][col] == 1) {
                    if (lives < 2 || lives > 3) {
                        board[row][col] = 3; // Mark as 3 (1 -> 0)
                    }
                }
                // Rule 4: Any dead cell with exactly three live neighbors becomes a live cell (reproduction)
                else {
                    if (lives == 3) {
                        board[row][col] = 4; // Mark as 4 (0 -> 1)
                    }
                }
            }
        }

        // Second pass: Update the board to the new state
        for (int row = 0; row <= totalRows; row++) {
            for (int col = 0; col <= totalCols; col++) {
                // Change temporary marks back to final state
                if (board[row][col] == 3) {
                    board[row][col] = 0; // Cell marked 3 becomes dead
                } else if (board[row][col] == 4) {
                    board[row][col] = 1; // Cell marked 4 becomes alive
                }
            }
        }
    }
}
