class Solution {
    public void gameOfLife(int[][] board) {
        int r = board.length;
	int c = board[0].length;
	int[][] result = new int[r][c];
	
	for(int i =0; i < r; i++){
		for(int j =0; j < c; j++){
			int count1 = countOne(i,j, board);
			
			if(board[i][j] == 1){
				if(count1 < 2 || count1 > 3)
					board[i][j] = -1;
			}else{
				if(count1 == 3)
					board[i][j] = -2;
			}
		}
	}
	
	for(int i =0; i < r; i++){
		for(int j =0; j < c; j++){
			if(board[i][j] == -1)
				board[i][j] = 0;
			if(board[i][j] == -2)
				board[i][j] = 1;
		}
	}
	
    }


    private int countOne(int i, int j, int[][] matrix){
	int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}, {-1,-1},{1,1},{-1,1},{1,-1}};
	int count = 0;
	for(int[] dir : dirs){
		int row = i + dir[0];
		int col = j + dir[1];
		if(row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length &&  (matrix[row][col] == 1 || matrix[row][col] == -1))
			count++;
	}
 return count;
}

}