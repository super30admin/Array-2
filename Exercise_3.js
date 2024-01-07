// Time Complexity : O(m * n) where m*n is matrix
// Space Complexity : O(1)
// Approach : counting live neighbours , modifying array on the basis of conditions, returning modified array


var gameOfLife = function (board) {
    const m = board.length;
    const n = board[0].length;

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            const liveN = countLiveNeighbours(board, i, j);
            if (board[i][j] == 1 && (liveN < 2 || liveN > 3)) {
                board[i][j] = 2;
            }
            if (board[i][j] == 0 && liveN === 3) {
                board[i][j] = 3;
            }
        }
    }

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (board[i][j] == 2) {
                board[i][j] = 0;
            }
            if (board[i][j] == 3) {
                board[i][j] = 1;
            }
        }
    }
    return board
};

function countLiveNeighbours(board, i, j) {
    let result = 0;
    const dirs = [[0, -1], [0, 1], [-1, 0], [1, 0], [-1, -1], [-1, 1], [1, 1], [1, -1]];
    for (const dir of dirs) {
        const nr = i + dir[0];
        const nc = j + dir[1];
        if (nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length
            && (board[nr][nc] === 1 || board[nr][nc] === 2)
        ) {
            result++;
        }
    }
    return result;
}