/**
Algorithm :

0 - dead, 1 - Alive
Life :
neighbor life  < 2 = die
3 or 3 - live

Dead :
neighbor >3 die
=3 live neighbor then live

dead -> alive  : we will write it as 2 
live -> dead : check if it is 0 or 2 (to check if changed in iteration) and change to 3
dead -> alive  : we will write it as 2 then check for 1 or 3

here 2 and 3 are flags -> can use any unique number to track it

TC : O(m*n)
SC : O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No



**/
class Solution {
    public void gameOfLife(int[][] board) {
        
        //Base Case
        if(board == null || board.length == 0)
            return;
        
        int rows = board.length;
        int cols = board[0].length;
        
        for(int i=0; i < rows; i++){
            for(int j=0; j < cols; j++){
                int lives = countLives(i, j, board);
                
                //Rule 1 and Rule 3
                if(board[i][j] == 1 && (lives < 2 || lives > 3))
                    board[i][j] = 2;
                
                //Rule 4 
                if(board[i][j] == 0 && lives ==3)
                    board[i][j] = 3;
            }
        }
        
        //Some 2 and 3 to change them
        // 2 -> 0 and 3-> 1 then val%2
        for(int i=0; i < rows; i++){
            for(int j=0; j < cols; j++){
                board[i][j] = board[i][j]%2;
            }
            
        }
        
        
        
    }
    private int countLives(int row, int col, int[][] board){
        int count = 0;
        int rows = board.length;
        int cols = board[0].length;
        //all eight direction of i,j
        int[][] dirs = {{1,-1},{1,0},{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,1}};
        int new_row, new_col;
        for(int[] dir : dirs){
            new_row = dir[0] + row;
            new_col = dir[1] + col;
            
            if(new_row >= 0 && new_row < rows && new_col >=0 && new_col < cols && (board[new_row][new_col] == 1 || board[new_row][new_col]==2))
                count+=1;
        }
        return count;
        
        
    }
}