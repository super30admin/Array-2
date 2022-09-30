// Time Complexity :O(M*N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this:No


class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0)
            return;
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int liveNeighbors = countliveNeighbors(board, i, j);
                if(board[i][j] == 0){
                    if(liveNeighbors == 3){
                        board[i][j] = 3;
                    }
                }
                else{
                    if(liveNeighbors < 2 || liveNeighbors > 3){
                        board[i][j] = 2;
                    }
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 2)
                    board[i][j] = 0;
                else if(board[i][j] == 3)
                    board[i][j] = 1;
            }
        }
    }
    
    private int countliveNeighbors(int[][] board, int i, int j){
        int count = 0;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
        for(int[] dir : dirs){
            int nr = i + dir[0];
            int nc = j + dir[1];
            if(nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length && (board[nr][nc] == 1 || board[nr][nc] == 2))
                count++;
        }
        return count;
    }
}
