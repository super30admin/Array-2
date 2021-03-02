// Time Complexity :
O(n*m) tarversing entire matrix and n= no.of rows and m= no.of columns
// Space Complexity :
o(1) 
// Did this code successfully run on Leetcode :
yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public void gameOfLife(int[][] board) {
     if(board == null || board.length == 0) return;
      //Calculate row length and column length
      int  n = board.length;
      int  m = board[0].length;
        
      //Iterate through each element of the matrix
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                /*for every Element call this function to calculate the surrounding neighbours                 that are alive */
                int aliveNeighbours = countAliveNeighbours(board, i, j, n, m);
                //check the conditions
            if(board[i][j] == 1 && aliveNeighbours<2) board[i][j] = 2;//1 to 0 represented by 2
            else if(board[i][j] ==1  && aliveNeighbours > 3) board[i][j] = 2;  
            else if(board[i][j] == 0 && aliveNeighbours == 3) board[i][j] = 4; /* 0 to 1 represent by 4 */
            }
        }
        
        //reset the values to 0's and 1's
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 2) board[i][j] = 0;
                else if(board[i][j] == 4) board[i][j] = 1;
            }
        }
    }

    private int countAliveNeighbours(int[][] board,int i, int j, int n, int m){
        //Define directions array
        int[][] dir = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        int count = 0;
        for(int[] k: dir){
          int  row = k[0]+i;
          int  col = k[1]+j;
            
    //Check boundary conditions        
    if((row >= 0) && (row < n) && (col >= 0) && (col < m) && (board[row][col] == 1 || board[row][col] == 2)) count++;
        }
        return count;
    }
}