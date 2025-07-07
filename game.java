//Time Complexity (TC):** O(m × n) — each cell is visited twice (once for counting neighbors, once for updating).
//Space Complexity (SC):** O(1) — in-place updates without extra space.

//For each cell, count live neighbors and mark state changes using temporary markers (2 for alive→dead, 3 for dead→alive).
//In a second pass, update the board to finalize the new states based on the markers.


class Solution {
    int[][] directions;
    int rows, cols;

    public void gameOfLife(int[][] board) {

        this.directions = new int[][]{
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1},  {1, 0},  {1, 1}
        };

        this.rows = board.length;
        this.cols = board[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int liveNeighbors = countLiveNeighbors(board, row, col);
                if (board[row][col] == 0 && liveNeighbors == 3) {
                    board[row][col] = 3;  // dead -> alive
                } else if (board[row][col] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[row][col] = 2;  // alive -> dead
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == 2) {
                    board[row][col] = 0;
                } else if (board[row][col] == 3) {
                    board[row][col] = 1;
                }
            }
        }
    }

    private int countLiveNeighbors(int[][] board, int row, int col) {
        int liveCount = 0;

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newCol >= 0 && newRow < rows && newCol < cols) {
                if (board[newRow][newCol] == 1 || board[newRow][newCol] == 2) {
                    liveCount++;
                }
            }
        }

        return liveCount;
    }
}
