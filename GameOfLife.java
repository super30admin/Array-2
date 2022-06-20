// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class GameOfLife {
    int m;
    int n;
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public void gameOfLife(int[][] board) {

        m = board.length;
        n = board[0].length;

        if (board == null || board.length == 0) {
            return;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int countAlive = countAlive(board, i, j);

                if (board[i][j] == 1 && countAlive < 2) {
                    board[i][j] = 3;
                } else if (board[i][j] == 1 && countAlive > 3) {
                    board[i][j] = 3;
                } else if (board[i][j] == 0 && countAlive == 3) {
                    board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                } else if (board[i][j] == 3) {
                    board[i][j] = 0;
                }
            }
        }
    }


    private int countAlive(int[][] board, int i, int j) {
        int res = 0;

        for (int[] dir : dirs) {
            int neighbour_row = i + dir[0];
            int neighbour_col = j + dir[1];

            if (neighbour_row >= 0 && neighbour_row < m && neighbour_col >= 0 && neighbour_col < n && (board[neighbour_row][neighbour_col] == 1 || board[neighbour_row][neighbour_col] == 3)) {
                res++;
            }
        }
        return res;
    }
}
