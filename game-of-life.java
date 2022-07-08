//time complexity: O(m*n)
//space complexity: O(1)
//Did it run successfully on leetcode: YES
class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) {
            return;
        }
        
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int countLiveNeighbors = countLiveNeighbors(board, i, j);
                
                if(board[i][j] == 0) {
                    if(countLiveNeighbors == 3) {
                        board[i][j] = 2;
                    }
                }
                else {
                    //fewer than 2 live neighbors
                    if(countLiveNeighbors < 2) {
                        board[i][j] = 3;
                    }
                    //more than 3 live neighbors
                    if(countLiveNeighbors > 3) {
                        board[i][j] = 3;
                    }
                }
                
            }
        }
        
        for(int i=0; i< m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 2) {
                    board[i][j] = 1;
                }else if(board[i][j] == 3) {
                    board[i][j] = 0;
                }
            }
        }
    }
    
    private int countLiveNeighbors(int[][] board, int row, int col){
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}, {-1,-1}, {1,1}, {-1,1}, {1,-1}};
        int count = 0;
        int m = board.length;
        int n = board[0].length;
        
        for(int[] dir: dirs){
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && (board[newRow][newCol] == 1 || board[newRow][newCol] == 3)){
                count ++;
            }
        }
       return count; 
    }
}