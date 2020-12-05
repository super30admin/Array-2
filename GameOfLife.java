// Time Complexity : O(m * n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

class Solution {
    
    int m, n;
    
    public void gameOfLife(int[][] board) {
        
        if (board == null || board.length == 0) return;
        
        m = board.length;
        n = board[0].length;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int liveCells = countlives(board, i, j);
                
                if(board[i][j] == 1 && (liveCells < 2 || liveCells > 3 ) ) {
                    board[i][j] = 3;
                }else if(board[i][j] == 0 && liveCells == 3 ) {
                    board[i][j] = 2;
                }
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                
                if(board[i][j] == 2) {
                    board[i][j] = 1;
                }
                else if(board[i][j] == 3) {
                    board[i][j] = 0;
                } 
            }
        }
        
    }
    
    private int countlives(int[][] board, int i, int j) {
        
        int count = 0;
        int[][] dirs = {{1, 1}, {-1, -1}, {1, 0}, {0, 1}, {-1, 1}, {1, -1}, {-1, 0}, {0, -1}};
        
        for(int[] dir: dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            
            if(r >= 0 && r < m && c >= 0 && c < n && (board[r][c] == 1 || board[r][c] == 3) ) {
                count++;
            }
        }
        return count;
    }
}