Time Complexity-O(n)
Space Complexity-O(1)

class Solution {
    int[][] dirs= {{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{1,-1},{-1,1},{1,1}};
    public void gameOfLife(int[][] board) {
        if(board==null || board.length==0)
            return;
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                int lives=countLife(board,i,j);
                if(board[i][j]==1 && (lives>3 || lives<2))
                {
                    board[i][j]=2;
                }
                else if (board[i][j]==0 && lives==3)
                    board[i][j]=3;
            }
        }
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                board[i][j]%=2;
            }
        }
        return;
    }

    public int countLife(int[][] board,int i,int j)
    {
        int count=0;
        for(int[] dir:dirs)
        {
            int x=i+dir[0];
            int y=j+dir[1];
            if(!(x>=0 && y>=0 && x<board.length && y<board[0].length))
                continue;
            if(board[x][y]==1 || board[x][y]==2)
               count++;
        }
        return count;
    }
}
