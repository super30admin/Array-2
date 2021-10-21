// Time Complexity : O(row*col)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public void gameOfLife(int[][] board) {
        
        // 0->1 = 2
        // 1->0 = 3
        
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                int lives = count(board, i, j);
                
                if(board[i][j] == 1) {
                    if(lives<2 || lives>3) {
                        board[i][j] = 3;
                    }   
                }
                else {
                    if(lives == 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j] == 3)
                    board[i][j] = 0;
                if(board[i][j] == 2)
                    board[i][j] = 1;
            }
        }
    }
    
    private int count(int[][] board, int row, int col) {
        int lives = 0;
        int[][] nums = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        
        for(int i=0;i<nums.length;i++) {
            int r = nums[i][0]+row;
            int c = nums[i][1]+col;
            if(0 <= r && r<board.length && c>=0 && c<board[0].length) {
                if(board[r][c] == 1 || board[r][c] == 3)
                    lives++;
            }
        }
        return lives;
    }
}