// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Initially did not understand how 2nd condition was covered. 
//Later understood that we don't have explicitly code it out because for this condition, value is not altered for board[i][j]

class Solution {
    
    int[][] directions = {{0,1},{0,-1},{-1,-1},{1,1},{1,0},{-1,0},{1,-1},{-1,1}};
    
    public void gameOfLife(int[][] board) {
        if (board == null || board.length ==0) return;
        
        for(int i=0; i< board.length; i++) {
                for(int j=0; j<board[0].length;j++) {
                    int lives = getLives(board,i,j);
                    
                    if (board[i][j] ==1 && (lives <2|| lives>3)) {
                        board[i][j] = 2;
                    } 
                    
                    else if (board[i][j] ==0 && lives==3) {
                        board[i][j] = 3;
                    }
            }    
        }
        
        for(int i=0; i< board.length; i++) {
                for(int j=0; j<board[0].length;j++) {
                    board[i][j] = board[i][j] % 2;     
                }
            }
        
    }
                               
            
    
    private int getLives(int[][]board, int i, int j) {
        int lives =0;
        
        for (int[] dir: directions) {
            int x = i+ dir[0];
            int y = j + dir[1];
            
            if (x<0 || x>= board.length || y<0 || y>=board[0].length) 
                continue;
                if(board[x][y] == 1 || board[x][y] == 2) {
                    lives ++;
                }
        }
        
        return lives ;
    }
}