class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length==0 || board[0].length==0)
            return;
        // 0 ---> 1 is 2
        // 1 ----> 0 is 3
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int count = directionIndicator(board,i,j,m,n);
                if(board[i][j]== 1 && (count < 2 || count > 3))
                {//alive to dead
                    board[i][j]= 3;
                }
                if(board[i][j] ==  0 && count ==3)
                {//dead to alive
                    board[i][j] = 2;
                }
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]==2)
                {
                    board[i][j] =1;
                }
                if(board[i][j]==3){
                    board[i][j]=0;
                }
            }
        }
    }
    private int directionIndicator(int[][] board, int i, int j, int m , int n)
    {
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}, {1,1}, {1,-1}, {-1,1}, {-1,-1}};
        int result = 0;
        for(int [] dir : dirs)
        {
            int r = i + dir[0];
            int c = j + dir[1];
            if(r>=0 && r < m && c==0 && c<n
                    && (board[r][c]==1 || board[r][c]==3))
            {
                result++;
            }
        }
        return result;
    }
}

//time complexity is O(m*n)
//space is O(1)