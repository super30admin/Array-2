//o(n*m) time and constant space
//passed all leetcode cases
//used approach discussed in class
class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        if(board == null|| m==0)return;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            for(int  j=0;j<n;j++){
                int countlives = countlives(board,i,j);
                if(board[i][j]==1 && (countlives<2 ||countlives>3)){
                    board[i][j]=3;
                }
                if(board[i][j]==0 && countlives==3)board[i][j]=5;
            }

        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==3) board[i][j]=0;
                if(board[i][j]==5) board[i][j]=1;
            }
        }
    }
    private int countlives(int[][] board, int i,int j){
        int m = board.length;
        int n = board[0].length;
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0},{1,1},{-1,1},{1,-1},{-1,-1}};
        int count=0;
        for(int[]dir:dirs){
            int r = i+dir[0];
            int c = j+dir[1];
            if(r>=0 && r<m && c>=0 && c<n){
                if(board[r][c]==1 || board[r][c]==3)count++;
            }
        }
        return count;
    }
}