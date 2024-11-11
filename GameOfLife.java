//Time Complexity:O(m×n)We visit each cell in the m x n grid twice — once for the transition and again for the final state update.
//Space Complexity:O(1)
// ran on leetcode: Yes
// Any problems: No
import java.util.*;
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

    // Directions array for the 8 neighbors
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
        // Count live neighbors
            int liveNeighbors = getLiveCount(board, i, j, dirs);

        // Apply rules
                if (board[i][j] == 1) {  // Current cell is alive
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[i][j] = 2;  // Alive -> Dead
                    }
                    } else if (board[i][j] == 0) {  // Current cell is dead
                    if (liveNeighbors == 3) {
                        board[i][j] = 3;  // Dead -> Alive
                    }
                }
            }
        }

    // Update the board to the next state
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;  // Change marked dead cells to 0
                } else if (board[i][j] == 3) {
                    board[i][j] = 1;  // Change marked live cells to 1
                }
            }
        }
    }

    // Helper function to count live neighbors
     private int getLiveCount(int[][] board, int i, int j, int[][] dirs) {
        int liveCount = 0;
        int m = board.length;
        int n = board[0].length;

        for (int[] dir : dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];

        // Check boundaries and count live neighbors
            if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                if (board[nr][nc] == 1 || board[nr][nc] == 2) {  // Count both original live states
                    liveCount++;
                }
            }
        }

        return liveCount;
    }

        public static void main(String[] args) {
            GameOfLife solution = new GameOfLife();

            // Sample board
            int[][] board = {
                    {0, 1, 0},
                    {0, 0, 1},
                    {1, 1, 1},
                    {0, 0, 0}
            };

            // Print the initial board
            System.out.println("Initial Board:");
            printBoard(board);

            // Apply Game of Life rules
            solution.gameOfLife(board);

            // Print the board after applying Game of Life rules
            System.out.println("\nNext Generation Board:");
            printBoard(board);
        }

        // Utility function to print the board
        private static void printBoard(int[][] board) {
            for (int[] row : board) {
                for (int cell : row) {
                    System.out.print(cell + " ");
                }
                System.out.println();
            }
        }
    }

