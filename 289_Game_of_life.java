class Solution {
    int m;
    int n;
    public void gameOfLife(int[][] board) {
        if(board==null || board.length==0)
            return;
        
        m = board.length;
        n = board[0].length;
        int count = 0;
       // 0-> 1 =====> 2
        // 1->0 ======> 3
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                count = countLives(board, i, j);
                
                if(board[i][j]==1 && (count>3 || count<2)){
                    board[i][j] = 3;
                }
                else if(board[i][j] == 0 && (count==3)){
                    board[i][j] = 2;
                }
            }
        }
        
         for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]==2){
                    board[i][j]=1;
                }
                else if(board[i][j]==3)
                {
                    board[i][j] = 0;
                }
            }
        }
    }
    
    private int countLives(int[][] board, int i, int j){
        int[][] dirs = {{-1,-1}, {-1,1}, {0,1}, {1,0}, {-1,0}, {0,-1}, {1,1}, {1,-1}};
        
        int x =0, y= 0;
        int count = 0;
        
        for(int[] dir: dirs){
            x = i+dir[0];
            y = j+dir[1];
            if(x<m && y <n && x>=0 && y>=0 && (board[x][y]==1 || board[x][y]==3)){
                count++;
            } 
        }
        return count;
    }
}

// TC => O(m*n)
//SC => O(1)
