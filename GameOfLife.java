class GameOfLife {
    int[][] dirs;
    int m, n;
    public void gameOfLife(int[][] board) {
        this.dirs = new int[][]{{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0},{1,1}};
        this.m = board.length;
        this.n = board[0].length;
    
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int count = getCount(board, i, j);
                if(board[i][j] == 0 && count == 3)
                    board[i][j] = 3; // Dead to Alive
                else if(board[i][j] == 1 && (count < 2 || count > 3))
                    board[i][j] = 2; // Alive to Dead
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j< n; j++){
                if(board[i][j] == 2)
                    board[i][j] = 0;
                else if (board[i][j] == 3)
                    board[i][j] = 1;
            }
        }
    }

    private int getCount(int[][] board, int i, int j){
        int count = 0;
        for(int[] dir: dirs){
            int row = dir[0]+i;
            int col = dir[1]+j;
            if(row>0 && col>0 && row<m && col<n){
                if(board[i][j]==1 || board[i][j]==3)
                    count++;
            }
        }
        return count;
    }
}
