// Time Complexity : O(m * n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
import java.util.*;

class Solution {
    public void gameOfLife(int[][] board) {
        
        // 0 -> 1 = 3
        // 1 -> 0 = 7
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                
                int living = count(board, row, column);
                //living cells
                if (board[row][column] == 1) {
                   if (living > 3 || living < 2) {
                        board[row][column] = 7;
                    } 
                }
                else {
                    if (living == 3) {
                        board[row][column] = 3;
                    }
                }
            }
        }
        
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                if (board[row][column] == 3) {
                    board[row][column] = 1;
                }
                if (board[row][column] == 7) {
                    board[row][column] = 0;
                }
            }
        }  
    }
    
    private int count(int[][] board, int row, int column) {
        int rows = board.length;
        int columns = board[0].length;
        
        int[][] neigh = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
        
        int living = 0;
        
        for (int i = 0; i < neigh.length; i++) {
            int nRow = row + neigh[i][0];
            int nCol = column + neigh[i][1];
            
            if ((nRow >= 0 && nRow < rows) && (nCol >= 0 && nCol < columns)) {
                if ((board[nRow][nCol] == 1) || (board[nRow][nCol] == 7)) {
                    living++;
                }   
            }
        }
        return living;
    }
}
