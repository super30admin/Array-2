/*
Problem - Game of Life
Approach - We go cell by cell and count how many live neighbors it has.
We mark transitions with temporary values: 2 (alive → dead) and 3 (dead → alive).
then, we finalize the board by converting 2 → 0 and 3 → 1.
Time Complexity - O(m*n)
Space Complexity - O(n)
 */

import java.util.Arrays;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        // 1 ----> 0 == 2
        // 0---> 1 == 3
        int m = board.length;
        int n = board[0].length;
        //checking the neighbors to see if the conditions given in the problem to make it alive,
        // if we are transitioning to 1-->0 we are marking it as 2 and if we are transitions from 0-->1 we are marking it as 3
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = countAlive(board, i, j);
                if ((board[i][j] == 1) && (count < 2 || count > 3)) {
                    board[i][j] = 2;
                }
                if ((board[i][j] == 0) && count == 3) {
                    board[i][j] = 3;
                }
            }
        }
        // Iterating again through the array to make to roolback the previous transitions which are marked as 2 and 3 to their original values
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
    }
    public int countAlive(int[][] board, int i, int j) {
        int count = 0;
        int[][] dirs = new int[][]{{-1,-1}, {-1,0}, {-1, 1}, {0, -1}, {0, 1}, {1,-1}, {1,0}, {1,1}};
        for(int []dir:dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            if (r >= 0 && c >= 0 && r < board.length && c < board[0].length) {
                if (board[r][c] == 1 || board[r][c] == 2) count++;
            }
        }
        return  count;
    }
    public static void main(String[] args) {
        GameOfLife gol = new GameOfLife();

        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };

        gol.gameOfLife(board);

        // Expected after 1 step:
        // [
        //   [0,0,0],
        //   [1,0,1],
        //   [0,1,1],
        //   [0,1,0]
        // ]
        int[][] expected = {
                {0, 0, 0},
                {1, 0, 1},
                {0, 1, 1},
                {0, 1, 0}
        };

        System.out.println(Arrays.deepEquals(board, expected));
    }
}
