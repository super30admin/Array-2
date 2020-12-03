
// 289. Game of Life (#PR 32 S30)




class Solution {
    public void gameOfLife(int[][] board) {
        
        if (board == null || board.length == 0) {
        return;
    }
        int m = board.length;
        int n = board[0].length;
        int id = 0;
      
      //  while (id < m*n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n ; j++) {
                 int alive =  countAlive(board, m, n, i, j);

                if(board[i][j] == 1 && (alive < 2 || alive > 3)) board[i][j] = 4;
                else if (board[i][j] == 0 && alive == 3) board[i][j] = 2;
                  
            }
        }
          
        //}
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n ; j++) {
             if (board[i][j] == 2) {
                 board[i][j] = 1;
             } else if (board[i][j] == 4) {
                 board[i][j] = 0;
             }
             
         }
        }
    }
    
    public int countAlive(int[][] board, int m, int n, int i, int j) {
        int count = 0;
        int dir[][] = {{-1, 0}, {-1,1}, {0, 1}, {1,1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        
        for (int di[] : dir) {
            int r = i + di[0];
            int c = j + di[1];
            
            if (r >= 0 && r < m  && c >= 0 && c < n && (board[r][c] == 1 || board[r][c] == 4)) count++;
            
            
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