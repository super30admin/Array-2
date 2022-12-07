
// Time Complexity : O(MN) where M is the row count and N is the column count
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No

public class GameOfLife {
	 
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{1,1},{-1,-1}};
    
    
    //0->1 - 2
    //1->0 - 3
    
    public void gameOfLife(int[][] board) {
      int m = board.length;
      int n = board[0].length;
        
      for(int i=0;i<m;i++){
          
              for(int j=0;j<n;j++){
                 int actvNbr = findActvNbr(i,j,m,n,board);

                      if(board[i][j]==1 &&  (actvNbr < 2 || actvNbr >3)){
                          board[i][j] = 3;
                      }
                      if(board[i][j]==0 && actvNbr==3){
                           board[i][j] = 2;
                      }
               }
        } 
     
     //// rolling 3,2 to 1,0
      for(int i=0;i<m;i++){
          
          for(int j=0;j<n;j++)
            {
                if(board[i][j]==3){
                    board[i][j] = 0;
                }
                if(board[i][j]==2){
                    board[i][j] = 1;
                }
           }
       }            
             
    }
    
    public int findActvNbr(int i,int j,int m,int n,int[][] board){
        int count = 0;
        
        for(int[] dir:dirs){
            int row = i+dir[0];
            int col = j+dir[1];
            if(row>=0 && row<m && col>=0 && col<n){
                if(board[row][col]==1 ||board[row][col]==3 )
                    count++;
            }
            
        }
        
        return count;
    }
}
