// Time Complexity :O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * We keep a direction array with all of an elements neighbors. 
 * We change the state to 2 when there is a change from 0 to 1 and a state of 3 when there is a change from 1 to 0. 
 * This helps avoid any issues because of a neighbors change. 
 * We keep a track of an elements neighbors and change state accordingly*/

public class Problem2 {
    class Solution {
        int[][] dirs = {{0,-1},{0,1},{-1,0},{1,0},{1,-1},{1,1},{-1,-1},{-1,1}};
   public void gameOfLife(int[][] board) {
       int m = board.length; 
       int n = board[0].length;
       for(int i =0; i < m ; i++){
           for(int j =0; j < n; j++){
               int count = countAlive(board, m, n, i, j);
               if(board[i][j] == 1){
                   if(count < 2 || count > 3)
                       board[i][j] = 2;
               }
               else{
                   if(count == 3)
                       board[i][j] = 3;
               }
           }
       }
       for(int i =0; i < m; i++){
           for(int j = 0; j < n; j++){
               if(board[i][j] == 2)
                   board[i][j] = 0; 
               else if(board[i][j] == 3)
                   board[i][j] = 1;
           }
       }
   }
   private int countAlive(int board[][],int m, int n, int i, int j){
       int counts = 0; 
       for(int dir[] : dirs){
           int r = dir[0] + i; 
           int c = j + dir[1];
       if( r >= 0  && c >= 0 && r < m && c < n && (board[r][c] == 1 || board[r][c] == 2) ){
           counts++;
       }
   }
       return counts;
   }
}
}
