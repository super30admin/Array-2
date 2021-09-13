// Time Complexity : o(m * n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// logic is to convert the array, by replacing the alive and dead state by 2 and 3. 
class Solution {
    int m;
    int n;
    int [][] dirs;
    public void gameOfLife(int[][] board) {
      m= board.length;
      n= board[0].length;
      //different directions right,left,top,bottom,top right,top bottom,bottm right,bottom left
      dirs = new int[][] {{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
      for(int i=0;i<m;i++){
          for(int j=0;j<n;j++){
              //counting no.of lives alive around that point
              int count = countLives(board,i,j); 
              //1 and 3
              if(board[i][j]==1 && (count<2 || count >3)){
                //making them dead by using 3 instead of 0 cause we might loose                  state
                  board[i][j]=3;
              }
              //3
              if(board[i][j]==0 && count == 3){
                  //making them alive
                  board[i][j]=2; 
              }
          }
      }
        //finally we get a matrix with 3 and 2 then we can convert
        for(int i=0;i<m;i++){
          for(int j=0;j<n;j++){
              if(board[i][j]==3) board[i][j]=0;
              if(board[i][j]==2) board[i][j]=1;
          }
        }
    }
    // to count lives
    public int countLives(int[][]board, int i, int j){
        int result =0;
        for(int[] dir : dirs){
            //calculating the eight directions at that point by using dirs
            // first we get [0,1]
            int nr = dir[0] + i;//i+0
            int nc = dir[1] + j;//j+1
            
    //if we are at boundary conditions and if that current cell is alive i.e. 1 and that current state is 3(dead) which means it is prev alive from line 16
            if(nr>=0 && nc>=0 && nr<m && nc<n 
               && (board[nr][nc]==1 || board[nr][nc]==3) )       
            {
                result++;
            }
        }
        return result;
    }
}