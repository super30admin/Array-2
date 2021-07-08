class Solution {
    public void gameOfLife(int[][] board) {
        
        if(board == null || board.length==0)
        {
            return;
        }
        
        //Since I cannot do have extra space
        //i will mark 1->0 as 3 and 0->1 as 2
        
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                int count = Ncount(board,i,j);
                
                if(board[i][j]==1 && (count<2||count>3))
                {
                    board[i][j] = 3;
                }
                else if(board[i][j]==0 && count == 3)
                   {
                       board[i][j] = 2;
                   }
            }
        }
        
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                 if(board[i][j]== 3)
                {
                    board[i][j] = 0;
                }
                else if(board[i][j]==2)
                   {
                       board[i][j] = 1;
                   }
            }
        }
    }
    
    private int Ncount(int[][] b, int i, int j)
    {
        int[][] findN = new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        int tc =0;
        
        for(int[] a: findN)
        {
            int r = i+a[0];
            int c = j+a[1];
            
            if(r>=0 && r<b.length && c>=0 && c<b[0].length)
            {
                if(b[r][c]==1 || b[r][c]==3)
                {
                    tc += 1;
                }
            }
        }
        return tc;
    }
}

//runtime: O(n^2)
//space: O(1)
