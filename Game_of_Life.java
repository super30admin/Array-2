// TC : O(n)
// SC : O(1)

class Solution {
    
    private int helper(int[][] board, int r, int c) {
        
        int m = board.length;
        int n = board[0].length;
        int[][] dirs = {{-1,-1},{-1, 0},{-1, 1},{0, 1},{1, 1},{1, 0},
                        {1, -1},{0, -1}};
        int c1 = 0;
        int nr,nc;
        for(int[] dir : dirs) {
            nr = r + dir[0];
            nc = c + dir[1];
            if (nr >= 0 && nc >= 0 && nr < m && nc < n) {
                if(board[nr][nc] == 1 || board[nr][nc] == 2)
                    c1++;
            }
        }
        
        return c1;
    }
    public void gameOfLife(int[][] board) {
        
        if(board == null || board.length == 0) return;
        
        int m = board.length;
        int n = board[0].length;
        
        // 2 --> 1 to 0
        // 3 --> 0 to 1
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int livesNear = helper(board, i, j);
                if (board[i][j] == 0) {
                    
                    if(livesNear == 3)
                        board[i][j] = 3;
                }
                else {
                    if(livesNear > 3 || livesNear < 2)
                        board[i][j] = 2;
                }
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                
                if(board[i][j] == 2)
                    board[i][j] = 0;
                
                if(board[i][j] == 3)
                    board[i][j] = 1;
                
            }
        }
        
    }
}
