// Time Complexity : O(m*n), where m is the number of rows and n is the number of columns
// Space Complexity : O(m*n), where m is the number of rows and n is the number of columns
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * 1. Create a new matrix to store the result, so that we can use the previous state of the board to calculate the next state.
 * 2. Iterate through the board and calculate the number of neighbors for each cell.
 * 3. Based on the number of neighbors and the current state of the cell, update the result matrix.
 * 4. Copy the result matrix to the board.
 */

class Solution {
    public void gameOfLife(int[][] board) {
        int rows = board.length, cols = board[0].length;
        int[][] result = new int[rows][cols];

        for(int i=0; i<rows; i++){ //O(m*n)
            for(int j=0; j<cols; j++){ 
                int currVal = board[i][j];
                int neighborsCount = neighbors(board, i, j); //O(8)
                if(currVal == 0 && neighborsCount == 3){
                    result[i][j] = 1;
                }else if(currVal ==1){
                    if(neighborsCount < 1){
                        result[i][j] = 0;
                    }else if(neighborsCount == 2 || neighborsCount == 3){
                        result[i][j] = 1;
                    }else if(neighborsCount > 3){
                        result[i][j] = 0;
                    }
                }
            }
        }

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                board[i][j] = result[i][j];
            }
        }
    }

    private int neighbors(int[][] board, int row, int col){
        int count = 0;
        int[][] directions = {
                    {-1, 0},     // Up
                    {-1, 1},     // Up-right
                    {0, 1},      // Right
                    {1, 1},      // Down-right
                    {1, 0},      // Down
                    {1, -1},     // Down-left
                    {0, -1},     // Left
                    {-1, -1}     // Up-left
        };
        
        for(int[] direction :  directions){
            int currRow = direction[0] + row;
            int currCol = direction[1] + col;
            
            if(currRow >= 0 && currRow <board.length && currCol>=0 && currCol<board[0].length){
                if(board[currRow][currCol] == 1)
                    count++;
            }
        }

        return count;
    }
}