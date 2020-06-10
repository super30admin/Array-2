/*
Time Complexity : O(M*N)
Space Complexity :O(1)
is worked on leetcode : YES
difficulty : finding out inplace array modification solution
*/

class LifeGame {
    public void gameOfLife(int[][] board) {
        if (board == null   || board.length == 0 ) return;
        
        int M = board.length;
        int N = board[0].length;
        
        // 1 -> 0 : 3
        // 0 -> 1 : 5
        
        for(int i=0;i< M; i++){
            for(int j=0;j<N;j++){
//                 get lives after for this cell
                int lives = countLives(board, i, j);
                // if cell is alive initially
                if(board[i][j] == 1 ){
                    if (lives < 2 || lives > 3){
                        board[i][j] = 3;
                    }
                }else{ // if cell is dead initially
                    if (lives == 3){
                        board[i][j] = 5;
                    }
                }
            }
        }
        
//         change to original 
        
        for(int i=0;i< M;i++){
            for(int j=0;j<N;j++){
                if(board[i][j] == 3){
                    board[i][j] = 0;
                }
                if(board [i][j] == 5){
                    board[i][j] = 1;
                }
            }
        }
    
    }
    
    private int countLives(int[][] board, int i, int j){
        int count = 0;
        int m = board.length;
        int n = board[0].length;
        int[][] dirs = {{0,1},{0,-1},{-1,0},{-1,-1},{1,0},{-1,1},{1,1},{1,-1}};
        for(int [] dir : dirs){
            int row = i + dir[0];
            int col = j +  dir[1];
            if(row >= 0  && col >= 0 && row < m && col< n &&( board[row][col] == 1 || board[row][col] == 3)) count++;
        }
        return  count;
    }
}