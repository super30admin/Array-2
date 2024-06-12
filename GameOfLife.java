// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0)
            return;
        
        int m = board.length, n = board[0].length;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int ln_count = count(board, i, j, m, n);
                //1-->3 ln_count<2
                if(board[i][j] == 1 && (ln_count < 2 || ln_count > 3))
                    board[i][j] = 3;
                //0-->1,2 ln_count = 3
                if(board[i][j] == 0 && ln_count == 3)
                   board[i][j] = 2;
            }     
        }
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == 3)
                    board[i][j] = 0;
                if(board[i][j] == 2)
                    board[i][j] = 1;
            }
        }
    }
    private int count(int[][] board, int row, int col, int m, int n) {
        int result = 0;
        int[][] dirs = {{-1,-1}, {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}};
        for(int[] dir: dirs) {
            int r = row + dir[0];
            int c = col + dir[1];
            if(r >= 0 && r < m && c >= 0 && c < n) {
                if(board[r][c] == 1 || board[r][c] == 3)
                    result += 1;
            } 
        }
        return result;
    }
}