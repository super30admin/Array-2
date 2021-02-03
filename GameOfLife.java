// Time Complexity : O(n*m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

class GameOfLife {
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        // 2 means the cell was alive and is now dead
        // 3 means the cell was dead and is now alive

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                int numSurroundingLives = getSurroundingLives(board, i, j, rows, cols);

                if(board[i][j] == 1 && (numSurroundingLives > 3 || numSurroundingLives < 2)) {
                    board[i][j] = 2;
                } else if(board[i][j] == 0 && numSurroundingLives == 3) {
                    board[i][j] = 3;
                }
            }
        }

        // if 2, then it's dead. if 3, then it's alive

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                
                if(board[i][j] == 2) {
                    board[i][j] = 0;
                } else if(board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int getSurroundingLives(int[][] board, int i, int j, int rows, int cols) {

        // all possible 8 directions
        int directions[][] = new int[][]{{0,-1}, {-1,-1}, {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}};
        int count = 0;
        for(int dir[] : directions) {
            int row = i + dir[0];
            int col = j + dir[1];

            // if valid indexes
            if(row >=0 && row < rows && col >= 0 && col < cols && (board[row][col] == 1|| board[row][col] == 2)) {
                count = count + 1;
            }
        }
        return count;
    }

}