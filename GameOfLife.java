// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class GameOfLife {
    private int m;
    private int n;
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return;
        m = board.length;
        n = board[0].length;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int count = countLives(board, i, j);
                if(board[i][j] == 1 && (count < 2 || count > 3)){
                    board[i][j] = -1;
                }
                if(board[i][j] == 0 && count == 3){
                    board[i][j] = 2;
                }
            }
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == -1){
                    board[i][j] = 0;
                }
                if(board[i][j] == 2){
                    board[i][j] = 1;
                }
            }
        }
    }
    
    private int countLives(int[][] board, int i, int j){
        int count = 0;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        for(int[] dir: directions){
            int r = i + dir[0];
            int c = j + dir[1];
            if(r >= 0 && r < m && c >= 0 && c < n){
                if(board[r][c] == 1 || board[r][c] == -1){
                    count++;
                }
            }
        }
        return count;
    }
}