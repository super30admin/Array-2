// TC: O(m*n) -> m,n -> dimensions of the board
// SC: O(1) -> no extra space required
// Did it run successfully on Leetcode? : Yes
class Solution {
    public void gameOfLife(int[][] board) {
        if ( board == null || board.length == 0)
            return;
      //  0 --> 1 :3  dead -> live
      //  1 --> 0 :2  live -> dead
        for ( int i = 0; i < board.length; i++)
        {
            for ( int j = 0; j < board[0].length; j++)
            {
                int liveNeigborsCount = countLive(board, i , j);
                if (board[i][j] == 1 && (liveNeigborsCount < 2 || liveNeigborsCount > 3))
                    board[i][j] = 2;
                if (board[i][j] == 0 && liveNeigborsCount == 3)
                    board[i][j] = 3;
            }
        }
        for ( int i = 0; i < board.length; i++)
        {
            for ( int j = 0; j < board[0].length; j++)
            {
                if (board[i][j] == 3)
                    board[i][j] = 1;
                if (board[i][j] == 2)
                    board[i][j] = 0;
            }
        }
    }
    
    private int countLive(int[][] board, int i, int j)
        {
            int[][] dirs = {{1, 0}, {0, 1},{0, -1},{-1,0}, {-1,-1}, {-1,1}, {1, -1}, {1,1}};
            int count = 0;
            int m = board.length;
            int n = board[0].length;
            for(int[] dir : dirs)
            {
                int r = i + dir[0];
                int c = j + dir[1];
                if (r >= 0 && c >=0 && r < m && c < n && (board[r][c] == 1 || board[r][c] == 2))
                    count++;
            }
        return count;
    }
}
