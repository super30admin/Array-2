// Time Complexity : O(m*n) where m is the no of rows in input, n is the number of columns in input
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length, count;
        int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, -1 },
                { -1, 1 } };
        for (int i = 0; i < m; i += 1) {
            for (int j = 0; j < n; j += 1) {
                count = findNeighbours(board, i, j, dirs);
                if (board[i][j] == 1 && (count < 2 || count > 3)) {
                    board[i][j] = 2;
                } else if (board[i][j] == 0 && (count == 3)) {
                    board[i][j] = 3;
                }
            }
        }

        for (int i = 0; i < m; i += 1) {
            for (int j = 0; j < n; j += 1) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    public int findNeighbours(int[][] board, int i, int j, int[][] dirs) {
        int count = 0;
        for (int[] dir : dirs) {
            int k = dir[0];
            int l = dir[1];
            if (i + k >= 0 && i + k < board.length && j + l >= 0 && j + l < board[0].length) {
                if (board[i + k][j + l] == 1 || board[i + k][j + l] == 2) {
                    count += 1;
                }
            }
        }
        return count;
    }
}