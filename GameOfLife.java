// Time Complexity : O(R*C)
// Space Complexity : O(R*C)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Calculating Bounds.

class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) {
            return;
        }
        int[][] tempBoard = new int[board.length][board[0].length];


        for(int row = 0; row < board.length; row++){
            int newValue = 0;
            for(int col = 0; col < board[0].length; col++){
                int currentStatus = board[row][col];
                int horizontal = checkHorizontal(board,row,col);
                int vertical = checkVertical(board,row,col);
                int diagonal = checkDiagonal(board,row,col);
                int totalLive = horizontal+vertical+diagonal;
                
                // if(row == 2 && col == 2)
                // System.out.println("Horizontal: " + horizontal + ", vertical: " + vertical + ", diagonal: " + diagonal);
                
                if( (currentStatus == 1 && (totalLive == 2 || totalLive == 3)) ||currentStatus == 0 && totalLive == 3 ){
                    //If cell is alive
                    //two or three live neighbors -> new value = 1
                    //If Cell is not alive: 
                    //3 live cells -> new value = 1. 
                    newValue = 1;
                }
                
                // System.out.println("Row: " + row + " , Col: " + col + ", New Value: " + newValue);

                //Grab new value, row, col, and put into new array.
                tempBoard[row][col] = newValue;
                newValue = 0;
            }
            // System.out.println(Arrays.toString(tempBoard[row]));

        }
        
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                board[row][col] = tempBoard[row][col];
            }
        }
        
        
    }
    
    private int checkHorizontal(int[][] board, int row, int col){
 
        int total = 0;
        //check left
        if(col-1 >= 0 && board[row][col-1] == 1){
            total++;
        }
        //check right
        if(col+1 < board[row].length && board[row][col+1] == 1){
            total++;
        }
        return total;
    }
    
    private int checkVertical(int[][] board, int row, int col){

        int total = 0;
            
        //check up
        if(row-1 >= 0 && board[row-1][col] == 1){
            total++;
        }

        //check down
        if(row+1 < board.length && board[row+1][col] == 1){
            total++;
        }
        return total;
        
    }
    
    private int checkDiagonal(int[][] board, int row, int col){
        int total = 0;
        //check top right
        if(row-1 >= 0 && col+1 < board[row].length && board[row-1][col+1] == 1){
            total++;
        }
        //check top left
        if(row-1 >= 0 && col-1 >= 0 && board[row-1][col-1] == 1){
            total++;
        }
        //check bottom left
        if(row+1 < board.length && col-1 >= 0 && board[row+1][col-1] == 1){
            total++;
        }
        //check bottom right
        if(row+1 < board.length && col+1 < board[row].length && board[row+1][col+1] == 1){
            total++;
        }
        
        return total;
    }
}