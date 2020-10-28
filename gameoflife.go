// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
loop through each element and first find the count of 1s around that element
if value should go from 0 to 1 set it to 3 and if should go from 1 to 0  set it to 2 if the lives match the conditions
loop through all elements again and set any 2 to 0 and any 3 to 1

to find lives check all neighbors if in range and value is either 1 or 2 increment lives
*/
package main

import "fmt"

func gameOfLife(board [][]int)  {
	fmt.Println(board)
	for i:=0;i<len(board);i++ {
		for j:=0;j<len(board[0]);j++{
			lives := neighborlives(board, i, j)
			//0->1 =3
			//1->0 =2
			if (board[i][j] == 1 || board[i][j] == 2) && (lives < 2 || lives > 3) {
				board[i][j] = 2
			}
			if (board[i][j] == 0 || board[i][j] == 3)  && lives == 3 {
				board[i][j] = 3
			}
		}
	}
	fmt.Println(board)
	for i:=0;i<len(board);i++ {
		for j:=0;j<len(board[0]);j++{
			if board[i][j] == 2 {
				board[i][j] = 0
			}
			if board[i][j] == 3 {
				board[i][j] = 1
			}
		}
	}
	fmt.Println(board)
}

func neighborlives(b [][]int, i, j int) int {
	count := 0
	dir := [][]int{{0,-1},{0,1},{-1,0},{1,0},{1,1},{1,-1},{-1,1},{-1,-1}}
	for k:=0;k<len(dir);k++ {
		x := i + dir[k][0]
		y := j + dir[k][1]
		if x>=0 && x<len(b) && y>=0 && y<len(b[0]) && (b[x][y] == 1 || b[x][y] == 2)  {
			count++
		}
	}
	return count
}

func MainGameOfLife() {
	gameOfLife([][]int {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}}) //expected [[0 0 0] [1 0 1] [0 1 1] [0 1 0]]
}
