// 289. Game of Life - https://leetcode.com/problems/game-of-life/
// Time Complexity : O(MN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) 
            return;
        
        int m=board.length, n=board[0].length;
        
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                // count live neighbors
                int count = countLiveNeighbors(board, i, j, m, n);
                if( board[i][j] == 1 && (count < 2 || count > 3))
                    board[i][j] = 3;
                if( board[i][j] == 0 && count == 3)
                    board[i][j] = 2;
            }
        }
        
        for(int i=0; i < m; i++)
        {
            for(int j=0; j < n; j++)
            {
                if(board[i][j] == 3)
                    board[i][j] = 0;
                else if(board[i][j] == 2)
                    board[i][j] = 1;
            }
        }
    }
    
    private int countLiveNeighbors(int[][] board, int i, int j, int m, int n)
    {
        int result = 0;
        int[][] dirs = new int[][]{{-1,-1},{-1,1},{1,-1},{1,1},{0,1},{1,0},{0,-1},{-1,0}};
        
        for(int[] dir: dirs)
        {
            int r = i+dir[0];
            int c = j+dir[1];
            
            if( r >= 0 && r < m && c >= 0 && c < n)
            {
                if(board[r][c] == 1 || board[r][c] == 3)
                {
                    result++; // counting live neighbors
                }
            }
        }
        return result;
    }
}