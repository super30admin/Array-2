// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


public class GameOfLife {

    public void gameOfLife(int[][] board) {
        
        if(board==null ||board.length==0 || board[0].length==0)
            return;
        
        int m=board.length;
        int n=board[0].length;
        
        for(int i=0; i<m;i++){
            for(int j=0;j<n;j++){
                int life=countLive(board,i,j,m,n);
                if(board[i][j]==1 && (life<2 || life>3)){
                    board[i][j]=3;
                }
                 if(board[i][j]==0 && life==3){
                      board[i][j]=2;
                 }  
            }
        }
        
         for(int i=0; i<m;i++){
            for(int j=0;j<n;j++){
                
                if( board[i][j]==3){
                     board[i][j]=0;
                }
                
                if( board[i][j]==2){
                     board[i][j]=1;
                }
                
            }
         }
        
    }
    
    private int countLive(int[][] board, int i, int j, int m, int n){
        
        int[][] dr={{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        int result=0;
        
        for(int [] dir:dr){
            int r= i+dir[0];
            int c= j+dir[1];
            
            if(r>=0 && c>=0 && r<m && c<n && (board[r][c]==1 ||board[r][c]==3)){
                result++;
            
            }
        }
        return result;
    }
    
}
