// Time Complexity : O(n) iterate through each element of array
// Space Complexity : O(1) in place changes
// Did this code successfully run on Leetcode : y
// Any problem you faced while coding this :

class Solution {
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        
        for (int row = 0; row < rows; row++){ // iterate through every cell in the board
            for (int col = 0; col < cols; col++){
                // for each cell, count live neihbours
                int live = 0;
                int top = Math.max(0, row - 1);
                int bottom = Math.min(rows - 1, row + 1);
                int right = Math.min(col + 1, cols - 1);
                int left = Math.max(0, col - 1);
                
                for (int i = top; i <= bottom; i++){
                    for (int j = left; j <= right; j++){
                        if (!(i==row && j == col) && board[i][j] == 1){
                            live++;
                        }
                    }
                }
                
                if ((board[row][col] == 1) && (live < 2 || live > 3)){
                    board[row][col] = -1; // now dead, originally live
                }
                
                if (board[row][col] == 0 && live == 3){
                    board[row][col] = 2; // was dead, now alive
                }
            }
        }
        
        for (int row = 0; row < rows; row++){
            for (int col = 0; col < cols; col++){
                if (board[row][col] > 0){
                    board[row][col] = 1;
                }
                else{
                    board[row][col] = 0;
                }
            }
        }
    }
}