// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class GameOfLife {
	
	int m;
    int n;
    
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return;
        m = board.length;
        n = board[0].length;
        
        for(int i = 0; i< m; i++) {
            for(int j = 0; j< n; j++) {
                int lCount = getLiveCounts(board, i , j);
                if(board [i][j] == 1 && (lCount < 2 || lCount > 3)) {
                    board [i][j] = 2;
                }
                if(board [i][j] == 0 && lCount == 3) {
                    board[i][j] = 3;
                }
            }
        }
        
        for(int i = 0; i< m; i++) {
            for(int j = 0; j< n; j++) {
                if(board [i][j] == 2) {
                    board [i][j] = 0;
                }
                if(board [i][j] == 3) {
                    board [i][j] = 1;
                }
            }
        }
    }
    
    public int getLiveCounts(int[][] board, int i, int j) {
        int count = 0;
        int [][] dirs = {{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
        
        for(int[]dir:dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            if(r >= 0 && c >= 0 && r < m && c < n && (board[r][c] == 1 || board[r][c] == 2)) {
               count++; 
            }
        }
        
        return count;
    }

}
