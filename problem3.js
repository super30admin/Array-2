//// Time Complexity : O(NxM) we go through each board position
//// Space Complexity : O(1) we are reusing the input space, no additional space
//// Did this code successfully run on Leetcode : yes
//// Any problem you faced while coding this :
// none

//// Your code here along with comments explaining your approach

// Go through the input array twice
// One time generating alive and dead state, storing it in the same input storage
// Second time to convert the state from holding 2 states to just the current 1 state
// return the state
var ALIVE, ALIVE_THEN_DEAD, DEAD, DEAD_THEN_ALIVE, countAlive, gameOfLife;

ALIVE = 1;

DEAD = 0;

ALIVE_THEN_DEAD = 2;

DEAD_THEN_ALIVE = 4;

countAlive = function(board, n, m, i, j) {
  var c, count, dir, dirs, k, len, r;
  count = 0;
  dirs = [[1, -1], [1, 0], [1, 1], [0, -1], [0, 1], [-1, -1], [-1, 0], [-1, 1]];
  for (k = 0, len = dirs.length; k < len; k++) {
    dir = dirs[k];
    r = i + dir[0];
    c = j + dir[1];
    if ((n > r && r >= 0) && (m > c && c >= 0) && (board[r][c] === ALIVE || board[r][c] === ALIVE_THEN_DEAD)) {
      count += 1;
    }
  }
  return count;
};

gameOfLife = function(board) {
  var alive, i, j, k, l, m, n, o, p, ref, ref1, ref2, ref3;
  if (board === null || board.length === 0 || board[0].length === 0) {
    return;
  }
  n = board.length;
  m = board[0].length;
  for (i = k = 0, ref = n; (0 <= ref ? k < ref : k > ref); i = 0 <= ref ? ++k : --k) {
    for (j = l = 0, ref1 = m; (0 <= ref1 ? l < ref1 : l > ref1); j = 0 <= ref1 ? ++l : --l) {
      alive = countAlive(board, n, m, i, j);
      if (board[i][j] === ALIVE && (alive < 2 || alive > 3)) {
        board[i][j] = ALIVE_THEN_DEAD;
      } else if (board[i][j] === DEAD && alive === 3) {
        board[i][j] = DEAD_THEN_ALIVE;
      }
    }
  }
// change board
  for (i = o = 0, ref2 = n; (0 <= ref2 ? o < ref2 : o > ref2); i = 0 <= ref2 ? ++o : --o) {
    for (j = p = 0, ref3 = m; (0 <= ref3 ? p < ref3 : p > ref3); j = 0 <= ref3 ? ++p : --p) {
      if (board[i][j] === ALIVE_THEN_DEAD) {
        board[i][j] = DEAD;
      } else if (board[i][j] === DEAD_THEN_ALIVE) {
        board[i][j] = ALIVE;
      }
    }
  }
  return board;
};

gameOfLife([[0, 1, 0], [0, 0, 1], [1, 1, 1], [0, 0, 0]]);

//# sourceMappingURL=problem3.js.map
