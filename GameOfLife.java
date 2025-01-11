import java.util.Arrays;

/**
 * Time Complexity : O(m*n)
 * Space Complexity :
 * Did this code successfully run on Leetcode :
 * Any problem you faced while coding this :
 * <p>
 * Approach:
 * - If a cell is alive (1) and has fewer than 2 or more than 3 live neighbors,
 * it is marked for death by changing its state to 2
 * - If a cell is dead (0) and has exactly 3 live neighbors,
 * it is marked to alive by changing its state to 3
 * - Iterate over the board again and update the values.
 * Any cell marked as 2 is converted to dead (0), and any cell marked as 3 is converted to alive (1).
 */
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int rows = board.length, cols = board[0].length;

        // Iterate over each cell to compute the next state
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int liveNeighbors = countLiveNeighbors(board, row, col);

                // Rule 1 or 3: Any live cell with fewer than 2 or more than 3 live neighbors dies
                if (board[row][col] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[row][col] = 2; // Mark as 'to die'
                }

                // Rule 4: Any dead cell with exactly 3 live neighbors becomes alive
                if (board[row][col] == 0 && liveNeighbors == 3) {
                    board[row][col] = 3; // Mark as 'to live'
                }
            }
        }

        // Update the board to its next state
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == 2) board[row][col] = 0; // 'to die'
                if (board[row][col] == 3) board[row][col] = 1; // 'to live'
            }
        }
    }

    /**
     * Helper method to count live neighbors
     */
    private int countLiveNeighbors(int[][] board, int row, int col) {
        int liveNeighbors = 0;
        /*
         * Example array indices
         *   0 1 2
         * 0
         * 1   X
         * 2
         */
        // Upper, lower, left, right, upper left, lower left, upper right, lower right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {1, -1}, {-1, 1,}, {1, 1}};

        for (int[] dir : directions) {
            int r = row + dir[0];
            int c = col + dir[1];
            // a cell that is alive and going to die in the next generation (marked as 2)
            // is still considered a live neighbor for other cells hence the check (board[r][c] == 1 || board[r][c] == 2)
            // Once the first pass is over, the second pass will convert the 2 cells to 0 (dead).
            if (r >= 0 && r < board.length && c >= 0 && c < board[0].length && (board[r][c] == 1 || board[r][c] == 2)) {
                liveNeighbors++;
            }
        }
        return liveNeighbors;
    }

    public static void main(String[] args) {
        GameOfLife obj = new GameOfLife();
        int[][] board = {
                {0,0,1,1},
                {1,0,1,0},
                {0,1,1,0},
                {1,0,0,1},
                {1,0,0,0}
        };
        obj.gameOfLife(board);
    }
}
