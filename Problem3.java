// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    int[][] dirs;
    private int count(int[][] board,int i,int j,int m,int n){
        int res = 0;
        for(int[] dir : dirs){
            int nrow = i + dir[0];
            int ncol = j + dir[1];
            if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n &&(board[nrow][ncol]==1||board[nrow][ncol]==2))
            res++;
        }
        return res;
    }
    public void gameOfLife(int[][] board) {
        dirs = new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int alive = count(board,i,j,m,n);
                if(board[i][j]==1){
                    if(alive < 2 || alive > 3)
                        board[i][j] = 2;
                        }
                else{
                    if(alive == 3)
                        board[i][j]=3;
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                
                if(board[i][j]==2){
                    board[i][j]=0;
                        }
                else if(board[i][j]==3)
                    board[i][j]=1;
                }
            }
        }
    }
