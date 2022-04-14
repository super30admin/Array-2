// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class GameOfLife {
    
    public boolean validCell(int nextRow, int nextCol, int m, int n) {
        return nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n;
    }
    
    public int getLiveCells(int[][] board, int r, int c) {
        int[][] dirs = new int[][] {
            {0, -1},
            {0, 1},
            {1, 0},
            {-1, 0},
            {1, -1},
            {-1, 1},
            {1, 1},
            {-1, -1}
        };
        int liveCells = 0;
        
        for(int[] dir: dirs) {
            int nextRow = r + dir[0];
            int nextCol = c + dir[1];

            if(validCell(nextRow, nextCol, board.length, board[0].length) && (board[nextRow][nextCol] == 1 || board[nextRow][nextCol] == 2)) {
                liveCells++;
            }
        }
        return liveCells;
    }
    public void gameOfLife(int[][] board) {
    
        int m = board.length;
        int n = board[0].length;

        for(int r = 0; r < m ; r++) {
            for(int c = 0; c < n; c++) {

                if(board[r][c] == 0 || board[r][c] == 3) {
                    int liveCells = getLiveCells(board, r, c);
                    if(liveCells == 3) {
                        board[r][c] = 3;
                    }
                } else if(board[r][c] == 1 || board[r][c] == 2) {
                    int liveCells = getLiveCells(board, r, c);
                    
                    if(liveCells > 3 || liveCells < 2) {
                        board[r][c] = 2;
                    }
                }
            }
        }

        for(int r = 0; r < m ; r++) {
            for(int c = 0; c < n; c++) {
                if(board[r][c] == 2) {
                    board[r][c] = 0;
                }

                if(board[r][c] == 3) {
                    board[r][c] = 1;
                }
            }
        }
    }
}