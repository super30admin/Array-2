// Time complexity:- O(m * n)
// Space complexity:- O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * Approach:
 * The problem simulates the "Game of Life" where the next state of each cell depends on its neighbors.
 * I counted the live neighbors for each cell and temporarily marked cells for transition using intermediate 
 * states (11 for dying and 20 for becoming live). After processing all cells, I updated the board to reflect 
 * the final state of each cell.
 */ 
class Solution {
    public void gameOfLife(int[][] board) {

        // Get the number of rows and columns of the board
        int rows = board.length;
        int cols = board[0].length;
        
        // Iterate over each cell in the grid
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {

                // Initialize the count of live neighbors
                int count = 0;

                // Check the 8 possible neighbors around the current cell
                // We check for the boundary conditions to ensure valid indices
                // Check the cell above (up)
                if(i-1 >= 0 && (board[i-1][j] == 1 ||  board[i-1][j] == 11)) {
                    count++;
                }
                // Check the diagonal cell above and to the right (up-right)
                if(i-1 >= 0 && j+1 < cols && (board[i-1][j+1] == 1 || board[i-1][j+1] == 11)) {
                    count++;
                }

                // Check the cell to the right
                if(j+1 < cols && (board[i][j+1] == 1 || board[i][j+1] == 11)) {
                    count++;
                }

                // Check the diagonal cell below and to the right (down-right)
                if(i+1 < rows && j+1 < cols && (board[i+1][j+1] == 1 || board[i+1][j+1] == 11)) {
                    count++;
                }

                // Check the cell below (down)
                if(i+1 < rows && (board[i+1][j] == 1 || board[i+1][j] == 11)) {
                    count++;
                }

                // Check the diagonal cell below and to the left (down-left)
                if(i+1 < rows && j-1 >= 0 && (board[i+1][j-1] == 1 || board[i+1][j-1] == 11)) {
                    count++;
                }

                // Check the cell to the left
                if(j-1 >= 0 && (board[i][j-1] == 1 || board[i][j-1] == 11)) {
                    count++;
                }

                // Check the diagonal cell above and to the left (up-left)
                if(i-1 >= 0 && j-1 >= 0 && (board[i-1][j-1] == 1 || board[i-1][j-1] == 11)) {
                    count++;
                }
                
                // Now update the cell's state based on the count of live neighbors
                // We use temporary states (11 and 20) to mark cells in transition
                // Rule 1: Any live cell with fewer than two live neighbors dies 
                if(board[i][j] == 1 && count < 2) {
                    // Temporarily mark the cell to be dead
                    board[i][j] = 11;
                // Rule 2: Any live cell with two or three live neighbors lives on
                } else if(board[i][j] == 1 && (count == 2 || count == 3)) {
                    // Remains live
                    board[i][j] = 1;
                // Rule 3: Any live cell with more than three live neighbors dies 
                } else if(board[i][j] == 1 && count > 3) {
                    // Temporarily mark the cell to be dead
                    board[i][j] = 11;
                // Rule 4: Any dead cell with exactly three live neighbors becomes live 
                } else if(board[i][j] == 0 && count == 3) {
                    // Temporarily mark the cell to be alive
                    board[i][j] = 20;
                }

            }
        }
        // Finalize the board to reflect the next state:
        // Convert temporary states back to the final states (0 or 1)
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                // Mark dead cells (11) as 0
                if(board[i][j] == 11){
                    board[i][j] = 0;
                // Mark newly alive cells (20) as 1
                } else if(board[i][j] == 20) {
                    board[i][j] = 1;
                }
            }
        }
                
    }
}


