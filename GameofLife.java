// Time Complexity :  O(MN) where M is number of rows and N is number of columns of Board.
// Space Complexity : O(1) - No extra space is used
// Did this code successfully run on Leetcode : Yes

class GameofLife {
    public void gameOfLife(int[][] board) {

        int[] neighbors = {0, 1, -1}; // find 8 directions for a given cell

        int rows = board.length;
        int cols = board[0].length;

        for (int row = 0; row < rows; row++) {   // Iterate through every cell in board.
            for (int col = 0; col < cols; col++) {

                int liveNeighbors = 0;

                for (int i = 0; i < 3; i++) {          // iterate over each direction
                    for (int j = 0; j < 3; j++) {

                        if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
                            int r = (row + neighbors[i]);
                            int c = (col + neighbors[j]);
                             // Check the validity of the neighboring cell.
                            // and whether it was originally a live cell.
                            if ((r < rows && r >= 0) && (c < cols && c >= 0) && (Math.abs(board[r][c]) == 1)) {
                                liveNeighbors += 1;
                            }
                        }
                    }
                }

              
                if ((board[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) {   // Rule 1 or Rule 3
                    // -1 signifies the cell is now dead but originally was live.
                    board[row][col] = -1;
                }
                // Rule 4
                if (board[row][col] == 0 && liveNeighbors == 3) {
                    // 2 signifies the cell is now live but was originally dead.
                    board[row][col] = 2;
                }
            }
        }

        
        for (int row = 0; row < rows; row++) { // retrieve newly updated board.
            for (int col = 0; col < cols; col++) {
                if (board[row][col] > 0) {
                    board[row][col] = 1;
                } else {
                    board[row][col] = 0;
                }
            }
        }
    }
}