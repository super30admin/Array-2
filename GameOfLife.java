public class GameOfLife {

    // Time complexity: O(m * n)
    // Space complexity: O(1)
    int m,n;
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return;

        m = board.length;
        n = board[0].length;

        // 1 --> 0 === 2
        // 0 --> 1 === 3
        for(int i=0;i< m;i++) {
            for(int j=0; j<n; j++){
                int countLiveCells = getCountLiveCells(board, i,j);

                if(board[i][j] == 1){
                    if(countLiveCells < 2 || countLiveCells > 3){
                        board[i][j] = 2;
                    }
                }else{
                    if (countLiveCells == 3){
                        board[i][j] = 3;
                    }
                }
            }
        }

        // Reverting all the 2s and 3s to the expected values
        for(int i=0; i < m;i ++){
            for(int j=0; j < n; j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }else if(board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }

    }

    private int getCountLiveCells(int[][] board, int row, int column) {
        int[][] dirs = {
                {0,1},{0,-1},{1,0},{-1,0}, // Horizontal and vertical neighbours
                {1,1},{1,-1},{-1,1},{-1,-1} // diagonal neighbours
        };

        int total = 0;
        for(int[] dir : dirs) {
            int newRow = row + dir[0];
            int newColumn = column + dir[1];

            if(newRow >= 0 && newRow < m && newColumn >=0 && newColumn < n &&
                    (board[newRow][newColumn] == 1 || board[newRow][newColumn] == 2)) {
                total++;
            }
        }
        return total;
    }
}
