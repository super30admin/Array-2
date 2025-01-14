// Time Complexity : O (m x n)
// Space Complexity : O (1)
// Did this code successfully run on Leetcode : Yes

public class GameOfLife {

    /**
     * Gets count of live/dead neighbours of a cell
     * (-1,0 => dead; 1,2 => alive)
     */
    int getNeighbourStatus(int[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        if (i < 0 || j < 0 || i > m - 1 || j > n - 1) {
            return 0;
        }
        return board[i][j] <= 0 ? 0 : 1;
    }

    /**
     * Gets count of (previously) alive/dead neighbours of a cell
     */
    public int countNeighbors(int[][] board, int i, int j) {
        return getNeighbourStatus(board, i - 1, j - 1) + getNeighbourStatus(board, i - 1, j) + getNeighbourStatus(board, i - 1, j + 1)
                + getNeighbourStatus(board, i, j - 1) + getNeighbourStatus(board, i, j + 1) + getNeighbourStatus(board, i + 1, j - 1)
                + getNeighbourStatus(board, i + 1, j) + getNeighbourStatus(board, i + 1, j + 1);
    }
    public void gameOfLife(int[][] board) {
        int i, j;
        int m = board.length;
        int n = board[0].length;
        /*
        * Mark temporary statuses initially to prevent affecting the neighbour statuses of
        * the cells that lie ahead.
        * 0 => was dead, is dead
        * -1 => was dead, is alive
        * 1 => was alive, is alive
        * 2 => was alive, is dead
        */
        for(i = 0; i < m; i++) {
            for(j = 0; j < n; j++) {
                int c = countNeighbors(board, i, j);
                if(board[i][j] == 0 && (c < 2 || c > 3)) board[i][j] = 0;
                if(board[i][j] == 0 && c == 3) board[i][j] = -1;
                if(board[i][j] == 1 && (c == 2 || c == 3)) board[i][j] = 1;
                if(board[i][j] == 1 && (c < 2 || c > 3)) board[i][j] = 2;
            }
        }
        /*
        * at the end, update all the states to reflect final states
        */
        for(i = 0; i < m; i++) {
            for(j = 0; j < n; j++) {
                if(board[i][j] == -1) board[i][j] = 1;
                if(board[i][j] == 2) board[i][j] = 0;
            }
        }

    }
}
