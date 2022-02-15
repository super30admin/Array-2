// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: Create a new array, copy. For every element,
// we find the number of live neighbours using the dir array.
// if live neighbors arre equal to 2 or 3, we mark the element
// as live. If live neighbour for a dead element is exactly 3,
// we mark that element as live too.

// LC- 289. Game of Life

public class GameOfLife {
  public void gameOfLife(int[][] board) {
    if (board == null || board.length == 0) {
      return;
    }

    int m = board.length, n = board[0].length;
    int[][] copy = new int[m][n];
    int[][] dir = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int live = 0;

        for (int[] d : dir) {
          int p = i + d[0];
          int q = j + d[1];

          if (p >= 0 && p < m && q >= 0 && q < n && board[p][q] == 1) {
            live++;
          }
        }

        if (board[i][j] == 1) {
          if (live == 2 || live == 3) {
            copy[i][j] = 1;
          }
        } else {
          if (live == 3) {
            copy[i][j] = 1;
          }
        }
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        board[i][j] = copy[i][j];
      }
    }
  }
}
