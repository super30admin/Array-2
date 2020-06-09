class Solution {
    // Time Complexity : O( m*n ) m - board rows, n -board cols
// Space Complexity : O(m*n ) 
// Did this code successfully run on Leetcode : Yes
// Your code here along with comments explaining your approach:
    
/*
1. Take separate matrix to store the updated cells and use the original cell for comparing in order to update.
2. For directions, use the directions matrix defined for all possible directions in problem statement like 8*2 for 8 directions and 2 is for row and column.
*/
    
    public void gameOfLife(int[][] board) {
            
        int[][] result = new int[board.length][board[0].length];
         
        for(int i = 0;i< board.length; i++){
            for(int j =0; j<board[0].length; j++){
                int lives = countLives(board, i,j);
                if(board[i][j] == 1){
                    if(lives < 2 || lives >3 )
                        result[i][j] = 0;
                    else
                        result[i][j] = board[i][j];
                }
                else{
                    if(lives == 3)
                        result[i][j] = 1;
                    else
                        result[i][j] = board[i][j];
                    
                }
            }
        }
        
        for(int i = 0;i< board.length; i++){
            for(int j =0; j<board[0].length; j++){
                board[i][j] = result[i][j];
            }
        }       
    }
    
    private int countLives(int[][] board, int i, int j){
        int count =0;
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}, {-1,1}, {1,1}, {1,-1}, {-1,-1}};
        for(int[] dir : directions){
            int row = i+dir[0]; int col = j+dir[1];
            if(row >= 0 && row < board.length && col >= 0 && col < board[0].length ){
                if(board[row][col] == 1)
                    count++;
            }
        }
        return count;
    }
    
}





class Solution {
    // Time Complexity : O( m*n ) m - board rows, n -board cols
// Space Complexity : O(1 ) 
// Did this code successfully run on Leetcode : Yes
// Your code here along with comments explaining your approach:
    
/*
1. Instead of taking new matrix, update the original with dummy values 
   1---> 0   2 (original alive, dead now)
   0---> 1   5 (original dead, alive now)
2. For directions, use the directions matrix defined for all possible directions in problem statement like 8*2 for 8 directions and 2 is for row and column.
*/
    
    public void gameOfLife(int[][] board) {
         
        for(int i = 0;i< board.length; i++){
            for(int j =0; j<board[0].length; j++){
                int lives = countLives(board, i,j);
                if(board[i][j] == 1){
                    if(lives < 2 || lives >3 )
                        board[i][j] = 2;
                }
                else{
                    if(lives == 3)
                        board[i][j] = 5;                    
                }
            }
        }
        
        for(int i = 0;i< board.length; i++){
            for(int j =0; j<board[0].length; j++){
                if(board[i][j] == 1 || board[i][j] == 5) // 5  for recently alive
                   board[i][j] = 1;
                else
                    board[i][j] = 0; 
            }
        }       
    }
    
    private int countLives(int[][] board, int i, int j){
        int count =0;
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}, {-1,1}, {1,1}, {1,-1}, {-1,-1}};
        for(int[] dir : directions){
            int row = i+dir[0]; int col = j+dir[1];
            if(row >= 0 && row < board.length && col >= 0 && col < board[0].length ){
                if(board[row][col] == 1 || board[row][col] == 2 ) // 2 for oiginally alive
                    count++;
            }
        }
        return count;
    }
    
}