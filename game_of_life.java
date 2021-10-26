// Time Complexity : O(m * n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {

  public void gameOfLife(int[][] board) {
    if (board == null || board.length == 0 || board[0].length == 0) return;
    int m = board.length;
    int n = board[0].length;

    //Encoding
    //Alive -> Dead (2)
    //Dead -> Alive (3)
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int count = count_life(board, i, j, m, n);
        if (board[i][j] == 1 && (count > 3 || count < 2)) board[i][j] = 2;
        if (board[i][j] == 0 && count == 3) board[i][j] = 3;
      }
    }

    //Getting back the matrix with the original values and removing the encoding values
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 2) board[i][j] = 0;
        if (board[i][j] == 3) board[i][j] = 1;
      }
    }
  }

  public int count_life(int[][] board, int i, int j, int m, int n) {
    int[][] dirs = {
      { 0, 1 },
      { 0, -1 },
      { 1, 0 },
      { -1, 0 },
      { -1, -1 },
      { 1, 1 },
      { -1, 1 },
      { 1, -1 },
    };
    int count = 0;
    for (int[] dir : dirs) {
      int r = i + dir[0];
      int c = j + dir[1];
      //Boundary check
      if (
        r >= 0 &&
        r < m &&
        c >= 0 &&
        c < n &&
        (board[r][c] == 1 || board[r][c] == 2)
      ) count++;
    }
    return count;
  }
}
