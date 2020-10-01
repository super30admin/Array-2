// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public void gameOfLife(int[][] board) {
        
        if (board == null || board.length ==0)
            return;
        
        int rows = board.length;
        int cols = board[0].length;
        
        for(int i=0; i<rows ; i++)
        {
            for(int j=0; j<cols ; j++)
            {
                int lives = countLive(i,j,board);
                if(board[i][j] == 1 && (lives < 2 || lives > 3))
                    board[i][j] = 2;
                
                if(board[i][j] ==0  && lives ==3 )
                    board[i][j] = 3;
            }
        }
        
        for(int i = 0; i<rows;i++)
        {
            for(int j = 0;j<cols;j++)
            {
                board[i][j] = board[i][j]%2;
            }
        }     
        
       
    }
    
     private int countLive(int row, int col , int[][] board)
        {
            int count=0;
            int rows = board.length;
            int cols = board[0].length;
            int[][] dirs = {{1,-1},{1,0},{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,1}};
            int new_row, new_col;
            
            for(int[] dir:dirs)
            {
                new_row = dir[0] + row;
                new_col = dir[1] + col;
                
                if(new_row >=0 && new_row< rows && new_col >=0
                  && new_col < cols && (board[new_row][new_col] ==1 || board[new_row][new_col] ==2))
                    count+=1;
            }
            return count;
            
        }
}