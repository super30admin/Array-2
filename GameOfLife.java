// Time Complexity : O(m*n)
// Space Complexity : O(1).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.lang.reflect.Array;
import java.util.Arrays;

public class GameOfLife {

    public static void main(String[] args)
    {
//        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        int[][] board = {{1,1},{1,1}};

        gameOfLife(board);
    }

    public static void gameOfLife(int[][] board) {

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                int countAlives = countAlive(board, i, j, m, n);
                // is alive
                if (board[i][j] == 1 && (countAlives < 2 || countAlives > 3)) {

                    // rules for alive
                    board[i][j] = 2;
                }

                if (board[i][j] == 0 && countAlives == 3) {
                    board[i][j] = 3;
                }

            }
        }

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (board[i][j] == 2) {
                    board[i][j] = 0;
                }

                if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }

        for (int[] arr : board) {
            System.out.println(Arrays.toString(arr));

        }
    }

    private static int countAlive(int[][] board, int i, int j, int m, int n) {
        int count = 0;
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };

        for (int[] dir : dirs) {
            int rowIndex = i + dir[0];
            int colIndex = j + dir[1];

            if (rowIndex >= 0 && rowIndex < m && colIndex >= 0 && colIndex < n
                    && (board[rowIndex][colIndex] == 1 || board[rowIndex][colIndex] == 2)) {
                count++;
            }

        }

        return count;
    }
}
