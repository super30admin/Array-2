// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Created new matrix of dimension m*n and populated each element with number of surrounding 1's
// Iterated through original matrix and modified each element based on the conditions with above matrix as input



class GameOfLife {
    public void gameOfLife(int[][] board) {
        //baseCase
		if(board == null || board.length == 0) return;
        int[][] onesArray = new int[board.length][board[0].length];
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				onesArray[i][j] = countOnes(board, i ,j);
			}
		}	
        
        for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j] == 0) {
					if(onesArray[i][j] == 3) {
						board[i][j] = 1;
					}
				}else {
					if(onesArray[i][j] < 2 || onesArray[i][j] > 3) {
						board[i][j] = 0;
					}
				}
			}
		}
    }
    
    private int countOnes(int[][] A, int i, int j) {
		int count = 0;
		for(int k = i-1; k <= i+1; k++) {
			for(int l = j -1; l <= j+1; l++) {
				if(k >= 0 && k < A.length && l>=0 && l < A[0].length) {
					count += A[k][l];
				}
			}
		}
		return count-A[i][j];
	}
}