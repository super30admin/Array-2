// Time Complexity : O(n*m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :  NO

// Maintaining a direction array that helps to check all its neighbour
// Created a helper function that counts the number of 1's in its array
// Based on the count we are changing the board values in a way such that we can distinguish 0's and 1's
public class GameOfLife {
    private int[][] dirs;
    private int m;
    private int n;
    public void gameOfLife(int[][] board) {
        
        m = board.length;
        n = board[0].length;
        dirs = new int[][] {{0,1}, {0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,1},{1,-1}};
        for(int i =0; i< board.length; i++){
            for(int  j =0; j< board[0].length; j++){
                int count = getCount(board, i, j);
                if(board[i][j] == 0 && count ==3)
                    board[i][j] = 2;
                if(board[i][j] == 1 && (count < 2 || count >3))
                    board[i][j] = 3;
            }
        }
        for(int i =0; i< board.length; i++){
            for(int  j =0; j< board[0].length; j++){
                if(board[i][j] == 2) board[i][j] = 1;
                if(board[i][j] == 3) board[i][j] = 0;
            }
        }
    }
    public int getCount(int[][] board, int i, int j){
        int count = 0;
        for(int[] direction : dirs){
            int r = i + direction[0];
            int c = j + direction[1];
            if(r >= 0 && r < m  && c >= 0 && c < n && (board[r][c] == 1 || board[r][c] == 3))
                count++;
        }
        return count;
    }
}
