
// TC: O(M*N) where M represents the length and N represents the breath of the matrix
// SC : O(1) since we are not using extra space.

// We are traversing each cell and checking for number of live Neighbors at all 9 positions, So, depending on the number of positions and conditions provided,
// we will update the board, So, if the live neighbors for a cell is 3, we add update that cell to 1, if the live neighbors for a cell is less than 2
// or greater than 3, we will update that cell as 0. Since we cannot update on the updated matrix, we are storing values as negative and positive so that
// we can update it later once we know if the cell is negative, update its value to 0 and if the board is positive, update its value to positive.


public class GamesOfLife {
	
	public void GamesLife(int[][] board) {
		
		int rows = board.length;
		int cols = board[0].length;
		int[] neighbors = {0, 1, -1};
		
		for(int row = 0;row<rows;row++) {
			for(int col = 0;col<cols;col++) {
				
				int liveNeighbors = 0;
				
				for(int i=0;i<3;i++) {
					for(int j=0;j<3;j++) {
						
						if(!(neighbors[i]==0 && neighbors[j]==0))
						{
							int r = (row + neighbors[i]);
							int c = (col + neighbors[j]);
							
							if((r<rows && r>=0)&& (c<cols && c>=0) && (Math.abs(board[r][c])==1))
								liveNeighbors++;
						}
					}
				}
					//Rule 1 and Rule 4
					if(board[row][col]==1 && (liveNeighbors<2 || liveNeighbors>3))
						board[row][col] = -1;
					
					//Rule 3
					if(board[row][col]==0 && liveNeighbors==3)
						board[row][col] = 2;
				
			}
		}
			for(int r=0;r<rows;r++) {
				for(int c=0;c<cols;c++) {
					if(board[r][c]>0)
						board[r][c]=1;
					else
						board[r][c] = 0;
				}
			}
			
			for(int r=0;r<rows;r++) {
				for(int c=0;c<cols;c++) {
					System.out.print(board[r][c]+" ");
				}
				
				System.out.println();
			}	
		
	}
	
	public static void main(String[] args) {
		
		GamesOfLife gol = new GamesOfLife();
		int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
		gol.GamesLife(board);
	}

}
