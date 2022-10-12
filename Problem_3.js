// Time Complexity : O(mn); m is the rows and n is the columns
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 


// Your code here along with comments explaining your approach
/*
    If live(1), live neighbors < 2 OR live neighbors > 3    ===> becomes dead(0)
    If dead(0), live neighbors === 3                        ===> becomes alive(1)
    When changing:
    1-->0   ====> 2 was alive, now dead 
    0-->1   ====> 3 was dead, now alive
    
    We check all directions and count live neighbors
*/

var getLiveNeighbors = (board, i, j) => {
    // All 8 neighbor directions
    let dirs = [[0, 1], [0, -1], [-1, 0], [1, 0], [-1, 1], [-1, -1], [1, -1], [1, 1]];
    let count = 0;
    dirs.map(dir => {
        let nr = i + dir[0];
        let nc = j + dir[1];
        if (nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length && (board[nr][nc] === 1 || board[nr][nc] === 2)) {
            count++;
        }
    });
    return count;
}
/**
 * @param {number[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
var gameOfLife = function (board) {
    if (board === null || board.length === 0)
        return;
    let rows = board.length;
    let cols = board[0].length;
    for (let i = 0; i < rows; i++) {
        for (j = 0; j < cols; j++) {
            let liveNeighbors = getLiveNeighbors(board, i, j);
            if (board[i][j] === 0) { // Is dead
                if (liveNeighbors === 3) {
                    board[i][j] = 3;
                }
            } else { // is alive
                if (liveNeighbors < 2 || liveNeighbors > 3) {
                    board[i][j] = 2;
                }
            }
        }
    }
    for (let i = 0; i < rows; i++) {
        for (j = 0; j < cols; j++) {
            if (board[i][j] === 2) {
                board[i][j] = 0;
            } else if (board[i][j] === 3) {
                board[i][j] = 1;
            }
        }
    }
};