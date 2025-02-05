// Time Complexity :O(m*n)+O(m*n) ==> O(2(m*n)) ->O(m*n)
// Space Complexity O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach:
// To solve the problem efficiently without using extra space, I modified the original grid in place. Instead of changing the values directly, I used temporary markers to track the future state of the cells:

// - I changed live cells (1) that would die to 2.
// - I changed dead cells (0) that would come to life to 3.

// While counting the live neighbors, I considered all the possible directions around each cell, making sure to handle edge cases. To avoid miscalculations in the counting, I only counted cells that were either alive (represented as 1 or 2).

// Once the counting was done and I had updated the cells based on the game rules, I made a final pass through the grid and reverted the temporary markers back:
// - 2 was changed back to 0 .
// - 3 was changed back to 1 .

class Solution {
    public void gameOfLife(int[][] board) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
             for(int j=0;j<n;j++){
                int liveCount=countOfLives( i, j, board,m,n);
               if(board[i][j] == 1 && (liveCount < 2 || liveCount > 3)){
                 board[i][j] =2;
                }else if(board[i][j] == 0 && liveCount == 3){
                    board[i][j] = 3;
                }else{
                    
                }
            
        }
        
        }
        for(int i=0;i<m;i++){
             for(int j=0;j<n;j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }else if(board[i][j] == 3){
                     board[i][j] = 1;
                }
             }
        }
    }
   private int countOfLives(int r,int c,int[][] board,int m,int n){
        int[][] dirs=new int[][]{{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
         int count=0;
        for(int[] currDir:dirs){
             int cr=r+currDir[0];
            int cc=c+currDir[1];
            if(cr >= 0 && cr< m && cc>=0 && cc<n && (board[cr][cc] == 1 || board[cr][cc] == 2) ){
               count++;
            }
        }
return count;
        }
        
        
    
}