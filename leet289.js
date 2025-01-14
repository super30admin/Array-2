/**
 * Time complexity - O(M*N)
 * Space complexity - O(1)
 * @param {number[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
var gameOfLife = function(board) {
     let rows = board.length, cols = board[0].length
  let directions = [[1,-1],[1,0],[1,1],[0,-1],[0,1],[-1,-1],[-1,0],[-1,1]]

  for(let r=0;r<rows;r++){
      for(let c=0;c<cols;c++){
          let lives=0;
          for(let dir of directions){
              if (dir[0] + r < 0 || dir [0] + r >= rows || dir[1] + c < 0 || dir[1] + c >= cols) continue; // if out of bounds
              if (board[dir[0] + r][dir[1] + c] == 1 || board[dir[0] + r][dir[1] + c] == 2) lives++;
          }
          if(board[r][c] == 0 && lives == 3) board[r][c] = 3;
          if(board[r][c] == 1 && (lives < 2 || lives > 3)) board[r][c] = 2;
      }
  }
  
  for(let i=0;i<rows;i++){
      for(let j=0;j<cols;j++){
          board[i][j] %= 2;
      }
  }
};