public class GameOfLife {
  /**
   * 
   * Game of Life problem: https://leetcode.com/problems/game-of-life/
   * 
   * Time Complexity: O(m * n) -> time taken to iterate over the entire board.
   * Space Complexity: O(1)
   * 
   * Were you able to solve this on leetcode? Yes
   * Any issues solving this? No
   */

  public void gameOfLife(int[][] board) {
    int m = board.length;
    int n = board[0].length;
    
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            int neighCount = countNeighbors(board, i, j);
            
            if(board[i][j] == 1 && (neighCount < 2 || neighCount > 3)){
                board[i][j] = 2; // represent dead as 2 so we don't effect the current state transition calculation.
            } else if (board[i][j] == 0 && neighCount == 3){
                board[i][j] = 3; // represent alive as 3 so we don't effect the current state transition calculation.
            }
        }
    }
    
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            if(board[i][j] == 2){
                board[i][j] = 0;
            } else if (board[i][j] == 3){
                board[i][j] = 1;
            }
        }
    }
  }

  int countNeighbors(int[][] board, int x, int y){
      int [][] dirs = new int[][]{{-1,0}, {-1,-1}, {-1, 1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};
      
      int result = 0;
      for(int[] dir : dirs){
          int new_x = dir[0] + x;
          int new_y = dir[1] + y;
          
          if(new_x >=0 && new_y >=0 && new_x < board.length && new_y < board[0].length && (board[new_x][new_y] == 2 || board[new_x][new_y] == 1)){
              result++;
          }
      }
      
      return result;
  }
}
