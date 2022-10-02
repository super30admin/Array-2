// 0 - > 1 === 2
// 1 - > 0 === 3
//Time Complexity: O(m*n).
//Space Complexity: O(1).

//The trick here is the various directions to go into and the replacement of live and dead cell while keeping the bounds intact. 




class Solution {
    int m;
    int n;
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return;
        
        m = board.length; // rows
        n = board[0].length; // columns
        
//                  int top = board[i-1][j];
//                 int bottom = board[i+1][j];
//                 int left = board[i][j-1];
//                 int right = board[i][j+1];
//                 int diagonaltop1 = board[i-1][j-1];
//                 int diagonaltop2 = board[i-1][j+1];
//                 int diagonalbottom1 = board[i+1][j-1];
//                 int diagonalbottom2 = board[i+1][j+1];
        

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++)
           {
             int neighbours = countNeighbours(board, i, j);
            
             if(board[i][j] == 0) {
                 if(neighbours == 3)
                     board[i][j] = 2;
             }
            else{
                if(neighbours < 2)
                    board[i][j] = 3;
    
            if(neighbours > 3)
                board[i][j] = 3;
            }    
          }
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 2){
                    board[i][j] = 1;
                }
                else if(board[i][j] == 3){
                    board[i][j] = 0;
                }
             }    
          }
    }
    
    private int countNeighbours(int[][] board, int row, int col){
        int[][] dirs = {{0,1}, {0, -1}, {1, 0}, {-1, 0}, {-1,-1}, {1,1},{-1,1},{1,-1}};

        int cnt = 0;
        
        for(int[] d: dirs){
            int newrow = row + d[0];
            int newcol = col + d[1];
            if(newrow >= 0 && newrow < m && newcol >=0 && newcol < n && (board[newrow][newcol] == 1 || board[newrow][newcol] == 3))
                cnt++;
        }
        
        return cnt;
    }
}