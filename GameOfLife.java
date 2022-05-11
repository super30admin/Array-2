// Time Complexity : O(MN * O(8)) O(8) - directions - constant time though
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public void gameOfLife(int[][] board) {
        for(int i=0;i<board.length;i++) {
            for(int j=0; j<board[0].length;j++) {
                // neighbouring 1s
                int countsAlive = countsAlive(board, i, j);
                // if counts that are alive nearby is exactly 3, curr index can respawn
                if(board[i][j] == 0 && countsAlive == 3) {
                    board[i][j] = 3;
                }
                // if counts that are alive nearby is exactly <2 or >3, curr index will die
                if(board[i][j] == 1 && (countsAlive <2 ||  countsAlive >3)) {
                    board[i][j] = 2;
                }
            }
        }
        //temporary state change pattern is used
        // 3 for if dead becomes alive
        // 2 for if live becomes dead

        // to put back the original values in-place
        for(int i=0;i<board.length;i++) {
            for(int j=0; j<board[0].length;j++) {
                if(board[i][j] == 2) {
                    board[i][j] = 0;
                }
                if(board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }
    private int countsAlive(int[][] board, int row, int col) {
        // to cover all the directions from the curr index
        int[][] dirs = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1}, {1,-1},{1,0},{1,1}};
        int count = 0;
        for(int[] currDir: dirs) {
            int calcRowIndex = row-currDir[0];
            int calcColIndex = col-currDir[1];
            // boundary checks
            if(calcRowIndex>=0 && calcColIndex>=0 && calcRowIndex<=board.length -1 && calcColIndex<= board[0].length -1 ) {
                if(board[calcRowIndex][calcColIndex] == 1 || board[calcRowIndex][calcColIndex] == 2) count++;
            }
        }
        return count;
    }
}