
//T.C = O(m*n)
// S.C = O(1)
class Solution {
    int m,n;
    public void gameOfLife(int[][] board) {
        
        m = board.length;
        n = board[0].length;
        //1->2
        //0->3
        
        for(int i =0;i<m;i++)
        {
            for (int j=0;j<n;j++)
            {
                int count = livecells(board,i,j);
                if(board[i][j]==1 && (count < 2 || count > 3))
                   {
                       board[i][j]=2;
                   }
                   
                   else if( board[i][j] == 0 && count==3)
                   {
                     
                       board[i][j]=3;
                   }
                   
                   
            }
        }
        
        for(int i =0 ;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]==2)
                {
                    board[i][j]=0;
                }
                else if (board[i][j]==3)
                {
                    board[i][j]=1;
                }
            }
        }
    }
                   
     private int livecells(int[][] board , int r , int c) {
                       int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{-1,1},{1,-1}};
                       
                       int count = 0;
                       for(int[] dir : dirs)
                       {
                           int nr = r + dir[0];
                           int nc = c + dir[1];
                           if((nr>=0 && nr <=m-1) && (nc >=0 && nc<= n-1))
                           {
                               if(board[nr][nc]==1 || board[nr][nc]==2)
                               {
                                   count = count+1;
                               }
                           }
                       }
                       
                       return count;
                   }
                   
                   }
           
             
        
            