// Time Complexity : O(m * n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach


class GameOfLife {
    int[][] directions;

    private int countLiveCells(int i, int j, int[][] directions, int[][] board, int m, int n) {
        int count = 0;

        //iterate all the neighbors of current cell to find the surrounding live cells
        for (int[] arr : directions) {
            int row = i + arr[0];
            int col = j + arr[1];

            //check for border conditions
            if (col < 0 || row < 0 || col > n-1 || row > m-1 ) {
                continue;
            } else {
                //checks if cells are alive or dead
                if (board[row][col] == 1 || board[row][col] == -1 ) {
                    count++;
                }
            }
        }
        return count;
    }

    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        this.directions = new int[][] { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 }, { -1, -1 }, { -1, 1 }, { 1, 1 },
                { 1, -1 } };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int countLiveCells = countLiveCells(i, j, directions, board, m, n);

                // live cell dies if count < 2 count > 3
                if (board[i][j] >= 1 && (countLiveCells < 2 || countLiveCells > 3)) {
                    //Previosly alive cell mark as -1
                    board[i][j] = -1;
                 // Any dead cell lives with count = 3
                } else if (board[i][j] <= 0 && countLiveCells == 3) {
                    //previously dead cell marked as -2
                    board[i][j] = -2;

                }
            }
        }

        // to get transformed array
        // for values  equal to zero OR -1 change them to zero
        // for values other tah ZERO OR -1 change them to 1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0 || board[i][j] == -1) {
                    board[i][j] = 0;
                } else  {
                    board[i][j] = 1;
                }
            }
        }

    }
}