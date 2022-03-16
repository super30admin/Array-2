// Time Complexity : O(m*n) where m is board.length and n is board[i].length
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * @param {number[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
 let m, n, dirs;
 var countLiveCells = function(board, i, j) {
     let result = 0;
     for(let dir of dirs) {
         let r = i + dir[0];
         let c = j + dir[1];
         if(r < m && r >= 0 && c < n && c >= 0 && (board[r][c] === 1 || board[r][c] === 2)) {
             result++;
         }
     }
     return result;
 }
 
 var gameOfLife = function(board) {
     m = board.length; //4
     n = board[0].length; //3
     dirs = [[0,1],[0,-1],[1,0],[-1,0],[-1,-1],[-1,1],[1,1],[1,-1]];
     
     for(let i=0; i<m; i++) {
         for(let j=0; j<n; j++) {
             // Counting the number of live cells
             let count = countLiveCells(board, i, j);
             
             //if live cell has less than 2 or greater than 3 neighbour, make it dead
             if(board[i][j] === 1 && (count < 2 || count > 3)) board[i][j] = 2;
             
             //if dead cell has exactly 3 neighbour, make it alive
             if(board[i][j] === 0 && count === 3) board[i][j] = 3;
         }
     }
     
     for(let i=0; i<m; i++) {
         for(let j=0; j<n; j++) {
             if(board[i][j] === 2) board[i][j] = 0;
             if(board[i][j] === 3) board[i][j] = 1;
         }
     }
 };