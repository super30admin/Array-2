
public class Problem_3 {
	
	  int m;
	    int n;
	    
	    public void gameOfLife(int[][] board) {
	        if(board.length == 0 || board == null){
	            return;
	        }    
	        
	        m = board.length;
	        n = board[0].length;
	        
	        for(int i=0; i<m; i++){
	            for(int j=0; j<n; j++){
	                int count = countLive(board, i, j);
	                
	                if(board[i][j] == 1 && (count < 2 || count > 3)){
	                    board[i][j] = -1;
	                }else if(board[i][j] == 0 && count == 3){
	                    board[i][j] = 2;
	                }
	            }
	        }
	        
	        for(int i=0; i<m; i++){
	            for(int j=0; j<n; j++){
	                if(board[i][j] == -1){
	                    board[i][j] = 0;
	                }else if(board[i][j] == 2){
	                    board[i][j] = 1;
	                }
	            }
	        }
	                
	    }
	    
	    private int countLive(int[][] board, int i, int j){
	        
	        int[][] dir = {{0,1}, {0,-1}, {-1, 0}, {1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
	        
	        int count = 0;
	        for(int[] d : dir){
	            int row = i + d[0];
	            int col = j + d[1];
	            
	            if(row >= 0 && row < m && col >= 0 && col < n){
	                if(board[row][col] == 1 || board[row][col] == -1)
	                    count++;    
	            }
	        }
	        
	        return count;
	        
	    }

}
