class GameOfLife {

    int[][] dirs;

    public void gameOfLife(int[][] board) {
        dirs = new int[][] {{-1,-1}, {-1, 0}, {-1,1}, {0, -1}, {0, 1}, {1, -1}, {1,0}, {1,1}};

        for(int i = 0; i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                int aliveCount = getAliveCount(board, i, j);

                if(board[i][j] == 0 || board[i][j] == 2) {
                    if(aliveCount == 3) {
                        board[i][j] = 2;  // 2 Dead - Alive
                    }
                } else {
                    if(aliveCount < 2 || aliveCount > 3) {
                        board[i][j] = 3; // 3 Alive - Dead
                    }
                }
            }
        }

        for(int i = 0; i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j] == 2) board[i][j] = 1;
                else if(board[i][j] == 3) board[i][j] = 0;
            }
        }


    }

    public int getAliveCount(int[][] board, int i, int j) {
        int count = 0;
        for(int[] dir : dirs) {
            int row = i + dir[0];
            int col = j + dir[1];

            if(row >=0 && col >=0 && row < board.length && col < board[0].length && (board[row][col] == 1 || board[row][col] == 3)) {
                count++;
            }
        }

        return count;
    }
}