// Approach: Temporary state change pattern to optimize space on previous solution
// Time: O(rows * columns)
// Space: O(1)
class Solution {
    // Initialize directions
    private static final int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};

    public void gameOfLife(int[][] board) {
        // Temporary states
        // Change from 1 -> 0: Mark 2 (dies)
        // Change from 0 -> 1: Mark 3 (lives)
        int rows = board.length;
        int columns = board[0].length;
        for (int row = 0; row < rows; row ++) {
            for (int column = 0; column < columns; column ++) {
                int liveNeighbors = countLiveNeighbors(board, row, column);
                if (board[row][column] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[row][column] = 2; // dies
                }
                if (board[row][column] == 0 && liveNeighbors == 3) {
                    board[row][column] = 3; // lives
                }
            }
        }
        // Putting back to actual values of live (1) or dead (0)
        for (int row = 0; row < rows; row ++) {
            for (int column = 0; column < columns; column ++) {
                if (board[row][column] == 2) { // marked as dead
                    board[row][column] = 0;
                } else if (board[row][column] == 3) { // marked as live
                    board[row][column] = 1;
                }
            }
        }
    }

    private int countLiveNeighbors(int[][] board, int row, int column) {
        int countOfLiveNeighbors = 0;
        // Iterate through all neighboring indices
        for (int[] direction: directions) {
            int neighborRow = row + direction[0];
            int neighborColumn = column + direction[1];
            if (neighborRow < 0 || neighborRow >= board.length || neighborColumn < 0 || neighborColumn >= board[0].length) {
                // continue with next direction if current one is out of bounds
                continue;
            }
            if (board[neighborRow][neighborColumn] == 1 || board[neighborRow][neighborColumn] == 2) {
                // 1 represents live neighbors and 2 was alive originally
                countOfLiveNeighbors ++;
            }
        }
        return countOfLiveNeighbors;
    }
}