// Time Complexity : O(MN)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    int m, n;
    public void gameOfLife(int[][] board) {
       if(board == null || board.length == 0)
           return;
        m = board.length;
        n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n;j++){
                int liveCells = countlives(board, i, j);
                //Rule 1 and 3
                if(board[i][j] == 1 && (liveCells < 2 || liveCells > 3)){
                    //We change the number to 3 if we want to make a dead cell
                    // this wont affect the rest cells
                    board[i][j] = 3;
                }
                else if(board[i][j] == 0 && liveCells ==3){
                    //We change the number to 2 if we want to make a live cell
                    // this wont affect the rest cells
                    board[i][j] = 2;
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //we reassign the values back to 1 and 0 to get the resultant matrix
                if(board[i][j] == 2){
                    board[i][j] = 1;
                }
                else if(board[i][j] == 3){
                    board[i][j] = 0;
                }
            }
        }
    }
        private int countlives(int[][] board, int i, int j){
            int count = 0;
            //0 , -1 => go to prev column
            //-1, 0 => same column above column
            // 1, 1 => add to row and column
            // -1,-1 => prev row , prev column
            // 1, 0 => next row, same column
            // 0, 1 => same row, next column
            //-1, 1 => prev row, next column (diagonal)
            //1, -1 => next row, prev column (diagonal)
            int[][] dirs = {{0,-1},{-1,0},{1,1},{-1,-1},{1,0},{0,1},{-1,1},{1,-1}};
            for(int[] dir: dirs){
                int r = i + dir[0];
                int c = j + dir[1];
        if(r >= 0 && r<m && c>=0 && c<n && (board[r][c] == 1 || board[r][c]==3)){
                    count++;
                }
            }
            return count;

    }
}