// Time Complexity : O(m*n) - where m is row length and n is col length
// Space Complexity : O(1)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach -:

Prepared direction array to explore and count the neighbours

written the logic to mutate the cell based on the given conditions.

Inorder to do the operation in place, I have changed the state of a cell temporarily

if the mutation is 1 -> 0, I am marking it as -1
if the mutation is 0 -> 1, I am marking it as -2

With this we can't lose the original state
 */
public class GameOfLife {
    int[][] dirs;

    public void gameOfLife(int[][] board) {

        dirs = new int[][]{ {-1, -1}, {-1, 0}, {-1, 1}, // top
                {0, -1}, {0, 1},            // current
                {1, -1}, {1, 0}, {1,1} };   //bottom

        int m = board.length;
        int n = board[0].length;


        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                int count = getLivingNeigboursCount(board, i, j);

                if(board[i][j] == 1 && (count < 2 || count > 3)) {
                    board[i][j] = -1;
                } else if(board[i][j] == 0 && count == 3) {
                    board[i][j] = -2;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == -1) {
                    board[i][j] = 0;
                } else if(board[i][j] == -2) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int getLivingNeigboursCount(int[][] board, int m, int n) {
        int livingNeighbourCount = 0;

        for(int i = 0; i < dirs.length; i++) {

            int row = m + dirs[i][0];
            int col = n + dirs[i][1];

            if(row >= 0 && row < board.length &&
                    col >= 0 && col < board[0].length) {
                if(board[row][col] == 1 || board[row][col] == -1)
                    livingNeighbourCount += 1;
            }
        }

        return livingNeighbourCount;
    }
}
