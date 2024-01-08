// Time Complexity :O(MN)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yess
// Any problem you faced while coding this : i wondered, Why we didnt use questions 2nd condition in our code


// Your code here along with comments explaining your approach

class Solution {
    int dirs[][];
    public void gameOfLife(int[][] board) {
        int m= board.length;
        int n= board[0].length;
        this.dirs=new int[][]{{0,-1},{0,1},{-1,0},{1,0},{-1,-1},{-1,1},{1,1},{1,-1}};
        for(int i=0;i<m;i++){
            for(int j=0; j<n; j++){
                int count= countForAliveCells(board, i, j);
                if((board[i][j]==1 && count<2) || (board[i][j]==1 && count > 3)){
                    board[i][j]=2;         //dead
                }
                if(board[i][j]==0 && count == 3){
                    board[i][j]=3;           //alive
                }
            }

        }

        for(int i=0;i<m;i++){
            for(int j=0; j<n; j++){
                if(board[i][j]==2){
                    board[i][j]=0;
                }
                if(board[i][j]==3){
                    board[i][j]=1;
                }
            }    
        }    
    }

    public int countForAliveCells(int board[][], int i, int j){
        int count =0;
        for(int dir[]: dirs){
            int nr= i+dir[0];
            int nc=j+dir[1];
            if(nr>=0 && nr<board.length && nc>=0 && nc< board[0].length){
                if(board[nr][nc]==1 || board[nr][nc]==2){
                    count++;
                }
            }
        }
        return count;    
    }
    
}