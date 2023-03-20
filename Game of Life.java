// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public void gameOfLife(int[][] board) {
        
        int r = board.length;
        int c = board[0].length;
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                int temp = sol(board,i,j);
                board[i][j] = temp;

            }
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j]==2){
                    board[i][j]=1;
                }
                if(board[i][j]==-2){
                    board[i][j]=0;
                }

            }
        }
    }

    public int sol(int[][]board,int r,int c){
        
            int live = 0;
            //up
            if(r-1>=0){
                if(board[r-1][c]==1 || board[r-1][c]==-2 ){
                    live++;
                }
            }
            //down
            if(r+1<board.length){
                if(board[r+1][c]==1 || board[r+1][c]==-2 ){
                    live++;
                }
            }
            //left
            if(c-1>=0){
                if(board[r][c-1]==1 || board[r][c-1]==-2 ){
                    live++;
                }
            }
            //right
            if(c+1<board[0].length){
                if(board[r][c+1]==1 || board[r][c+1]==-2 ){
                    live++;
                }
            }
            //upper left diagonal
            if(r-1>=0 && c-1>=0){
                if(board[r-1][c-1]==1 || board[r-1][c-1]==-2 ){
                    live++;
                }

            }
            //uper right diagonal
            if(r-1>=0 && c+1<board[0].length){
                if(board[r-1][c+1]==1 || board[r-1][c+1]==-2 ){
                    live++;
                }
            }
            // lower left diagonal
            if(r+1<board.length && c-1>=0){
                if(board[r+1][c-1]==1 || board[r+1][c-1]==-2 ){
                    live++;
                }
            }
            // lower right diagonal
            if(r+1<board.length && c+1<board[0].length){
                if(board[r+1][c+1]==1 || board[r][c+1]==-2 ){
                    live++;
                }
            }
            if( board[r][c]==0 && live==3){
                return 2;
            }
            else if(board[r][c]== 1 && live<2){
                return -2;
            }
            else if(board[r][c]==1 && live>3){
                return -2;
            }
            else if((board[r][c]==1 && (live==2 || live==3))){
                return 1;
            }
        
        
        return board[r][c];
    }
}