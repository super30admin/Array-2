/*289. Game of Life 
 According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state of the board is determined by applying the above rules simultaneously to every cell in the current state of the m x n grid board. In this process, births and deaths occur simultaneously.
Given the current state of the board, update the board to reflect its next state.
Note that you do not need to return anything.
Example 1:
Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
Constraints:
m == board.length
n == board[i].length
1 <= m, n <= 25
board[i][j] is 0 or 1.

Follow up:
Could you solve it in-place? Remember that the board needs to be updated simultaneously: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches upon the border of the array (i.e., live cells reach the border). How would you address these problems?

/*
Time Complexity:-O(m*n)
Space Complexity:-O(1)
Approach:-The game is played on a grid where:
1 = alive
0 = dead
You must compute the next state of each cell based on its 8 neighbors, in-place (without using extra space).
To do this, we use temporary encoded values:
2 = was alive → now dead
3 = was dead → now alive
Final pass converts all encoded values to 0 or 1.
*/
class GameofLife {
    int[][] dirs; // direction vectors for 8 neighbors
    int m, n; // grid dimensions

    public void gameOfLife(int[][] board) {
        // Define 8 possible directions (top-left, top, top-right, etc.)
        this.dirs = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 },
                { 1, 1 } };

        this.m = board.length; // number of rows
        this.n = board[0].length; // number of columns
        // First pass: determine and encode the state transitions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = getCount(board, i, j); // number of alive cells around it
                // Rule: dead cell with exactly 3 live neighbors becomes alive
                if (board[i][j] == 0 && count == 3) {
                    board[i][j] = 3; // dead -> alive;
                } else if (board[i][j] == 1 && (count < 2 || count > 3)) { // Rule: live cell with <2 or >3 live
                                                                           // neighbors dies
                    board[i][j] = 2; // alive -> dead;
                }
            }
        }
        // Second pass: decode encoded values to final state
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;// cell died
                } else if (board[i][j] == 3) {
                    board[i][j] = 1;// cell became alive
                }
            }
        }
    }

    // Helper method to count live neighbors
    private int getCount(int[][] board, int i, int j) {
        int count = 0;

        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            // Check bounds
            if (r >= 0 && c >= 0 && r < m && c < n) {
                // Consider cells that were alive originally: 1 or 2
                if (board[r][c] == 1 || board[r][c] == 2)
                    count++;
            }
        }

        return count;
    }
}