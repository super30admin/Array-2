// ## Problem3 

// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

// (https://leetcode.com/problems/game-of-life/)


// 0 -> 1 === 7
// 1 -> 0 === 8  
function gameOfLife(board) {
    if(board.length === 0 || !board) return [];
    let m = board.length, n = board[0].length;
    for(let i = 0; i<m; i++) {
        for(let j = 0; j<n; j++) {
            let livingCount = countLives(board, i, j, m, n);
            // rule 1 and 3
            if(board[i][j] === 1) {
                if(livingCount < 2 || livingCount > 3) {
                    board[i][j] = 8;
                } 
            }
            else {
                if(livingCount === 3) board[i][j] = 7;
            }
        }
    }
    for(let i = 0; i<m; i++) {
        for(let j = 0; j<n; j++) {
            if(board[i][j] === 7) board[i][j] = 1;
            if (board[i][j] === 8) board[i][j] = 0;
        }
    }
}

function countLives(board, i, j, m, n) {
    let directions = [[0,1],[0,-1],[-1,0],[1,0],[-1,-1],[1,-1],[-1,1],[1,1]];
    let count = 0;
    for(let dir of directions) {
        let r = i + dir[0];
        let c = j + dir[1];
        if(r >= 0 && c >= 0 && r < m && c < n && (board[r][c] === 1 || board[r][c] === 8)) {
            count++;
        }
    }
    return count;
}

