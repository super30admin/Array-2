/*
Author: Akhilesh Borgaonkar
Problem: LC 289. Game of Life (Array-2)
Approach: To avoid extra space I am mutating my input array with different conventions of denoting live and dead cells. If I find that a live cell is
    going to be dead then I mark it with -1 & if I find that a dead cell is going to be revived then I mark it as 2. This denotations will help in
    the processing of future elements in the matrix while counting live neighbors. Eventually, I convert the -1 and 2 to 0 and 1 resp. 
Time Complexity: O(m*n) where m and n are rows and cols of input matrix.
Space complexity: O(1) no extra space.
LC verified
*/

class Solution {
    public void gameOfLife(int[][] board) {
        
        if(board == null || board.length==0)
            return;
        
        int r = board.length;
        int c = board[0].length;
        
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                int liveNeighbors = getLiveNeighbors(board, i, j);
                if(board[i][j]==1 && (liveNeighbors < 2 || liveNeighbors > 3))
                    board[i][j]=-1;
                if(board[i][j]==0 && liveNeighbors==3)
                    board[i][j]=2;
            }
        }
        
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(board[i][j]==-1)
                    board[i][j]=0;
                if(board[i][j]==2)
                    board[i][j]=1;
            }
        }
    }
    
    private int getLiveNeighbors(int[][] board, int row, int col){
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