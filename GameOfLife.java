class Solution {
    public void gameOfLife(int[][] board) {
        // 0 to 1 => 3 // u live when 3 niegh
        // 1 to 0 => 2 // u die for less than 2 neigh
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length; j++){
                int lives = countLives(board,i,j);
                if(board[i][j] == 1){
                   if(lives < 2 || lives >3){
                    board[i][j] = 2;
                   }
                }else if(board[i][j] == 0){
                    if(lives == 3){
                        board[i][j] = 3;
                    }
                }
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }else if(board[i][j] == 3){
                    board[i][j] = 1;
                }
            }
        }
    }
    
    public int countLives(int[][] board,int i,int j){
        int[][] dirs = {{1,0},{0,1},{-1,0},{1,1},{-1,-1},{0,-1},{-1,1},{1,-1}};
        int count_lives = 0;
        for(int[] dir : dirs){
            int r = i+dir[0];
            int c = j+dir[1];
            if(r>=0 && r<board.length && c>=0 && c<board[0].length){
                if(board[r][c] == 1 || board[r][c] == 2){
                    count_lives++;
                }
            }
        }
        return count_lives;
    }
    
    
}