/*
Time Complexity - O(m+n) - m is number of rows and n is  number of columns
Space Complexity - O(1)
*/

class Solution {  
    public void gameOfLife(int[][] board) {

        int m = board.length;
        int n = board[0].length;
        int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,-1},{-1,1}};
        if(board==null ||  board.length ==0) return;       
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int alive = countAlive(board,i,j,dir,m,n);
                if((board[i][j] == 1 && alive<2) ||  (board[i][j] == 1 && alive>3)){
                    board[i][j] = 3;
                }
                if(board[i][j] == 0 && alive == 3){
                    board[i][j] = 2;
                }
            }
        }
        
          for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 2){
                    board[i][j] = 1;
                }
                if(board[i][j] == 3){
                    board[i][j] = 0;
                }
            }
          }
        
        
    }
    
    private int countAlive(int[][] board, int i, int j, int[][] dir,int m,int n){
        int result =0;
        for(int[] direction : dir){
            int nr = i + direction[0];
            int nc = j + direction[1];
            if(nr>=0 && nc>=0 && nr<m && nc<n)
            {
                if(board[nr][nc]==1 || board[nr][nc]==3){
                    result++;
                }
            }
        }
        return result;
    }
}
