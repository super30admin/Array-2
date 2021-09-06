package Arrays1;

public class GameOfLife {
	  public void gameOfLife(int[][] board) {
		  if(board==null) return;
		  int m = board.length; int n = board[0].length;
		  for(int i=0;i<m;i++) {
			  for(int j=0;j<n;j++) {
				  int count =  countAlive(board,i,j);
				  if(board[i][j]==1 && (count <2 || count>3)) {
					  board[i][j]=3;
				  }
				  if(board[i][j]==0 && count==3 ) {
					  board[i][j]=2;
				  }
				  
			  }
		  }
		  for(int i=0;i<m;i++) {
			  for(int j=0;j<n;j++) {
				if(board[i][j]==2) {
					board[i][j]=1;
				}
				if(board[i][j]==3) {
					board[i][j]=0;
				}
				  
			  }
		  }
		  
	  }
	  private int countAlive(int[][] board,int i,int j) {
		  int m = board.length; int n = board[0].length;
		  int alive=0;
		  int[][] dirs= {{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
		  for(int[] dir:dirs) {
			  int nr=i+dir[0];
			  int nc=j+dir[1];
			  if(nr>=0 && nr < m && nc>=0 && nc<n && (board[nr][nc]==1 || board[nr][nc] ==3)) {
				  alive++;
			  }
		  }
		  return alive;
	  }

}
