class Solution {
    //TimeComplexity: m * n
    //SpaceComplexity: O(1)
                 //righ    left    up   down  leftUp  righUp dwnLft dwnRit
        int [][] dirs = new int[][]{{0,1},{0,-1},{-1,0},{1,0},{-1,-1},{-1,1},{1,-1},{1,1}} ;
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
       

        int alivecount= 0 ;
        for (int i = 0; i<m ; i++)   {
            for(int j= 0 ; j < n; j++)  {
                alivecount = neighbours(board, i, j, m, n);  
            if(board[i][j]==1 && (alivecount<2||alivecount>3) ) board[i][j] = 2;//tmpState 1->0
            if(board[i][j]==0 && alivecount==3) board[i][j] = 3 ;    //tmpState 0->1
            }
        }
        
        for (int i = 0; i<m ; i++)   {
            for(int j= 0 ; j < n; j++)  {
                if(board[i][j] == 2) board[i][j]=0;
                if(board[i][j]==3) board[i][j]=1;
            }
        }
    }

    private int neighbours(int[][]board, int i, int j, int m, int n)    {
        int count = 0;
        for(int[]dir: dirs)  {
            int x = i+dir[0];
            int y = j+dir[1];
            if(x>=0 && y>=0 && x<m && y<n ) {
            if(board[x][y]==1 || board[x][y]==2)  count++;}
        }
        return count;
    }
}