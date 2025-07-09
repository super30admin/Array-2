// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to revise basic syntax

// ## Problem3 (https://leetcode.com/problems/game-of-life/)

// According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
// The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
// Any live cell with fewer than two live neighbors dies as if caused by under-population.
// Any live cell with two or three live neighbors lives on to the next generation.
// Any live cell with more than three live neighbors dies, as if by over-population.
// Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
// The next state of the board is determined by applying the above rules simultaneously to every cell in the current state of the m x n grid board. In this process, births and deaths occur simultaneously.

// Given the current state of the board, update the board to reflect its next state.
// Note that you do not need to return anything.

// Example 1:
// Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
// Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]

// Example 2:
// Input: board = [[1,1],[1,0]]
// Output: [[1,1],[1,1]]
 
// Constraints:
// m == board.length
// n == board[i].length
// 1 <= m, n <= 25
// board[i][j] is 0 or 1.

class Solution {
    int m, n; // Variables to store the dimensions of the board

    public void gameOfLife(int[][] board) {
        // Checking if the board is null or empty
        if (board == null || board.length == 0) {
            return;
        }

        m = board.length; // Number of rows
        n = board[0].length; // Number of columns

        // 1 --> 0 == 2
        // 0 --> 1 == 3
        // Iterating through each cell in the board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Counting the number of live neighbors for the current cell
                int countLiveNeighbors = countLiveNeighbors(board, i, j);
                
                // Applying the given rules
                if (board[i][j] == 1) { // If the cell is currently alive
                    // Rule 1 or 3: Live cell with fewer than 2 or more than 3 live neighbors dies
                    if (countLiveNeighbors < 2 || countLiveNeighbors > 3) {
                        board[i][j] = 2; // Marking it as dead in the next state (1 -> 0)
                    }
                } else if (board[i][j] == 0) { // If the cell is currently dead
                    // Rule 4: Dead cell with exactly 3 live neighbors becomes alive
                    if (countLiveNeighbors == 3) {
                        board[i][j] = 3; // Marking it as alive in the next state (0 -> 1)
                    }
                }
            }
        }

        // Updating the board to the next state
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Updating the board based on the temporary markings
                if (board[i][j] == 2) {
                    board[i][j] = 0; // Cell dies
                } else if (board[i][j] == 3) {
                    board[i][j] = 1; // Cell becomes alive
                }
            }
        }
    }

    // Method to count live neighbors of a cell
    private int countLiveNeighbors(int[][] board, int i, int j) {
        int count = 0;
        // Directions for the 8 possible neighbors
        int[][] dirs = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}, // UP, DW, L, R
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1} // Diagonal
        };

        for (int[] dir : dirs) {
            int nr = i + dir[0]; // New row index
            int nc = j + dir[1]; // New column index
            // Checking if the neighbor is within bounds and is alive (1 or marked as 2)
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 2)) {
                count++; // Incrementing count if the neighbor is alive
            }
        }
        return count; // Returning the total count of live neighbors
    }
}