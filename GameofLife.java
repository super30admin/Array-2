// Time Complexity : O(MN)
// Space Complexity : O(MN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0){
            return;
        }
        
        int m = board.length, n = board[0].length;
        
        //live -> <2, >3 implies dead
        //live == 2,3, continue live
        //dead with 3 live, relives
        
        //if alive cell dies then we mark it as 3
        //if dead cell relives then we mark as 2
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //count live neighbors
                int count = countLiveNeighbors(board, i, j, m, n);
                
                if(board[i][j] == 1 && (count < 2 || count > 3)){
                    board[i][j] = 3; //alive cell dies
                }
                
                if(board[i][j] == 0 && count == 3){
                    board[i][j] = 2; //dead cell relives
                }
            }
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 3){
                    board[i][j] = 0;
                }
                else if(board[i][j] == 2){
                    board[i][j] = 1;
                }
            }
        }
    }
    
    private int countLiveNeighbors(int[][] board, int i, int j, int m, int n){
        int result = 0;
        int[][] dirs = new int[][]{{-1, -1}, {-1, 1}, {1, 1}, {1, -1}, {0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for(int[] dir: dirs){
            int r = i + dir[0]; //i - 1, i - 1, i + 1, 
            int c = j + dir[1]; //j - 1, j + 1, 
            
            if(r >= 0 && r < m && c >= 0 && c < n){
                if(board[r][c] == 1 || board[r][c] == 3){
                    result++; //counting live neighbors
                }
            }
        }
        return result;
    }
}








