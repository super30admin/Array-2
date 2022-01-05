// Time Complexity : O(r * c)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : y
// Any problem you faced while coding this : n

class Solution {
    public void gameOfLife(int[][] board) {
        
        int r = board.length;
        int c = board[0].length;
        int nei;
         
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                nei = getCount(board, i, j);
                if(board[i][j]==1) {
                    if(nei < 2 || nei > 3) {
                        board[i][j] = -1; // live to die
                    } 
                } else if(board[i][j]==0) {
                    if(nei==3) {
                        board[i][j] = 9; // die to live
                    }
                }
            }
        }
        
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                if(board[i][j] == 9) {
                    board[i][j] = 1;
                } else if(board[i][j] == -1) {
                    board[i][j] = 0;
                }
            }
        }
    }
    
    private int getCount(int[][] board, int r, int c) {
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        int nr, nc;
        int nei = 0;
        
        for(int[] dir: dirs) {
            nr = r + dir[0];
            nc = c + dir[1];
            
            if(nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length) {
                if(Math.abs(board[nr][nc]) == 1) {
                    nei++;
                }
            }
        }
        
        return nei;
    }
}
