class Solution {
    private int die = 2;
    private int live = 3;
    public void gameOfLife(int[][] board) {
        // we only flip the 1 to die and 0 to live
        // so when we find a die around, it must be a previous 1
        // then we can count the 1s without being affected
        int rows = board.length;
        int cols = board[0].length;
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                int around = countLive(i,j,board);
                if (board[i][j] == 0 && around == 3)
                    board[i][j] = live;
                else if (board[i][j] == 1){
                    if (around == 2 || around ==3)
                        continue;
                    if (around < 2 || around > 3)
                        board[i][j] = die;
                }
            }
        }
        
          for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                 if (board[i][j] == die)
                     board[i][j] = 0;
                 if (board[i][j] == live)
                     board[i][j] = 1;
                }
            }
        
    }
    
    private int countLive(int i, int j,int[][] board){
        int count = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
        
        for (int[] dir:dirs){
            int x = i+dir[0];
            int y = j+dir[1];
            
            if (x>=0 && y>=0 && x < board.length && y<board[0].length ){
                
                if (board[x][y] == 1 || board[x][y] == die)
                    count ++;
            }
        }
        
        return count;
        
    }
}
