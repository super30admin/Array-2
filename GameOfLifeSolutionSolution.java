// Time Complexity : O(MxN) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// A cell can either be 0 or 1. We can add an extra bit to the cells to keep track of their next states. 
// After iterating through the board we can shift all cells by 1 bit towards right. 
// It has fewer cells in the corner than the ones in the center.
import java.util.*;
class GameOfLifeSolutionSolution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        if (m == 0) {
            return;
        }
        int n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int live = getLiveNeighbors(board, i, j);
                if (board[i][j] == 0 && live == 3) {
                    board[i][j] = 2;
                }
                if (board[i][j] == 1 && (live == 2 || live == 3)) {
                    board[i][j] = 3;
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }
    
    private int getLiveNeighbors(int[][] board, int row, int col) {
        int live = 0;
        int m = board.length;
        int n = board[0].length;
        
        for (int i = Math.max(row - 1, 0); i <= Math.min(row + 1, m - 1); i++) {
            for (int j = Math.max(col - 1, 0); j <= Math.min(col + 1, n - 1); j++) {
                if (i == row && j == col) {
                    continue;
                }
                if (board[i][j] % 2 == 1) {
                    live++;
                }
            }
        }
        return live;
    }
}