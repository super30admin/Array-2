//Time Complexity- O(n*m)
//Space Complexity=O(1)
class Solution {
    public void gameOfLife(int[][] board) {
        if(board==null||
           board.length==0||
           board[0].length==0)
        {
            return;
        }
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int countAlive=countLiveCell(board,m,n,i,j);
                if(board[i][j]==1 && (countAlive<2||countAlive>3))
                {
                    board[i][j]=2;
                }
                else if(board[i][j]==0 && countAlive==3)
                {
                    board[i][j]=4;
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
                if(board[i][j]==4)
                {
                    board[i][j]=1;
                }
            }
        }
    }
    
    int countLiveCell(int[][]board,int m,int n,int i,int j)
    {
        int count=0;
        int dirs[][]= {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        for(int[]dir : dirs)
        {
            int row=i+dir[0];
            int col=j+dir[1];
            if(row>=0 && row<m &&col>=0 &&col<n)
            {
                if(board[row][col]==1||
                   board[row][col]==2)
                {
                    count++;
                }
            }
        }
        return count;
    }
}