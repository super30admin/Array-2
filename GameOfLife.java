class GameOfLife {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i<m; i++) {
            for(int j = 0; j < n; j++) {
                int alive = countAlive(board, i, j, m , n);
                if(board[i][j] == 1) {
                    if(alive < 2) {
                        board[i][j] = 2;
                    } else if( alive > 3) {
                        board[i][j] = 2;
                    }
                } else if ( board[i][j] == 0 && alive == 3) {
                    board[i][j] = 3;
                }
            }
        }

        for(int i = 0; i<m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int countAlive(int[][] board, int i, int j, int m, int n) {
        int count = 0;

        int boardR = (j+1 < n) && (board[i][j+1] == 1 ||board[i][j+1] == 2) ? count++ : 0;
        int boardL = (j-1 > -1) && (board[i][j-1] == 1 ||board[i][j-1] == 2) ? count++ : 0;
        int boardU = (i-1 > -1) && (board[i-1][j] == 1 || board[i-1][j] == 2) ? count++ : 0;
        int boardD = (i+1 < m) && (board[i+1][j] == 1 || board[i+1][j] == 2) ? count++ : 0;
        int boardUL = (i-1 > - 1 && j-1 > -1) && (board[i-1][j-1] == 1 || board[i-1][j-1] == 2) ? count++ : 0;
        int boardUR = (i-1 > -1  && j+1 < n) && (board[i-1][j+1] == 1 || board[i-1][j+1] == 2) ? count++ : 0;
        int boardDL = (i+1 < m && j-1 > -1) && (board[i+1][j-1] == 1 ||board[i+1][j-1] == 2) ? count++ : 0;
        int boardDR = (i+1 < m && j+1 < n) && (board[i+1][j+1] == 1 || board[i+1][j+1] == 2) ? count++ : 0;

        return count;
    }
}