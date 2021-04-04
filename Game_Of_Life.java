// Concept - State Change - Initial State --> Intermediate state --> Result state

//Time Complexity - O(NxM) - where N is length of board, M is width of board
//Space Complexity - O(1)

// Conditions -
// 1 -> 0, less than 2 1s
// 1 -> 1, 2 or 3 1s
// 1 -> 0, more than 3 1s
// 0 -> 1, 3 1s

//In the intermediate state
// 1 -> 0, 2
// 0 -> 1, 3

// 0 2 0
// 3 0 1
// 2 1 1
// 0 3 0
class Solution {
  public void gameOfLife(int[][] board) {

    if(board == null || board.length == 0){
      return;
    }

    int m = board.length, n = board[0].length;

    for(int i=0; i<m; i++){
      for(int j=0; j<n; j++){

        int count = countOfLiveNeighbors(board, i, j);

        if(board[i][j] == 1 && (count < 2 || count > 3)){
          board[i][j] = 2;
        }
        else if(board[i][j] == 0 && count == 3){
          board[i][j] = 3;
        }
      }
    }


    for(int i=0; i<m; i++){
      for(int j=0; j<n; j++){

        if(board[i][j] == 2){
          board[i][j] = 0;
        }
        else if(board[i][j] == 3){
          board[i][j] = 1;
        }
      }
    }
  }

  public int countOfLiveNeighbors(int[][] board, int i, int j){

    int count = 0;

    int[][] dirs = new int[][]{{0,1}, {0, -1}, {-1, 0}, {1,0}, {-1,-1}, {-1,1}, {1,-1}, {1,1}};
    for(int[] dir: dirs){
      int r = dir[0]+i;
      int c = dir[1]+j;

      if(r >=0 && r < board.length && c>=0 && c< board[0].length && (board[r][c] == 1 || board[r][c] == 2)){
        count++;
      }
    }

    return count;

  }
}