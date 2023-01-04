package main

import "fmt"

// https://leetcode.com/problems/game-of-life/

/*


For state change going to use a temp state
- 3 will ne new dead : all 0 will be changed to 3
- 2 will be new alive = all 1 change to 2 in first pass

*/

// Time : O(mXn) + O(mXn) = 2xO(mXn)
// Space : O(1)
func gameOfLife(board [][]int) {
	// need a matrix to store mutated matrix
	matrix := make([][]int, len(board))
	for i := 0; i < len(matrix); i++ {
		matrix[i] = make([]int, len(board[i]))
	}

	// dirs array
	dirs := [][]int{
		//r,c // 0,1
		{-1, -1},
		{-1, 0},
		{-1, 1},
		{0, -1},
		{0, 1},
		{1, -1},
		{1, 0},
		{1, 1},
	}
	fmt.Println(dirs)

	var livingCount int

	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board[0]); j++ {
			fmt.Println("i,j", i, j)
			livingCount = 0
			// need to check all neighbours
			for _, v := range dirs {
				r := i + v[0]
				c := j + v[1]
				// need the bound check
				if (c >= 0 && c <= len(board[0])-1) && (r >= 0 && r <= len(board)-1) {
					if board[r][c] == 1 || board[r][c] == 3 {
						livingCount++
					}
				}
			}
			fmt.Println("i,j,alive", i, j, livingCount)
			if board[i][j] == 1 && (livingCount < 2 || livingCount > 3) {
				board[i][j] = 3 //dies
			}

			if board[i][j] == 1 && (livingCount == 2 || livingCount == 3) {
				//matrix[i][j] = 1 // lives
				board[i][j] = 1 // state remains the same based on given condition
			}
			if board[i][j] == 0 && livingCount == 3 {
				board[i][j] = 2 // lives
			}
		}
	}
	//change state again
	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board[0]); j++ {
			if board[i][j] == 3 {
				board[i][j] = 0
			} else if board[i][j] == 2 {
				board[i][j] = 1
			}
		}
	}
}
