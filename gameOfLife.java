// Time Complexity : O(n*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

// set the changed values to other numbers and got back 
// the original representation at last

class Solution {
    public void gameOfLife(int[][] board) {
        int[][] dirs = {
                { 1, 0 }, { 1, 1 }, { 0, 1 }, { -1, 1 }, { -1, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 }
        };
        int rows = board.length;
        int cols = board[0].length;
        // int[][] ans = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int count = 0;
                for (int[] dir : dirs) {
                    int r = row + dir[0];
                    int c = col + dir[1];
                    if (r < rows && r >= 0 && c < cols && c >= 0 && (board[r][c] == 1 || board[r][c] == 3))
                        count++;
                }
                if ((board[row][col] == 0 || board[row][col] == 4)) {
                    if (count == 3)
                        board[row][col] = 4;
                } else {
                    if (count < 2 || count > 3)
                        board[row][col] = 3;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 3)
                    board[i][j] = 0;
                else if (board[i][j] == 4)
                    board[i][j] = 1;
            }
        }
    }
}