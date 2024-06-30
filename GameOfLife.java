// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
class Solution {
  int m = 0, n = 0;
  public void gameOfLife(int[][] board) {
    m = board.length;
    n = board[0].length;
    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        int liveNeighbours = countLiveNeighbours(board, i, j);
        // If the cell is live
        if(board[i][j]==1) {
          if(liveNeighbours<2 || liveNeighbours>3){
            board[i][j] = 2; // Live cell changing to dead.
          }
         // If the cell is dead
        }else {
          if(liveNeighbours == 3) board[i][j] = 3; // Dead cell changing to live cell.
        }
      }
    }
    // Changing all 2 to 0 and 3 to 1 in the matrix.
    for(int i = 0; i<m; i++) {
      for(int j = 0; j<n; j++) {
        if(board[i][j]==2) board[i][j] = 0;
        else if(board[i][j]==3) board[i][j] = 1;
      }
    }
  }

  // Count the number of live neighbours for each cell.
  public int countLiveNeighbours(int[][] board, int row, int col) {
    int count = 0;
    // Using a direction array to traverse through all the 8 neighbours
    int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}, {-1,1}, {1,-1}, {-1,-1}, {1,1}};
    for(int[] dir: dirs) {
      int newRow = row + dir[0];
      int newCol = col + dir[1];
      if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && (board[newRow][newCol]==1 || board[newRow][newCol]==2)) {
        count++;
      }
    }
    return count;
  }
}