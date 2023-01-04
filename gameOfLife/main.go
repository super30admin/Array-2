package main

/*

0 = dead
1 = live

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

Given the current state of the m x n grid board, return the next state.


Approach 1:
- Simulate the above rules with its immediate neighbours in a new mxn matrix
- Return the new matrix
- Time: o(mn)
- Space: o(mn)


Approach 2:
- Simulate the above rules with its immediate neighbours but mutate the same matrix
- But we will lose a cells previous state by doing that, which leads to side effects for other cells ( wrong answers )
- Then we can come up with a new standard of marking a cell dead or alive in a way it can tell its previous state/history
    - when changing 1 -> 0; we will temporarily use the value 2 ( previously alive )
    - when changing 0 -> 1; we will temporarily use the value 3 ( prevously dead )
    - so now to search for live neighbors, we need to consider 1 and 2 ( newely dead but previously alive )

*/
func gameOfLife(board [][]int) {
	m := len(board)
	n := len(board[0])

	// when changing 1 -> 0; we will temporarily use the value 2 ( previously alive )
	// when changing 0 -> 1; we will temporarily use the value 3 ( prevously dead )
	// so now to search for live neighbors, we need to consider 1 and 2 ( newely dead but previously alive )
	dirs := [][]int{{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {-1, -1}, {1, -1}, {-1, 1}, {1, 1}}

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {

			aliveCount := 0
			for _, dir := range dirs {
				r := i + dir[0]
				c := j + dir[1]
				if r >= 0 && r < m && c >= 0 && c < n && (board[r][c] == 1 || board[r][c] == 2) {
					aliveCount++
				}
			}

			if board[i][j] == 1 {
				if aliveCount < 2 || aliveCount > 3 {
					board[i][j] = 2
				}
			}
			if board[i][j] == 0 {
				if aliveCount == 3 {
					board[i][j] = 3
				}
			}
		}
	}

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if board[i][j] == 3 {
				board[i][j] = 1
			}
			if board[i][j] == 2 {
				board[i][j] = 0
			}
		}
	}

}
