package main

var m, n int

func gameOfLife(board [][]int) {
	if len(board) == 0 {
		return
	}

	m = len(board)
	n = len(board[0])

	// consider 0 AND 2 as dead
	// consider 1 AND 3 as alive

	// first pass - calculate next state
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			liveNeighbors := getLiveNeighbors(board, i, j)
			if board[i][j] == 1 { // currently alive
				if liveNeighbors < 2 || liveNeighbors > 3 {
					board[i][j] = 2
				}
			} else if board[i][j] == 0 { // currently dead
				if liveNeighbors == 3 {
					board[i][j] = 3
				}
			}
		}
	}

	// second pass - revert values
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if board[i][j] == 2 {
				board[i][j] = 0
			} else if board[i][j] == 3 {
				board[i][j] = 1
			}
		}
	}
}

// add dir value to index of cell to get neighbor
var dir = [][]int{
	// m, n
	{-1, 0},  // up
	{1, 0},   // down
	{0, -1},  // left
	{0, 1},   // right
	{-1, 1},  // up right
	{1, 1},   // down right
	{1, -1},  // down left
	{-1, -1}, // up left
}

func getLiveNeighbors(board [][]int, i, j int) int {
	alive := 0
	for _, d := range dir {
		if i+d[0] >= 0 && i+d[0] < m && j+d[1] >= 0 && j+d[1] < n &&
			(board[i+d[0]][j+d[1]] == 1 || board[i+d[0]][j+d[1]] == 2) {
			// it's 1 and 2 because 1 means cell has not changed
			// and 2 means earlier it was a 1
			alive++
		}
	}

	return alive
}
