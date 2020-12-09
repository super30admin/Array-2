/** Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors 
* (horizontal, vertical, diagonal) using the four rules
* TC O(N*M). Space complexity O(1)
* Code was submitted on leetcode
*/
 
class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length ==0 )
            return;
        for (int row = 0; row< board.length; row++) {
            for(int col = 0; col < board[0].length; col ++) {
                int liveCells = findAlive(row, col, board);
                if (board[row][col] == 1) {
                    if (liveCells < 2 || liveCells > 3) {
                         board[row][col] = 2;
                    }
                }
               
                else{
                    if (liveCells == 3) {
                         board[row][col] = 3;
                    }
                   
                }
            }
        }
         for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == 3) {
                    board[row][col] = 1;
                } else if (board[row][col] == 2){
                    board[row][col] = 0;
                }
            }
        }
    }
    
    
    public int findAlive(int row, int col, int[][]board) {
        int[] neighbors = new int[] {-1,0,1};
        int alive = 0;
        for (int r = 0; r < 3; r++) {
            for (int c =0; c<3; c++) {
                int nRow = row + neighbors[r];
                int nCol = col + neighbors[c];
                if (row != nRow || col != nCol) {
                    if ((nRow >=0 && nRow < board.length) && (nCol >=0 && nCol < board[0].length)){
                        if (board[nRow][nCol] == 1 || board[nRow][nCol] == 2)
                        {
                            alive++;
                        }
                    }
                }
            }
        }
        return alive;
    }
}    

