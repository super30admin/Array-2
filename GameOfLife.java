

// Time Complexity : O(m*n) where m is the number of rows and n is the number of columns
// Space Complexity : O(1) since we are modifying the board in place and not using any extra space
// Leetcode problem : https://leetcode.com/problems/game-of-life/


/**
 * Iterate through the board to count live neighbors for each cell and mark state changes using temporary values.  
 * Use `2` to indicate a live cell turning dead and `3` for a dead cell becoming alive to avoid affecting neighbor counts.  
 * Perform a second pass to finalize the board by converting temporary values back to their respective states.  
 */

public class GameOfLife {
    int[][] dir={{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};

    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int currentCell = board[i][j];
                int count = getCount(board, i, j);
                if (currentCell == 0 && count == 3) {
                    board[i][j] = 3;
                }

                if (currentCell == 1 && (count > 3 || count < 2)) {
                    board[i][j] = 2;
                }
            }
        }

        for(int i = 0; i < board.length ; i++) {
            for(int j =0 ; j<  board[i].length ; j++) {
                if(board[i][j] == 2) board[i][j] = 0;
                else if(board[i][j] == 3) board[i][j] = 1;
            }
        }
    }

    public int getCount(int[][] board, int i, int j) {
        int count = 0;
        for (int[] direction : dir) {
            int r = i + direction[0];
            int c = j + direction[1];

            int rowLength = board.length;
            int colLength = board[i].length;

            if (r >= 0 && c >= 0 && r < rowLength && c < colLength) {
                if (board[r][c] == 1 || board[r][c] == 2) {
                    count++;
                }
            }
        }
        return count;
    }
    
}
