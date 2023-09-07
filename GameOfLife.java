class Solution {
        int [][] dirs = new int [][] {{0,1},{1,0},{0,-1},{-1,0},{-1,-1},{1,1},{1,-1},{-1,1}};
        private int m;
        private int n;

    public void gameOfLife(int[][] board) {
         m = board.length;
         n = board[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                 int countAlive = countAlive(board, i, j);
                 if(board[i][j] == 0 && countAlive == 3){
                     board[i][j] = 2;
                 }
                 if(board[i][j] == 1 && (countAlive < 2 || countAlive >3)){
                     board[i][j] =3;
                 }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 3){
                    board[i][j] =0;
                }
                if(board[i][j] == 2){
                    board[i][j] = 1;
                }
            }
        }

        
    }

     private int countAlive(int [][] board, int r, int c){
              int count =0;
            for(int [] dir : dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr >=0 && nc >=0 && nr<m && nc<n && (board[nr][nc] == 1 || board[nr][nc] == 3)) count++;
            }
            return count;
        }
   
}



/**
TC : O(m*n) --> Iterating whole matrix 
SC : O(1) --> Not using any Auxilary space and not returning anything


Description : what is the problem if I normally update my input matrix? --> It is going to affect my next numbers. Unable to make a decision, bcz old number is getting updated.

So, using State change concept → Updating 0→ 1 with 2 and 1→0 with 3. 

If we make 1→0 is 3, that means originally 3 is a 1. So we can know the old value here.

Lastly changing to original state and returning → TC : O(m*n), SC : O(1). 

In Coding, Creating a ‘dir’ array (Direction’s array) to check the neighbor element. This function will return the neighbor count. We are using this array in multiple questions. 






 */