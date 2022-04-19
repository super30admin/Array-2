
//Time Complexity O(n^2)
// Space Complexity O(1)
public class Problem3 {
    static int m = 0;
    static int n = 0;

    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        m = board.length;
        n = board[0].length;

        //1 --> 0 ===2
        //0---> 1 ===3
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int countLiveCells = countLiveCells(board, i, j);
                if (board[i][j] == 0) {
                    if (countLiveCells == 3) {
                        board[i][j] = 3;
                    }
                } else {
                    if (countLiveCells < 2 || countLiveCells > 3) {
                        board[i][j] = 2;
                    }
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

    private static int countLiveCells(int[][] board, int r, int c) {
        int[][] dirs = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}, {1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int total = 0;
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 2)) {
                total++;
            }
        }
        return total;
    }
}
