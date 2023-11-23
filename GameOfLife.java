
/*
Time : 0(m*n)
Space: 0(1)
 */
public class GameOfLife {

  int[][] dir;

  public void gameOfLife(int[][] board) {
    dir = new int[][]{
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1},
            {-1, -1},
            {1, -1},
            {1, 1},
            {-1, 1}
    };
    int m = board.length;
    int n = board[0].length;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {

        int numb = validNeighbours(board, m, n, i, j);

        if (board[i][j] == 1 && (numb < 2 || numb > 3)) {
          board[i][j] = 2;
        } else if (board[i][j] == 0 && numb == 3) {
          board[i][j] = 3;
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

  private int validNeighbours(int[][] board, int m, int n, int i, int j) {
    int count = 0;

    for (int[] d : dir) {

      int x = i + d[0];
      int y = j + d[1];

      if (x >= 0 && x < m && y >= 0 && y < n && (board[x][y] == 1 || board[x][y] == 2)) {
        count++;
      }
    }

    return count;

  }

}
