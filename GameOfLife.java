// Time Complexity : O(MxN)M=number of rows and N=number of columns in  the matrix. 
// Space Complexity : O(1) no extra space used.
// Did this code successfully run on Leetcode :yes. 

// Any problem you faced while coding this :


// we traverse the matrix and check the 8 neighbords and check the cases. When we see we need to change the cel to dead or live, we cannot 
//override the value because it will affect the next calculation so we need a value that allow us understand that the value will change, but
// we can use it for future calculation without lossing previous value. First iteration allow us to modify the matrix so that we have the 
// values we will use  to calculate next cells without lossing the correct meaning the current column, in a second iteration we will 
// check the values and convert to correct value of dead and live.
// possitive.
//Success
//Details 
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Game of Life.
//Memory Usage: 38.1 MB, less than 7.69% of Java online submissions for Game of Life.
  public void gameOfLife(int[][] board) {
        //edge case
        if (board==null|| board.length==0)
            return;
        
        //1 first traversal change live to 5(DEAD) and dead to 3(life) when applicable.
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                int countNeighbors=countLives( board,  i,  j);
                if (board[i][j]==1 && (countNeighbors<2 || countNeighbors>3)){
                    board[i][j]=5;
                }else if (board[i][j]==0 && countNeighbors==3)
                    board[i][j]=3;
            }
        }
        //second traversal change 5 to 0 and 3 to 1;
         for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
               if (board[i][j]==3)
                   board[i][j]=1;
                else if (board[i][j]==5)
                    board[i][j]=0;
                    
            }
         }
        
    }
    
    
   private int countLives(int[][] board, int i, int j){
       int count=0;
       if (j>0 && (board[i][j-1]==1||board[i][j-1]==5))//<-
           count++;
       if (j<board[0].length-1 && (board[i][j+1]==1||board[i][j+1]==5))//-->
           count++;
       if (i>0 && (board[i-1][j]==1||board[i-1][j]==5))// up
           count++;
       if (i<board.length-1 && (board[i+1][j]==1|| board[i+1][j]==5))//down
           count++;
       if (i>0 && j>0 && (board[i-1][j-1]==1 || board[i-1][j-1]==5))
           count++;
       if (j<board[0].length-1 && i>0 && (board[i-1][j+1]==1 || board[i-1][j+1]==5 ))
           count++;
       if (i<board.length-1 && j>0 && (board[i+1][j-1]==1 || board[i+1][j-1]==5))
           count++;
       if (i<board.length-1 && j<board[0].length-1 &&( board[i+1][j+1]==1 || board[i+1][j+1]==5))    
          count++;
       return count;
   }