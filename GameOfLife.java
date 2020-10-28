/**
 * TC: O(m*n) SC: O(1)
 * Approach: traverse through each element and count the live neighbor cell by helper mehtod, then apply the rule as given, 
 *           to preserve both new and previous state we need some transitional values that can be changed to the new state at the end.
 */
class Solution {
    public void gameOfLife(int[][] board) {
        // 0 --> 1 = 2
        // 1 --> 0 = 3
        if(board.length == 0 && board[0].length == 0) return;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                int lives = helper(board, i , j);
                if(board[i][j] == 1 && (lives < 2 || lives > 3)){
                    board[i][j] = 3;
                }
                if(lives == 3 && board[i][j] == 0){
                    board[i][j] = 2;
                }
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 2){
                    board[i][j] = 1;
                }else if(board[i][j] == 3){
                    board[i][j] = 0;
                }
            }
        }
        
        
    }
    
    private int helper(int[][] board, int i, int j){
        int[][] dirs = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
        int lives = 0;
        for(int[] dir:dirs){
            int n = i + dir[0];
            int c = j + dir[1];
            if(n >= 0 && c >= 0 && n < board.length && c < board[0].length){
                if(board[n][c] == 1 || board[n][c] == 3) lives++;
            }
        }
        return lives;
    }
}