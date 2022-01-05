// Time Complexity : o(m*n)
// Space Complexity : o(m*n) constant space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none


// Your code here along with comments explaining your approach

class Solution {
    public void gameOfLife(int[][] board) {
        
        int row = board.length;
        int col = board[0].length;
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                int num = numOflive(board,i,j);
                
                if (board[i][j] >= 1){
                    if (num < 2 || num > 3) {
                        board[i][j] = 2;
                    }
                }
                else{
                    if (num == 3) {
                        board[i][j] = -1;
                    }
                }
                
            }
        }
        
         for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                }
                else if (board[i][j] == -1) {
                    board[i][j] = 1;
                }
                
            }
         }
        
    }
    
    public int numOflive(int[][] board, int x, int y){
        
        int count = 0;
        for(int i= x-1; i< x+2; i++){
            for(int j= y-1; j<y+2; j++){
                
                if(!(i == x && j == y) && isLive(board,i,j))
                    count++;   
            }
        }
        return count;
        
    }
    
    
    public boolean isLive(int[][] board, int i, int j){
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        if (board[i][j] >= 1) {
            return true;
        }
        return false;
    }
    
    
}