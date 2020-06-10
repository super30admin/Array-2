// Time Complexity :O(m*n) m- length of the row, n- length of the column
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes 
// Any problem you faced while coding this : -
class Solution {
    int m,n;
    public void gameOfLife(int[][] board) {
        if(board==null || board.length==0)
            return;
        m=board.length;
        n=board[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
             int lives=helper(board,i,j);
              if(board[i][j]==1)
              {
                  if(lives<2 || lives>3)
                    board[i][j]=3;
                  
              }else{
                  if(lives==3)
                    board[i][j]=2;
              }
                
            }
        }
        
       for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]==2)
                    board[i][j]=1;
                else if(board[i][j]==3)
                    board[i][j]=0;
            }
       }
        
    }
    
    private int helper(int[][] board, int i, int j)
    {
        int count=0;
        int [][]dirs={{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,1},{1,-1}};
        for(int[] d:dirs)
        {
          int r=i+d[0];
          int c=j+d[1];
            
          if(r>=0 && c>=0 && c<n && r<m && (board[r][c]==1 || board[r][c]==3))
              count++;
        }
        return count;
    }
}