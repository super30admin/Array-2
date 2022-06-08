// Time Complexity : O(mxn) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Game of life
public class Problem3 {
    int m;
    int n;
    int[][] dirs;

    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;
        dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { -1, 1 }, { -1, -1 }, { 1, -1 }, { 1, 1 } }; // using directions
                                                                                                                     // to
                                                                                                                     // count
                                                                                                                     // the
                                                                                                                     // number
                                                                                                                     // of
                                                                                                                     // live
                                                                                                                     // neighbours
                                                                                                                     // in
                                                                                                                     // countAlive
                                                                                                                     // method
                                                                                                                    
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int countAlive = countAlive(board, i, j);
                if ((countAlive < 2 || countAlive > 3) && board[i][j] == 1)
                    board[i][j] = 3; // rule 1-4
                if (countAlive == 3 && board[i][j] == 0)
                    board[i][j] = 2; // rule 1-4
            }
        }

        for (int i = 0; i < m; i++) { // changing the temporary state to what the result should be
            for (int j = 0; j < n; j++) {

                if (board[i][j] == 2)
                    board[i][j] = 1;
                if (board[i][j] == 3)
                    board[i][j] = 0;
            }
        }
    }

    private int countAlive(int[][] board, int i, int j) {

        int count = 0;
        for (int[] dir : dirs) {
            int row = i + dir[0];
            int col = j + dir[1];

            if ((row >= 0 && col >= 0 && row < m && col < n) && (board[row][col] == 1 || board[row][col] == 3))
                count++;
        }
        return count;
    }
}
