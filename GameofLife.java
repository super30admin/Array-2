// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : To perform in-place, for each cell, if its updating from 1 to 0, 
// make it 3 instead of 0 and if from 0 to 1, make it 2 instead of 1.
// Perform one more traversal to update 2 and 3 to 1 and 0 respectively so that each cell 
// can check its neighbors without any issue.
// Return the updated board.


class GameofLife {
    int m,n;
    public void gameOfLife(int[][] board) {
        if(board == null ||board.length == 0) return;
        m = board.length; n= board[0].length;
        // 0 --> 1 = 2
        // 1--> 0 = 3
        for(int i=0;i < m;i++) {
            for(int j=0;j<n;j++) {
                int lives = countLives(board,i,j);
                if(board[i][j] == 1) { //live state
                    if(lives > 3 || lives < 2) { // rule 1 & 3
                        board[i][j] = 3;
                    }
                } else {
                    if(lives == 3) { // rule 4
                        board[i][j] = 2;
                    }
                }
            }
        }
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j] == 3) board[i][j] = 0;
                if(board[i][j] == 2) board[i][j] = 1;
            }
        }
    }
    
    private int countLives(int[][] board, int i, int j) {
        int count = 0;
        int dirs[][] = {{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
        for(int []dir: dirs) {
            int r = i+dir[0];
            int c = j+dir[1];
            if(r>=0 && c>=0 && r<m && c<n && ((board[r][c]==1) || (board[r][c] == 3))) {
                    count++;
            }
        }
        return count;
    }
}