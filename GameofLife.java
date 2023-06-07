// Time Complexity o(m*n) Space complexity o(1);  
class Solution {
    public void gameOfLife(int[][] board) {
        int[][] dir = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
        int r = board.length;
        int c = board[0].length;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                int count = neighbors(board,dir,r,c,i,j);
                if(board[i][j]==1 && (count<2 || count>3)) board[i][j] =2;
                if(board[i][j]==0 && (count==3)) board[i][j] =3;

            }
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j]==2) board[i][j]=0;
                if(board[i][j]==3) board[i][j]=1;
            }
        }

    }
    public int neighbors(int[][] board,int[][] dir, int r,int c,int i,int j){
        int count=0;
        for(int[] d: dir){
            int rn = i + d[0];
            int cn = j + d[1];

            if(rn>=0 && rn<r && cn>=0 && cn<c && (board[rn][cn] == 1 || board[rn][cn]==2)){
                count++;
            }
        }
        return count;
    }
}
