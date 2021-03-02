// Traverse through the matrix, and for each element, check it's eight neighbors and calculate the live cells. 
// Based on the rules provided, if live cell needs to be changed to dead mark it as -1, or if a dead cell needs to be changed to be alive, then mark it as 2
// Traverse the matrix again, and change -1 to be 0 and 2 to be 1. 

// Time Complexity : O(m * n) where m is the number of rows, and n is the number of columns
// Space Complexity : O(1)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameOfLife {
    private static int check(int[][] board, int i, int j) {
        int r = board.length, c = board[0].length;
        if (i < 0 || i >= r || j < 0 || j >= c)
            return 0;
        if (Math.abs(board[i][j]) == 1)
            return 1;
        return 0;
    }

    public static void gameOfLife(int[][] board) {
        int r = board.length, c = board[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int live = check(board, i, j + 1) + check(board, i, j - 1) + check(board, i + 1, j)
                        + check(board, i - 1, j) + check(board, i + 1, j + 1) + check(board, i - 1, j - 1)
                        + check(board, i - 1, j + 1) + check(board, i + 1, j - 1);

                if (board[i][j] > 0)
                    if (live < 2 || live > 3)
                        board[i][j] = -1;

                if (board[i][j] < 1)
                    if (live == 3)
                        board[i][j] = 2;
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                }
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        List<int[][]> inputs = new ArrayList<>();
        Collections.addAll(inputs, new int[][] { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } },
                new int[][] { { 1, 1 }, { 1, 0 } });

        for (int[][] board : inputs) {
            gameOfLife(board);
            System.out.println(Arrays.deepToString(board));
        }
    }
}
