class Solution {
    int [][]dirs=new int[][]{{0,1},{1,0},{1,1},{-1,0},{0,-1},{-1,-1},{-1,1},{1,-1}};
    public void gameOfLife(int[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                        int countAlive= countAlive(board,i,j);
                        if(board[i][j]==1 &&(countAlive<2||countAlive>3)){
                            board[i][j]=3;
                        }
                         if(board[i][j]==0 &&countAlive==3){
                             board[i][j]=2;
                         }
            }
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                        
                            if(board[i][j]==3) board[i][j]=0;
                            if( board[i][j]==2) board[i][j]=1;
                  }
            }

        }
        private int countAlive(int[][] board,int i,int j){
            int result=0;
            for(int[] dir:dirs){
                int p=i+dir[0];
                int q=j+dir[1];
               if((p>=0&&p<board.length)&&(q>=0&&q<board[0].length) ){
               if(board[p][q]==1||board[p][q]==3)  result++;
               }
            }
            return result;
        }
    }
