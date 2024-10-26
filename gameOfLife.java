// Time Complexity : 
// Space Complexity : 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
 * Created dirs array for easy traversal between neighbours
 * In place solution
 */
class Solution {

    int[][] dirs;

    private int countAlive(int[][] board, int i, int j, int m, int n) {
        int res = 0;
        for (int[] dir : dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];

            // bound check
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 2)) {
                res++;
            }
        }
        return res;
    }

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        // left, right, up, down, diagonal-up-left, diagonal-up-right, diagonal
        // down-right, diagonal-down-left
        this.dirs = new int[][] { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 }, { -1, -1 }, { -1, 1 }, { 1, 1 },
                { 1, -1 } };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = countAlive(board, i, j, m, n);
                if (board[i][j] == 1 && (cnt < 2 || cnt > 3)) {
                    board[i][j] = 2;
                } else if (board[i][j] == 0 && cnt == 3) {
                    board[i][j] = 3;
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
}
