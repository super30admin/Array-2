// Time Complexity : O(mxn)
// Space Complexity : O(mxn) if extra array is considered, but since that isn't being returned we can say that it's constant space O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :Referred a solution to get a headstart


// Your code here along with comments explaining your approach
class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0){
            return;
        }
        
        int m = board.length;
        int n = board[0].length;
        int[][] result = new int[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int liveCount=0;
                //up
                if((i-1)>=0 && board[i-1][j]==1){
                    liveCount++;
                }
                //down
                if((i+1)<m && board[i+1][j]==1){
                    liveCount++;
                }
                //left
                if((j-1)>=0 && board[i][j-1]==1){
                    liveCount++;
                }
                //right
                if((j+1)<n && board[i][j+1]==1){
                    liveCount++;
                }
                //upper left
                if((i-1)>=0 && (j-1)>=0 && board[i-1][j-1]==1){
                    liveCount++;
                }
                //upper right
                if((i-1)>=0 && (j+1)<n && board[i-1][j+1]==1){
                    liveCount++;
                }
                //lower left
                if((i+1)<m && (j-1)>=0 && board[i+1][j-1]==1){
                    liveCount++;
                }
                //lower right
                if((i+1)<m && (j+1)<n && board[i+1][j+1]==1){
                    liveCount++;
                }
                
                if(board[i][j]==1 && liveCount<2){
                    result[i][j]=0;
                }   
                else if(board[i][j]==1 && (liveCount==2 || liveCount==3)){
                    result[i][j]=1;                    
                }
                else if(board[i][j]==1. && liveCount>3){
                    result[i][j]=0;                  
                }
                else if(board[i][j] ==0 && liveCount==3){
                    result[i][j]=1;                  
                }
                
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                board[i][j] = result[i][j];
            }
        }
        
    }
}