class Solution {
    // 1 -> 0 -- 5
    // 0 -> 1  -- 4
    //Time O(m*n)
    //Space O(1)
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0)
        {
            return;
        }
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,1},{1,-1},{-1,-1}};
        int m = board.length , n = board[0].length;
        for(int i=0 ; i<board.length ; i++)
        {
            for(int j=0 ; j<board[0].length ; j++)
            {
                int lives = 0;
                for(int[] dir : dirs)
                {
                    int row = i + dir[0];
                    int col = j + dir[1];
                    if(row >= 0 && row < m && col >= 0 && col < n && (board[row][col] == 5 || board[row][col] == 1))
                    {
                        lives++;
                    }
                }
                if(board[i][j] == 1 && (lives > 3 || lives < 2))
                {
                    board[i][j] = 5;
                }
                else if(board[i][j] == 0 && lives == 3)
                {
                    board[i][j] = 4;
                }
            }
        }
        for(int i=0 ; i<m ; i++)
        {
            for(int j=0 ; j<n ; j++)
            {
                if(board[i][j] == 5)
                {
                    board[i][j] = 0;
                }
                if(board[i][j] == 4)
                {
                    board[i][j] = 1;
                }
            }
        }
    }
}