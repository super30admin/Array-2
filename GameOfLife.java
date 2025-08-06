import java.util.Arrays;
// Time Complexity : O(m * n), where m = rows and n = columns of the board
// Space Complexity : O(1), since we do in-place modification using encoding
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Three line explanation:
// We simulate the Game of Life in-place by encoding transitions:
// -1 for dead to alive, and 2 for alive to dead.
// After processing, we convert the encoded values back to final states.


public class GameOfLife {
    public void gameOfLife(int[][] board) {
        // 8 directions: top-left, top, top-right, left, right, bottom-left, bottom, bottom-right
        int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        // First pass: mark cells with transitional values
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count = count(board, i, j, dir);

                // Dead cell becomes alive
                if (board[i][j] == 0 && count == 3) {
                    board[i][j] = -1;  // mark as "will become alive"
                }
                // Live cell dies due to under/overpopulation
                else if (board[i][j] == 1 && (count < 2 || count > 3)) {
                    board[i][j] = 2;   // mark as "was alive but will die"
                }
            }
        }

        // Second pass: finalize board state
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 1;  // now alive
                } else if (board[i][j] == 2) {
                    board[i][j] = 0;  // now dead
                }
            }
        }
    }

    // Helper function to count live neighbors
    public int count(int[][] board, int i, int j, int[][] dir) {
        int count = 0;
        for (int[] d : dir) {
            int r = i + d[0];
            int c = j + d[1];
            if (r >= 0 && c >= 0 && r < board.length && c < board[0].length) {
                if (board[r][c] == 1 || board[r][c] == 2) {
                    count++;
                }
            }
        }
        return count;
    }

    // Main method to test the gameOfLife method
    public static void main(String[] args) {
        GameOfLife sol = new GameOfLife();
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };

        System.out.println("Original Board:");
        printBoard(board);

        sol.gameOfLife(board);

        System.out.println("Board after one update:");
        printBoard(board);
    }

    // Utility function to print the board
    public static void printBoard(int[][] board) {
        for (int[] row : board) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}
