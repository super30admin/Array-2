/**
 * Time Complexity: O(m * n)
 * Space Complexity: O(1)
 */
class Solution {
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int neighbourCount = calcNeighbours(board, i, j, rows, cols);

                // Rule 4: Dead cell with exactly 3 live neighbors becomes a live cell
                if (board[i][j] == 0 && neighbourCount == 3) {
                    board[i][j] = 2;
                }
                // Rule 1 or Rule 3: Live cell with < 2 or > 3 live neighbors dies
                if (board[i][j] == 1 && (neighbourCount < 2 || neighbourCount > 3)) {
                    board[i][j] = 3;
                }
            }
        }


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
                if (board[i][j] == 3) {
                    board[i][j] = 0;
                }
            }
        }
    }

    private int calcNeighbours(int[][] board, int row, int col, int rows, int cols) {
        int count = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < rows && j >= 0 && j < cols && !(i == row && j == col)) {
                    if (board[i][j] == 1 || board[i][j] == 3) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
