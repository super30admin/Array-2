// Time Complexity : O(rows*cols)
// Space Complexity : O(rows*cols)
// Did this code successfully run on Leetcode : YES
class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        int prev[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prev[i][j] = board[i][j];
            }
        }

        int dirs[][] = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int live = 0;
                for (int dir[] : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x >= 0 && y >= 0 && x < m && y < n) {
                        if (prev[x][y] == 1) {
                            live++;
                        }
                    }
                }
                if (prev[i][j] == 1 && (live < 2 || live > 3)) {
                    board[i][j] = 0;
                } else if (prev[i][j] == 1 && live <= 3) {
                    board[i][j] = 1;
                } else if (prev[i][j] == 0 && live == 3) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }
}