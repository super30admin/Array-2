//TC: O(mn)
//SC: O(1) used directions 2d-array for 8 directions
//Leetcode : There was array bound exception. Help me where I went wrong.

class Solution {
    int m;
    int n;
    int [][] dirs;
    public void gameOfLife(int[][] board) {
        if(board==null || board.length==0)
            return;
     m = board.length;
     n = board[0].length;
    dirs = new int[][] {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
        for(int i=0;i<m;i++){
            for(int j=0;i<n;j++){
                int count_lives = Alive(board,i,j);
                if(board[i][j]==1 && (count_lives < 2 || count_lives > 3 ))
                {
                    board[i][j]=2;
                }
                if(board[i][j]==0 && count_lives==3)
                {
                    board[i][j]=3;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==2)
                {
                    board[i][j]=0;
                }
                if(board[i][j]==3)
                {
                    board[i][j]=1;
                }
            }
        }
    }
    private int Alive(int [][] board, int r , int c){
        int count=0;
        for(int []dir :dirs){
        int nr = r+dir[0];
        int nc = c+dir[1];
        if(nr >=0 && nr <m && nc>=0 && nc<n 
       && (board[nr][nc]==1 || board[nr][nc]==2)){
        count++;
        }
        }
    return count;
    }
}