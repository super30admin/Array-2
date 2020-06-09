// Time Complexity : O(n * m) --> where n & m are length of input 2D array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode (289): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    int m;
    int n;
    public void gameOfLife(int[][] board) {
        // 0 --> 1 = 2 , 3
        // 1 --> 0 = 3 , 5
        if (board == null || board.length == 0) return;
        m = board.length;
        n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = countLives(board, i, j);
                // case1: cell is live
                if (board[i][j] == 1) {
                    if (lives < 2 || lives > 3) board[i][j] = 3;
                }            
                // case2: cell is dead
                else {
                    if (lives == 3) board[i][j] = 2;
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) board[i][j] = 1;
                if (board[i][j] == 3) board[i][j] = 0;
            }
        }
    }
    
    private int countLives(int[][] board, int i, int j) {
        int count = 0;
        int dirs[][] = {{-1,0}, {1,0}, {0,-1}, {0,1}, {-1,-1}, {-1,1}, {1,-1},{1,1}};
        
        for (int dir[] : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            if (r >= 0 && c >=0 && r < m && c < n && (board[r][c] == 1 || board[r][c] == 3)) count++;
        }
        return count;
    }
}