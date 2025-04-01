// Time Complexity : O(M*N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


class GameOfLife {
    int[][] dirs;
    int m,n;
    public void gameOfLife(int[][] board) {
        //let diagonal up, up, right diagonal up, left, right, left diagonal down, down, right diagonal down
        this.dirs = new int[][]{{-1,-1}, {-1,0}, {-1,1}, {0, -1}, {0,1}, {1,-1}, {1,0}, {1,1}};

        this.m = board.length;
        this.n = board[0].length;

        for(int i=0; i<m ; i++) {
            for(int j=0; j<n; j++) {
                int count = getCount(board, i, j); //number of alive cells around
                if(board[i][j] == 0 && count == 3) {
                    board[i][j] = 3; // dead -> alive
                } else if(board[i][j] == 1 && (count < 2 || count > 3)) {
                    board[i][j] = 2; // alive -> dead
                }
            }
        }

        // retrieve the original board
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == 2){
                    board[i][j] = 0;
                } else if(board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int getCount(int[][] board, int i, int j) {
        int count = 0;

        for(int[] dir: dirs) { // {-1,-1}
            int r = i + dir[0];
            int c = j + dir[1];

            if(r>=0 && c>=0 && r<m && c<n) { // check if we are not going out of bounds
                if(board[r][c] == 1 || board[r][c] == 2) count++;
            }
        }
        return count;
    }
    
}