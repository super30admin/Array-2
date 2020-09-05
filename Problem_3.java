// Time Complexity : O(m * n) where m and n are no. of rows and columns of 2D array board
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class Problem_3 {
	
	 public void gameOfLife(int[][] board) {
	        for(int i = 0; i < board.length; i++){
	            for(int j = 0; j < board[0].length; j++){
	                int count = getNeighborCount(i,j,board);
	                if(board[i][j] == 1 && (count < 2 || count > 3)){
	                    board[i][j] = 5;
	                }else if(board[i][j] == 0 && count == 3){
	                     board[i][j] = 6;
	                }
	            }
	        }
	        
	        for(int i = 0; i < board.length; i++){
	            for(int j = 0; j < board[0].length; j++){
	                if(board[i][j] == 5) board[i][j] = 0;
	                if(board[i][j] == 6) board[i][j] = 1; 
	            }
	        }
	    }
	    public int getNeighborCount(int row, int col, int[][] board){
		        int[][] neighbors = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
		        int count = 0;
		        int m = board.length, n = board[0].length;
		        for(int[] neighbor: neighbors){
		            int r = row + neighbor[0];
		            int c = col + neighbor[1];
		            if(r < m  && r >= 0 && c < n && c >= 0 && (board[r][c] == 1 || board[r][c] == 5))
		                count++;
		        }
		        return count;
		    }
}
