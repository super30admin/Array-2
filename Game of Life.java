// Time Complexity : O(N*M)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    private int rows;
    private int cols;
    private int countNeighbours(int[][] board,int i, int j){
        int count = 0;
        int dirs[][] = {{0,1},{1,0},{0,-1},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        for(int[] dir: dirs){
            int ni = i + dir[0];
            int nj = j + dir[1];
            if(ni >= 0 && nj >= 0 && ni < rows && nj < cols && (board[ni][nj] == 1 || board[ni][nj] == 2)){
                count++;
            }
        }
        return count;
    }
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0){
            return;
        }
        // 1 -> 0 = 2
        // 0 -> 1 = 3
        rows = board.length;
        cols = board[0].length;
        for(int i=0 ; i<rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                int liveNeighbours = countNeighbours(board,i,j);
                if(board[i][j] == 1){
                    if(liveNeighbours < 2){
                        board[i][j] = 2;
                    }
                    if(liveNeighbours > 3){
                        board[i][j] = 2;
                    }
                }else{//board[i][j] == 0
                    if(liveNeighbours == 3){
                        board[i][j] = 3;
                    }
                }
            }
            
        }
        
        for(int i=0 ; i<rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }
                if(board[i][j] == 3){
                    board[i][j] = 1;
                }
                
            }
        }
        
        
    }
}
