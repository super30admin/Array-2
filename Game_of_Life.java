// Time Complexity : O(M*N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

class Game_of_Life {
	int m;
	int n;

	/*
	 * This function first checks the edge cases and then is responsible for
	 * producing the correct mutated array
	 */
	public void gameOfLife(int[][] board) {
		if (board == null || board.length == 0) {
			return;
		}
		m = board.length;
		n = board[0].length;
		// 1 --->0 = 3
		// 0 --->1 = 2
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int lives = count_lives(board, i, j);
				if (board[i][j] == 1) {
					// Condition 1 and 3 is checked
					if (lives > 3 || lives < 2) {
						board[i][j] = 3;
					}
				} else {
					// Condition 4 is checked
					if (lives == 3) {
						board[i][j] = 2;
					}
				}
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 3) {
					board[i][j] = 0;
				}
				if (board[i][j] == 2) {
					board[i][j] = 1;
				}
			}
		}
	}

	/*
	 * This function uses a 2D dir array which is used to explore all the 8 paths of
	 * the current element we are at. It then counts the number of neighboring 1's
	 * at each element and increments the count
	 */
	private int count_lives(int[][] board, int i, int j) {
		int count = 0;
		int dirs[][] = { { 0, 1 }, { 1, 0 }, { -1, -1 }, { 1, 1 }, { 0, -1 }, { -1, 0 }, { 1, -1 }, { -1, 1 } };
		for (int dir[] : dirs) {
			int r = i + dir[0];
			int c = j + dir[1];
			if (r < m && c < n && r >= 0 && c >= 0 && (board[r][c] == 1 || board[r][c] == 3)) {
				count++;
			}
		}
		return count;
	}
}