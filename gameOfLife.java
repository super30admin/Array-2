// Time Complexity :O(m*n) where m is no of rows and n is no of columns
// Space Complexity :constant
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No

class gameOfLife {
    public void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                int neighbours = findNeighbours(board, i, j);

                if (board[i][j] == 0) {
                    if (neighbours == 3) {
                        board[i][j] = 2;
                    }
                } else if (board[i][j] == 1) {
                    if (neighbours < 2 || neighbours > 3) {
                        board[i][j] = 3;
                    }
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                } else if (board[i][j] == 3) {
                    board[i][j] = 0;
                }
            }
        }
    }

    private int findNeighbours(int[][] board, int i, int j) {
        int[][] dirs = { { 1, 1 }, { 1, -1 }, { 1, 0 }, { -1, 0 }, { -1, -1 }, { -1, 1 }, { 0, -1 }, { 0, 1 } };
        int row = board.length - 1;
        int col = board[0].length - 1;
        int count = 0;
        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            if (r >= 0 && r <= row && c >= 0 && c <= col && (board[r][c] == 1 || board[r][c] == 3)) {
                count++;
            }
        }
        return count;
    }
}
