// Time Complexity : O(m*n) where m = number of rows in board, n = number of columns in board
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.*;
public class Problem3 {

    private static int[][] directions = new int[][]{
        {-1, -1}, // left up
        {-1, 0}, // up
        {-1, 1}, // right up
        {0, 1}, // right
        {1, 1}, // right down
        {1, 0}, // down
        {1, -1}, // left down
        {0, -1} // left
        
    };
    
    private static int findliveneighbors(int[][] board, int i, int j) {
        int rows = board.length;
        int cols = board[0].length;
        int count = 0; 
        for (int[] direction: directions) {
            int row = i + direction[0];
            int col = j + direction[1];
            if (row >= 0 && row < rows && col >= 0 && col < cols) {
                if (board[row][col] == 1 || board[row][col] == -2) {
                    count++;
                }
            }
        }
        return count;
        
        
    }
    
    public static void gameOfLife(int[][] board) {
        // 0 to 1 => -1
        // 1 to 0 => -2
        // 0 to 0 => 0
        // 1 to 1 => 1
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int liveneighbors = findliveneighbors(board, i, j);
                if (board[i][j] == 1) { // live cell
                    if (liveneighbors < 2 || liveneighbors > 3) {
                        board[i][j] = -2;
                    }
                } else {
                    if (liveneighbors == 3) {
                        board[i][j] = -1;
                    }
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 1;
                }
                if (board[i][j] == -2) {
                    board[i][j] = 0;
                }
            }
        }
            
    }

    public static void main(String[] args) {
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(board);
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }


}
