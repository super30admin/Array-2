// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        // First pass: apply transformation rules
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = countAlives(board, i, j, m, n, dirs);
                if (board[i][j] == 1 && (count < 2 || count > 3)) {
                    board[i][j] = 4; // Change live to dead
                } else if (board[i][j] == 0 && count == 3) {
                    board[i][j] = 3; // Change dead to live
                }
            }
        }

        // Second pass: finalize the state transformation
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 4) {
                    board[i][j] = 0;
                } else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int countAlives(int[][] board, int r, int c, int m, int n, int[][] dirs) {
        int count = 0;
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 4)) {
                count++;
            }
        }
        return count;
    }
}
