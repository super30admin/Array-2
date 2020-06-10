// Time complexity - O(mn)
// Space complexity - O(1)

// Replace board value if 0 -> 1 with 2 and 1 -> 0 with 3.

class Solution {
    int m, n;
    public void gameOfLife(int[][] board) {
        //  0 -> 1 = 2
        // 1 -> 0 = 3
        if(board == null || board.length == 0){
            return;
        }
        m = board.length;
        n = board[0].length;
        for(int  i = 0 ; i < m; i++){
            for(int j = 0 ; j< n; j++){
                int lives = countLives(board,i,j);
                if(board[i][j] == 1){
                    if(lives > 3 || lives < 2){
                        board[i][j] = 3;
                    }
                }else{
                    if(lives == 3){
                        board[i][j] = 2;
                    }
                }
            }
        }
          for(int  i = 0 ; i < m; i++){
            for(int j = 0 ; j< n; j++){
                if(board[i][j] == 3) board[i][j] = 0;
                if(board[i][j] == 2) board[i][j] = 1;
            }
          }
    }
    
    private int countLives(int[][] board, int i, int j){
        int count  = 0;
        int[][] dirs={{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
        for(int []dir : dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            
            if(r >= 0 && c >= 0 && r<m && c<n  && (board[r][c] == 1 || board[r][c] == 3)){
                count++;
            }
        }
    return count;
    }
}
