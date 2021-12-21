// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

// Approach
// For each element counted the lives 
// if the element was 1 and the lives were <2 or >3 made the element as 2
// if the element was 0 and the lives were 3 made the element as 3
// made another oass and converted all the 2 to 0 and 3 to 1

class Solution {
    int m, n;

    public void gameOfLife(int[][] board) {
        if (board == null && board.length == 0)
            return;

        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = count(board, i, j);
                if (board[i][j] == 1) {
                    if (lives < 2 || lives > 3) {
                        board[i][j] = 2;

                    }
                } else {
                    if (lives == 3) {
                        board[i][j] = 3;
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

    //
    // Function used for counting lives
    // created a 2d array with all possible directions
    // iterated throught all the direction for particular element and gave the count
    private int count(int[][] board, int r, int c) {
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 } };
        int count = 0;
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr >= 0 && nr < m && nc < n && nc >= 0 && (board[nr][nc] == 1 || board[nr][nc] == 2))
                count++;
        }
        return count;
    }
}