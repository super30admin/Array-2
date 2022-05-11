// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


class Solution {
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] dirs = new int[][]{{-1,-1},{-1,0}, {-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                int value = neighbors(i,j,dirs,rows,cols, board);
                if(board[i][j]==1 && (value<2 || value>3) ){
                    board[i][j]=3;
                }
                if(board[i][j]==0 && value==3){
                    board[i][j]=2;
                }
            }
        }
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(board[i][j] ==2 ) board[i][j]=1;
                if(board[i][j] ==3) board[i][j]=0;
            }}
        
    }
    private int neighbors(int i, int j, int[][] dirs, int rows, int cols, int[][]  board){
        int res =0;
        for(int[] dir : dirs){
            int m = i+dir[0];
            int n = j+dir[1];
            if(m>=0 && m<=rows-1 && n>=0 && n<=cols-1 &&(board[m][n] ==1 || board[m][n]==3)){
                res++;
            }     
        }
        return res;
    }
}