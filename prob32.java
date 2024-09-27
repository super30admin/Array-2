// S30 Big N Problem #32 {Medium}
// 289. Game of Life
// Time Complexity : O(m*n)
// Space Complexity : No extra Space
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None


// Your code here along with comments explaining your approach
class Solution {
    
    //in-place solution
    private int m;
    private int n;
    
    private int countLives(int[][] board, int i,int j){
        int count =0;
        //direction array for neighbors
        //              right left and so on... (8 neighbors)
        int [][] dirs={{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,-1},{-1,1}};
        for (int []dir:dirs){
            int r=i+dir[0];
            int c=j+dir[1];
            if(r>=0 && r<m && c>=0 && c<n){
                if(board[r][c]==1 || board[r][c]==2){
                    count++;
                }
            }
        }
        return count;
    }
    public void gameOfLife(int[][] board) {
        // 0->1 ----(-1) state
        // 1->0 -----(2) state
        if(board==null || board.length==0) return;
        m=board.length; //row
        n=board[0].length; //column
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int count=countLives(board,i,j);
                if(board[i][j]==1 && (count<2 || count>3)){
                    board[i][j]=2;
                }
                if(board[i][j]==0 && count==3){
                    board[i][j]=-1;
                }
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int count=countLives(board,i,j);
                if(board[i][j]==-1){
                    board[i][j]=1;
                }
                if(board[i][j]==2){
                    board[i][j]=0;
                }
            }
        }    
      return;  
    }   
}