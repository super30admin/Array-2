// Time Complexity : O (m * n)
// Space Complexity : O (1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Logic: Mutate the board of live cells with 2 and dead with 3, and as per the games rules

/**
 * @param {number[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */

var m, n;
var gameOfLife = function(board) {
  if (board === null || board.length === 0) return;

  m = board.length;
  n = board[0].length;

  //Game rules
  //1: Live cell || Becomes Dead if <2 live neighbours : 2<= live <=3 :  >3
  //0: Dead Cell || Becomes Live if ===3 live neighbours

  for (var i = 0; i < m; i++) {
    for (var j = 0; j < n; j++) {
      var count = countLive(board, i, j);
      if (board[i][j] === 1) {
        if (count < 2 || count > 3) {
          board[i][j] = 2;
        }
      } else {
        if (count === 3) {
          board[i][j] = 3;
        }
      }
    }
  }

  for (var i = 0; i < m; i++) {
    for (var j = 0; j < n; j++) {
      if (board[i][j] === 2) {
        board[i][j] = 0;
      } else {
        if (board[i][j] === 3) {
          board[i][j] = 1;
        }
      }
    }
  }
};

var countLive = function(board, i, j) {
  var count = 0;
  //i , j : 0  0
  var dir = [
    [-1, 0],
    [1, 0],
    [0, -1],
    [0, 1],
    [-1, -1],
    [-1, 1],
    [1, -1],
    [1, 1]
  ];

  for (var d = 0; d < dir.length; d++) {
    // console.log(dir[d][0], dir[d][1])
    var nr = i + dir[d][0];
    var nc = j + dir[d][1];
    // console.log(nr, nc, m ,n ,board[nr][nc], board[nr][nc])
    if (
      nr >= 0 &&
      nc >= 0 &&
      nr < m &&
      nc < n &&
      (board[nr][nc] === 1 || board[nr][nc] === 2)
    ) {
      count++;
    }
  }
  return count;
};
