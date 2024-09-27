// Time Complexity : O(M*N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : after class solution


// Your code here along with comments explaining your approach
//The idea is to use the rules of the game to change state.
//We use constant variable to mark change of state.

class Solution {

    public void gameOfLife(int[][] board) {
        
        int[] dx = {-1, -1, -1,  0, 0,  1, 1, 1};
        int[] dy = {-1,  0,  1, -1, 1, -1, 0, 1};
        
        if(board == null || board.length == 0) return;
        
        int m = board.length;
        int n = board[0].length;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                
                int count = findNeighbours(board, i, j, dx, dy);
                
                //if live
                if(board[i][j] == 1){
                    if(count < 2 || count > 3){
                        board[i][j] = -1; // mark change of state
                    }
                }
                //if dead
                if(board[i][j] == 0){
                    if(count == 3){
                        board[i][j] = 2; // mark change of state
                    }
                }
                
            }
        }
        //changing values back to actual NEW state
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 2){
                    board[i][j] = 1;
                }
                
                if(board[i][j] == -1){
                    board[i][j] = 0;
                }
            }
        }
        
        
        return;
    }
    
    private int findNeighbours(int[][] board, int i, int j, int[] dx, int[] dy){
        int count = 0;
        int current = board[i][j];
        int row = board.length;
        int col = board[0].length;
        
        for(int k=0; k<8; k++){
            int x = i + dx[k];
            int y = j + dy[k];
            
            if(isValid(row, col, x, y) && (board[x][y] == 1 || board[x][y] == -1)){
                count++;
            }
        }
       return count; 
    }
    
    
    private boolean isValid(int row, int col, int x, int y){
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}