class Solution {
    /*
     * Time - O(MN) 
     * Space - O(1)
     */
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                int countLives = countAlive(board, i, j);
                // save 1->0 as 2, 0->1 as 3
                if (board[i][j]==1 && (countLives<2 || countLives>3))
                    board[i][j] = 2;
                else if (board[i][j]==0 && countLives==3)
                    board[i][j] = 3;
            }
        }
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == 2)
                    board[i][j]=0;
                else if (board[i][j] == 3)
                    board[i][j]=1;
                else
                    continue;
            }
        }
    }
    
    private int countAlive(int[][] board, int i, int j) {
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{1,-1}, {-1,1}};
        int lives = 0;
        for (int[] dir: dirs) {
            int row = i+dir[0];
            int col = j+dir[1];
            if (row<board.length && row>=0 && col<board[0].length && col>=0) {
                if (board[row][col]==1 || board[row][col]==2)
                    lives++;
            }
        }
        return lives;
    }
}