package com.ds.rani.dfs;

/**
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0).
 * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following
 * four rules (taken from the above Wikipedia article):
 *
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state.
 * The next state is created by applying the above rules simultaneously to every cell in the current state,
 * where births and deaths occur simultaneously.
 *
 * Example:
 *
 * Input:
 * [
 *   [0,1,0],
 *   [0,0,1],
 *   [1,1,1],
 *   [0,0,0]
 * ]
 * Output:
 * [
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 * Follow up:
 *
 * Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
 * In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
 */

//Approach: I am doing this in place
//when I am counting neighbours and based on rule if live cell dies(it means when it become 1->0) I will represnt it by 7
//If dead cell becomes live(0->1) I will represnt it by 8 and finally resetting 7 to 0 and 8 to1
public class GameOfLife {

    //Time complexity:o(rows*cols)
    //Space complexity:o(1) as I am doing it in place
    /**
     *
     * @param board 2d matrix consists of 0's and 1's
     */
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0)
            return;

        int rows = board.length;
        int cols = board[0].length;

        //traverse over board
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                int liveNeighbourCount = countLiveNeigbours( board, row, col, rows, cols );

                //if it is live cell
                if (board[row][col] == 1) {
                    //rule number 1 and 3:live cell dies,represnt it by 7.
                    if (liveNeighbourCount < 2 || liveNeighbourCount > 3) {
                        board[row][col] = 7;
                    }

                }
                //if it is dead cell
                else {
                    //rule number 4: dead becomes live
                    if (liveNeighbourCount == 3) {
                        board[row][col] = 8;
                    }

                }
            }
        }
        //change the board to the final state. change 7 to 0 and 8 to 1
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                if (board[row][col] == 7)
                    board[row][col] = 0;

                if (board[row][col] == 8)
                    board[row][col] = 1;
            }
        }
    }

    /**
     * Helper method to count the live neighbours
     * @param board 2d board
     * @param row current row
     * @param col current column
     * @param rows number of rows in board
     * @param cols number of columns in board
     * @return live neigbours count for current cell
     */
    private int countLiveNeigbours(int[][] board, int row, int col, int rows, int cols) {
        //use dirs to go to 8 neigbours
        // left,right,top,down,top-left,top-right,bootom-left,bootom-right
//        int[][] dirs = {{row, col-1}, {row, col+1}, {row-1, col}, {row+1, col}, {row-1, col-1},
//        {row-1, col+1}, {row+1, col-1}, {row+1, col+1}};

        int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        int count = 0;

        for (int[] dir : dirs) {
            int r = row + dir[0];
            int c = col + dir[1];
            //if the computed neigbour is valid and it is 1 or 7(it was live initially)
            if (r >= 0 && r < rows && c >= 0 && c < cols && (board[r][c] == 1 || board[r][c] == 7)) {
                count++;
            }
        }

        return count;
    }
}
