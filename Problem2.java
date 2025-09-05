// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Getting the neighbor count for each index and marking the element to be flipped using the numbers which are not present in the matrix.
 * Flipping the numbers back in original array to keep 1s and 0s
 */
class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        // updating the index from 0->2 and 1->3 based on the conditions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = liveCount(board, i, j);
                if (board[i][j] == 1) {
                    if (count < 2 || count > 3) {
                        board[i][j] = 2;
                    }
                } else {
                    if (count == 3) {
                        board[i][j] = 3;
                    }
                }
            }
        }

        // updating it back from 2->0 and 3->1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                }
                if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }

    }

    private int liveCount(int[][] board, int i, int j) {
        int count = 0;
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        for (int[] direction : directions) {
            int r = i + direction[0];
            int c = j + direction[1];

            if (r >= 0 && r < board.length && c >= 0 && c < board[0].length) {
                if (board[r][c] == 1 || board[r][c] == 2)
                    count++;
            }
        }

        return count;
    }
}