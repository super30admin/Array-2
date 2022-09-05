// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int m;
    int n;
    int[][] dirs;
    
    public void gameOfLife(int[][] board) {
        m = board.length - 1;
        n = board[0].length - 1;
        
        // null matrix check
        if (board == null || m < 0)
            return;
        
        // all possible directions to calculate neighbors
        dirs = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}, {-1,-1}, {1,1}, {-1,1}, {1,-1}};
        
        
        int lives = 2;  // 0 -> 1
        int died = 3;  // 1 -> 0
        
        for (int i=0; i <= m; i++) {
            for (int j=0; j <= n; j++) {
                int liveNeighbors = countLiveNeighbor(board, i, j); //count live neighbors
                int cell = board[i][j];
                
                /* Rules */
                if (cell == 1 && liveNeighbors < 2) {
                    board[i][j] = died;
                } else if (cell == 1 && liveNeighbors > 3) {
                    board[i][j] = died;
                } else if (cell == 0 && liveNeighbors == 3) {
                    board[i][j] = lives;
                }
            }
        }
        
        // changing back the temporary states to 0 or 1
        for (int i=0; i <= m; i++) {
            for (int j=0; j <= n; j++) {
                if (board[i][j] == lives)
                    board[i][j] = 1;
                if (board[i][j] == died)
                    board[i][j] = 0;
            }
        }
        
    }
    
        
    private int countLiveNeighbor(int[][] board, int i, int j){
        int res = 0;
        for(int[] dir : dirs) {
            int nr = dir[0] + i;  // new row
            int nc = dir[1] + j;  // new column
            
            if (nr>=0 && nc>=0 && nr<=m && nc<=n && (board[nr][nc]==1 || board[nr][nc]==3)){
                res++; 
            }           
        }
        return res;
    }
}
