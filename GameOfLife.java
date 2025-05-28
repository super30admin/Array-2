// TC : O(mn)
// SC : O(mn)
// Approach : Count alives with given condition and consider 2 numbers(any) to replace 0 and 1 on te board
// Iterate through the whole board again to replace numbers back to 0 and 1 

public class GameOfLife {

  public void gameOfLife(int[][] board) {
    int m = board.length;
    int n = board[0].length;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int count = countAlives(board, i, j);
        if (board[i][j] == 1 && (count < 2 || count > 3)) {
          board[i][j] = 5;
        }
        if (board[i][j] == 0 && count == 3) {
          board[i][j] = 4;
        }
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 5) {
          board[i][j] = 0;
        }
        if (board[i][j] == 4) {
          board[i][j] = 1;
        }
      }
    }
  }

  private int countAlives(int[][] board, int r, int c) {

    int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 }, { -1, 1 }, { -1, -1 }, { 1, 1 },
        { 1, -1 } };
    int result = 0;

    for (int[] dir : directions) {
      int nr = r + dir[0];
      int nc = c + dir[1];

      // bounds check
      if (nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length
          && (board[nr][nc] == 1 || board[nr][nc] == 5)) {
        result++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    GameOfLife gof = new GameOfLife();
    int[][] board = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };

    gof.gameOfLife(board);
  }
}