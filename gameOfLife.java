class Solution {
    public void gameOfLife(int[][] board) {
        
        int n=board.length;
        int m=board[0].length;
        //2 is dead, 3 is live
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int res = checkN(board,i,j,n,m);
                if(board[i][j]==0 && res == 3){
                    board[i][j]=3;                    
                }
                else if(board[i][j]==1 && (res<2 || res >3)){
                        board[i][j]=2;                    
                }


            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==2){
                    board[i][j]=0;
                }
                else if(board[i][j]==3){
                    board[i][j]=1;
                }
            }
        }
        
        
        
        
    }
    
    private int checkN(int[][] board,int r, int c,int n, int m){
        int [][] boards = {{ -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };
        int count=0;
        for(int [] in : boards){
            int rr = r + in[0];
            int cc = c + in[1];
            
            if(rr>=0 && rr<n  && cc>=0 && cc<m && (board[rr][cc]==1 || board[rr][cc] == 2)){
                count++;
            }
        }
               
               return count;
    }
}