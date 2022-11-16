// Problem 2: Leetcode 289 - Game of Life
// Time Complexity : O(mxn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

const gameOfLife = (board) => {
  if (!board.length) return;
  let m = board.length;
  let n = board[0].length;

  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      let count = countLive(board, i, j, m, n);
      if (board[i][j] === 1) {
        if (count < 2 || count > 3) {
          board[i][j] = 2; // assign 2 for live --> dead
        }
      } else {
        if (count === 3) {
          board[i][j] = 3; // assign 3 for dead --> live
        }
      }
    }
  }

  // assign 0 and 1 for dead and live cells respectively

  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      if (board[i][j] === 2) {
        board[i][j] = 0;
      } else if (board[i][j] === 3) {
        board[i][j] = 1;
      }
    }
  }
};

// function to get count of cell

const countLive = (board, r, c, m, n) => {
  let count = 0;
  // directions array
  const dirs = [
    [-1, 0],
    [-1, 1],
    [0, 1],
    [1, 1],
    [1, 0],
    [1, -1],
    [0, -1],
    [-1, -1],
  ]; // U, UR, R, LR, D, LL, L, UL
  for (dir of dirs) {
    let nr = r + dir[0];
    let nc = c + dir[1];
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
