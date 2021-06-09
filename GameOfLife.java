/**
 * @author Vishal Puri
 * // Time Complexity : O(mn)
 * // Space Complexity : O(1)
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this :
 */

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //countLives runs for constant time
                count = countLives(board, i, j, m, n);
                if (board[i][j] == 0) {
                    if (count == 3)
                        board[i][j] = 2;
                } else {
                    if (count < 2 || count > 3)
                        board[i][j] = 3;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2)
                    board[i][j] = 1;
                else if (board[i][j] == 3)
                    board[i][j] = 0;
            }
        }
    }

    private int countLives(int[][] board, int i, int j, int m, int n) {
        //direction matrix
        //              r l u b ur ul br bl
        int count = 0;
        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}, {-1, 1}, {-1, -1}, {1, 1}, {1, -1}};
        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            if (r >= 0 && r < m && c >= 0 && c < n && (board[r][c] == 1 || board[r][c] == 3))
                count++;
        }
        return count;
    }


}
