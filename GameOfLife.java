// Time Complexity : O(mn) +O(mn) where
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

// since we are manipulating iteratively, value of the current element will be
//  wrongly influenced by the neighbouring element which are updated on the fly
// to stop this we will encode the newly created 1->0 as 4 and 0->1 as 2 

class Solution {
    public void gameOfLife(int[][] board) {
        // Edge case
        if (board == null || board.length == 0)
            return;

        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // helper to calculate alive neighbours (1 or 4 in neighbours)
                int alive = countAlive(board, n, m, i, j);
                // conditions to convert the current cell to dead or alive
                if (board[i][j] == 1 && (alive < 2 || alive > 3))
                    board[i][j] = 4; // for the newly created 1
                else if (board[i][j] == 0 && (alive == 3))
                    board[i][j] = 2; // for the newly created 0
            }
        }

        // to decode the 4 and 2 encodings
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 4)
                    board[i][j] = 0;
                else if (board[i][j] == 2)
                    board[i][j] = 1;
            }
        }

    }

    private int countAlive(int[][] board, int n, int m, int i, int j) {

        int[][] dirs = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };
        int count = 0;

        // for all the eight directions
        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            // checks the boundary conditions for all the r and c and counts the number of
            // 1s and 4s
            if (r >= 0 && r < n && c >= 0 && c < m && (board[r][c] == 1 || board[r][c] == 4))
                count++;
        }
        return count;

    }
}