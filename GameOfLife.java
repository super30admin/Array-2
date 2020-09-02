// Time Complexity : O(N x M) where N is the number of rows and M is the columns
// Space Complexity : O(1) as our walking pattern array is constant space and won't change with N or M
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nope

class GameOfLife {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        
        int n = board.length;
        int m = board[0].length;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int count = getNextState(board, n, m, i, j);
                
                if(board[i][j] == 1 && (count < 2 || count > 3)) {
                    board[i][j] = 2;
                } else if (board[i][j] == 0 && count == 3) {
                    board[i][j] = 4;
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == 4) {
                    board[i][j] = 1;
                }
            }
        }
        
        return;
    }
    
    public int getNextState(int[][] nums, int n, int m, int i, int j) {
        int[][] walkingPattern = {{-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}};
        int count = 0;
        
        for(int x = 0; x < walkingPattern.length ; x++) {
            int r = i + walkingPattern[x][0];
            int c = j + walkingPattern[x][1];
            
            if(r >= 0 && r < n && c >= 0 && c < m && (nums[r][c] == 1 || nums[r][c] == 2)) {
                count++;
            }
        }
        return count;
    }
}