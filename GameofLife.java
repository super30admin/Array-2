// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
 
 Iterating through each element in the board and check the neighbor live cell and keep the count increasing.
 If the element is live(1) and as per the rule its neighbors live cells should be 2 or 3 and change 
 it to 3 (It represents the live cell became dead).
 
 If the element is dead(0) and as per the rule its neighbor live cells should be exactly 3 and change it 
 to 5 (it represents dead cell became live).
 
 Changing to 3 and 5 are saving the new state of the element.
 
 Iterate once more to change 3 and 5 to 0 and 1 respectively.
 
 */
public class GameofLife {

	int m, n;
	public void gameOfLife(int[][] board) {

		if(board == null && board.length == 0)
			return;
		
		m = board.length; n = board[0].length;
		
		for(int i = 0; i<m; i++) {
			for(int j=0; j<n; j++) {
				int countLives = countLives(board,i,j);
				if(board[i][j] == 1 && (countLives<2 || countLives>3)) {
					board[i][j] = 3;
				}
				
				if(board[i][j] == 0 && countLives == 3) {
					board[i][j] = 5;
				}
			}
		}
		
		
		for(int i = 0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(board[i][j] == 3) {
					board[i][j] = 0 ;
				}else if(board[i][j] == 5) {
					board[i][j] = 1;
				}
				
			}
		}
		
		
		
		
	}
	
	private int countLives(int[][] board, int i, int j) {
		int count = 0;
		int[][] dir = new int[][] {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,1},{1,0},{1,-1},};
		
		for(int[] d: dir) {
			int r = i + d[0];
			int c = j+ d[1];
			
			if((r>=0 && r<m) && (c>=0 && c<n)) {
				if(board[r][c] == 1 || board[r][c] == 3) {
					count++;
				}
			}
			
		}
		return count;

	}

	public static void main(String[] args) {

		int[][] board = new int[][] {
		  {0,1,0},
		  {0,0,1},
		  {1,1,1},
		  {0,0,0}
		};
		
		GameofLife g = new GameofLife();
		g.gameOfLife(board);
	}

}
