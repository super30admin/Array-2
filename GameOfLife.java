
// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

/*
 * Intuition: I used a two-pass approach to solve the Game of Life problem.
*/

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;

        // Directions to the 8 neighbors
        int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = 0;

                // Count live neighbors
                for (int k = 0; k < 8; k++) {
                    int ni = i + dx[k], nj = j + dy[k];
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                        // Use board[ni][nj] & 1 to get original state
                        liveNeighbors += board[ni][nj] & 1;
                    }
                }

                // Apply the rules
                if (board[i][j] == 1 && (liveNeighbors == 2 || liveNeighbors == 3)) {
                    // Live cell stays live → mark with 3 (binary 11)
                    board[i][j] = 3;
                } else if (board[i][j] == 0 && liveNeighbors == 3) {
                    // Dead cell becomes live → mark with 2 (binary 10)
                    board[i][j] = 2;
                }
                // Otherwise, live cell dies or dead cell stays dead → leave as is
            }
        }

        // Update board to next state
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Shift right by 1 to get next state
                board[i][j] >>= 1;
            }
        }
    }

    public static void main(String[] args) {
        GameOfLife solution = new GameOfLife();
        int[][] board = {
                { 0, 1, 0 },
                { 0, 0, 1 },
                { 1, 1, 1 },
                { 0, 0, 0 }
        };
        solution.gameOfLife(board);

        // Print the updated board
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
