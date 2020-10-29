// Time Complexity : O(M*N)
// Space Complexity : O(1) - No auxillary space
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return;
        int[][] dir={{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};//directions 8
        int n = board.length;
        int m = board[0].length;
        
        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                int live = 0;
                for(int[] d: dir){
                
                    if(i + d[0] < 0 || i + d[0] == n || j + d[1] < 0 || j + d[1] == m ){
                        continue;
                    }
                    if(board[i + d[0]][j + d[1]] == 1 || board[ i + d[0]][ j + d[1]] == 2){ //comparing 2 as well since modifying board to mark 0's
                        live++;
                    }
                }
                
                if(board[i][j] == 1 && (live > 3 || live < 2)){
                    board[i][j] = 2;
                }
                if(board[i][j] == 0 && live == 3){
                    board[i][j] = 3;
                }
                
            }
        }
        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                board[i][j] %= 2; 
            }
        }
        
    }
}