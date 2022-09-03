// TC: mxn
// SC: mxn
class Solution {
    int m,n;
    int [][] dirs;
    public void gameOfLife(int[][] board) {
        m= board.length;
        n= board[0].length;
        dirs= new int[][]{{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,1},{1,-1}};

        for(int i=0; i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int countlive=countLive(board,i,j);

                if(board[i][j]==1 && (countlive<2 ||countlive>3))
                    board[i][j]=3;
                if(board[i][j]==0 && countlive==3)
                    board[i][j]=2;
            }
        }

         for(int i=0; i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]==3) board[i][j]=0;
                if(board[i][j]==2) board[i][j]=1;
            }
         }

    }

    private int countLive(int [][]board, int i, int j)
    {
        int result=0;
        for(int[] dir:dirs)
        {
            int nr=i +dir[0];
            int nc=j+ dir[1];

            if(nr>=0 && nc>=0 && nr<m && nc<n &&(board[nr][nc]==1 || board[nr][nc]==3))
                result++;


        }
        return result;
    }
}