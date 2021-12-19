package sol;

public class GameOfLife {
	 public int count(int x, int y, int[][]board){
	        
		    int[][]op={{-1,0},{1,0},{-1,-1},{1,1},{1,-1},{-1,1},{0,-1},{0,1}};
		        
		        int count=0;
		        for(int i=0;i<op.length;i++){
		            
		        int    x1=x+op[i][0];
		        int    y1=y+op[i][1];
		        
		        if(x1>=0&&x1<board.length&&y1>=0&&y1<board[0].length){
		            if( board[x1][y1]==1 || board[x1][y1]==3){count++;}
		            
		        }
		        
		           
		        
		    }
		    return count;
		    }
		    
		    
		    
		    public void gameOfLife(int[][] board) {
		        
		        for( int i=0;i<board.length;i++){
		        for( int j=0;j<board[0].length; j++){
		            
		            int a= count(i,j,board);
		            
		            if(board[i][j]==0){
		                if(a==3){
		                    
		                    board[i][j]=2;
		                }
		                
		            }else{
		                if(a==2||a==3){
		                    
		                    
		                }else{
		                    
		                    board[i][j]=3;
		                }
		                
		                
		            }
		        }
		        
		    }

		    
		         for( int i=0;i<board.length;i++){
		        for( int j=0;j<board[0].length; j++){
		        
		        if(board[i][j]==3){
		            board[i][j]=0;
		        }
		            
		            if(board[i][j]==2){
		                board[i][j]=1;
		            }
		            
		        }}
		        
		        
		    }
}
