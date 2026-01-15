/**
 * @param {number[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
Inuition:

The key idea is to update the board in-place without losing the original state needed to count neighbors.

First scan each cell and determine its fate based on its live neighbors. Instead of changing 1 → 0 or 0 → 1 immediately, we temporarily mark transitions ('Y' for 1→0 and 'X' for 0→1).This allows us to still correctly count original live neighbors while processing the board. 

After the first pass, we do a second pass to finalize the state by converting 'Y'to 0 and'X'` to 1. This ensures the rules of the Game of Life are applied correctly using only constant extra space.
 */
var gameOfLife = function (board) {
    const m = board.length;
    const n = board[0].length;
    // 8 directions
    const directions = [
        [0, -1], [0, 1], [1, 0], [-1, 0],
        [1, 1], [-1, -1], [1, -1], [-1, 1]
    ];

    const getNeighborCount = (row, col) => {
        let count = 0;
        for (let [rowAdd, colAdd] of directions) {
            const newRow = row + rowAdd;
            const newCol = col + colAdd;
            if (newRow < 0 || newCol < 0 || newRow >= m || newCol >= n) continue;
            if (board[newRow][newCol] === 1 || board[newRow][newCol] === 'Y') count++;
        }
        return count;
    }

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            // get the live neighbors count
            const count = getNeighborCount(i, j);
            // if 0 turns to 1, mark it as X else Y
            if (board[i][j] === 1) {
                // dies by over and under population
                if (count < 2 || count > 3) board[i][j] = 'Y'; // 1-> 0
            } else if (board[i][j] === 0) {
                if (count === 3) board[i][j] = 'X'; // 0 -> 1
            }

        }
    }

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (board[i][j] === 'Y') board[i][j] = 0;
            else if (board[i][j] === 'X') board[i][j] = 1;
        }
    }
    return board;
};