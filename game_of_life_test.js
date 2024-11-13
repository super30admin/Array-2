/**
 * @param {number[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
var gameOfLife = function (board) {
  const directions = [
    [-1, 0], // Top
    [1, 0], // Bottom
    [0, -1], // Left
    [0, 1], // Right
    [-1, -1], // Top Left
    [-1, 1], // Top Right
    [1, -1], // Bottom Left
    [1, 1], // Bottom Right
  ];

  for (let row = 0; row < board.length; row++) {
    for (let col = 0; col < board[row].length; col++) {
      let live_count = get_live_count(board, row, col, directions);
      if (board[row][col] == 0) {
        if (live_count == 3) {
          board[row][col] = 2; // Previously Dead -> Live
        }
      } else if (board[row][col] == 1) {
        if (live_count > 3 || live_count < 2) {
          board[row][col] = 3; // Previously Live -> Dead
        }
      }
    }
  }
};

var get_live_count = function (board, row, col, directions) {
  let live_count = 0;

  for (let direction in directions) {
    let nearRow = row + direction[0];
    let nearCol = col + direction[1];
    if (
      nearRow >= 0 &&
      nearRow < board.length &&
      nearCol >= 0 &&
      nearCol < board[0].length &&
      (board[nearRow][nearCol] == 1 || board[nearRow][nearCol] == 2)
    ) {
    }
  }
};
