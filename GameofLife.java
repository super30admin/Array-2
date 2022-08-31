class Solution {
    //sc-0(1)
    //tc-o(n)
    int m;
    int n;
    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int count = countAlive(board,i,j);
                if(board[i][j] == 1&& (count<2 || count>3))
                {
                    board[i][j] = 3;
                    
                }
                if(board[i][j] == 0 && count == 3)
                {
                    board[i][j] =2;
                }
            }
        }
        //change states back to 0 or 1
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j] == 3) {board[i][j]= 0;}
                if(board[i][j] == 2){board[i][j] = 1;}
            }
        }
        
     
        
    }
       //count alive
        
        private int countAlive(int[][]board, int i, int j)
        {
             m = board.length;
        n = board[0].length;
            int[][]dir = new int[][]{{0,1},{1,0},{-1,0},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
            int result=0;
            for(int[] dirs : dir)
            {
                int nr = dirs[0]+i;
                int nc = dirs[1]+j;
                
                if(nr>=0 && nc >= 0 && nr<m && nc<n)
                    
                   
                {
                    if(board[nr][nc] == 3|| board[nr][nc] == 1)
                    result++;
                    
                }
                
            }
            
            return result;
        }

}