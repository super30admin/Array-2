// Time Complexity :O(mn) m is the length and n is the breadth of the matrize
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0);
        // 1->0 = 3 (Live to dead)
        // 0->1 = 4 (Dead to live)
        for(int i=0; i<board.length; i++){
            for(int j=0;j<board[0].length;j++){
                int lives = countLives(board,i,j);
                //Rule 1,2,3:
                if(board[i][j] == 1){
                    if(lives<2 || lives>3 ) board[i][j] = 3;
                }
                //Rule 4
                else{
                    if(lives == 3 ){
                        board[i][j] = 4;
                    }
                }
            }
        }
        
         for(int i=0; i<board.length; i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == 3) board[i][j] = 0;
                if(board[i][j] == 4 ) board[i][j] = 1;
            }
         }
    }
    
    private int countLives(int[][] board, int i, int j){
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0},{1,1},{-1,-1},{1,-1},{-1,1}};
        int count = 0;
        for(int[] dir : dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            if(r>=0 && c>=0 && r<board.length && c<board[0].length && (board[r][c] == 1 || board[r][c] == 3)){
                count ++;
            }
        }
        
        return count;
    }
}
