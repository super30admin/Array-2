// Time Complexity : O(m x n), m is no of rows and n is no of cols
// Space Complexity : O(1) in place changes
// Did this code successfully run on Leetcode : y
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int[] neighbours = {0, 1, -1};
        
        for (int row = 0; row < rows; row++){ // iterate through every cell in the board
            for (int col = 0; col < cols; col++){
                // for each cell, count live neihbours
                int live = 0;
                for (int i = 0; i < 3; i++){
                    for (int j = 0; j < 3; j++){
                        if (!(neighbours[i] == 0 && neighbours[j] == 0)){
                            int r = row + neighbours[i];
                            int c = col + neighbours[j];
                        
                            if ((r < rows && r >= 0) && (c < cols && c >= 0) && (Math.abs(board[r][c]) == 1)){
                                live++;
                            }
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