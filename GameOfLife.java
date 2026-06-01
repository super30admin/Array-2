//Time Complexity : O(m*n)
//Space Complexity : O(1)

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        for(int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int live = 0;

                for(int[] dir: dirs) {
                    int nrow = r + dir[0];
                    int ncol = c + dir[1];
                    if(nrow >= 0 && ncol >=0 && nrow < m && ncol < n && (board[nrow][ncol] == 2 || board[nrow][ncol] == 1)) {
                        live++;
                    }
                }

                // 2 : live -> dead
                // 3 : dead -> live
                if(board[r][c] == 1 && (live < 2 || live > 3)) {
                    board[r][c] = 2;
                } else if (board[r][c] == 0 && live == 3) {
                    board[r][c] = 3;
                }

            }
        }
        for(int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if(board[r][c] == 2)
                    board[r][c] = 0;
                else if (board[r][c] == 3)
                    board[r][c] = 1;
            }
        }

    }
}
