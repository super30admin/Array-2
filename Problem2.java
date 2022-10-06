// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    int m,n;
    public void gameOfLife(int[][] board) {
        if(board == null || board.length ==0) return;
        m = board.length;
        n = board[0].length;
        
        // 0 -> 1 we use 3
        // 1 -> 0 we use 2
        for(int i = 0;i < m;i++)
        {
            for(int j = 0;j < n;j++)
            {
                int live = countLive(board,i,j);
                if(board[i][j] == 0)
                {
                    if(live == 3)
                    {
                        board[i][j] = 3;
                    }
                }
                else if(board[i][j] == 1)
                {
                    if(live < 2 || live > 3)
                    {
                        board[i][j] = 2;
                    }
                }
            }
        }
        for(int i = 0;i < m;i++)
        {
            for(int j =0;j<n;j++)
            {
                if(board[i][j]==2)
                {
                    board[i][j] = 0;
                }
                else if(board[i][j] == 3)
                {
                    board[i][j] = 1;
                }
            }
         }
    }
    private int countLive(int [][]board,int i,int j)
    {
        int count = 0;
        int dir[][] = {{0,-1},{0,1},{-1,0},{1,0},{-1,-1},{1,-1},{-1,1},{1,1}};
            
        for(int[] u : dir)
        {
           int nr = i + u[0];
           int nc = j + u[1];
           if(nc < n && nr < m && nc >=0 && nr >=0 &&(board[nr][nc] == 1 || board[nr][nc] == 2) )
            {
                count++;
            }
            
        }
        return count;
    }
}
