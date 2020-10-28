// # // Time Complexity : O(mn)
// # // Space Complexity : O(1)
// # // Did this code successfully run on Leetcode : Yes
// # // Any problem you faced while coding this : 

class Solution {
    public void gameOfLife(int[][] board) {
        // 2  = 0->1
        // -1 = 1->0 
        
        //Edge 
        if(board == null || board.length==0){
            return;
        }
        
        
        for(int i=0;i<board.length;i++){
            for(int j=0; j<board[0].length;j++){
                int neighbors = checkForNeighbors(board,i,j);
                
                if(board[i][j]==1 && (neighbors <2 || neighbors>3)){
                    board[i][j]=-1;
                }
                else if(board[i][j]==0 && neighbors == 3){
                    board[i][j]=2;
                }
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0; j<board[0].length;j++){
                if(board[i][j]==2){
                    board[i][j]=1;
                }
                 else if(board[i][j]==-1){
                    board[i][j]=0;
                }
            }
        }
        
        
    }
    private int checkForNeighbors(int[][] board,int i,int j){
        int [][] dirs={{-1,0},{0,1},{1,0},{0,-1},{-1,-1},{-1,1},{1,-1},{1,1}};
        int count=0;
        for(int [] dir: dirs){
            int r = i+dir[0];
            int c = j+dir[1];
            
            if(r>=0 && r<board.length && c>=0 &&c<board[0].length && (board[r][c]==1 || board[r][c]==-1)){
                count++;
            }
        }
        return count;
    }
}