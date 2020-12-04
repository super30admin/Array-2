// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


public class GameOfLife{
	int rows,cols;
    public int[][] gameOfLife(int[][] board) {
        
        //base case: checking whether the input array is empty or not
        if(board==null || board.length==0){
            return new int[0][0];
        }
        
         rows = board.length;
         cols = board[0].length;
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                //0-1->2, 1->0->3
                //rule1: if current cell is alive and it has fewer than 2 alive neighbors, then it dies
                //rule3: if current cell is alive and it has more than 3 alive neighbors, then it dies
                int lives = countLives(board,i,j); 
                
                if(board[i][j]==1 && (lives>3 || lives<2)){
                    board[i][j]=3;
                }
                //rule4: if current cell is dead and it has exactly 3 alive neighbors, then it becomes alive
                else if(board[i][j]==0 && lives==3){
                    board[i][j]=2;
                }                
            }
        }
        
        //change the value 3->0 and 2->1
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]==3){
                    board[i][j]=0;
                }else if(board[i][j]==2){
                    board[i][j]=1;
                }
            }
        }
        return board;
    }
    
    //function to count the number of alive neighbors
    public int countLives(int[][] board,int i,int j){
        int count=0;
        int[][] dirs={{0,1},{0,-1},{-1,0},{-1,-1},{-1,1},{1,0},{1,-1},{1,1}};
        
        for(int[] dir:dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            
            if(r>=0&&r<rows&&c>=0&&c<cols &&(board[r][c]==1 || board[r][c]==3)){
                count = count+1;
            }
        }
        return count;
    }
	public static void main(String[] args) {
		GameOfLife ob = new GameOfLife();
		int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
		int[][] printRes = ob.gameOfLife(board);
		 
        for(int i=0;i<printRes.length;i++){
            for(int j=0;j<printRes[0].length;j++){
            	System.out.print(" "+printRes[i][j]);
            }
        }    
	}
}