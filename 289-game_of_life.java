//Overall Time Complexity: O(M*N)
//Overall Space Complexity: O(1)
class Solution {
    private int[][] dirs = new int[][]{{0, 1},{1, 0},{0, -1},{-1, 0},{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    private int m,n;
    
    //Void return type and hence we will have to work with the given matrix and no auxillary space needed
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return;    
        
        m = board.length;
        n = board[0].length;
        
        //Going through all the elements in the matrix
        for(int i = 0; i < m; i++){
            for(int j = 0 ; j < n; j++){
                int aliveNeighbors = countAlive(board, i, j);
                if((board[i][j] == 1) && (aliveNeighbors < 2 || aliveNeighbors > 3)){
                    board[i][j] = 3;
                }
                if((board[i][j] == 0) && (aliveNeighbors == 3)){
                    board[i][j] = 2;
                }
            }
        }
        
        for(int i = 0; i < m ; i++){
            for(int j = 0 ; j < n; j++){
                if(board[i][j] == 2){
                    board[i][j] = 1;
                }else if(board[i][j] == 3){
                    board[i][j] = 0;
                }
            }
        }
    }
    
    private int countAlive(int[][] board, int i, int j){
        int count = 0;
        for(int[] dir: dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            
            if(r >= 0 && r < m && c >= 0 && c < n && (board[r][c] == 1 || board[r][c] == 3 )){
                count++;
            }
        }
        
        return count;
    }
}