// Time Complexity : O(N*M), where N*M is board size
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Based on certain rules, either a cell can die or survive. We have to find the next generation of cells i.e
// next state of board. We can either create new board for next generation or use the current board instance to reduce
// space complexity. In either case, a cell survives if it has 3 neighbours, it dies if it has more than 3 neighbors or
// less than 3 neighbors. A cell revives if it has 3 neighbors.
// To save the space complexity, we must keep the previous state and the next state into the current board, we can do
// that representing the state change by a new number, for example, 0(no cell) ==> 1(regrows) can be represented as 3
// and the state 1(live cell) ==> 0 (dies) can be represented as 2. We can traverse through the board and convert  0(dead)
// or 1(live) cells to 2 or 3. Then we can again traverse through the board to convert state from 2 or 3 to 0 or 1.
// That will be state for next generation of cells.

public class GameOfLife {

    int[][] direction = {{-1, -1}, {1, 1}, {-1, 1}, {1, -1}, {0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public void gameOfLife(int[][] board) {

        int row = board.length;
        int col = board[0].length;

        updateBoard(board);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }

    }

    private void updateBoard(int[][] board) {
        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int lives = getLives(board, i, j);
                if (board[i][j] == 1) {
                    if (lives < 2 || lives >= 4) {
                        board[i][j] = 2;
                    }
                } else {
                    if (lives == 3) {
                        board[i][j] = 3;
                    }
                }

            }
        }
    }

    private int getLives(int[][] board, int i, int j) {
        int lives = 0;
        for (int dir[] : direction) {
            int currX = i + dir[0];
            int currY = j + dir[1];
            if (isOutOfBounds(currX, currY, board)) {
                continue;
            }
            if (board[currX][currY] == 1 || board[currX][currY] == 2) {
                lives += 1;
            }
        }
        return lives;
    }


    private boolean isOutOfBounds(int currX, int currY, int[][] board) {
        int row = board.length;
        int col = board[0].length;

        if (currX < 0 || currY < 0) return true;
        if (currX >= row || currY >= col) return true;
        return false;
    }
}
