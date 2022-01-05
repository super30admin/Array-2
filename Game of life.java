//Time complexity:O(m*n)
//Space complexity:O(1)

class Solution {
   
    int m,n;
   int dirs[][]=new int[][]{{0,1},{0,-1},{-1,0},{1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
    public void gameOfLife(int[][] board) {
        m=board.length;
        n=board[0].length;
        //1->0: 2, 0->1:3
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int count=countAlive(board, i, j);
                if(board[i][j]==1)
                {
                
                    if(count<2 || count>3)
                    {
                        board[i][j]=2;
                    }
                    
                    }
                else if( board[i][j]==0)
                {
                    if(count==3)
                        board[i][j]=3;
                }
                    
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]==2)
                {
                    board[i][j]=0;
                }
               else if(board[i][j]==3)
                {
                    board[i][j]=1;
                }
            }
        }
    }
    public int countAlive(int[][]board, int i, int j)
    {
        int count=0;
        for(int[] dir:dirs)
        {
            int r= i+dir[0];
            int c=j+dir[1];
            if(r>=0 && c>=0 &&(r<m && c<n))
            {
                if(board[r][c]==1 || board[r][c]==2)
                    count++;
            }
        }
        return count;
     }
}