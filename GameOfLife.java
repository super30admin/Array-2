/*
Time Complexity - O(n^2)
Space Complexity - O(1)
*/
class Solution {
    public void gameOfLife(int[][] board) {
        if(board.length ==0 || board[0].length == 0)
            return;
        int row = board.length, col = board[0].length;
        for(int i=0; i< row; i++){
            for(int j=0; j<col; j++){
                int count= countLives(board, i, j);
                //case 1 and 3 live cell with less than 2 or more than 3 neighbors would die because of under and over population
                if(board[i][j] == 1 && (count > 3 || count < 2))
                   board[i][j] = 5;
                //case 4 dead cell with exactly 3 neighbors would become live because of reproduction
                if(board[i][j] == 0 && count == 3)   
                   board[i][j] = -5;
            }
        }
        updateBoard(board);
    }
    // as we have mutated the array for our calculation we would be changing it again by replacing 5 with 0 and -5 with 1
    private void updateBoard(int[][] board){
        for(int i=0; i< board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == 5)
                    board[i][j] = 0;
                else if(board[i][j] == -5)
                    board[i][j] = 1;
            }
        }
    }
    //we want to update the current cell value based on the given condition, whether it will live to next generation or not.
    //so when live cell is dieing because of more than three live neighbors make it -5 so that we would know that we have updated 
    //it to 5 and ww we would consider that cell as live for calculating live neighbors of other cells. 
    private int countLives(int [][]board, int rowIndex, int colIndex){
        int count=0;
        int[][] dirs = {{-1,1},{1,-1},{1,1},{-1,-1},{0,1},{1,0},{-1,0},{0,-1}};
        //checking cells in all directions for the current cell if it is live or not.
        for(int[] dir: dirs){
            int newRowIndex =  rowIndex+ dir[0];
            int newColIndex = colIndex+ dir[1];
            //check if new cells coordinates are within range as well as check if it was or is a live cell 
            if(newRowIndex>= 0 && newRowIndex< board.length && newColIndex>= 0 && newColIndex< board[0].length &&
              (board[newRowIndex][newColIndex] == 5 ||  board[newRowIndex][newColIndex] == 1) )
            count++;
        }
        return count;
    }
}
