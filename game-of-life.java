// Time Complexity : O(mxn)
// Space Complexity : O(1)

class Solution {
    int m;
    int n;
    int[][] dirs;

    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;
        dirs = new int[][] { { -1, -1 }, { 0, 1 }, { 1, 0 }, { 1, 1 }, { -1, 1 }, { 1, -1 }, { 0, -1 }, { -1, 0 } };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = countAlive(board, i, j);
                if ((count < 2 || count > 3) && board[i][j] == 1)
                    board[i][j] = 3;
                if (count == 3 && board[i][j] == 0)
                    board[i][j] = 2;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 3)
                    board[i][j] = 0;
                if (board[i][j] == 2)
                    board[i][j] = 1;
            }
        }
    }
    private int countAlive(int[][] board, int i, int j) {
        int result = 0;
        for (int[] dir : dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];
            if ((nc >= 0) && (nr >= 0) && (nc < n) && (nr < m) && (board[nr][nc] == 1 || board[nr][nc] == 3)) {
                result++;
            }
        }
        return result;
    }
}