// Time Complexity : O(8*m*n) m - no. of rows, n - no. of col, 8 neighbors at max
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


class Solution {
    public void gameOfLife(int[][] board) {
        // 1 -- 0 -> 2 ; If 1 becomes 0 change to 2 
        // 0 -- 1 -> 3 ; If 0 becomes 1 change to 3 
        // alive cells can be 1 or 2 while counting alive cells
        
        // if board is null or len = 0, return empty
        if(board == null || board.length == 0) return;
        
        // get board size
        int m = board.length;
        int n = board[0].length;
        
        //transerse the board
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++ ) {
                //call method to count alive neighbor cells
                int lives = countLives(board, i, j);
                
                // if current cell is 1 (alive) then we can keep it 1 or change to (0 -- dead) (2 for now)
                if(board[i][j] == 1) {
                    // if lives count is > 2 or < 3 (condition 1 and 3), that cell dies (0 or 2)
                    // (condition 3) is also met when lives == 2 or 3, do not change 1 (remains alive)
                    if(lives < 2 || lives > 3) {
                        board[i][j] = 2;
                    }
                }
                // if current cell is 0 (dead) then we can keep it 0 or change to (1 -- alive) (3 for now)
                else {
                    // dead cell is alive if lives count = 3 (condition 4)
                    if(lives == 3) {
                        board[i][j] = 3; 
                    }
                }
                
            }
        }
        
        // change 2 to 0, and 3 to 1 to get final board
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 2) {
                    board[i][j] = 0;
                }
                if(board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
        
    }
    
    // method to count alive neighbors, get board and i,j position
    public int countLives(int[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        int count = 0; 
        
        // define direction array eg : {-1,-1} - top left neighbor (row and col reduced by 1)
        int[][] dir = {{-1,-1}, {-1,0},{-1,1}, {0,-1}, {0,1},{1,-1},{1,0},{1,1}};
        
        // for each neighbor 
        for(int[] dirs : dir) {
            // find row and col position for neighbor position
            int r = i + dirs[0];
            int c = j + dirs[1];
            // if neighbor not out of bounds, increase count by one, (1 value can be 1/2)
            if(r >= 0 && c >= 0 && r < m && c < n && (board[r][c] == 1 || board[r][c] == 2)) {
                count++;
            }            
        } return count;         
    }
}
