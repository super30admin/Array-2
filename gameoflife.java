// Time Complexity : O(m*n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length , n = board[0].length;
            //0  --> 1 -- 2
            //1 --> 0 -- 3
         for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int liveCount = countNeighbours(board, i, j, m, n);
                if(board[i][j] == 1 && (liveCount < 2 || liveCount > 3)){
                    board[i][j] = 3;
                }
                if(board[i][j] == 0 && liveCount == 3){
                    board[i][j] = 2;
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 2){
                    board[i][j] = 1;
                }
                if(board[i][j] == 3){
                    board[i][j] = 0;
                }
            }
        }
    }
    private int countNeighbours(int[][] board, int i, int j, int m, int n){
        int [][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}, {1,1}, {1,-1}, {-1, 1}, {-1, -1}};
        int count = 0;
        for(int k=0; k<dirs.length; k++){
            int r = i + dirs[k][0];
            int c = j + dirs[k][1];
            if(r >= 0 && r<m && c>=0 && c<n && (board[r][c] == 1 || board[r][c] == 3)){
                count =count + 1;
				}
        }
        return count;
    }
}
    