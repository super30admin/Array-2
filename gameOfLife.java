// Time Complexity : O(m*n) where m, n are dimensions of the matrix
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach : Mark ex-alive elements as any number and ex-dead elements to another number and remember these
// numbers. Now iterate thru the matrix, calculating the neighbors along the way and applying the rules.
// Lastly traverse the matrix again, replacing the numbers assigned to correct alive or dead numbers i.e. 0,1

// Your code here along with comments explaining your approach

import java.util.*;
class gameOfLife {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int neighbors = calcLiveNeighbors(board, i, j);
                if (board[i][j] == 1) { // if alive
                    if (neighbors < 2) { // case 1
                        board[i][j] = -1;
                    }
                    if (neighbors > 3) { // case 3
                        board[i][j] = -1;
                    }
                }
                else { // if dead
                    if (neighbors == 3) { // case 4
                        board[i][j] = 2;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                }
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }
        return;
    }
    private int calcLiveNeighbors(int[][] matrix, int i, int j) {
        int count = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1},{-1,1},{-1,-1},{1,1},{1,-1}};
        for (int[] dir : dirs) {
            int row = i + dir[0];
            int col = j + dir[1];
            if (row >= 0 && row < m && col >= 0 && col < n) {
                if (matrix[row][col] == 1 || matrix[row][col] == -1) {
                    count++;    
                }
            }
        }
        return count;
    }
}