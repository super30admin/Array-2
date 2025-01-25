/*
1 -> 0 (live to dead) is temporarily represented as 2.
0 -> 1 (dead to live) is temporarily represented as 3.
T.C = O(m*n)
S.C = O(1)
*/

class GameOfLife {
    int m, n;
    public void gameOfLife(int[][] board) {
        if(board ==null || board.length == 0)
        {
            return;
        }
        m = board.length;
        n = board[0].length;

       /*
       1->0 == 2 i.e live to dead cell is denoted by 2
       0->1 == 3 i.e dead to live cell is denoted by 3
       */

        for(int i =0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                //to check number of live neighbours
                int countliveneighbours = countliveneighbours(board,i,j);

                if(board[i][j] == 1)
                {
                    if(countliveneighbours < 2 || countliveneighbours > 3)
                    {
                        board[i][j] = 2;
                    }
                }

                else if(board[i][j] == 0)
                {
                    if(countliveneighbours == 3)
                    {
                        board[i][j] = 3;
                    }
                }
            }
        }

        for(int i =0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]==3)
                {
                    board[i][j] = 1;
                }
                else if(board[i][j]==2)
                {
                    board[i][j] = 0;
                }
            }
        }
    }
    private int countliveneighbours(int[][] board, int i, int j)
    {
        int count = 0;
        int[][] d ={{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
        for(int[] dir: d)
        {
            int nr = i+dir[0];
            int nc = j+dir[1];
            if(nr>=0 && nr<m && nc>=0 && nc< n && (board[nr][nc] == 1 || board[nr][nc] == 2))
            {
                count ++;
            }
        }
        return count;
    }
}