class Solution {
    int[]rows= {-1,-1,-1,0,0,1,1,1};
    int[]cols= {1,0,-1,-1,1,-1,0,1};
    
    public void gameOfLife(int[][] board) {
        
        
        int[][]res = new int[board.length][board[0].length];
        
        int m =board.length;
        int n = board[0].length;
            
        for(int i =0; i < m;i++){
            for(int j=0;j<n;j++){
                
                int neighborDead =0;
                int neighborAlive = 0;
                
                calcNeighbors(board,neighborDead,neighborAlive, i,  j);
                
                    
                    //here are the 4 game conditions 
                    //case1: Any live cell with fewer than two live neighbors dies as if caused by under-population.
                    if(board[i][j] == 1 && neighborAlive < 2){
                        res[i][j] = 0;
                    }
                    //case2: Any live cell with two or three live neighbors lives on to the next generation.
                    if(board[i][j] == 1 && neighborAlive >= 2){
                        res[i][j] = 1;
                    }
                    //case3: Any live cell with more than three live neighbors dies, as if by over-population.
                    if(board[i][j] == 1 && neighborAlive > 3){
                         res[i][j] = 0;
                    }
                    //case4: Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
                    if(board[i][j] == 0 && neighborAlive == 3){
                        res[i][j]= 1;
                    }
                
                
            }
        }
        
        for(int i =0 ;i < m;i++){
            for(int j =0;j< n;j++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
        for(int i =0 ;i < m;i++){
            for(int j =0;j< n;j++){
                board[i][j]=res[i][j];
            }
        }
        
    }
    
    private boolean isSafe(int[][]board,int r,int c)
    {
        int m =board.length;
        int n = board[0].length;
        if(r < 0 || r >= m || c < 0 || c >= n){
            return false;
        }
        return true;
    }
    
    private void calcNeighbors(int[][]board,int neighborDead,int neighborAlive,int i, int j)
    { 
        for(int k = 0; k < 7;k++){
                    int nr = i+rows[k];
                    int nc = j+cols[k];
                        
                    if(isSafe(board,nr,nc)){
                        if(board[nr][nc] == 1){
                            neighborAlive++;
                        }else{
                            neighborDead++;
                        }
                    }
                }
        
    }
}
