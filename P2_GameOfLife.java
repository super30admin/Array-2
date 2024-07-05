/*
 TC: O(n*m)
 SC: O(1)
 Did this code successfully run on Leetcode :yes
 Approach: 
 traverse the matrix and calculate each cell's neighbouring alive cells.
 To calculate neighbors use a direction array.

 */

class Solution {
    public void gameOfLife(int[][] board) {
        int rows=board.length;
        int cols=board[0].length;
        int[][] directionsArray = new int[][]{
            {-1,0}, {0,1}, {0,-1}, {1,0},
            {-1,-1}, {-1,1}, {1,1}, {1,-1}
            };
        for(int row=0 ; row<rows ; row++) {
            for(int col=0 ; col<cols ;col++) {
                int aliveCells = calculateNeighbors(board, row, col, directionsArray);
                if(board[row][col] == 1 ) {
                    if(aliveCells > 3 || aliveCells < 2 ) {
                        board[row][col] = 4;
                    }
                } else  {
                    if(aliveCells == 3) {
                        board[row][col] = 3;
                    }
                }
            }
        }
        for(int row=0 ; row<rows ; row++) {
            for(int col=0 ; col<cols ;col++) {
                if(board[row][col] == 4) {
                    board[row][col] = 0;
                } 
                if(board[row][col] == 3) {
                    board[row][col] = 1;
                } 
            }
        }
    }
    public int calculateNeighbors(int[][] board, int row, int col, int[][] directionsArray) {
        int aliveCells = 0;
        for(int[] dir: directionsArray) {
            int r = row+dir[0];
            int c = col+dir[1];
            if(r>=0 && r<board.length && c>=0 && c<board[0].length) {
                if(board[r][c] == 1 || board[r][c] == 4) {
                    aliveCells++;
                }
            }
        }
        return aliveCells;
    }
}