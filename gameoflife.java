class Solution {
    public void gameOfLife(int[][] board) {
        int n=board.length;
        int m=board[0].length;
        int [][] dirs= new int[][] {{-1,0},{1,0},{0,-1},{0,1},{-1,1},{-1,-1},{1,1},{1,-1}};

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
                int nb =countalive(board,i,j,dirs);
                if(board[i][j]==1 && (nb<2 ||nb>3)){
                    board[i][j]=2;
                }
                if(board[i][j]==0 && nb==3){
                    board[i][j]=3;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==2) board[i][j]=0;
                if(board[i][j]==3) board[i][j]=1;
            }
        }
    }

    private int countalive(int[][] board, int i, int j, int[][] dirs){
        int count=0;
        for(int[] dir:dirs){
            int r=i+dir[0];
            int c=j+dir[1];
            if(r>=0 && r<board.length && c>=0 && c<board[0].length){
            if(board[i+dir[0]][j+dir[1]]==1 || board[i+dir[0]][j+dir[1]]==2) count++;}
        }
        return count;
    }


}
