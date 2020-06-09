// Time Complexity : O(m*n) where m and are dimensions of the given input
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

// 0--> 1 = 3
// 1--> 0 = 5

class Solution {    
    int m;
    int n;
    public void gameOfLife(int[][] board) {
        //edge
        if(board == null || board.length == 0) return;
        m = board.length;
        n = board[0].length;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int lives  = countLives(board, i, j);
                if(board[i][j] == 1){
                    if(lives < 2 || lives > 3){
                        board[i][j] = 5;
                    }
                 } else{
                    if(lives == 3){
                        board[i][j] = 3;
                    }
                 }                  
            }
        }        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){                
                if(board[i][j] == 3) board[i][j] = 1;
                if(board[i][j] == 5) board[i][j] = 0;                
            }
        }                
    }
    
    private int countLives(int[][] board, int i, int j){
        int[][] dirs ={{0,1},{0,-1},{-1,0},{1,0},{-1,1},{1,1},{-1,-1},{1,-1}};
        int count=0;        
        for(int[] dir : dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            if(r >= 0 && c >= 0 && r < m && c < n && 
               (board[r][c] == 1) || (board[r][c] == 5)) count++;    
        } 
         return count;
    }     
    
}