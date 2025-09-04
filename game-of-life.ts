// Time complexity - O(m*n)
// Space complexity - O(1)
function gameOfLife(board: number[][]): void {
	const m = board.length;
	const n = board[0].length;

	// first pass to apply rules and mark cells for change
	for (let i = 0; i < m; i++) {
		for (let j = 0; j < n; j++) {
			const aliveCount = countAlive(board, i, j);

			// rule 1 & 3: alive cell dies if it has fewer than two or more than three alive neighbors
			if (board[i][j] === 1 && (aliveCount < 2 || aliveCount > 3)) {
				board[i][j] = 2; // mark as alive -> dead
			}
			// rule 4: dead cell becomes alive if it has exactly three alive neighbors
			else if (board[i][j] === 0 && aliveCount === 3) {
				board[i][j] = 3; // mark as dead -> alive
			}
		}
	}

	// second pass to finalize the state changes
	for (let i = 0; i < m; i++) {
		for (let j = 0; j < n; j++) {
			if (board[i][j] === 2) {
				board[i][j] = 0; // set to dead
			} else if (board[i][j] === 3) {
				board[i][j] = 1; // set to alive
			}
		}
	}
}

function countAlive(board: number[][], i: number, j: number): number {
	const dirs = [
		[-1, -1],
		[-1, 0],
		[-1, 1],
		[0, -1],
		[0, 1],
		[1, -1],
		[1, 0],
		[1, 1],
	];
	let count = 0;

	for (const dir of dirs) {
		const r = i + dir[0];
		const c = j + dir[1];

		if (r >= 0 && c >= 0 && r < board.length && c < board[0].length) {
			// count neighbors that are currently alive (1) or were alive and will die (2)
			if (board[r][c] === 1 || board[r][c] === 2) {
				count++;
			}
		}
	}

	return count;
}
