class GameOfLife {
    int dirs[][]= new int[][]{{0,1}, {1,0}, {-1,1},{1,-1},{1,1},{-1,-1},{-1,0},{0,-1}};
    public void gameOfLife(int[][] board) {
        // 0->1 -> 3
        // 1-> 0 -> 2
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int count = countNumberOfAliveCells(board,i,j);
                if(board[i][j]==1 && (count<2 || count>3)){
                    board[i][j]=2;
                }
                if(board[i][j]==0 && count == 3){
                    board[i][j]=3;
                }
            }
        }
         for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==2){
                    board[i][j]=0;
                
                }
                if(board[i][j]==3){
                    board[i][j]=1;
                }
            }
         }
         
    }
    private int countNumberOfAliveCells(int[][] board, int i, int j){
        int count = 0;
        for(int[] dir: dirs){
            int nr = i+dir[0];
            int nc = j+dir[1];
            if(nr<board.length && nc<board[0].length && nc>=0 && nr>=0){
                if(board[nr][nc]==1 || board[nr][nc]==2){
                    count++;
                }
            }
        }
        return count;
    }
}