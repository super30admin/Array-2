public class SimpleLife {
   
    int[][] dirs = new int[][]{{1,1},{1,-1},{-1,-1},{-1,1},{-1,0},{0,1},{0,-1},{1,0}};
    public void gameOfLife(int[][] board) {
        int rowSize = board.length;
        int colSize = board[0].length;

        //temp state
        for(int rowIndex = 0; rowIndex < rowSize; rowIndex++){
            for(int colIndex =0; colIndex < colSize; colIndex++){
                int neighbourLiveCount = countAlive(board, rowIndex, colIndex, rowSize, colSize);
                if(board[rowIndex][colIndex] == 1 && (neighbourLiveCount < 2 || neighbourLiveCount > 3 )){
                    board[rowIndex][colIndex] = 2;
                }
                if(board[rowIndex][colIndex] == 0 && neighbourLiveCount == 3){
                    board[rowIndex][colIndex] = 3;
                }

            }
        }

        //return to original state
        for(int rowIndex = 0; rowIndex < rowSize; rowIndex++){
            for(int colIndex =0; colIndex < colSize; colIndex++){
                if(board[rowIndex][colIndex] == 2){
                    board[rowIndex][colIndex] = 0;
                }
                if(board[rowIndex][colIndex]==3){
board[rowIndex][colIndex] = 1;
                } 

            }
        }
        
    }

    private int countAlive(int[][] board, int i, int j, int boardRowLength, int boardColumnLength){
        int count = 0;
        for(int[] dir: dirs){
            int neighbourRow = i + dir[0];
            int neighbourColumn = j + dir[1];
            if(neighbourRow >=0 && neighbourColumn >=0 && neighbourRow < boardRowLength && neighbourColumn < boardColumnLength && (board[neighbourRow][neighbourColumn] == 1 || board[neighbourRow][neighbourColumn] == 2)){
                count++;
            }

        }

        return count;

    }

}
