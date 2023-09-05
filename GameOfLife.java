//TC: O(M*N) SC: O(1)
class GameOfLife {
    int[][] dirs;
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        // right, left, up, down, upleft, upright, downleft, downright
        dirs = new int[][]{{0,1}, {0,-1}, {-1,0}, {1,0}, {-1,-1}, {-1, 1}, {1,-1}, {1,1}};
        //1 -> 0 == 3
        //0 -> 1 == 2
        for(int i=0; i<m; i++ ) {
            for(int j=0; j<n; j++) {
                int countAlive = countAlive(board, i, j ,m, n);
                if(board[i][j] == 1 && (countAlive < 2 || countAlive > 3)) board[i][j] = 3;
                if(board[i][j] == 0 && countAlive == 3) board[i][j] = 2;
            }
        }
        for(int i=0; i<m; i++ ) {
            for(int j=0; j < n;j++) {
                if(board[i][j] == 2) board[i][j] = 1;
                if(board[i][j] == 3) board[i][j] = 0;
            }
        }
    }

    private int countAlive(int[][] board, int i, int j, int m, int n) {
        int count = 0;
        for(int[] dir: dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];
            if(nr >= 0 && nc >=0 && nr < m && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 3)) count++;
        }
        return count;
    }
}
