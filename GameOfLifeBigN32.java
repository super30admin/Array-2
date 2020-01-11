//Time complexity is o(row*column) i.e O(N) as we are iterating through the entire matrix
//Space complexity is O(1) as we are not using any extra space
//This code is submitted on leetcode

public class GameOfLifeBigN32 {
	private int row;
	private int column;

	public void gameOfLife(int[][] board) {
		row = board.length;
		column = board[0].length;
		// edge case
		if (board == null || row == 0)
			return;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				int count = countLive(board, i, j);
				if (board[i][j] == 1 && (count < 2 || count > 3)) {
					board[i][j] = -1;
				}
				if (board[i][j] == 0 && (count == 3)) {
					board[i][j] = 2;
				}
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (board[i][j] == -1) {
					board[i][j] = 0;
				}
				if (board[i][j] == 2) {
					board[i][j] = 1;
				}

			}
		}
	}

	private int countLive(int[][] matrix, int i, int j) {
		int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };
		int count = 0;
		for (int[] dir : dirs) {
			int r = i + dir[0];
			int c = j + dir[1];
			if (r >= 0 && r < row && c >= 0 && c < column) {
				if (matrix[r][c] == 1 || matrix[r][c] == -1) {
					count++;
				}
			}
		}
		return count;
	}

}
