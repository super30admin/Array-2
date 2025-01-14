/**
 * Time complexity: O(m*n)
 * Space complexity: O(1)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: No
 */
public class GameOfLife {
  int m;
  int n;

  public void gameOfLife(int[][] board) {
    if (board == null || board.length == 0) {
      return;
    }
    m = board.length;
    n = board[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int countLiveNeighbors = countLiveNeighbors(board, i, j);
        if (board[i][j] == 1) {
          if (countLiveNeighbors < 2 || countLiveNeighbors > 3) {
            board[i][j] = 2;
          }
        } else if (board[i][j] == 0) {
          if (countLiveNeighbors == 3) {
            board[i][j] = 3;
          }
        }
      }
    }

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

  private int countLiveNeighbors(int[][] board, int i, int j) {
    int count = 0;
    int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };
    for (int[] dir : dirs) {
      int nr = i + dir[0];
      int nc = j + dir[1];
      if (nr >= 0 && nr < m && nc >= 0 && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 2)) {
        count++;
      }
    }

    return count;
  }
}
