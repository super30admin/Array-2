// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no

class Solution {

    int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
    int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };

    public int calculateNeighbors(int[][] board, int i, int j) {

        int neighbors = 0;
        for (int k = 0; k < 8; k++) {
            int row = i + dx[k];
            int col = j + dy[k];

            if (isValid(board, row, col)) {
                if (board[row][col] == 1 || board[row][col] == -1) {
                    neighbors++;
                }
            }

        }

        return neighbors;

    }

    public boolean isValid(int[][] board, int row, int column) {
        return row >= 0 && column >= 0 && row < board.length && column < board[0].length;
    }

    public void gameOfLife(int[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count = calculateNeighbors(board, i, j);

                if (board[i][j] == 1) {

                    if (count < 2 || count > 3) {
                        board[i][j] = -1;
                    }
                } else {
                    if (count == 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                }
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }

    }
}