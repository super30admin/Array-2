package day11_Array2;

//Idea : 1. Make a copy of the board
//		 2. We iterate over the matrix till last element.
//		 3. Follow the rules of the games 
//Time Complexity : O(m*n) where n is the number of elements in given board matrix
//Space Complexity : O(m*n) for copy of matrix
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : no

public class GameOfLife {
	
	// method containing all the rules of the game
	public static int getNumberOfLiveNeighbours(int[][] board, int i, int j) {
		int count = 0;
		int m = board.length - 1;
		int n = board[0].length - 1;

		if (i > 0 && board[i - 1][j] == 1)
			count++;
		if (i < m && board[i + 1][j] == 1)
			count++;
		if (j > 0 && board[i][j - 1] == 1)
			count++;
		if (j < n && board[i][j + 1] == 1)
			count++;
		
		if (i > 0 && j > 0 && board[i - 1][j - 1] == 1)
			count++;
		if (i > 0 && j < n && board[i - 1][j + 1] == 1)
			count++;
		if (i < m && j < n && board[i + 1][j + 1] == 1)
			count++;
		if (i < m && j > 0 && board[i + 1][j - 1] == 1)
			count++;
		
		return count;
	}

	public static void gameOfLife(int[][] board) {
		int[][] resultBoard = new int[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				
				if (board[i][j] == 0) {
					int numberOfNeighbours = getNumberOfLiveNeighbours(board, i, j);
					if (numberOfNeighbours == 3) {
						resultBoard[i][j] = 1;
					}
				} else {
					int numberOfNeighbours = getNumberOfLiveNeighbours(board, i, j);
					if (numberOfNeighbours < 2 || numberOfNeighbours > 3) {
						resultBoard[i][j] = 0;
					} else {
						resultBoard[i][j] = 1;
					}
				}

			}
		}

		for (int i = 0; i < resultBoard.length; i++) {
			for (int j = 0; j < resultBoard[0].length; j++) {
				board[i][j] = resultBoard[i][j];
			}
		}
	}

}
