// TC - O(m*n)
//SC - O(1)

class Solution {
    public void gameOfLife(int[][] board) {
        
        int m = board.length;
        int n = board[0].length;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                
                int neighbor = countLive(board,i,j,m,n);
                
                if(board[i][j] == 0 && neighbor == 3){
                    board[i][j] = 2;
                }
                else if ((neighbor<2 || neighbor > 3) && board[i][j]==1){
                    board[i][j] = 3;
                }
                   
        }
    }
    
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==3){
                    board[i][j] = 0;
                }
                else if (board[i][j]==2){
                    board[i][j] = 1;
                }
            }
        }
}
                   
                   
          public int countLive(int[][]board,int i,int j,int m,int n){
              int count = 0;
              int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
              for(int[] dir: dirs){
                  int nr = i + dir[0];
                  int nc = j + dir[1];
              
             if(nr>=0 && nc>=0 && nr<m && nc<n && (board[nr][nc]==1 || board[nr][nc]==3)){
                 count++;
             }  
          }   
              return count;
          }   
                   
                   
                   
                   }