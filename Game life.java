// Time complexity 0(m*n) {rows*columns}
// space complexity 0(1)
// Code successfully executed in leetcode
class Solution {
    //global variables
     private int m;
     private int n;

     public void gameOfLife(int[][] board) {

         m = board.length;
         n = board[0].length;

         //Edge case
         if(board == null || board.length == 0) return;

         for(int i=0; i<m; i++){
             for(int j=0; j<n; j++){
                 int count = countLive(board, i ,j);

//Element alive and under populated or over populated, node changes from 1->0 i.e it dies
                 if(board[i][j] == 1 && (count< 2 || count > 3)){
                     board[i][j] = -1;
                 }

                 //Element dead and number of live neighbors is exactly 3, then element changes its state from 0->1
                 if(board[i][j] == 0 && count == 3){
                     board[i][j] = 2;
                 }
   //Not checking for condition 2 where live element continues to live if alive neighbors' count
             }
         }

         //To check -1 and 2 states and replace it with 0 and 1 respectively
         for(int i=0; i<m; i++){
             for(int j=0; j<n; j++){
                 if(board[i][j] == -1){
                     board[i][j] = 0;
                 }
                 else if(board[i][j] == 2){
                     board[i][j] = 1;
                 }
             }
         }

     }


     private int countLive(int[][] board, int i, int j){
         //Standard definition
int [][] direction = { {0,1}, {0,-1}, {1,0}, {-1,0}, {-1,-1}, {-1,1},{1,-1} ,{1,1}};                                                                                 
         int count = 0;

         for(int[] dir : direction){
             int r = i + dir[0];
             int c = j + dir[1];
             if( r >= 0 && r < m && c >= 0 && c < n){
                 if(board[r][c] == 1 || board[r][c] == -1){
                     count++;
                 }
             }

         }
         return count;
     }
}

