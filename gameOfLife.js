// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


function gameOfLife(board) {
    if (board == null || board.length === 0) return;
  
    const h = board.length;
    const w = board[0].length;
  
    function liveNeighbors(x, y) {
      let lives = 0;
      for (let i = Math.max(x - 1, 0); i <= Math.min(x + 1, h - 1); i++) {
        for (let j = Math.max(y - 1, 0); j <= Math.min(y + 1, w - 1); j++) {
          lives += board[i][j] & 1;  // Get 1st bit
        }
      }
      lives -= board[x][y] & 1;  // subtract itself
      return lives;
    }
  
    for (let i = 0; i < h; i++) {
      for (let j = 0; j < w; j++) {
        const lives = liveNeighbors(i, j);
  
        // In the beginning, every 2nd bit is 0
        // So we only need to care about when will the 2nd bit become 1
        if (board[i][j] === 1 && lives >= 2 && lives <= 3) {
          board[i][j] = 0b11;  // Make the 2nd bit 1: 01 -> 11
        }
        if (board[i][j] === 0 && lives === 3) {
          board[i][j] = 0b10;  // Make the 2nd bit 1: 00 -> 10
        }
      }
    }
  
    for (let i = 0; i < h; i++) {
      for (let j = 0; j < w; j++) {
        board[i][j] >>= 1;  // Get the 2nd bit
      }
    }
  }