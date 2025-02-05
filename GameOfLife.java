class GameOfLife {
    public int aliveCount(int[][] board, int i, int j,int m, int n)
    {   int count=0;
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1},{-1,1},{1,1},{-1,-1},{1,-1}};
        for(int[] dir: dirs)
        {
            int nr = i+dir[0];
            int nc = j+dir[1];
            if(nr>=0 && nr <m && nc>=0 && nc<n && (board[nr][nc]==1 || board[nr][nc]==2))
            {
                count++;
            }
       
        }
         return count;
    }
    public void gameOfLife(int[][] board) {
        // underpopulation alive < 2 then 1->0
        //overpopulation >3 alive 1->0
        //alive==2 || alive==3 then 1->1
        //if alive==3 then 0->1
        //1->0 make it 2 or any number other than 1 or 2
        //0->1 make it 3 or any number other than 1 or 2
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int aliveCount = aliveCount(board,i,j,m,n);
                if(board[i][j]==1 && (aliveCount < 2 || aliveCount >3))
                {
                    board[i][j]=2;
                }
                else if(board[i][j]==0 && (aliveCount==3))
                {
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
}

//tc: O(m*n)
//sc: O(1)
