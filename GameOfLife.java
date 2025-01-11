class GameOfLife {
    int rowLength;
    int colLength;

    public void gameOfLife(int[][] board) {
        rowLength = board.length;
        colLength = board[0].length;
        int n = rowLength * colLength;
        // <2 || >3 - dies under or over population
        // ==2||==3 lives
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                int count = getNeighbors(board, i, j);
                if (board[i][j] == 1) {
                    if (count < 2 || count > 3) {
                        board[i][j] = 2;
                    }
                } else if (board[i][j] == 0) {
                    if (count == 3) {
                        board[i][j] = 3;
                    }
                }
            }
        }
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int getNeighbors(int[][] board, int i, int j) {
        int count = 0;
        int[][] dirs = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
        for (int[] dir : dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];
            if (nr >= 0 && nr < rowLength && nc >= 0 && nc < colLength && (board[nr][nc] == 1 || board[nr][nc] == 2)) {
                count++;
            }
        }
        return count;
    }
}