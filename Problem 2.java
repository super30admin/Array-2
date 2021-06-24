// Time Complexity : O(m*n) 
// Space Complexity : O(m*n) 
// Did this code successfully run on Leetcode : yes, but this is directly from class could not do on my own

// Three line explanation of solution in plain english
// We are using the countLives constructor to see how many alive points there are
// Based on number of alive people around, you declare the index alive or dead. 
 
//
class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return;
        }

        int m = board.length;
        int n = board[0].length;
        //0 --> 1   2
        //1 --> 0   3
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int count = countLives(board,i,j,m,n);
                if(board[i][j] == 1 && (count < 2 || count > 3)){
                    board[i][j] = 3;
                }
                if(board[i][j] == 0 && count ==3){
                    board[i][j]  = 2;
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //int count = countLives(board,i,j,m,n);
                if(board[i][j] == 3){
                    board[i][j] = 0;
                }
                if(board[i][j] == 2){
                    board[i][j] = 1;
                }
            }
        }

        }

    private int countLives(int[][] board, int i, int j, int m, int n){
        int result = 0;
        int [][] dirs = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{1,-1},{-1,1}};
        for(int [] dir : dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            if(r >= 0 && r < m && c >= 0 && c < n && (board[r][c] == 1 || board[r][c] == 3)){
                result++;
            }
        }
        return result;
    }
}