// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Create a direction array using which we can move in all 8 directions. Traverse through the entire board, where for each cell checking its elements in all 8 direction.
 * If the count of live cells around live cell is <2 or >3, mark it 2(dead now, previously alive). If the count of live cells around dead cell is 3, mark it 3(now alive,
 * previously dead). After traversing the entire board, mark all 3 as 1, and 2 as 0.
 */
class Solution {

    int[][] dirs;
    public void gameOfLife(int[][] board) {

        this.dirs = new int[][]{{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
        int m = board.length;
        int n = board[0].length;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int count = findCount(board, i, j, m, n);

                if(board[i][j] == 1) {
                    if(count < 2 || count > 3)
                        board[i][j] = 2;
                }
                else {
                    if(count == 3)
                        board[i][j] = 3;
                }
            }
        }

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == 3)
                    board[i][j] = 1;
                else if(board[i][j] == 2)
                    board[i][j] = 0;
            }
        }
    }

    private int findCount(int[][] board, int i, int j, int m, int n) {

        int count = 0;
        for(int[] dir: dirs) {
            int row = i + dir[0];
            int col = j + dir[1];

            if(row>=0 && col>=0 && row<m && col<n &&
                    (board[row][col] == 1 || board[row][col] == 2))
                count++;
        }

        return count;
    }
}