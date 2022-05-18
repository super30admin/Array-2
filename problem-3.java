// Time Complexity : O(8*m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    //State Change Method
    int wasAlive=2;
    int wasDead=3;
    public void gameOfLife(int[][] board) {
        for(int i=0; i<board.length; i++){
          for(int j=0; j<board[0].length; j++){
              if(countAlive(board, i, j)<2 || countAlive(board, i, j)>3){
                  if(board[i][j]==1){
                      board[i][j]=wasAlive;
                  }
              }
              else if(countAlive(board, i, j)==3){
                  if(board[i][j]==0){
                      board[i][j]=wasDead;
                  }
              }  
          }  
        }
        
        for(int i=0; i<board.length; i++){
          for(int j=0; j<board[0].length; j++){
            if(board[i][j]==wasAlive){
                board[i][j]=0;
            }
            else if(board[i][j]==wasDead){
                  board[i][j]=1;
            }
          }  
        }
    }
    
    public int countAlive(int[][] board, int i, int j){
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}, {-1 ,1}, {1 ,1}, {1 ,-1}, {-1 ,-1}};
        int count=0;
        for(int[] dir : dirs){
            int r=i+dir[0];
            int c=j+dir[1];
            if(r>=0 && r<board.length && c>=0 && c<board[0].length && (board[r][c]==1 || board[r][c]==wasAlive)){
                count++;
            }
        }
        return count;
    }
}
