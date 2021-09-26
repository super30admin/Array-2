// Time Complexity : O(m*n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// use direction array to go to the neightbours and check for the values
// Your code here along with comments explaining your approach
class Solution {
    public void gameOfLife(int[][] board) {
        // null
        if( board == null || board.length == 0 || board[0].length == 0) return;
        int m = board.length;
        int n = board[0].length;
        for( int i = 0; i < m ; i++){
            for( int j = 0; j < n ; j++){
                int count = countNeighbours(board, i,j,m,n);
                if( board[i][j] == 1 && ( count < 2 || count > 3)){
                    board[i][j] = 3;
                }
                if( board[i][j] == 0 && count == 3){
                    board[i][j] = 2;
                }
            }
        }
        for(int i=0;i<m; i++){
            for(int j=0;j<n; j++){
                if( board[i][j] == 2 ) board[i][j] = 1;
                if( board[i][j] == 3 ) board[i][j] = 0;
            }
        }
    }
    private int countNeighbours(int[][] board, int i, int j, int m, int n){
        int result = 0;
        int [][] dirs = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
        for(int [] dir : dirs){
            int nr = i + dir[0];
            int nc = j + dir[1];
            if( nr >= 0 && nr < m && nc >= 0 && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 3)) result ++;
        }
        return result;
    }
}