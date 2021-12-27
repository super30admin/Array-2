// Time Complexity : O(M*N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class GameOfLife {
    public void gameOfLife(int[][] board) {

    if(board==null || board.length==0) return;
        
    int rows=board.length;
    int cols=board[0].length;
    
    // Keep dirs array
    int dirs[][]={{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,1},{1,-1},{-1,-1}};
        
    for(int i=0;i<rows;i++)
    {
        for(int j=0;j<cols;j++)
        {
            int count=0;
            
            // For all directions , find out count.
            for(int[] dir:dirs)
            {
                int nr=i+dir[0];
                int nc=j+dir[1];
                
                if(nr>=0 && nr<rows && nc>=0 && nc<cols && (board[nr][nc]==1 ||board[nr][nc]==2))
                {
                    count++;
                }
            }
            
            // Use 2 if we transition from 1 to 0.  from 0 to 1 , use 3. Check the required conditions using if case
            if(board[i][j]==1 && count<2)
                board[i][j]=2;
            if(board[i][j]==1 && (count==2||count==3))
                board[i][j]=1;
            if(board[i][j]==1 && count>3)
                board[i][j]=2;
            if(board[i][j]==0 && count==3)
                board[i][j]=3;
            
        }
    }
        
    for(int i=0;i<rows;i++)
    {
        for(int j=0;j<cols;j++)
        {
            if(board[i][j]==2)
                board[i][j]=0;
            if(board[i][j]==3)
                board[i][j]=1;
            
        }
    }
        
    }
}