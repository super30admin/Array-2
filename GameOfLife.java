// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {

    int[][] dirs;
    public void gameOfLife(int[][] board) {
                    //left//right//top//bottom//topleft//topright//bottomleft//bottomright
     

       dirs=new int[][]{{0,1},{0,-1},{-1,0},{1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
     int m = board.length;
     int n = board[0].length;
   
     

   //  0-1->3
    // 1-0->2
     for(int i=0; i< m;i++ ){
         for(int j=0;j<n;j++){
    
          int countLive = countAliveNeighbours(board,  m,  n , i , j);  // count the no.of alive neighbours
          if(board[i][j]==1 && (countLive<2 ||countLive>3)){
              board[i][j]=2;
          }
          if(board[i][j]==0 && countLive==3 )
             board[i][j]=3;
        }
     }
     for(int i=0; i<m;i++)
     {
         for(int j=0;j<n;j++)
         {
            if(board[i][j]==3)
             board[i][j]=1; 
            if(board[i][j]==2)
            board[i][j]=0; 
         }
     }
    }
    public int countAliveNeighbours(int[][] board, int m , int n, int i, int j)
    { 
        int count =0;
        for(int[] dir : dirs) // for each array 
        {
            int newRow= i+dir[0];
            int newCol= j+dir[1];
            if(newRow>=0 && newRow<m && newCol>=0 && newCol<n &&( board[newRow][newCol]==1||board[newRow][newCol]==2)) // check if neighbour is 1 or if 1 is changed to 0(so 2)
              {
                  count++;
            }
        }
        return count;
    }
}