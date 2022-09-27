class Solution {
    int m,n;
    public void gameOfLife(int[][] board) {
        
        m=board.length;
        n=board[0].length;
        //1--->0 =2
        //0--->1=3
        
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                
                int aliveNeighbors=getAliveNeighbors(board,i,j);
                if(board[i][j]==0)
                {
                    if(aliveNeighbors==3)
                        board[i][j]=3;
                        
                }else{
                    if(aliveNeighbors<2 || aliveNeighbors>3)
                        board[i][j]=2;
                    
                }
                
            }
        }
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]==3)
                    board[i][j]=1;
                if(board[i][j]==2)
                    board[i][j]=0;
            }
        }
        
    }
    
    public int getAliveNeighbors(int[][] board, int r,int c)
    {
        int[][] dirs={{1,0},{0,1},{-1,0},{0,-1},{-1,-1},{-1,1},{1,-1},{1,1}};
        int count=0;
        for(int[] dir : dirs )
        {
            int nr=r+dir[0];
            int nc=c+dir[1];
            
            if(nr>=0 && nc>=0 && nr<m && nc<n &&(board[nr][nc]==1 || board[nr][nc]==2))
            {
                count++;
            }
        }
        
        return count;
    }
}

// Time Complexity : O(M*N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no