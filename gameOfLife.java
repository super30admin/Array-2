class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return ;
        int m = board.length;
        int n = board[0].length;
        
        //1--->0 -- 3
        //0--->1 -- 2   
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int Alives = directionArray(board, i, j, m, n);
                if(board[i][j] == 1 && (Alives < 2 || Alives > 3)){ //if element at board[i][j] is 1
                    board[i][j] = 3;
                }
                if(board[i][j] == 0 && Alives == 3){ //if element at board[i][j] is 0
                    board[i][j] = 2;
                }    
            }
        }
        
        for(int i = 0; i < m; i++){  // maintaining the orignal state of the array
            for(int j = 0; j < n; j++){
                if(board[i][j] == 3){
                    board[i][j] = 0;
                }
                if(board[i][j] == 2){
                    board[i][j] = 1;
                    
                }
            }
        }
    }
  
    // taking direction array to get the number of living elements around it 
    private int directionArray(int[][]board, int i, int j, int m, int n){
        int result = 0;
                            // right   left   down   up.     dr     dl.     ur.    dl
        int [][] directions = {{0, 1}, {0,-1},{1,0}, {-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        
        for(int [] d : directions){
            int r = i + d[0];
            int c = j + d[1];
            if(r >= 0 && r < m && c >= 0 && c < n && (board[r][c] == 1 || board[r][c] == 3)){
                result++;
            }
        }
        return result;
    
    }
}
