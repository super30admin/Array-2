// Time: O(m * n) : m = rows, n = cols
// Space: O(1)

class GameOfLife {
    int[] dirRow = {0, 0, 1, -1, 1, -1, 1, -1};
    int[] dirCol = {1, -1, 0, 0, 1, -1, -1, 1};

    // 2 : 0-> 1
    // 3: 1 -> 0

    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0){
            return;
        }

        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 0){
                    if(countAliveCells(board, i, j, m, n) == 3){
                        board[i][j] = 2;
                    }
                }else if(board[i][j] == 1){
                    if(countAliveCells(board, i, j, m, n) < 2){
                        board[i][j] = 3;
                    }else if(countAliveCells(board, i, j, m, n) > 3){
                        board[i][j] = 3;
                    }
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 2){
                    board[i][j] = 1;
                }

                if(board[i][j] == 3){
                    board[i][j] = 0;
                }
            }
        }
    }

    private int countAliveCells(int[][] nums, int row, int col, int m, int n){

        int count = 0;
        for(int i = 0; i < 8; i++){
            int nRow = row + dirRow[i];
            int nCol = col + dirCol[i];

            if(nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && (nums[nRow][nCol] == 3 || nums[nRow][nCol] == 1)){
                count++;
            }
        }
        return count;
    }
}
