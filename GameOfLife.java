public class GameOfLife {
    int[][] dirs;
    int m, n;

    public void gameOfLife(int[][] board) {

        this.dirs = new int[][]{
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1}, {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };

        this.m = board.length; //rows
        this.n = board[0].length; //cols

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = getCount(board, i, j); //get neighboring alive cells count

                if (board[i][j] == 0 && count == 3) {
                    board[i][j] = 3; //dead -> alive
                } else if (board[i][j] == 1 && (count < 2 || count > 3)) {
                    board[i][j] = 2; //alive -> dead
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int getCount(int[][] board, int i, int j) {
        int count = 0;
        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];

            if (r >= 0 && c >= 0 && r < m && c < n) {
                if (board[r][c] == 1 || board[r][c] == 2)
                    count++;
            }
        }

        return count;
    }
}

/**
 * TC: O(m*n)
 * SC: O(1)
 */