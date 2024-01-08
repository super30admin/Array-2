// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {

    int[][] dirs = new int[][] {
           { 0, 1 },  //left
           { 0, -1 },  //right
           { 1, 0 },  //down
           { -1, 0 },  //up
           { 1, 1 },  //downright
           { 1, -1 },  //downleft
           { -1, 1 },  //upright
           { -1, -1 }   //upleft
   };
   public void gameOfLife(int[][] board) {
       int m = board.length;
       int n = board[0].length;

       // 1---> 0  2
       //0 ---> 1  3

       for(int i=0; i < m; i++)
       {
           for(int j=0; j < n; j++)
           {
               int count = countAlive(board, i, j);
               if(board[i][j] == 1 && (count <2 || count > 3)  )  //under population and over population
               board[i][j] = 2;

               if(board[i][j] == 0 && count == 3)
               {
                   board[i][j] = 3;
               }

           }
       }
           for(int i=0; i < m; i++)
               {
                    for(int j=0; j < n; j++)
                {
                   if(board[i][j] == 2)
                       board[i][j] = 0;
                   if(board[i][j] == 3)
                       board[i][j] = 1;
                }
               }

       }

   

   private int countAlive(int [][] board, int i, int j)
   {
            int result = 0;
       for(int[] dir: dirs)
       {
           int nr = i + dir[0];
           int nc = j + dir[1];
           if(nr >= 0 && nc >=0 && nr < board.length && nc < board[0].length && (board[nr][nc] == 1 || board[nr][nc] == 2))
           {
               result++;
           }
       }
       return result;
   }
}