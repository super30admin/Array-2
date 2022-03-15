// Time Complexity : O(m*n) where m=rows and n=cols of matrix
// Space Complexity : O(1)
class GameOfLife {
	public int[][] gameOfLife(int[][] board) {
		int m= board.length;
		int n= board[0].length;
		
		//Change state of matrix based on rules provided and have dummy state for transition
		//1->0= 2
		//0->1= 3		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				int count= countAlive(board, i, j, m, n);
				
				//Rule 1, 3
				if(board[i][j] ==1 && (count<2 || count>3)) {
					board[i][j]= 2; //make it dead due to under and over population
				}
				
				//Rule 4
				if(board[i][j] ==0 && count==3) {
					board[i][j]= 3; //Make it alive by reproduction
				}
			}
		}
		
		//Replace dummy states to achieve final state of matrix after applying all rules
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(board[i][j] == 2) {
					board[i][j]= 0;
				}
				if(board[i][j] == 3) {
					board[i][j]= 1;
				}
			}
		}
		
		return board;
	}
	
	private int countAlive(int[][] board, int i, int j, int rows, int cols) {
		int[][] dirs= new int[][] {{0,1},{1,0},{0,-1},{-1,0},{1,1},{-1,-1},{-1,1},{1,-1}};
		int count=0;
		
		for(int[] dir: dirs) {
			int row=i+dir[0];
			int col=j+dir[1];
			
			if(row>=0 && row<rows && col>=0 && col<cols && (board[row][col] ==1 || board[row][col] ==2)) {
				count++;
			}
		}
		
		return count;
	}

	// Driver code to test above 
    public static void main(String args[]) { 
    	GameOfLife ob = new GameOfLife();  
    	int[][] nums= {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};  
    	ob.gameOfLife(nums);
    } 
}