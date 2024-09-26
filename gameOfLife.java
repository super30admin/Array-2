//Time Complexity: O(M*N)
//Space Complexity: O(1)

class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        if(board==null || board.length==0)
            return;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int neighbours = findneighbours(board, i, j);
                if(board[i][j] == 1)
                {
                    if(neighbours<2 || neighbours>3)
                        board[i][j] = 8;
                }
                else
                {
                    if(neighbours==3)
                    {
                        board[i][j]=7;
                    }
                }
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]==7)
                    board[i][j] =1;
                else
                    board[i][j]=0;  
            }
        }
    }
    
    private int findneighbours(int[][] board, int i, int j)
    {
        int dirs[][] = {{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
        int result = 0;
        for(int[] dir:dirs)
        {
            int r = i+dir[0];
            int c = j + dir[1];
            if(r>=0 && c>=0 && r<board.length && c<board[0].length && (board[r][c]==1) || (board[r][c] == 8))
            {
                result++;
            }
        }
        return result;
    }
    
}