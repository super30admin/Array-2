//Time Complexity : O(m*n), where, m is the no. of rows and n is the no. of columns.
//Space Complexity : O(1)
//Code run successfully on LeetCode.

public class Problem2 {

   public void gameOfLife(int[][] board) {  
			 
		 if(board == null || board.length == 0)
			 return;
		 
		 int m = board.length;
		 int n = board[0].length;
		 
		 for(int i =0; i < m; i++) {
			 for(int j =0; j <n; j++) {
				 
				 int lives = countLives(board, i, j,m,n);
				 
				 if(board[i][j] == 1) {
					 
					 if(lives < 2)
						 board[i][j] = 3;
					 
					 else if(lives > 3)
						 board[i][j] = 3;
					 
				 }
				 
				 else if(board[i][j] == 0) {
					 
					 if(lives == 3)
						 board[i][j] = 2;
	
				 }
			 }
		 }
	     
		 for(int i =0; i < m; i++) {
			 for(int j =0; j < n; j++) {
				 
				 if(board[i][j] == 3)
					 board[i][j] = 0;
				 
				 else if(board[i][j] == 2)
					 board[i][j] = 1;
				 
			 }
		 }
	       
	 }
	
	public int countLives(int[][] board, int r, int c,int m, int n) {
		 
		int lives = 0;
		int nr =0, nc =0;
		int[][] dirs = new int[][] {{-1,0},{0,-1},{1,0},{0,1},{-1,-1},{1,-1},{1,1},{-1,1}};
		
		for(int[] dir : dirs) {
			
			nr = r + dir[0];
			nc = c + dir[1];
			
			if((nr >= 0 && nr <m && nc >= 0 && nc < n) && (board[nr][nc] == 1 || board[nr][nc] == 3))
				lives++;
			
		}
		return lives;
	 }
	 
	 
}
