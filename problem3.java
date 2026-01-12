// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Need to carefully count live neighbors using old state only.


// Your code here along with comments explaining your approach in three sentences only
// We update the board in-place by using extra marker states so we don’t lose original info.
// 2 means dead -> live (was 0, will be 1) and 3 means live -> dead (was 1, will be 0).
// After first pass, we convert markers to final 0/1 values in second pass.

class Solution {
    public void gameOfLife(int[][] board) {

        int m = board.length;
        int n = board[0].length;

        int[] dr = {-1,-1,-1,0,0,1,1,1};
        int[] dc = {-1,0,1,-1,1,-1,0,1};

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                int live = 0;

                // count live neighbors based on old values
                for (int k = 0; k < 8; k++) {
                    int nr = r + dr[k];
                    int nc = c + dc[k];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                        // old live is 1 or 3 (3 means it was live before update)
                        if (board[nr][nc] == 1 || board[nr][nc] == 3) {
                            live++;
                        }
                    }
                }

                // apply rules with markers
                if (board[r][c] == 1) {
                    if (live < 2 || live > 3) board[r][c] = 3; // live -> dead
                } else {
                    if (live == 3) board[r][c] = 2; // dead -> live
                }
            }
        }

        // convert markers to final state
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == 2) board[r][c] = 1;
                else if (board[r][c] == 3) board[r][c] = 0;
            }
        }
    }
}
