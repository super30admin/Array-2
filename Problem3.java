package Array2;

//Time O(n*m)
//space :O(1)
public class Problem3 {
	 public void gameOfLife(int[][] board) {
	        if(board ==null || board.length==0)
	            return;
	        
	        int n = board.length;
	        int m = board[0].length;
	        
	        for(int i=0;i<n;i++){
	            for(int j=0;j<m;j++){
	                int alive= getalivecount(board,n,m,i,j);
	                
	                if(board[i][j]==1 && (alive<2 || alive >3))
	                    board[i][j]=4;
	                
	                else if(board[i][j]==0 && alive==3)
	                    board[i][j]=2;
	            }
	        }
	        
	        
	        for(int i=0;i<n;i++){
	            for(int j=0;j<m;j++){
	                if(board[i][j]==4){
	                    board[i][j]=0;
	                    
	                }else if(board[i][j]==2){
	                    board[i][j]=1;
	                }
	            }
	        }
	        
	       
	    }
	    
	    private int getalivecount(int[][] board,int n,int m,int i,int j){
	        int[][] dirs= {{-1,0},{-1,-1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
	        
	        int count=0;
	        
	        for(int[] dir : dirs){
	            int r=i+dir[0];
	            int c=j+dir[1];
	       
	        if(r>=0 && r<n && c>=0 && c<m && (board[r][c]==1 || board[r][c]==4)){
	            count++;
	        }
	        }
	        
	        return count;
	    }
}
