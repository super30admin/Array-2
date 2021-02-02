// Time Complexity :O(m*n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//Approach is to find the neighbouring elements in effective manner and replace the changed cell with the value which can be used to remember the prev value.s
class Solution {
    public void gameOfLife(int[][] board) {
        if(board==null || board.length==0 || board[0].length==0)
            return ;
        
        int n=board.length; int m= board[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                int count= countneighbours(board,n,m,i,j);
                
                if(board[i][j]==0 && count==3 )
                    board[i][j]=3;//dead cell becomes live
                else if(board[i][j]==1 && (count<2 || count >3))
                    board[i][j]=2;//alive cell becomes dead
            }
        }
        
         for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]==2)
                    board[i][j]=0;
               else if(board[i][j]==3)
                    board[i][j]=1;
            }
         }
        
        
    }
    
   public int countneighbours(int[][] board,int n,int m,int i,int j)
   {
       int[][]dirs= {{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
       int count=0;
       for(int dir[]: dirs)
       {
          
           int r=i+dir[0];
           int c=j+dir[1];
           if(r>=0 && r<n && c>=0 && c<m && (board[r][c]==1 || board[r][c]==2))
               count++;
       }
       return count;
   }
}