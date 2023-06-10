// Time Complexity : O(m*n) as we iterate through each element of the matrix
// Space Complexity : O(1) no auxiliary space used
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :
// Your code here along with comments explaining your approach
class GameOfLife {
    int rows;
    int cols;

    public void gameOfLife(int[][] board) {

        rows = board.length;
        cols = board[0].length;
        for(int i =0; i< rows; i++){
            for(int j =0; j< cols; j++){
                int currentCellValue = board[i][j]; //0, 1
                int aliveNeighborCount = getAliveNeighborCount(board, i, j);
                boolean isMutation = false;

                if(currentCellValue == 1){
                    //live to dead
                    if(aliveNeighborCount != 2 && aliveNeighborCount != 3){
                        board[i][j] = 3;
                    }
                }else{
                    //dead to live
                    if(aliveNeighborCount == 3){
                        board[i][j] = 2;
                    }
                }
            }
        }

        //now replace the 2s and 3s to the real values;
        for(int i =0; i< rows; i++){
            for(int j =0; j< cols; j++){
                int currentCellValue = board[i][j]; //0, 1, 2,3

                if(currentCellValue == 2){
                    board[i][j] = 1;
                }
                if(currentCellValue == 3){
                    board[i][j] = 0;
                }
            }
        }
    }

    private int getAliveNeighborCount(int[][] board, int i, int j){

        int sum = 0;
        for(int rowIndex = i-1; rowIndex <= i+1; rowIndex++){
            for(int colIndex = j-1; colIndex <= j+1; colIndex++){

                if(rowIndex >= 0 && rowIndex <rows && colIndex >=0 && colIndex < cols ){

                    if(rowIndex == i && colIndex== j){
                        continue; //exclude the current cell
                    }
                    int currentValue = board[rowIndex][colIndex];
                    if(currentValue == 2){
                        currentValue = 0;
                    }
                    if(currentValue == 3){
                        currentValue = 1;
                    }
                    sum = sum + currentValue;
                }
            }
        }
        return sum;
    }
}
