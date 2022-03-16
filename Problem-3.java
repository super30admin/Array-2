// Time Complexity : O(M*N) 
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public void processNode(int[][] board, int[][] temp, int i,int j){
            int count=0;

            if(i-1>=0 && board[i-1][j]==1) count++;
            if(i-1 >=0 && j-1>=0 && board[i-1][j-1]==1) count++;
            if(j-1>=0 && board[i][j-1]==1) count++;
            if(i-1>=0 && j+1 < board[0].length && board[i-1][j+1]==1) count++;
            if(j+1 < board[0].length && board[i][j+1]==1) count++;
            if(i+1 < board.length && board[i+1][j]==1) count++;
            if(i+1< board.length && j-1>=0 &&board[i+1][j-1]==1) count++;
            if(i+1< board.length && j+1<board[0].length && board[i+1][j+1]==1) count++;
        
       
        if(board[i][j]==0 && count==3)
            temp[i][j]=1;
        if(board[i][j]==1){
            if(count<2)
                temp[i][j]=0;
            if(count>=2 && count<=3)
                temp[i][j]=1;
            if(count>3)
                temp[i][j]=0;
        }

    
            
        
    }
    public void gameOfLife(int[][] board) {
        int[][] temp = new int[board.length][board[0].length];
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                processNode(board,temp,i,j);
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
               board[i][j]=temp[i][j];
            }
        }
        
    }
}