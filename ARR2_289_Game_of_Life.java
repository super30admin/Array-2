/**** Method 1 ****/
//Time Complexity: O(n^2)
//Space Complexity: O(1)

//Successfully submitted in LeetCode

//Traverse the arr, and at each index find the count of 1's if it is already 1 and count <2 or >3 then change it's value to 2 as we if alter it to "0" we may lose the state for others,else if is "0" and count is 3 we update the board value to 3. Later we convert all the 2 to 0 and 3 to 1 by traversing.

public class ARR2_289_Game_of_Life {

  public void gameOfLife(int[][] board) {
    //1 --> 0 : 2
    //0 --> 1 : 3

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        int count = count1s(board, i, j);
        if (board[i][j] == 1) {
          if (count < 2 || count > 3) {
            board[i][j] = 2;
          }
        } else {
          if (count == 3) {
            board[i][j] = 3;
          }
        }
      }
    }

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == 2) board[i][j] = 0;
        if (board[i][j] == 3) board[i][j] = 1;
      }
    }
  }

  public int count1s(int[][] board, int i, int j) {
    int count = 0;

    int mat[][] = {
      { -1, -1 },
      { -1, 0 },
      { -1, 1 },
      { 0, -1 },
      { 0, 1 },
      { 1, -1 },
      { 1, 0 },
      { 1, 1 },
    };

    for (int k = 0; k < mat.length; k++) {
      int x = i + mat[k][0];
      int y = j + mat[k][1];
      if (x >= 0 && x < board.length && y >= 0 && y < board[i].length) {
        if (board[x][y] == 1 || board[x][y] == 2) {
          count++;
        }
      }
    }

    return count;
  }
}
