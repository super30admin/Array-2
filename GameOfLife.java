// Time Complexity :O(MN)
// Space Complexity :O(MN)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here  with comments explaining your approach

class Solution {
    int m;
    int n;

    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;

        // 0-->1=2
        // Changes when Count==3
        // 1-->0=3
        // Changes when count>3 and count<2
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = countHelper(board, i, j);
                if (board[i][j] == 1 && (count < 2 || count > 3)) {
                    board[i][j] = 3;
                }
                if (board[i][j] == 0 && count == 3) {
                    board[i][j] = 2;
                }
            }
        }
        // Change all 3's to 0 and 2's to 1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 3)
                    board[i][j] = 0;

                if (board[i][j] == 2)
                    board[i][j] = 1;
            }
        }

    }

    private int countHelper(int[][] board, int i, int j) {
        // dirs array to check on all neighbours
        int dirs[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 } };
        int count = 0;
        for (int[] dir : dirs) {
            int row = i + dir[0];
            int col = j + dir[1];
            if (row < m && col < n && row > -1 && col > -1 && (board[row][col] == 1 || board[row][col] == 3))
                count++;
        }
        return count;
    }
}