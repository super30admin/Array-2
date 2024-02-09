//TC: O(n*n)
//SC: O(1)
class Solution {
    private int [][] dirs;
    public void gameOfLife(int[][] board) {
        int m=board.length;
        int n=board[0].length;
        this.dirs=new int[][]{{0,-1},{0,1},{-1,0},{1,0},{-1,-1},{-1,1},{1,1},{1,-1}};
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int countAlive= countAlive(board,i,j);
                if(board[i][j]==1&&(countAlive<2||countAlive>3))
                board[i][j]=-1;
                else if (board[i][j]==0&&countAlive==3)
                board[i][j]=-2;
            }
        }
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]==-1)
                board[i][j]=0;
                if(board[i][j]==-2)
                board[i][j]=1;
            }
        }
    }
        private int countAlive(int [][] board,int r,int c)
               {
                   int count =0;
                   for(int[] dir:dirs)
                   {
                       int nr=r+dir[0];
                       int nc=c+dir[1];
                       if(nr>=0&&nc>=0&&nr<board.length&&nc<board[0].length&&(board[nr][nc]==1||board[nr][nc]==-1))
                         count++;
                   }
                   return count;
               }
    
}