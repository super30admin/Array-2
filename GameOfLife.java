
//TC: O(m * n)
//SC: O(1)
// Each cell is checked with its 8 neighbors.
class GameOfLife {
    int m,n;
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0){
            return;
        }
        m = board.length;
        n = board[0].length;
        for(int i = 0; i< m; i++) {
            for(int j =0; j < n; j++) {
                int countNeighbors = countNeighbors(board, i, j);
                if(board[i][j] == 1){
                    if(countNeighbors < 2 || countNeighbors > 3){
                        board[i][j] = 2;
                    }
                } else {
                    if(countNeighbors == 3){
                        board[i][j] = 3;
                    }
                }
            }
        }
        for(int i = 0; i< m; i++) {
            for(int j =0; j < n; j++) {
                if(board[i][j] == 2) {
                    board[i][j] = 0;

                } else if(board[i][j] == 3) {
                    board[i][j] = 1;
                }

            }
        }



    }
    private int countNeighbors(int[][] board, int i, int j) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        int count = 0;
        for (int[] dir: dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 2)){
                count++;
            }

        }
        return count;

    }
}