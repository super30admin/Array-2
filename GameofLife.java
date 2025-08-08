class Solution {
    //Idea is to traverse each cell in the matrix and look at all of its neighbours to check for alive and dead cells
    //and based on the number of alive / dead cells surrounding the cell,  make a decision
    //To optimize on space and avoid wrong updates , we mark cells as 2 - previously 1 , now 0 
    //and 3 - previously 0, now 1  and process matrix once again. 

    // Time Complexity : O(m*n)
    // Space Complexity: O(m*n)

    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
      //00 - previous 0 , present 0
      //01 - previous 1 , present 1
      //10 - previous 1 , present 0
      //11 - previous 0 , present 1 
       for(int i=0;i<board.length;i++)
       {
           for(int j=0;j<board[0].length;j++)
           {   
    int sum=calculate(i-1,j-1,board,rows,cols)+calculate(i-1,j,board,rows,cols)+calculate(i-1,j+1,board,rows,cols)+calculate(i,j-1,board,rows,cols)+calculate(i,j+1,board,rows,cols)+calculate(i+1,j-1,board,rows,cols)+calculate(i+1,j,board,rows,cols)+calculate(i+1,j+1,board,rows,cols);
               if(board[i][j]==1)
               {
                   if(sum<2)
                   {  
                       board[i][j] = 2;
                   }
                   else if(sum>3)
                   {
                       board[i][j] = 2;
                   }
                   else{
                       
                     
                       board[i][j] = 1;
                   }
               }
               if(board[i][j]==0)
               {
                   if(sum==3){
                       board[i][j] = 3;
                   }
                   else{
                       board[i][j]= 0;
                   }
               }
           }
       }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]==2){
                    board[i][j] = 0;
                }
                if(board[i][j]==3){
                    board[i][j] = 1;
                }
               
            }
                
        }
    }
    public int calculate(int row, int col, int[][] board,int rows,int cols){
      
        if(row<0||col<0||row>rows-1||col>cols-1){
            
            return 0;
        }
        else{
           
            if(board[row][col]==0||board[row][col]==3){
               
                return 0;
            }
            else{
                return 1;
            }
        }
           
    }
}
