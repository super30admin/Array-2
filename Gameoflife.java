//TC On
//Sc O1

public class Gameoflife {
    public static void main(String[] args) {
      int[][] board=  new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
       // int[][] re = gameOfLife(board);

    }

    public static void gameOfLife(int[][] board) {
        int r=board.length;
        int c=board[0].length;

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
              int count=  countAlive(board,i,j);
              //if board[i][j]==1
                if((board[i][j]==1 && count<2) || (board[i][j]==1 && count > 3)){
                    board[i][j]=2;

                }
               else if(board[i][j]==0 && count==3){
                   board[i][j]=3;
                }
            }
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
            if(board[i][j]==2){
                board[i][j]=0;
            }  else  if(board[i][j]==3){
                board[i][j]=1;
            }

            }}
//return board;
    }

    private static int countAlive(int[][] board, int i, int j) {
        int dirs[][]=new int[][]{{0,-1},{0,1},{-1,0},{1,0},{-1,-1},{-1,1},{1,1},{1,-1}};
        int c=0;
        for(int dir[]:dirs){
            int nr=i+dir[0];
            int nc=j+dir[1];
            if(nr>=0 && nr<board.length &&
            nc>=0 && nc<board[0].length){
                if(board[nr][nc]==2 || board[nr][nc]==1){
                    c++;
                }
            }

        }return c;
    }
}
