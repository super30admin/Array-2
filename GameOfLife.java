// Time Complexity :O(m*n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int rows = board.length;
       int cols = board[0].length;
       int[][] directions = {
           {-1, -1}, {-1, 0}, {-1, 1},
           {0, -1},         {0, 1},
           {1, -1}, {1, 0}, {1, 1}
       };

       // First pass: Encode new states
       for (int r = 0; r < rows; r++) {
           for (int c = 0; c < cols; c++) {
               int liveNeighbors = 0;

               // Count live neighbors
               for (int[] dir : directions) {
                   int nr = r + dir[0], nc = c + dir[1];
                   if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && Math.abs(board[nr][nc]) == 1) {
                       liveNeighbors++;
                   }
               }

               // Apply game rules
               if (board[r][c] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                   board[r][c] = 2; // Live → Dead
               } else if (board[r][c] == 0 && liveNeighbors == 3) {
                   board[r][c] = -1; // Dead → Live
               }
           }
       }

       // Second pass: Convert back to 0 and 1
       for (int r = 0; r < rows; r++) {
           for (int c = 0; c < cols; c++) {
               if (board[r][c] == 2) {
                   board[r][c] = 0; // Convert dead
               } else if (board[r][c] == -1) {
                   board[r][c] = 1; // Convert alive
               }
           }
       }
       
   }
    
}
