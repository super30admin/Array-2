class Solution {
    public void gameOfLife(int[][] board) {
        int m=board.length;
        int n=board[0].length;

        //first pass
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int count = countAlive(board, i ,j);
                //1-->0 maps to 2
                if(board[i][j]==1 && (count<2 || count>3)){
                    board[i][j]=2;
                }
                //0-->1 maps to 3
                if(board[i][j]==0 && count==3 ){
                    board[i][j]=3;
                }
            }
        }
        //second pass
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //2 maps backs to 0
                if(board[i][j]==2){
                board[i][j]=0;
                }
                //3 maps back to 1
                if(board[i][j]==3){
                    board[i][j]=1;
                }
            }
        }
    }

    private int countAlive(int[][] board, int i, int j){
        int count=0;               // up  down  right  left   
        int dirs[][]= new int [][] {{0,1},{0,-1},{1,0},{-1,0},{-1,1},{1,1},{-1,-1},{1,-1}};

        for(int[] dir: dirs){
            //nr= nieghbouring row , nc=nieghbouring column
            int nr=i+dir[0];
            int nc=j+dir[1];
            if(nr>=0 && nc>=0 && nr<board.length && nc<board[0].length &&
            (board[nr][nc]==1 || board[nr][nc]==2)){
                count++;
            }
        }
        return count;
    }
}