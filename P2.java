// Time Complexity :    O(m * n)
// Space Complexity :   O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length; int n = board[0].length;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                int countAlives = countAlive(board, i, j, m, n);
                if (board[i][j] == 1 && (countAlives < 2 || countAlives > 3)){
                    //alive
                    board[i][j] = 2;
                }
                if (board[i][j] == 0 && countAlives == 3) {
                    board[i][j] = 3;
                }
            }
        }
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                }
                if (board[i][j] == 3){
                    board[i][j] = 1;
                }
            }
        }
    }

    private int countAlive(int[][] board, int i, int j, int m, int n) {     //2, 3
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        int count = 0;
        for (int[] dir: dirs) {
            int nr = i + dir[0];    //neighbouring row
            int nc = j + dir[1];    // " "  col

            //bounds check
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 2)) {
                count ++;
            }
        }
        return count;
    }
}
