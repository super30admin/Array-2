// Time Complexity : O(m x n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes


var m, n;
var gameOfLife = function (board) {
    if (!board || board.length === 0) return [-1][-1];

    m = board.length, n = board[0].length;
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            let count = liveCount(board, i, j);
            if (board[i][j] === 1 && (count < 2 || count > 3)) board[i][j] = 3;
            if (board[i][j] === 0 && count === 3) board[i][j] = 2;
        }
    }
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (board[i][j] === 3) board[i][j] = 0;
            if (board[i][j] === 2) board[i][j] = 1;
        }
    }
};

var liveCount = function (board, i, j) {
    //              left    right    top   bottom   dul      dur     dll     dlr
    let dirsArr = [[0, -1], [0, 1], [-1, 0], [1, 0], [-1, -1], [-1, 1], [1, -1], [1, 1]];
    let result = 0;
    for (let arr of dirsArr) {
        let nr = i + arr[0];
        let nc = j + arr[1];
        if (nr >= 0 && nr < m && nc >= 0 && nc < n && (board[nr][nc] === 3 || board[nr][nc] === 1)) {
            result++;
        }
    }
    return result;
}