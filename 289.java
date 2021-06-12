class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length ==0) return;
        
        int m = board.length;
        int n = board[0].length;
        
        //0->1 2
        //1->0 3
        for(int i=0;i<m;i++){
            for(int j=0; j<n;j++){
                int count = countLives(board,i,j,m,n);
                //1 and 3
                if(board[i][j] == 1 && (count<2 || count > 3)){
                    //alive to dead
                    board[i][j]=3;
                }
                if(board[i][j]==0 && (count==3)){
                    //dead to alive
                    board[i][j]=2;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0; j<n;j++){
                if(board[i][j]==2){
                    board[i][j]=1;
                }
                if(board[i][j]==3){
                    board[i][j]=0;
                }
            }
        }
    }
    
    
    private int countLives(int[][] board, int i, int j, int m, int n){
        int count=0;
          //            r,     ,l   ,b      ,u,   br,  bl,      ur,     ul
        int[][] dirs ={{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}}; 
        for(int[] dir : dirs){
            int r = i + dir[0];
            int c = j+dir[1];
            
            if(r>=0 && r<m && c>=0 && c<n 
               && (board[r][c]==1 || board[r][c]==3)){
                count++;
            }         
        }
        return count;        
    }
    
    
}