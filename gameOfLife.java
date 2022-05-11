// Time Complexity :O(m*n) where m is no of rows and n is no of columns
// Space Complexity :constant
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No

//we'll traverse through each entry and check its no.of neighbours, and change 0 to 1 and 1 to 0 according to 
//the rules of game while changing 1 to 0 we'll put 3 in cell and while converting 0 to 1 we'll put 2 in cell so
// that while counting neighbours we can count 1's after changing states, we replace 2 with 1 and 3 with 0
class Solution {
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