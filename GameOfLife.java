// Time Complexity :O(n*m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class GameOfLife {
    public void gameOfLife(int[][] board) {
    	   
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int living=count(board,i,j);
                if(board[i][j]==1){
                    if(living<2 || living>3){
                        board[i][j]=2;
                    }
                }else{
                    if(living==3){
                        board[i][j]=3;
                    }
                }
            }
        }
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==2){
                    board[i][j]=0;
                }else if(board[i][j]==3){
                     board[i][j]=1;
                }
            }
        }
    }
    
    public int count(int[][] board, int i,int j){
        int [][]neighbours={{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
        int count=0;
        for(int k=0;k<neighbours.length;k++){
            int row=i+neighbours[k][0];
            int col=j+neighbours[k][1];
            if((row>=0 && row<board.length) && (col>=0 && col<board[0].length)){
                if(board[row][col]==1 || board[row][col]==2){
                    count++;
                }
            }
        }
        return count;
    }
}
