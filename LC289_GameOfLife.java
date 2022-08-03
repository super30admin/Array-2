
 // Time Complexity : O(m*n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes



class Solution {
      int m;
    int n;
        //initializing the diff neighbors around the element in matrix
        int [][] dirs = new int [][]{{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}} ;
    public void gameOfLife(int[][] board) {
           m = board.length;
         n= board[0].length;
       
        //implementing the rules and tem changing the value
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                int ncount = helper(board, i ,j);
                
                if(board[i][j]==1 && (ncount<2 || ncount>3)){
                    board[i][j]=2;
                }
                
                else if(board[i][j]==0 && ncount ==3){
                    board[i][j]=3;
                }
            }
        }
        //reverting the temp state
        for(int i = 0;i<m;i++){
            for (int j=0;j<n;j++)
            {
                if(board[i][j]==2){
                    board[i][j]=0;
                }
                
                else if(board[i][j]==3){
                    board[i][j]=1;
                }
                
            }    
        }
    }
    //helper function to count the alive neighbour
    private  int helper(int [][]board, int r, int c){
        int count =0;
        for (int i=0;i<8;i++){
            int nr = r+dirs[i][0];
            int nc = c+dirs[i][1];
            if((nr>=0 && nr<m)&&(nc>=0&&nc<n) && (board[nr][nc]==1 || board[nr][nc]==2)){
                count++;
            }
        }
        return count;
    }
}