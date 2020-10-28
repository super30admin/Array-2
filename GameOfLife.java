
public class GameOfLife {
	public void gameOfLife(int[][] board) {
		if (board == null || board.length == 0)
			return;

		int row = board.length;
		int col = board[0].length;
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int lives = countNeighbors(board, i, j);
				if (board[i][j] == 1 && (lives < 2 || lives > 3)) {
					board[i][j] = 2;
				}

				if (board[i][j] == 0 && (lives == 3)) {
					board[i][j] = 3;

				}
			}
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (board[i][j] == 3) { // 0 --> 1  3
					board[i][j] = 1; 

				}
				if (board[i][j] == 2) {// 1---> 0  2
					board[i][j] = 0;

				}
			}
		}

	}

	public int countNeighbors(int[][] board, int row, int col) {
		int count = 0;
		int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, 1 }, { 1, 1 }, { -1, -1 }, { 1, -1 } };
		for (int[] direction : dirs) {
			int nr = row + direction[0];
			int nc = col + direction[1];
			if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length
					&& (board[nr][nc] == 1 || board[nr][nc] == 2)) {
				count++;
			}
		}

		return count;
	}
}
