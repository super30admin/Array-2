//TC - O(m*n)
//SC - O(1)
public class GameOfLife {
	static int[][] direction;

	public static void gameOfLife(int[][] board) {
		direction = new int[][] { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 }, { -1, -1 }, { -1, 1 }, { 1, -1 },
				{ 1, 1 } };
		int row = board.length;
		int column = board[0].length;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				int alive = countAlive(board, i, j);

				if (board[i][j] == 1 & (alive < 2 || alive > 3)) {
					board[i][j] = -1; // dies
				}
				else if (board[i][j] == 0 & alive == 3) {
					board[i][j] = -2; // live
				}
			}
		}                                                                                                   

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (board[i][j] == -1)
					board[i][j] = 0;
				else if (board[i][j] == -2)
					board[i][j] = 1;
			}
		}
	}

	private static int countAlive(int[][] board, int i, int j) {
		int count = 0;
		for (int[] dir : direction) {
			int newRow = i + dir[0];
			int newCol = j + dir[1];
			if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length
					&& (board[newRow][newCol] == 1 || board[newRow][newCol] == -1))
				count++;
		}
		return count;
	}

	public static void main(String[] args) {
		int[][] board = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
		gameOfLife(board);
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println(" ");
		}
			}
	}


