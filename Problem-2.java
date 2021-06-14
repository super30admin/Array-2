import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(m x n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// We standard iteration over the matrix
// On each cell we find out the next state of the cell (as per given rules)
// Checking on all the neighbour cells (8 possible cells) and finding out the total lives around current cell
// Finally we revert back to 1 and 0 removing temporary state
class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;
        int lives = 0;

        // temporary state for new state:
        // 1 -> 0 -> 2 (becomes dead)
        // 0 -> 1 -> 3 (becomes alive)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                lives = getSurroundLivesCount(board, i, j);

                if (board[i][j] == 1) {
                    if (lives < 2 || lives > 3) {
                        // becomes dead
                        board[i][j] = 2;
                    }
                } else {
                    if (lives == 3) {
                        // becomes alive
                        board[i][j] = 3;
                    }
                }
            }
        }

        // here we change the temporary state to it's actual state
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

    private int getSurroundLivesCount(int[][] board, int i, int j) {
        // we create directions array
        int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 1 }, { 1, 1 }, { 1, -1 }, { -1, -1 } };

        int count = 0;
        int r = 0, c = 0;
        for (int[] dir : dirs) {
            r = i + dir[0];
            c = j + dir[1];

            if (r >= 0 && r < board.length && c >= 0 && c < board[0].length && (board[r][c] == 1 || board[r][c] == 2)) {
                count++;
            }
        }

        return count;
    }
}