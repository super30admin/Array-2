/********* Time Complexity : O(2mn) -> O(mn) **********/
/********* Space Complexity : O(1) **********/
/********* The code ran in Leetcode **********/

class Solution {
    public void gameOfLife(int[][] board) {
        
        //base case
        if(board == null || board.length==0)
            return;
        
        int row = board.length;
        int col = board[0].length;
        
        //according to the rules for the entire board
        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {
                int liveCells = getLiveCells(board, i, j);
                if(board[i][j]==1 && (liveCells < 2 || liveCells > 3))
                    board[i][j]=-1;
                if(board[i][j]==0 && liveCells==3)
                    board[i][j]=2;
            }
        }
        
        //converting all -1 -> 0 & 2 -> 1
        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {
                if(board[i][j]==-1)
                    board[i][j]=0;
                if(board[i][j]==2)
                    board[i][j]=1;
            }
        }
    }
    
    private int getLiveCells(int[][] board, int row, int col){
        int count = 0, m = board.length, n = board[0].length;
        
        //up
        if(row > 0)
            if(board[row-1][col]==1 || board[row-1][col]==-1)   count++;
        
        //down
        if(row < m-1)
            if(board[row+1][col]==1 || board[row+1][col]==-1)   count++;
        
        //left
        if(col > 0)
            if(board[row][col-1]==1 || board[row][col-1]==-1)   count++;
        
        //right
        if(col < n-1) 
            if(board[row][col+1]==1 || board[row][col+1]==-1)   count++;
        
        //diagonal left up
        if(row > 0 && col > 0)
            if(board[row-1][col-1]==1 || board[row-1][col-1]==-1)   count++;
        
        //diagonal left down
        if(row < m-1 && col > 0)
            if(board[row+1][col-1]==1 || board[row+1][col-1]==-1)   count++;
        
        //diagonal right up
        if(row > 0 && col < n-1)
            if(board[row-1][col+1]==1 || board[row-1][col+1]==-1)   count++;
        
        //diagonal right down
        if(row < m-1 && col < n-1)
            if(board[row+1][col+1]==1 || board[row+1][col+1]==-1)   count++;
        
        return count;
    }
}