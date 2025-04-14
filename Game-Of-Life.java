## Problem3 (https://leetcode.com/problems/game-of-life/)


class Solution {
    public void gameOfLife(int[][] board) {
        if(board==null || board.length==0){
            return;
        }
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int a=getLiveNeighbours(i,j,board);
                if(board[i][j]==1){
                    if(a<2 || a>3){
                        board[i][j] = 3;
                    }        
                }else{
                    if(a==3){
                        board[i][j] = 2;
                    }
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==2){
                    board[i][j]=1;
                }
                if(board[i][j]==3){
                    board[i][j]=0;
                }
            }
        }
    }
    private int getLiveNeighbours(int m,int n, int[][] board){
        int[][] arr={
            {-1,-1},{-1,0},{-1,1},{0,-1},{0,+1},{1,-1},{1,0},{1,1}
        };
        int a=0;
        for(int k=0;k<arr.length;k++){

            int nr=m+arr[k][0];
            int nc=n+arr[k][1];
            int i=board.length;
            int j=board[0].length;
            if(nr>=0 && nr<i && nc>=0 && nc<j && (board[nr][nc]==1 || board[nr][nc]==3)){
                a++;
            }



           
        }
        return a;
    }
}