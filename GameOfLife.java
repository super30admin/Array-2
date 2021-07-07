// Time Complexity : O(M*N) M->
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class GameOfLife {
    public void gameOfLife(int[][] board) {

        if(board == null || board.length == 0)
            return;

        int m = board.length, n = board[0].length;

        // iterate over each cell value
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {

                // count live neighbours using helper method
                int count = countLiveCells(board, i, j, m, n);

                // update current live cell to 3 if it has live neighbours less than 2 or more than 3
                if(board[i][j] == 1 && (count < 2 || count > 3 ))
                    board[i][j] = 3;

                // update current dead cell to 2 if it has 3 live neighbours
                if(board[i][j] == 0 && count == 3)
                    board[i][j] = 2;
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                // change back values to live/dead respectively
                if(board[i][j] == 3) board[i][j] = 0;
                else if(board[i][j] == 2) board[i][j] = 1;
            }
        }

    }

    private int countLiveCells(int[][] board, int i, int j, int m, int n) {
        int[][] dirs = new int[][]{{-1,-1}, {-1,0}, {-1,1}, {1,1}, {1,-1}, {1,0}, {0,1}, {0,-1}};

        int res = 0;

        for(int dir[] : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];

            // check row and column values are within borders
            if(r >= 0 && r < m && c >= 0 && c < n) {
                // if current cell is live increment result
                if(board[r][c] == 1 || board[r][c] == 3) {
                    res++;
                }
            }
        }

        return res;
    }
}