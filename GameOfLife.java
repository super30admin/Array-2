// Time Complexity : O(2m*n) = O(m*n) => As we iterate over the entire 2D matrix of m rows and n columns twice
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. Initially combined these 2 conditions (if (board[i][j] == 1) , if (countLiveNeighbours < 2 || countLiveNeighbours > 3)) and was getting incorrect answer

/*
Approach: Used 2 to inidcate live cell to deal cell and 3 to indicate dead cell to live cell. Used 2D direction matrix to calculate values for all the neighbours.
Maintained the count of live neighbours and marked cell as dead or live
 */
class Solution {
    public void gameOfLife(int[][] board) {

        if (board.length == 0 || board == null) {
            return;
        }

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int countLiveNeighbours = calcualteLiveNeighbours(board, i, j);

                if (board[i][j] == 1) {
                    if (countLiveNeighbours < 2 || countLiveNeighbours > 3) {
                        board[i][j] = 2; //2 indicates live cell to dead cell
                    }
                } else {
                    if (countLiveNeighbours == 3) {
                        board[i][j] = 3; //3 indicates dead cell to live cell
                    }
                }
            }
        }

        //Used to convert all the 2's and 3's to 0's and 1's
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    //This method is used to calculate all the live neighbours
    private int calcualteLiveNeighbours(int[][] board, int row, int column) {

        int countLiveNeighbours = 0;
        //Indicates all the 8 neighbours 0 inidcates same, -1 indicates row--/col--, 1 inidcates row++, col++
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newColumn = column + dir[1];

            //Check condition for board[newRow][newColumn] == 2 as it indicates the cell was live in the original matrix
            if (newRow >= 0 && newColumn >= 0 && newRow < board.length && newColumn < board[0].length
                    && (board[newRow][newColumn] == 1 || board[newRow][newColumn] == 2)) {
                countLiveNeighbours = countLiveNeighbours + 1;
            }
        }

        return countLiveNeighbours;
    }
}