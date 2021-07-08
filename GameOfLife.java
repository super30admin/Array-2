//Time Complexity = O(m*n)
//Space Complexity =O(1)
//Did you run it on leet code :yes

class Solution {
    public void gameOfLife(int[][] board) {
        
        if( board == null || board.length == 0)
            return;
        
        int m = board.length;
        int n = board[0].length;
        
        
        for(int i = 0 ; i < m ; i++ ){
            for(int j = 0; j < n ; j++){
                int lives = countLives(board,i,j);
                if(board[i][j] == 1 || board[i][j] == 2){
                    if(lives < 2 || lives > 3){
                        board[i][j] = -1;
                    }  
                }
                else{
                  if(lives == 3)
                      board[i][j] = 2;   
                }
            }
        }
        
        for(int i = 0; i < m ; i++ ){
           for(int j = 0 ;j < n; j++){
           if(board[i][j] == -1)
               board[i][j] = 0;
          else if(board[i][j] == 2)
              board[i][j] = 1;
        }                    
      }
        
    }
    
    
    private int countLives(int[][] board,int i,int j){
        
        int m = board.length;
        int n = board[0].length;
        
        int[][] dirs = new int[][]{ {0,1} ,{0,-1},{1,0},{-1,0},{-1,1},{-1,-1},{1,1},{1,-1}};
        
        int count = 0;
        for(int[] dir : dirs){
            int r = dir[0];
            int c = dir[1];
            if((i + r >= 0 && i + r <= m-1) && ((j + c) >= 0 && (j + c <= n-1)))
            {
                if(board[i + r][c + j] == 1 || board[i + r][c + j] == -1) 
                    count++;   
            }   
        }
        return count;
    }
}