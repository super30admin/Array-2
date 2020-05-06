// Time Complexity : O(m*n) where m is the number of rows and n is the number of columns
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public void gameOfLife(int[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int count = findCount(i,j,board);
                if(board[i][j]==1){
                    if(count<2 || count>3)
                        board[i][j]=8;
                }
                else{
                    if(count==3)
                        board[i][j]=7;
                } 
            }
        }
            
            for( int i=0;i<board.length;i++){
                for( int j=0;j<board[0].length;j++){
                    if(board[i][j]==8)
                        board[i][j]=0;
                    else if(board[i][j]==7)
                        board[i][j]=1;
                }
            }
        
        }
    
    
    public int findCount(int i,int j, int[][] board){
        int[] arrX = {-1,-1,0,1,1,1,0,-1};
        int[] arrY = {0,1,1,1,0,-1,-1,-1};
        int count=0;
        
        for(int k=0;k<8;k++){
            int x = i+arrX[k];
            int y = j+arrY[k];
            
            if(x>=0 && x<board.length && y>=0 && y<board[0].length && (board[x][y]==1 || board[x][y]==8))
                count++;
            
        }
        
        return count;
    }
}