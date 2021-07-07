// Time Complexity : 
//      gameOfLife() - O(nm)
//      
// Space Complexity :
//      gameOfLife() - O(1)
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board[0].length == 0)
            return;
        
        for(int i=0; i < board.length; ++i)
        {
            for(int j = 0; j <board[0].length; ++j)
            {
                int co = helper(board, i, j);
                
                if(board[i][j] == 1)
                {
                    if(co < 2 || co > 3)
                        board[i][j] = -1;
                }
                if(board[i][j] == 0)
                {
                    if(co == 3)
                    {
                        board[i][j] = 2;
                    }
                }
            }
        }
        
        for(int i=0; i < board.length; ++i)
        {
            for(int j = 0; j < board[0].length; ++j)
            {
                if(board[i][j] == -1)
                    board[i][j] = 0;
                
                if(board[i][j] == 2)
                    board[i][j] = 1;
            }
        }
        
    }
    
    private int helper(int[][] board, int i, int j)
    {
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}, {-1,1},{-1,-1},{1,1},{1,-1}};
        
        int count = 0;
        
        for(int[] dir : dirs )
        {
            int r = dir[0] + i;
            int c = dir[1] + j;
            
            if(r < board.length && r >= 0 && c < board[0].length && c >= 0)
            {
                if(board[r][c] == 1 || board[r][c] == -1)
                    ++count;
            }
            
        }
        
        return count;
    }
}