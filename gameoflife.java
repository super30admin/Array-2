/*
// Time Complexity : O(n *m) where m is the number of rows and n is number of column.
// Space Complexity : O(n *m) where m is the number of rows and n is number of column. beacause we have created extra 2-d arrray.
// Did this code successfully run on Leetcode : Yes.
// Any problem you faced while coding this : No
*/

// Your code here along with comments explaining your approach

public class gameoflife {

    public void gameOfLife(int[][] board) {

        int m = board.length;
        int n = board[0].length;

        int[][] next = new int[m][n];
        int[][] dirs = new int[][] { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 },
                { -1, -1 } };

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                int count = 0;
                for (int[] dir : dirs) {

                    int x = dir[0] + i;
                    int y = dir[1] + j;

                    if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 1) {

                        count++;
                    }

                }

                if ((board[i][j] == 0) && (count == 3)) {
                    next[i][j] = 1;
                }

                else if (board[i][j] == 1) {

                    if (count == 2 || count == 3) {

                        next[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                board[i][j] = next[i][j];
            }
        }
    }
}
