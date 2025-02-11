class Solution {
    public void gameOfLife(int[][] board) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int lives=countLives(board,i,j,m,n);
                if(board[i][j]==1 &&(lives<2 || lives>3)){
                    board[i][j]=2;
                }
                if(board[i][j]==0 &&(lives==3)){
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
    private int countLives(int[][] board, int i, int j, int m, int n){
        int[][] dirs=new int[][]{{0,1},{0,-1},{-1,0},{1,0},{-1,1},{-1,-1},{1,1},{1,-1}};
        int count=0;
        for(int[] dir:dirs){
            int nr=i+dir[0];
            int nc = j+dir[1];
            if(nr>=0 && nr<m && nc>=0 && nc<n && (board[nr][nc]==1 ||
                    board[nr][nc]==2)){
                count++;
            }
        }
        return count;
    }
}