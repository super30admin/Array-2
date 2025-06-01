// ## Problem2
// Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison

// ## Problem3 (https://leetcode.com/problems/game-of-life/)

// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : 0 to 4 , 1 to 5 was very confusing

/**
 * @param {number[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
var gameOfLife = function(board) {
        //**Time Complexity: O(N X M) */
    //**Space Complexity: O(1) */
    for(let i =0;i<board.length;i++)
    for(let j=0;j<board[0].length;j++){
        //4 = 0 = dead
        //5 = 1 = alive
        const aliveNeighbors = checkAlive(board, i, j);
        if( board[i][j]==1  && aliveNeighbors < 2){
            board[i][j] = 4
        }
        else if( board[i][j]==1 && aliveNeighbors > 3){
            board[i][j] = 4
        }
        else if( board[i][j]==0 && aliveNeighbors == 3){
            board[i][j] = 5
        }

    }  

    function checkAlive(board,i,j){
    let aliveCount = 0
    let direction = [[-1,-1],[-1,0],[-1,1],[0,-1],[0,1],[1,1],[1,0],[1,-1]]
    for(let [dr,dc] of direction){
        let nr = i+dr
        let nc = j+dc
        //check bounds
        if(nr >=0 && nc >= 0 && nr < board.length && nc < board[0].length && (board[nr][nc] == 1 || board[nr][nc] == 4) ){
            aliveCount+=1
        }
    }
    return aliveCount
    }

    for(let i=0;i<board.length;i++){
        for(let j=0;j<board[0].length;j++){
            if(board[i][j]===4){
                board[i][j]=0
            }
            else if(board[i][j]===5){
                board[i][j]=1
            }
        }
        //Back to old values
    }
    return board
};