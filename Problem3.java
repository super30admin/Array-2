// Time Complexity : O(2(m*n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Array Syntex and Limit out of bound exceptions but solved finally


// Your code here along with comments explaining your approach: My using unique vaalue if a life becomes death and death becomes life to find their previous position.

class Solution {
    public void gameOfLife(int[][] board) {
      int  row = board.length;
      int  col = board[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                int n = countTotal(i, j, board);
                if(board[i][j] == 1 && n<2) board[i][j] = 2;
                else if(board[i][j] ==1  && n > 3) board[i][j] = 2;
                else if(board[i][j] == 0 && n == 3) board[i][j] = 3;
            }
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == 2) board[i][j] = 0;
                else if(board[i][j] == 3) board[i][j] = 1;
            }
        }
    }
    
    private int countTotal(int i, int j, int[][] board){
        int[][] dir = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        int count = 0;
        for(int[] k: dir){
          int  new_row = k[0]+i;
          int  new_col = k[1]+j;
            if((new_row >= 0) && (new_row < board.length) && (new_col >= 0) && (new_col < board[0].length) && (board[new_row][new_col] == 1 || board[new_row][new_col] == 2)) count++;
        }
        return count;
    }
}
