class GameOfLife {
    int m,n;
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0){
            return;
        }
        m = board.length;
        n = board[0].length;

        //died 1->0 => 2
        //born 0->1 => 3
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int countLiveNeighbors = countLiveNeighbors(board, i, j);

                if(board[i][j] == 1){
                    if(countLiveNeighbors < 2 || countLiveNeighbors > 3){
                        board[i][j] = 2;
                    }
                }else if(board[i][j] == 0){
                    if(countLiveNeighbors == 3){
                        board[i][j] = 3;
                    }
                }
            }
        }

        for(int i=0; i<m;i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }else if(board[i][j] == 3){
                    board[i][j] = 1;
                }
            }
        }
    }

    private int countLiveNeighbors(int[][] board, int i, int j){
        int[][] dirs = {{-1,0}, {0,-1}, {0,1}, {1,0}, {-1,-1}, {-1,1}, {1,-1}, {1,1}}; //U L R D UL UR LL LR
        int count = 0;
        for(int[] dir: dirs){
            int nr = i + dir[0];
            int nc = j + dir[1];

            if(nc >=0 && nc<n && nr>=0 && nr<m && (board[nr][nc] == 1 || board[nr][nc] == 2)){
                count++;
            }
        }
        return count;
    }
}
