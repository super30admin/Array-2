// Time Complexity : O(m*n); where m = number of rows and n = number of columns
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    int [][] dirs;
    int m,n;
    
    public void gameOfLife(int[][] board) {
    
        // check if input matrix is null or empty
        if(board == null || board.length == 0)  return;
        
        // find number of rows and columns of input matrix
        m = board.length;
        n = board[0].length;
        
        //Old-->New-->Temporary
        //1 --> 0 --> 2
        //0 --> 1 --> 3
        
        // directions matrix
        dirs = new int [][] {{0,1}, {0,-1}, {-1,0}, {1,0}, {1,1}, {1,-1}, {-1,1}, {-1,-1}};
        
        // for each cell in the matrix
        // count the number of live neighbors
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n;j++){
                
                int countAlive = countAlive(board, i , j);
                
                // if the current cell is alive
                // and number of neighbors are less than 2 or
                // number of neighbors are more than 3
                // then mark the current cell as dead (2: living to dead)
                
                if(board[i][j] == 1 && (countAlive <2 || countAlive > 3)){
                    board[i][j] = 2;
                }
                
                // if the current cell is dead
                // and number of live neighbors are equal to 3
                // then mark the current cell as living (3: dead to alive)
                
                if(board[i][j] == 0 && countAlive == 3){
                    board[i][j] = 3;
                }
                
            }
        } 
        
        // traverse through the matrix and mark 2 as 0 and 3 as 1
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                if(board[i][j] == 2){
                    board[i][j] = 0;
                }

                if(board[i][j] == 3){
                    board[i][j] = 1;
                }
            }
        }
    }
            
    private int countAlive(int [][] board, int i, int j){
        
        // initialize result as 0
        int result = 0;
        
         // check for living neighbors in every direction and update the counter
        for(int [] dir : dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            
            if(r >= 0 && c >= 0 && r < m && c < n && (board[r][c] == 1 || board[r][c] == 2)){
                result++;
            }
        }
        return result;
    }
}