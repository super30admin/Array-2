// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return;
        }
        
        //1 -> 0    3
        //0 -> 1    2
        int m = board.length; // rows
        int n = board[0].length; // cols
        for(int i =0; i < m; i++){
            for(int j = 0; j < n; j++){
                int count = countLives(board, i ,j, m, n);
                //alive and neighbours are either less than 2 or greater than 3 then assign the alive pos to 3
                if(board[i][j] == 1 && (count < 2 || count > 3)){
                    board[i][j] = 3;
                }
                
                //dead to alive
                if(board[i][j] == 0 && count == 3){
                    board[i][j] = 2;
                }
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j =0; j< n; j++){
                if(board[i][j] == 3)
                    board[i][j] = 0;
                if(board[i][j] == 2)
                    board[i][j] = 1;
                    
            }
        }
    }
    
    private int countLives(int[][] board, int i, int j,int m, int n){
        int result = 0;
        //down, top, right, left and diagonals with down-right, down-left, up-left, up-right 
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        for(int[] dir : dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            if(r >= 0 && c >= 0 && r < m && c < n && (board[r][c] == 1 || board[r][c] == 3)){
                result++;
            } 
            
        }
        return result;
    }
    
    
}