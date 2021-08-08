// Time Complexity : O(M*N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes while going for in-place


// Your code here along with comments explaining your approach
/*Approach
1) for going in place, we do not need to have another matrix.
2) we just need to get counts, and see the rules. thus we can count of the lives through the matrix and then change dead cells to 2 and live cells to 3
3) we need another pass to change 2 to 0 and change 3 back to 1

*/



class Solution {
    public void gameOfLife(int[][] board) {
       
      if(board==null || board.length==0)
      {
          return;
          
      }
        
        
        // denote dead -> 2
        // denote alive ->3
        
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
             
                int count =countL(board,i,j);
                
                if(board[i][j]==1 && (count<2  || count>3))
                {
                    board[i][j]=2;
                }
               // else if(board[i][j]==1 && (count==2 || count ==3))
                //{
                  //  board[i][j]=3;
                //}
                /*else if(board[i][j]==1 && (count>3))
                {
                    board[i][j]=2;
                }*/
                if(board[i][j]==0 && count==3)
                {
                    board[i][j]=3;
                }
                
            }
        }
        
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]==2)
                {
                    board[i][j]=0;
                }
                else if(board[i][j]==3)
                {
                    board[i][j]=1;
                }
            }
        }
        
        
        
        
        
    }
    
     public int countL(int board[][],int row,int col)
     {
         int result =0;
         int dirs[][]=new int[][]{{-1,-1},{-1,0},{-1,1},{0,1},{1,0},{1,-1},{1,1},{0,-1}};
         
         for(int [] dir:dirs)
         {
             int nRow =dir[0]+row;
             int nCol = dir[1]+col;
             
             if(nRow>=0 && nRow<board.length && nCol>=0 && nCol<board[0].length &&(board[nRow][nCol]==1 || board[nRow][nCol]==2))
             {
                 result++;
             }
         }
         
         return result;
     }
}