// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/* Assign values to state change, 0 -> 1 as 3, 1->0 as 4,
loop through the matrix and change state based on rules*/

public class GameofLife{ 
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] dir = new int[][]
        {{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int alives = getAliveCount(board,i,j,dir);
                if(board[i][j]==1){
                    if(alives>3 || alives<2){
                        board[i][j] = 4;
                    }
                }else{
                    if(alives==3){
                        board[i][j] = 3;
                    }
                }
            }
        }

         for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] ==3){
                    board[i][j] = 1;
                }
                if(board[i][j] == 4){
                    board[i][j] = 0;
                }
            }
         }
    }

    public int getAliveCount(int[][] board,int r, int c,int[][] dir){
        int m = board.length;
        int n = board[0].length;
        int count =0;
        for(int[] d : dir){
            int newr = r+d[0];
            int newc = c+d[1];
            if(newr>=0 && newr <m && newc>=0 && newc < n &&
            (board[newr][newc] == 1 || board[newr][newc] == 4)){
                count++;
            }
        }
        return count;
    }
}