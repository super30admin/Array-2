// 289. Game of Life

class Solution {
    int m;
    int n;
        
    public void gameOfLife(int[][] board) {
       
        if (board == null || board.length == 0)
            return ;
        // 0--> 1 3
        // 1--> 0 2
        
        m = board.length; n = board[0].length;
        
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                int count = countLives(board, i, j);
                
                // rule 1 & 3
                if(board[i][j] == 1 && (count < 2 || count > 3))
                {
                    board[i][j] = 2;
                }
                
                if(board[i][j] == 0 && count == 3){
                    board[i][j] = 3;
                }
            }
        }
        
        for(int k = 0; k < m; k++)
        {
            for(int l = 0; l < n; l++ )
            {
                if(board[k][l] == 3)
                {
                    board[k][l] = 1;
                }
                if(board[k][l] == 2)
                {
                    board[k][l] = 0;
                }
            }
        }
        
     }
    
    private int countLives(int [][] board, int i, int j)
    {
        int count = 0;
        int [][] dirs = {{0,1},{0,-1},{-1,0},{1,0},{-1,-1},{-1,1},{1,1},{1,-1}};
        for(int []dir : dirs)
        {
            int r = i + dir[0];
            int c = j + dir[1];
            if(r >=0 && c >= 0 && r < m && c  < n && (board[r][c] == 1 || board[r][c] == 2 ))
            {
                count++;
            }
        }
        return count;
    }
}

/*
Complexity Analysis

Time Complexity: 

O(M×N), where 
M is the number of rows and N is the number of columns of the Board.

Space Complexity: 
O(1) 
*/