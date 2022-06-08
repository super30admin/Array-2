// Time Complexity : O(m*n) where m and n are no of rows and columns in board
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

class Solution {
    int m,n;
    int [][]dirs;
    public void gameOfLife(int[][] board) {
        m = board.length;
        n= board[0].length;
        dirs= new int[][]{{0,1},{0,-1},{1,0},{-1,1},{-1,-1},{1,1},{1,-1},{-1,0}};
              // 0 -> 1 = 2
              // 1 -> 0 = 3   
       
       for(int i =0;i<m;i++)
           for(int j=0;j<n;j++)
           {
               
               int count = countAlive(board,i,j);
               if(board[i][j]==1)
                 {if(count<2)
                     board[i][j] =3;
                  if(count>3)
                      board[i][j] =3;
                     
                  }
               else if(board[i][j]==0)
               {
                   if(count==3)
                       board[i][j]=2;
               }
 
           }
                          
       for(int i=0;i<m;i++)
           for(int j=0;j<n;j++)
           {
               if(board[i][j]==3)
                   board[i][j]=0;
               if(board[i][j]==2)
                   board[i][j]=1;
           }
                                           
                         
                          
    }
    
   public int countAlive(int [][] board, int i , int j)
   {  int count =0;
       for(int[]d:dirs)
       {
           int nr  = i+d[0];
           int nc = j+ d[1];
           if(nr>=0 && nr<m && nc>=0 && nc<n && (board[nr][nc]==3 || board[nr][nc]==1))
           {
               count++;
           }
          
       }
   
    return count;
       
       
   }
    
    
    
}