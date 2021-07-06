// Time Complexity : O(m*n), m * n -> Number of elements
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem3;

public class GameOfLife {
	private int getLiveNeighborCount(int row, int col, int[][] board) {
		int cnt = 0;
		int[][] dirs = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };
		for (int[] dir : dirs) {
			int r = row + dir[0];
			int c = col + dir[1];
			if (r >= 0 && c >= 0 && r < board.length && c < board[0].length && Math.abs(board[r][c]) == 1) {
				cnt += 1;
			}
		}
		return cnt;
	}

	public void gameOfLife(int[][] board) {
		if (board == null || board.length == 0) {
			return;
		}

		int m = board.length;
		int n = board[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int liveNeighbors = getLiveNeighborCount(i, j, board);
				if (board[i][j] == 1) {
					if (liveNeighbors < 2 || liveNeighbors > 3) {
						board[i][j] = -1;
					} else if (liveNeighbors == 2 || liveNeighbors == 3) {
						board[i][j] = 1;
					}
				} else {
					if (liveNeighbors == 3) {
						board[i][j] = 2;
					}
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] > 0) {
					board[i][j] = 1;
				} else {
					board[i][j] = 0;
				}
			}
		}

	}

	public static void main(String[] args) {
		GameOfLife obj = new GameOfLife();
		int[][] board = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
		System.out.println("Previous Generation Board:");
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

		obj.gameOfLife(board);
		System.out.println("Next Generation Board:");
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

}
