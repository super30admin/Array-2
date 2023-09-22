// Time Complexity : O(mxn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
/*
 * Count the Live Neighbors based on the given conditions
 * Every time conditions are met change the values to temporarily different variables
 * Maintain the dirs to check the 8 directions 
 */
class Solution {
    int m=0,n=0;
    public void gameOfLife(int[][] board) {
        if(board== null || board.length == 0)
            return;
        m = board.length;
        n = board[0].length;
        for(int i=0; i<m;i++){
            for(int j=0; j<n;j++){
                int countLN = countLN(board, i, j);
                if(board[i][j]==1){
                    if(countLN < 2 || countLN > 3)
                        board[i][j] = 2;
                }
                else if(board[i][j]==0){
                    if(countLN == 3)
                        board[i][j] = 3;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] ==2){
                    board[i][j]=0;
                }
                else if(board[i][j] ==3){
                    board[i][j]=1;
                }
            }
        }
        
    }
    int countLN(int[][] board, int row, int col){
        int count = 0;
        int[][] dirs ={{-1,0}, {1,0}, {0,-1}, {0,1}, {-1,-1}, {-1,1}, {1,-1}, {1,1}};
        for(int[] dir : dirs){
            int nr = row +dir[0];
            int nc = col +dir[1];
            if(nr>=0 && nr<m && nc>=0 && nc<n &&(board[nr][nc] == 1 || board[nr][nc] == 2))
                count++;
        }
        return count;
    }
}