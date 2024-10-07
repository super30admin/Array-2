
// Time Complexity : 0(m*n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int m, n;

    public void gameOfLife(int[][] board) {
        this.m = board.length;
        this.n = board[0].length;
        int[][] dirs = new int[][] { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 }, { -1, -1 }, { -1, 1 }, { 1, -1 },
                { 1, 1 } };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = countAlive(dirs, board, i, j);
                if (board[i][j] == 1) {
                    if (count < 2 || count > 3) {
                        board[i][j] = 2;
                    }
                } else if (board[i][j] == 0) {
                    if (count == 3) {
                        board[i][j] = 3;
                    }
                }
            }
        }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
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

    private int countAlive(int[][] dirs, int[][] board, int i, int j) {
        int count = 0;
        for (int[] dir : dirs) {
            int r = dir[0] + i;
            int c = dir[1] + j;
            if (r >= 0 && c >= 0 && r < m && c < n) {
                if (board[r][c] == 1 || board[r][c] == 2) {
                    count++;
                }
            }
        }

        return count;
    }
}