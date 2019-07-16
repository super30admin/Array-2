class Solution {
    public void gameOfLife(int[][] board) {
        int n=board.length;
        int m=board[0].length;
        int [][] newboard = new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                newboard[i][j]=board[i][j];
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                int count=check(newboard,i,j);
                if(newboard[i][j]==0 &&(count==3 )){board[i][j]=1;}
                if(newboard[i][j]==1 &&(count<2 || count>3)){board[i][j]=0;}
            }
        }
    }
    public int check(int[][] board,int x,int y)
    {
        int count=0;
        if(y!=board[0].length-1 && board[x][y+1]==1){count++;}
        if(x!=board.length-1 && board[x+1][y]==1){count++;}
        if(y!=0 && board[x][y-1]==1){count++;}
        if(x!=0 && board[x-1][y]==1){count++;}
        if((x!=0 && y!=0) && board[x-1][y-1]==1){count++;}
        if((x!=0 && y!=board[0].length-1) && board[x-1][y+1]==1){count++;}
        if((x!=board.length-1 && y!=0) && board[x+1][y-1]==1){count++;}
        if((x!=board.length-1 && y!=board[0].length-1) && board[x+1][y+1]==1){count++;}
        
        return count;
    }
}