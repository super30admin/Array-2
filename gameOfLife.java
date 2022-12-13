// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
public class gameOfLife {
    private int m, n;
    private int[][] dirs;

    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;
        // array for 8 directions
        dirs = new int[][] { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };
        // iterate through the matrix , count Alive cells and take decison based on the
        // conditions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int countAlive = checkAlive(board, i, j);
                if (board[i][j] == 0 && countAlive == 3) {
                    // for changing to 0 to 1, for calculations consider 2
                    board[i][j] = 2;
                }
                if (board[i][j] == 1 && (countAlive < 2 || countAlive > 3)) {
                    // for changing to 0, for calculations consider 3
                    board[i][j] = 3;
                }

            }
        }

        // change back the temporary assigned values
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
                if (board[i][j] == 3) {
                    board[i][j] = 0;
                }
            }
        }
    }

    // function to count the live ceels in all the 8 directions
    private int checkAlive(int[][] board, int i, int j) {

        int count = 0;
        // create static array for direction
        for (int[] dir : dirs) {
            int row = i + dir[0];
            int col = j + dir[1];
            if (row >= 0 && col >= 0 && row < m && col < n && (board[row][col] == 1 || board[row][col] == 3)) {
                count++;
            }
        }
        return count;

    }

}
