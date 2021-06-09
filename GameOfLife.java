// Time Complexity : O(M N) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


/**
 * 1. loop through input array and get liveNeighborCount .
 * 2. if element is 1 and count <2 or >3 mark item as 2(1 to 0 update).
 * 3. if element is 0 and count =3 mark item as 3(0 to 1 update)
 * 3. at the end update the value 2 to 0 and 3 to 1. 
 */

import java.util.Arrays;

public class GameOfLife {

	public void gameOfLife(int[][] board) {

		int rows = board.length;
		int cols = board[0].length;

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {

				int count = liveNeighborCount(board, row, col, rows, cols);
				if (board[row][col] == 1 && (count < 2 || count > 3)) {
					// 1 to 0 marked as 2
					board[row][col] = 2;
				} else if(board[row][col] == 0 &&count==3){
					//0 to 1 marked as 3
					board[row][col] = 3;
				}
			}
		}
		
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if(board[row][col]==2) {
					board[row][col]=0;
				}else if(board[row][col]==3) {
					board[row][col]=1;
				}
			}
		}
		
	}

	private int liveNeighborCount(int[][] board, int row, int col, int rows, int cols) {
		int[][] arr= new int[][]{{0,-1},{0,1},{-1,0},{1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
		int count = 0;
		for (int[] is : arr) {
			int i = row+is[0];
			int j= col+is[1];
			if(i>=0 && j>=0 && i<rows && j<cols&&(board[i][j]==1||board[i][j]==2)) {
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
//		int[][] arr=new int[][] {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
		int[][] arr=new int[][] {{1,1},{1,0}};
		new GameOfLife().gameOfLife(arr);
		for (int[] is : arr) {
			System.out.println(Arrays.toString(is));			
		}
	}
}
