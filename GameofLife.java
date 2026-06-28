public class GameofLife {
    // 1 -> 0 = 5
    // 0 -> 1 = -1

    public void gameOfLife(int[][] m) {
        int row = board.length;
        int col = board[0].length;
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                int count = lifeCount(board, i, j);
                if (board[i][j] == 1 && (count <2 || count >3)) {
                    board[i][j] = -1;
                }  else if (board[i][j] == 0 && count ==3) {
                    board[i][j] = 2;
                }
            }
        }
        //if -1 => change it to 0
        //if 2 => change to 1;
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                }  else if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }        
    }
    private int lifeCount(int[][] board, int row, int col) {
        int[][] dirs = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
        int rows = board.length;
        int cols = board[0].length;
        int count =0;
        for (int[] dir: dirs) {
            int adjRow = row+dir[0];
            int adjCol = col+dir[1];

            if ((adjRow>=0 && adjRow<rows) &&(adjCol>=0 && adjCol<cols)){
                if (board[adjRow][adjCol] == 1 || board[adjRow][adjCol] == -1) {
                    count++;
                }
            }
        }
        return count;
    }
}
