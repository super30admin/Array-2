//TimeComplexity O(mn)
//Space Complexity O(1)

class GameofLife {
    int[][] dirs;
    int m; int n;
   public void gameOfLife(int[][] board) {
       if(board == null) return;
       m = board.length;
       n= board[0].length;
       //1-0 -->2
       //0--1-->3
      dirs = new int[][] {{0,1},{0,-1},{-1,0},{1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
       for(int i =0; i<m;i++){
           for (int j =0; j<n;j++){
               int countAlive = countAlive(board,i,j);
               //rule 1,3
               if(board[i][j] ==1  && (countAlive <2 || countAlive >3)){
                   board[i][j]=2;  
               }
               //rule 4
               if(board[i][j] ==0 && countAlive == 3){
                   board[i][j] = 3;
                   
               }
           }
       }
       for(int i=0; i<m;i++){
           for(int j =0;j<n;j++){
               if(board[i][j]==2) board[i][j] = 0;
               if(board[i][j] ==3) board[i][j] =1;
           }
       }    
   }
   
   private int countAlive (int[][] board, int i , int j){
       int result =0;
       for(int[] dir: dirs){
           int r = i+dir[0];
           int c = j+dir[1];
           if(r>=0 && c>=0 && r<m && c<n &&
             (board[r][c] ==1 || board[r][c] ==2)){
               result++;
           }
       }
       return result;
   }
}