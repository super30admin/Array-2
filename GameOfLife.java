// Time Complexity : O(m * n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class GameOfLife {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0){
            return;
        }
        
        int m = board.length;
        int n = board[0].length;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int count = countLives(board, i, j, m, n);
                
                if(board[i][j] == 1 && (count < 2 || count > 3)){
                    board[i][j] = 3;
                }
                
                if(board[i][j] == 0 && count == 3){
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
    
    private int countLives(int[][] board, int i, int j, int m, int n){
        int result = 0;
        int[][] dirs = {{0,1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        
        for(int[] dir : dirs){
            int row = i + dir[0];
            int col = j + dir[1];
            
            if(row >= 0 && row < m && col >= 0 && col < n 
               && (board[row][col] == 1 || board[row][col] == 3)){
                result++;
            }
        }
        
        return result;
    }
}