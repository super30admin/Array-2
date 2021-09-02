// Time Complexity : O(mn)  m=number of rows n=number of columns
// Space Complexity :O(1)   
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


class Solution {
	public void gameOfLife(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				int count = count(i, j, board);
				if (board[i][j] == 0 && count == 3) {
					board[i][j] = 2;
				}
				if (board[i][j] == 1 && (count > 3 || count < 2)) {
					board[i][j] = 3;
				}
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 3) {
					board[i][j] = 0;
				}
				if (board[i][j] == 2) {
					board[i][j] = 1;
				}
			}
		}
	}

	// 1-0=3 0-1=2
	int count(int i, int j, int[][] brd) {
		int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } };
		int count = 0;
		for (int[] dir : dirs) {
			int ni = i + dir[0];
			int nj = j + dir[1];
			if (ni >= 0 && ni <= brd.length-1 && nj >= 0 && nj <= brd[0].length-1 && (brd[ni][nj] == 1 || brd[ni][nj] == 3)) {
				count++;
			}
		}
		return count;
	}
}