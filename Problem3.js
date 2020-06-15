//Game of Life (LC 289)

// Time Complexity : O(m x n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes

//Make numbers negative - marking them as visited if they are there and then push the missing numbers to result array

/**
 * @param {number[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
var gameOfLife = function(board) {
    if(board.length === 0 || board === null){
        return;
    }
    let row = board.length - 1;
    let col = board[0].length - 1;
    for(let i=0;i<=row;i++){
        for(let j=0;j<=col;j++){
            let lives = countLives(board,i,j);
            if(board[i][j] === 1){
                if(lives > 3 || lives < 2){
                    board[i][j] = 3
                }                
            } else{
                if(lives === 3){
                    board[i][j] = 2;    
                }
            }
        }
    }
     for(let i=0;i<=row;i++){
        for(let j=0;j<=col;j++){
            if(board[i][j] === 3){
                board[i][j] = 0;
            }
            if(board[i][j] === 2){
                board[i][j] = 1;
            }
        }
     }
};

let countLives = function(board, i, j){
    let dirs = [[0,-1],[0,1],[-1,0],[1,0],[1,-1],[1,1],[-1,1],[-1,-1]];
    let count = 0;
    for(let dir of dirs){
        let r = i + dir[0];
        let c = j + dir[1];
        if(r >= 0 && c >= 0 && r < board.length && c < board[0].length && 
           (board[r][c] === 1 || board[r][c] === 3)){
            count++;
        }
    }
    return count;
}