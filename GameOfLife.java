// Time Complexity : O(MN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

/**
 * Iterate over each index, check the 8 neighbors. If the count is < 2 or > 3
 * then mark that index as -1 which mean 1 has become 0 in future step. If == 3,
 * then make the 0 in that index to 2 if not 1 already. Then iterate over the matrix
 * and update the -1s to 0 and 2s to 1.
 *
 */
class Solution {
	public void gameOfLife(int[][] board) {
		int[] x8 = { -1, -1, 0, 1, 1, 1, 0, -1 };
		int[] y8 = { 0, 1, 1, 1, 0, -1, -1, -1 };

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				int count = 0;
				for (int t = 0; t < 8; t++) {
					int x = i + x8[t];
					int y = j + y8[t];
					if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && Math.abs(board[x][y]) == 1) {
						count++;
					}
				}
				if ((count < 2 || count > 3) && Math.abs(board[i][j]) == 1) {
					board[i][j] = -1;
				}
				if (count == 3 && board[i][j] == 0) {
					board[i][j] = 2;
				}
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] > 0)
					board[i][j] = 1;
				else if (board[i][j] < 0)
					board[i][j] = 0;
			}
		}
	}
}