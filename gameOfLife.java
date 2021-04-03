/*
 *  Time Complexity: O(N*M) where N is the number of rows and M is number of columns.
 *  Space Complexity: O(1) Since we are mutating the existing 2d matrix.
 *
 *  Did this code successfully run on Leetcode : Yes
 *  Any problem you faced while coding this : None
 *
 *  Explanation: For every element we calculate the number of 1's in the neighbours. Based on the conditions we update the existing values from 0 to 1 or vice-versa. When we update these conversion in the current matrix we maintain the 0-1 conversion by 3 and 1-0 conversion by 2, just to keep track of the original value. Once we are done with all the updations, we again traverse through all the elements and convert the 2 to 0 and 3 to 1.
 */
class Solution {
    public void gameOfLife(int[][] board) {
        if(board==null || board.length==0) return;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
               int numAlive = neighbors(board, i,j); 
                if(board[i][j]==1 && (numAlive>3 || numAlive<2)) board[i][j]=2;
                if(board[i][j]==0 && numAlive==3) board[i][j]=3;
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==2) board[i][j]=0;
                else if(board[i][j]==3) board[i][j]=1;
            }
        }
    }
    private int neighbors(int[][] board, int x, int y){
        int[][] dirArr= new int[][]{{1,1},{-1,-1},{1,-1},{-1,1},{0,1},{0,-1},{1,0},{-1,0}};
        int numAlive=0;
        for(int[] dir:dirArr){
            int newX=x+dir[0];
            int newY=y+dir[1];
            if(newX<0 || newX>=board.length || newY<0 || newY>=board[0].length){
                continue;
            }
            if(board[newX][newY]==1 || board[newX][newY]==2) numAlive+=1;
        }
        return numAlive;
    }
}
