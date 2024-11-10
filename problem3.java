// Time Complexity : o(n*m)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : We are taking dirs[][] to calculate at all 8 indices values surrounding the element



public class problem3 {
    public void gameOfLife(int[][] board) {

        int m=board.length;
        int n=board[0].length;
        int[][] dirs= new int[][]{{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int count=getLiveCount(dirs, board,i,j,m,n);
                if(board[i][j]==0)
                {
                    if(count==3)
                    {
                        board[i][j]=3; //dead to alive
                    }
                }
                else if(board[i][j]==1)
                {
                    if(count<2 || count>3)
                    {
                        board[i][j]=2;  //alive to dead
                    }
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


    private int getLiveCount(int[][] dirs,int[][] board, int i, int j, int m , int n){
        int count=0;
        for(int dir[]: dirs)
        {
            int nr= dir[0]+i;
            int nc= dir[1]+j;
            if(nr>=0 && nr<m && nc>=0 && nc<n)
            {
                if(board[nr][nc]==1 || board[nr][nc]==2)
                {
                    count++;
                }
            }
        }
        return count;
    }
}
