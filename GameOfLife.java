// Time Complexity : O(n*2). n is the length of the array
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

class Solution {
    private final static int allDirections[][] = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 },
			{ 1, 0 }, { 1, 1 } };
    public void gameOfLife(int[][] board) {

		if (board == null || board.length == 0)
			return;

		int rowLength = board.length;
		int columnLength = board[0].length;

		for (int rows = 0; rows < rowLength; rows++) {
			for (int columns = 0; columns < columnLength; columns++) {
				if (board[rows][columns] == 0) {
					int livesCount = livesCount(board, rows, columns);
					if (livesCount == 3)
						board[rows][columns] = 2; // dead to live is 2
					// else we are not changing which means 1 will be 1 or
					// 0 will be 0

				} else if (board[rows][columns] == 1) {

					int livesCount = livesCount(board, rows, columns);
					if (livesCount < 2 || livesCount > 3)
						board[rows][columns] = 3; // live to dead is 3
					// else we are not changing which means 1 will be 1 or
					// 0 will be 0
				}
			}
		}

		updateTheBoardwithbinary(board);

	}

	private void updateTheBoardwithbinary(int[][] board) {
		for (int rows = 0; rows < board.length; rows++) {
			for (int columns = 0; columns < board[0].length; columns++) {
				if (board[rows][columns] == 2)
					board[rows][columns] = 1;
				else if (board[rows][columns] == 3)
					board[rows][columns] = 0;
			}
		}

	}

	private int livesCount(int[][] board, int rows, int columns) {
		int livesCount = 0;
		for (int[] direction : allDirections) {
			
			  int updatedRow = rows + direction[0]; 
			  int updatedColumn = columns + direction[1];
			 

			if (updatedRow >= 0 && updatedRow < board.length && 
					updatedColumn >= 0
					&& updatedColumn < board[0].length
					&& (board[updatedRow][updatedColumn] == 1
					|| board[updatedRow][updatedColumn] == 3)) {
				livesCount++;
			}
		}
		return livesCount;
	}
}
