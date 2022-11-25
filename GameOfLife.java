public class GameOfLife {
    private int row;
    private int col;

    /**
     * TC - O(m * n)
     * SC - O(1)
     * @param board
     */
    public void gameOfLife(int[][] board) {
        row = board.length;
        col = board[0].length;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                int neighborLiveCellCount = getNeighborLiveCellCount(board, i, j);

                if(board[i][j] == 1) {
                    if(neighborLiveCellCount < 2 || neighborLiveCellCount > 3) {
                        board[i][j] = 2;
                    }
                } else if (board[i][j] == 0){
                    if (neighborLiveCellCount == 3) {
                        board[i][j] = 3;
                    }
                }
            }
        }

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(board[i][j] == 2) {
                    board[i][j] = 0;
                }

                if(board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }

    }

    int getNeighborLiveCellCount(int[][] board, int r, int c) {
        int[][] dirs = {{-1,0}, {1, 0}, {0,-1}, {0,1}, {-1,-1}, {-1,1}, {1,1}, {1,-1}}; //U, L, Left, R, ULeft, UR, LR, LLeft
        int count = 0;

        for(int[] dir: dirs) {
            if (r + dir[0] >= 0 && r + dir[0] < row && c + dir[1] >= 0 && c + dir[1] < col) {
                if (board[r + dir[0]][c + dir[1]] == 1 || board[r + dir[0]][c + dir[1]] == 2) {
                    count++;
                }
            }
        }

        return count;
    }
}
