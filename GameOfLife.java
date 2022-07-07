// Time Complexity :O(m*n)
// Space Complexity : O(1) , since the changes are made on the same array.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 

class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0)
            return;
        int m, n;

        m = board.length;
        n = board[0].length;

        // 0->1 =2 ;
        // 1->0 =3
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveneighborcount = countLive(board, i, j);
                // if cell was dead
                if (board[i][j] == 0) {
                    if (liveneighborcount == 3) {
                        board[i][j] = 2; // 0->1 =2
                    }
                } else { // if cell was alive
                    if (liveneighborcount < 2) {
                        board[i][j] = 3; // 1->0 =3
                    }
                    if (liveneighborcount > 3) {
                        board[i][j] = 3; // 1->0 =3
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) { // replacing 2 with 1
                    board[i][j] = 1;
                } else if (board[i][j] == 3) { // replacing 3 with 0
                    board[i][j] = 0;
                }
            }
        }
    }

    private int countLive(int[][] board, int r, int c) {
        int count = 0;
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { -1, -1 }, { 1, 1 }, { -1, 1 }, { 1, -1 } };
        for (int[] dir : dirs) {
            int newrow = r + dir[0];
            int newcol = c + dir[1];
            if (newrow >= 0 && newrow < m && newcol >= 0 && newcol < n
                    && (board[newrow][newcol] == 1 || board[newrow][newcol] == 3)) {
                count++;
            }
        }

        return count;
    }
}