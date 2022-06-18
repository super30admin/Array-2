public class GameOfLife {
    private int[][] dirArray = {{1,1}, {1,0}, {0,1}, {-1,0}, {0,-1},{-1,-1},{-1,1},{1,-1}};
    // TC is O(m*n)
    // SC is constant
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m;i++){
            for(int j=0; j<n;j++){
                if(board[i][j] == 0 && isDead(board,i,j,m,n) == 3){
                    board[i][j] = 3;
                }else if((board[i][j] == 1) && (isDead(board,i,j,m,n) > 3 || isDead(board,i,j,m,n)<2)){
                    board[i][j] = 2;
                }else {
                    continue;
                }
            }
        }
        for(int i=0; i<m;i++){
            for(int j=0; j<n;j++){
                if(board[i][j] == 3) board[i][j] = 1;
                if(board[i][j] == 2) board[i][j] = 0;
            }
        }
    }
    
    private int isDead(int[][]board,int i,int j,int m,int n){
        int liveCount = 0;
        for(int[] dir: dirArray){
            int r = i+dir[0];
            int c = j+dir[1];
            if(r>=0 && r<m && c>=0 && c<n){
                if(board[r][c] == 1 || board[r][c] == 2){
                    liveCount++;
                }
            }
        }
        return liveCount;
    }
}
