// Time Complexity : O(m*n)), 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No
package array2;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
       int m = board.length;
        int n = board[0].length;
        //1--0--3
        //0--1--2
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //count live cells
                int count = countLives(board,i, j, m, n);
                if(board[i][j] == 1 && (count < 2 || count > 3)){
                    board[i][j] = 3;
                }
                if(board[i][j] == 0 && (count == 3)){
                    board[i][j] = 2;
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 3){
                    board[i][j] = 0;
                }
                if(board[i][j] == 2){
                    board[i][j] = 1;
                }
            }
        }
    }
    private int countLives(int [][] board, int i, int j, int m, int n){
        int [][] dirs = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        int res = 0;
        for(int [] dir: dirs){
        int r = i + dir[0]; //row index of neighbour i + 0
        int c = j + dir[1]; //column index j + 1
        if(r >= 0 && c >= 0 && r < m && c < n &&(board[r][c] == 1 || board[r][c] == 3))             {
            res++;
            }
        }
        return res;
    }    
}
