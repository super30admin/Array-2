public class GameOfLife {
    /**
     * In-place matrix update with logic to retrieve/understand original value of a cell
     * here 0 -> -1 (-1 during processing indicate originally it was 0)
     * 1 -> 2 (2 during processing indicate originally it was 1
     * One final pass to change -1 to 1 and 2 to 0 to mark their final state
     *
     * Time: O(m*n) Space: O(1)
     */
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int neighbors = getLiveNeighbors(board, i, j);

                // condition on live cell to turn to dead
                if (board[i][j] > 0 && (neighbors < 2 || neighbors > 3)) {
                    board[i][j] = 2;
                }

                // condition on dead cell to turn alive
                if (board[i][j] < 1 && neighbors == 3) {
                    board[i][j] = -1;
                }
            }
        }

        //final pass to mark final state
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 1;
                }
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                }
            }
        }
    }

    private int getLiveNeighbors(int[][] board, int r, int c) {
        // 8 possible directions to explore neighbors
        int[][] neighbors ={{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int result = 0;

        for (int[] neighbor: neighbors) {
            int newRow = r + neighbor[0];
            int newCol = c + neighbor[1];

            if (newRow >= 0 && newRow < board.length && newCol >= 0
                    && newCol < board[0].length && board[newRow][newCol] > 0) {
                result++;
            }
        }
        return result;
    }
}
