class Solution {
    public void gameOfLife(int[][] board) {
        int[][] b = new int[board.length][board[0].length];
        int s=0;
          for(int row=0;row<board.length;row++){
          
            for(int col=0;col<board[0].length;col++){

                b[row][col]=board[row][col];
            }
          }

        for(int row=0;row<board.length;row++){
           
            for(int col=0;col<board[0].length;col++){
               s=0;
               if(col-1 >=0)
                s=s+ b[row][col-1]; 
                if(col+1 < board[0].length)
                s=s+ b[row][col+1];
                if(row-1 >=0){
                  s=s+b[row-1][col];
                  if(col-1 >=0)
                   s=s+ b[row-1][col-1]; 
                   if(col+1 < board[0].length)
                   s=s+ b[row-1][col+1];
                }

                if(row+1 < board.length){
                 s=s+b[row+1][col];
                  if(col-1 >=0)
                   s=s+ b[row+1][col-1]; 
                   if(col+1 < board[0].length)
                   s=s+b[row+1][col+1];
                }
            
                if(board[row][col]==1){
                if(s==2 || s==3)
                 board[row][col]= 1;
                 else
                 board[row][col]= 0;
                }else{
                    if(s==3)
                    board[row][col]= 1;
                    else
                    board[row][col]= 0;
                }
            }
            
        }

       
    }
}