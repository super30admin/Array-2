
// Time Complexity : O(mn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// Traverse the board and mark cells with intermediate states: `2` for live→dead, `3` for dead→live, based on the number of live neighbors.
// Count neighbors by considering cells that were originally alive (`1` or `2`) so that updates are done in-place without affecting the current state.
// In a second pass, finalize the board by converting intermediate states (`2→0`, `3→1`) to get the next state of the Game of Life.

class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return;

        int m = board.length;
        int n = board[0].length;
        int[][] dirs = {{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};

        // First pass: mark intermediate states
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbours = countNeighbours(board, i, j, m, n, dirs);

                if (board[i][j] == 1) {
                    if (liveNeighbours < 2 || liveNeighbours > 3) {
                        board[i][j] = 2; // live -> dead
                    }
                } else {
                    if (liveNeighbours == 3) {
                        board[i][j] = 3; // dead -> live
                    }
                }
            }
        }

        // Second pass: finalize the board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) board[i][j] = 0;
                else if (board[i][j] == 3) board[i][j] = 1;
            }
        }
    }

    private int countNeighbours(int[][] board, int i, int j, int m, int n, int[][] dirs) {
        int count = 0;
        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            // Explicitly check for originally alive cells (1 or 2)
            if (r >= 0 && r < m && c >= 0 && c < n && (board[r][c] == 1 || board[r][c] == 2)) {
                count++;
            }
        }
        return count;
    }
}
