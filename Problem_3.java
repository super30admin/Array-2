// Time Complexity : O(m+n)
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach

//289. Game of Life
class Solution {
    int n, m;
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return;
        m = board.length; //rows
        n = board[0].length; //columns
        
        //1 -> 0 , then replace value with 2
        //0 -> 1 , then replace value with 3
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int count = countLive(board, i, j);
                if(board[i][j] == 1){
                    if(count < 2 || count > 3){
                        board[i][j] = 2;
                    }
                }
                else{
                    if(count == 3){
                        board[i][j] = 3;
                    }
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }
                if(board[i][j] == 3){
                    board[i][j] = 1;
                }
            }
        }
    }
    private int countLive(int[][] board, int r, int c){
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}, {-1,-1}, {-1,1}, {1,-1}, {1,1}};
        int count = 0;
        for(int[] dir : dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nr >= 0 && nc >= 0 && nr < m && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 2)){
                count++;
            }
        }
        return count;
    }
}