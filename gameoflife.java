// Time Complexity :O(m*n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach: took -1 for dead becoming alive and -2 for alive becoming dead and followed the conditiond by using the trick to store the directions and count in class and changed the values accouding the condition

class Solution {
    int [][] dirs;
     public void gameOfLife(int[][] board) {
         int m=board.length;
         int n=board[0].length;
         this.dirs=new int[][]{ {0,-1}, {0,1},{-1,0},{1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
         for(int i=0;i<m;i++){
             for(int j=0;j<n;j++){
                 int countAlive = countAlive(board,i,j,m,n);
                 if(board[i][j]== 1 && (countAlive<2 || countAlive>3)){
                     board[i][j]=-1;
                 }else if(board[i][j]==0 && countAlive ==3 ){
                     board[i][j]=-2;
                 }
             }
         }
         for(int i=0;i<m;i++){
             for(int j=0;j<n;j++){
                 if(board[i][j]==-1){
                     board[i][j]=0;
                 }
                 if(board[i][j]==-2){
                     board[i][j]=1;
                 }
             }
         }
         
     }
     private int countAlive(int[][] board, int r,int c,int m, int n){
         int count=0;
         for(int[] dir:dirs){
             int nr=r+dir[0];
             int nc=c+dir[1];
            if (nr >= 0 && nc >= 0 && nr < m && nc < n && (board[nr][nc] == 1 || board[nr][nc] == -1)) {
 
                 count++;
             }
             }
             return count;
     }
 }