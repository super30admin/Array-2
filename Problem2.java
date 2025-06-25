// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Problem2 {
    int[][] dir={{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int live = 0;
                for (int[] d : dir) {
                    if ((i + d[0]) < 0 || (i + d[0]) >= board.length || (j + d[1]) < 0
                            || (j + d[1]) >= board[0].length) {
                        continue;
                    }
                    if (board[i + d[0]][j + d[1]] == 1 || board[i + d[0]][j + d[1]] == 2) {
                        live++;
                    }
                }
                if (board[i][j] == 1 && (live < 2 || live > 3)) {
                    board[i][j] = 2;
                }
                if (board[i][j] == 0 && live == 3) {
                    board[i][j] = 3;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] % 2;
            }
        }
    }
}
