// Find All Numbers Disappeared in an Array
// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    private int m, n;
    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1,1}};
    //                           R        L       B       T       TL          TR      BL      BR
    private int countAlive(int[][] board, int i, int j) {
        int alive = 0;
        for(int[] dir: dirs) {
            int nr = i + dir[0]; // neighboring row
            int nc = j + dir[1]; // neighboring col
            if(nr >= 0 && nc >= 0 && nr < m && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 3))
                alive++;
        }
        return alive;
    }
    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;
        //null
        if(board == null || m == 0) return;
        // 0 -> 1 = 2   
        // 1 -> 0 = 3
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                int alive = countAlive(board, i, j);
                if(board[i][j] == 0 && alive == 3) board[i][j] = 2;
                if(board[i][j] == 1 && (alive < 2 || alive > 3)) board[i][j] = 3;
            }
        }
        // replacing 2 & 3 with 0 & 1
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 3) board[i][j] = 0;
                if(board[i][j] == 2) board[i][j] = 1;
            }
        }
    }
}