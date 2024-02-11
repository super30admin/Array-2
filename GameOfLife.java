// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english  : create a temparory state of matrix. 1 --> 0 is marked by -1 
// 0 --> 1 is marked by -2. Then iterated to again to get final next stage of matrix.

// Your code here along with comments explaining your approach

class Solution {
    int[][] dirs;

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        //right left down downlt downrt up upleft upright
        dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { 1, -1 }, { 1, 1 }, { -1, 0 }, { -1, -1 }, { -1, 1 } };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //check neighbors
                int live = countLiveNeigh(board, i, j);

                if (board[i][j] == 1) { // alive
                    if (live < 2 || live > 3) { // under and over population
                        board[i][j] = -1; // 1 --> 0 is marked by -1
                    }
                } else { // dead
                    if (live == 3) {
                        board[i][j] = -2; // 0 --> 1 is marked by -2
                    }
                }
            }
        }

        // convert to final state by making -1 as 0 and -2 as 1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // lives
                if (board[i][j] == -1) {
                    board[i][j] = 0; 
                } else if (board[i][j] == -2) {
                    board[i][j] = 1; 
                }
            }
        }
    }

    private int countLiveNeigh(int[][] board, int i, int j) {
        int count = 0;

        for (int[] dir : dirs) {
            // new row and column for checking neighbours
            int nr = i + dir[0];
            int nc = j + dir[1];
            // boundary checks
            if (nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length && (board[nr][nc] == 1 || board[nr][nc] == -1)) {
                count++;
            }
        }

        return count;
    }
}
