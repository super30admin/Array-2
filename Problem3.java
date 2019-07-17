class Solution {
    public void gameOfLife(int[][] board) {
        
        // if originially dead, now live ==> 2
        // if originally live, now dead ==> -1
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int liveCount = liveCount(board, i, j);
                // rule 1 and rule 3
                if(board[i][j] == 1 && (liveCount < 2 || liveCount > 3 )){
                    board[i][j] = -1;
                }
                
                // rule 4
                if(board[i][j] == 0 && liveCount == 3){
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
    
    public int liveCount(int[][] board, int i, int j){
        int m = board.length;
        int n = board[0].length;
        int result = 0;
        //top
        if(i > 0){
            if(board[i-1][j] == 1 || board[i-1][j] == -1){
            result++;
            }    
        }
        // left
        if(j > 0){
            if(board[i][j-1] == 1 || board[i][j-1] == -1){
                result++;
            }    
        }
        // right
        if(j < n-1){
            if(board[i][j+1] == 1 || board[i][j+1] == -1){
                result++;
            }      
        } 
        // bottom
        if(i < m-1){
            if(board[i+1][j] == 1 || board[i+1][j] == -1){
                result++;
            }    
        }
        // diagonal up left
        if( i > 0 && j > 0){
            if(board[i-1][j-1] == 1 || board[i-1][j-1] == -1){
                result++;
            }    
        }
        // diagonal up right
        if( i > 0 && j < n-1){
            if(board[i-1][j+1] == 1 || board[i-1][j+1] == -1){
                result++;
            }    
        }
        // diagonal down left
        if( i < m-1 && j > 0){
            if(board[i+1][j-1] == 1 || board[i+1][j-1] == -1){
                result++;
            }    
        }
        // diagonal down right
        if( i < m-1 && j < n-1){
            if(board[i+1][j+1] == 1 || board[i+1][j+1] == -1){
                result++;
            }    
        }
        return result;
    }
}