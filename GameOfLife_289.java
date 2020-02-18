// Time Complexity : O(MN)
// Space Complexity : O(MN)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : couldnt come up with O(1) space solution


/*
1. Calculate neighbors for every cell using i from -1 to 1 and j from -1 to 1 because we have 8 neighbors
2. Update a temporary result matrix with the output
3. Copy the next state from result to board
*/

class Solution {
    public void gameOfLife(int[][] board) {
        int[][] result = new int[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                int neighbors = calculateNeighbors(board,i,j);

                //update cell state based on given conditions
                if(board[i][j] == 1) {
                    if(neighbors == 2|| neighbors == 3)
                        result[i][j] = 1;
                    else
                        result[i][j] = 0;
                }
                else {
                    if(neighbors == 3)
                        result[i][j] = 1;
                     else
                        result[i][j] = 0;
                }
            }
        }
        // copy cell next state from temp to board
        for(int i = 0; i <board.length; i++)  {
            for(int j = 0; j <board[0].length; j++) {
                board[i][j] = result[i][j];
            }
        }
    }

    int calculateNeighbors(int[][] board, int r,int c) {
        int neighbors = 0;
        // 8 neighbors so i: -1..1 and j from -1.. 1
        for(int i = -1; i <= 1;i++) {
            for(int j = -1; j <= 1; j++) {
                if(!(i == 0 && j == 0)) {
                    //shouldn't count itself
                    if(r+i >= 0 && r+i < board.length && c+j >= 0 && c+j < board[0].length && board[r+i][c+j] == 1)
                        neighbors++;
                }
            }
        }
        return neighbors;
    }
}