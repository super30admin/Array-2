// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * As we are required to solve it in-place, we are considering
 * the state change of 1 -> 0 as -1 and 0 -> 1 as -2 so that our input
 * remains same and does not alter the solution
 */


public class Problem3 {
    int[][] dirs;
    public void gameOfLife(int[][] board) {
        //1-->0 -1
        //0-->1 -2
        int m = board.length;
        int n = board[0].length;

        this.dirs = new int[][] {
                {-1,0}, //up
                {1,0}, //down
                {0,-1}, //left
                {0,1}, //right
                {-1,-1}, //up-left
                {-1,1}, //up-right
                {1,-1}, //down-left
                {1,1}, //down-right
        };

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int countAlive = countAlive(board, i, j);
                if(board[i][j] == 1 && (countAlive < 2 || countAlive > 3)) {
                    //it dies
                    board[i][j] = -1;
                } else if(board[i][j] == 0 && countAlive == 3)
                    //it becomes alive
                    board[i][j] = -2;
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == -1) {
                    board[i][j] = 0;
                } else if(board[i][j] == -2) {
                    board[i][j] = 1;
                }
            }
        }
    }

    int countAlive(int[][] board, int r, int c) {
        int countAlive = 0;
        for(int[] dir: this.dirs) {
            int nr = r + dir[0]; //next row
            int nc = c + dir[1]; //nect col

            if (nr >= 0 &&
                    nr < board.length &&
                    nc >= 0 &&
                    nc < board[0].length &&
                    (board[nr][nc] == 1 || board[nr][nc] == -1)
            ) {
                countAlive++;
            }

        }

        return countAlive;
    }
}
