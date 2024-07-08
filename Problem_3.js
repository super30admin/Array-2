https://leetcode.com/problems/game-of-life/
// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// To convert the state based on the given conditions, we need to first create an intermediate state to 
// not lose the previous state to continue further in the rows and cols. So we assign as follows:
// 2 -> when live state dies
// 3 -> when live state continues to live
// 4 -> when dead state comes alive
// While counting, we count the value 1 and previous state of 1 i.e. 2 or 3.
// Once we change all the cells to intermediate state, we change them to either 0 or 1 accordingly. 
/**
 * @param {number[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
var countBoardLives = function(board, i, j){
    let dirs = [[0,-1],[0,1],[-1,0],[-1,-1],[-1,1],[1,0],[1,-1],[1,1]];
    var count = 0;
    dirs.forEach((dir) => {
        let r = dir[0] + i;
        let c = dir[1] + j
        if((r>= 0 && r<board.length) && 
            (c>=0 && c<board[0].length) 
            && (board[r][c] == 1 || board[r][c] == 2 || board[r][c] == 3))
            count++;
    })
    return count;
}
var gameOfLife = function(board) {
    let rows = board.length;
    let cols = board[0].length;
    // Make an intermediate board of assignments using number assignment other than 0 or 1 to not lose previous state 
    for(let i=0; i<rows; i++){
        for(let j=0; j<cols; j++){
            let count = countBoardLives(board, i, j);
            if(board[i][j] == 1){
                // Previously live cell, now dead is assigned 2
                if(count < 2 || count > 3)
                    board[i][j] = 2;
                // Previously live cell, still live is assigned 3
                else if(count == 2 || count == 3)
                    board[i][j] = 3;
            }
            else if(board[i][j] == 0){
                // Previously dead cell, now live is assigned 4
                if(count == 3)
                    board[i][j] = 4;
            }
        }
    }
        // Reassign the intermediate assignments back to 0 and 1 
        for(let i=0; i<rows; i++){
            for(let j=0; j<cols; j++){
                if(board[i][j] == 2)
                    board[i][j] = 0
                else if(board[i][j] == 3 || board[i][j] == 4)
                    board[i][j] = 1
            }
        }
};