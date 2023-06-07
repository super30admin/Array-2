// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

import java.util.Arrays;

public class GameOfLife {
    int[][] dicts;

    public void gameOfLife(int[][] board) {
        dicts = new int[][] { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = helper(board, i, j, m, n);
                if (board[i][j] == 1 && (count < 2 || count > 3)) {
                    board[i][j] = -1;
                }
                if (board[i][j] == 0 && count == 3) {
                    board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                }
            }
        }
    }

    public int helper(int[][] board, int i, int j, int m, int n) {
        int count = 0;
        for (int[] dict : dicts) {
            int nr = dict[0] + i;
            int nc = dict[1] + j;
            if (nr >= 0 && nc >= 0 && nr < m && nc < n &&
                    (board[nr][nc] == 1 || board[nr][nc] == -1)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        GameOfLife obj = new GameOfLife();
        int[][] input = {
                { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 }
        };
        System.out.println("Input Array is : " + Arrays.deepToString(input));
        obj.gameOfLife(input);
        System.out.println("Output Array is: " + Arrays.deepToString(input));
    }
}
