// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int m; int n; int[][] dirs;
    public void gameOfLife(int[][] board) {
        // return if the matrix is null or empty
        if(board == null || board.length == 0) return;
        // store the dimensions of the matrix in variables
        m = board.length;
        n = board[0].length;
        // store the directional changes to be made to index in an array
        dirs = new int[][] {{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                // for each element in the matrix
                // count the number of live neighbors
                int count = countLive(board, i, j);
                // if the current cell is alive
                // and number of neighbors are less than 2 or
                // number of neighbors are more than 3
                // then mark the current cell as dead (3: living to dead)
                if(board[i][j] == 1 && (count < 2 || count > 3)){
                    board[i][j] = 3;
                }
                // if the current cell is dead
                // and number of live neighbors are equal to 3
                // then mark the current cell as living (2: dead to alive)
                if(board[i][j] == 0 && count == 3){
                    board[i][j] = 2;
                }
            }
        }
        // traverse through the matrix and mark 3 as 0 and 2 as 1
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 3) board[i][j] = 0;
                if(board[i][j] == 2) board[i][j] = 1;
            }
        }
    }
    private int countLive(int[][] board, int i, int j){
        // initialize counter as 0
        int count = 0;
        // check for living neighbors in every direction and update the counter
        for(int[] dir: dirs){
            int nr = i + dir[0];
            int nc = j + dir[1];
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 3)) count ++;
        }
        return count;
    }
}