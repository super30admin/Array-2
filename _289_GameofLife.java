package com.javaDwarf.graphs.leetcode.dfs;

public class _289_GameofLife {

	public static void main(String[] args) {
		
		

	}
	
	// time and space o(n*m) logic is to preserve board state by using other values like from 1 to 0 would be 1->3 and o->1 would be o->2
	
	public void gameOfLife(int[][] board) {

		if(board == null || board.length == 0) return;

		for(int i=0;i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {

				int count = getAliveCount(board, i, j);

				if(board[i][j] == 1 && (count < 2 || count > 3)) {
					board[i][j] = 3;
				}
				else if(board[i][j] == 0  &&  count == 3) {
					board[i][j] = 2;
				}
			}
		}
		
		
		for(int i=0;i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				if(board[i][j] == 3) board[i][j] = 0;
				if(board[i][j] == 2) board[i][j] = 1;
			}
		}

	}

	public int getAliveCount(int[][] board, int x, int y) {

		int count = 0;

		int[] xArr = {-1,0,1,-1,1,-1,0,1};
		int[] yArr = {-1,-1,-1,0,0,1,1,1};

		for(int i =0; i<xArr.length; i++) {
			int xNew = x + xArr[i];
			int yNew = y + yArr[i];

			if(xNew >= 0 && xNew < board.length && yNew >= 0 && yNew < board[0].length
					&& (board[xNew][yNew] == 1 || board[xNew][yNew] == 3)) {
				count += 1;
			}
		}
		return count;
	}
	/*****************************************************************************************************************************/
	
	// time and space o(n*m) logic is to preserve board sate in another board

	public void gameOfLife1(int[][] board) {

		if(board == null || board.length == 0) return;

		int[][] originalBoard = new int[board.length][board[0].length];

		for(int i=0;i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				originalBoard[i][j] = board[i][j];
			}
		}


		for(int i=0;i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {

				int count = getAliveCount1(originalBoard, i, j);

				if(count < 2 || count > 3) {
					board[i][j] = 0;
				}
				else if(board[i][j] == 0  &&  count == 3) {
					board[i][j] = 1;
				}
			}
		}

	}

	public int getAliveCount1(int[][] board, int x, int y) {

		int count = 0;

		int[] xArr = {-1,0,1,-1,1,-1,0,1};
		int[] yArr = {-1,-1,-1,0,0,1,1,1};

		for(int i =0; i<xArr.length; i++) {
			int xNew = x + xArr[i];
			int yNew = y + yArr[i];

			if(xNew >= 0 && xNew < board.length && yNew >= 0 && yNew < board[0].length
					&& board[xNew][yNew] == 1) {
				count += 1;
			}
		}
		return count;
	}



}
