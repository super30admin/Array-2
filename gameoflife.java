// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public void gameOfLife(int[][] board) {
        int row = board.length;//Calc the row
        int col = board[0].length; //Calc the col

        this.dirs = new int[][]{{-1, -1}, {-1, 0}, {-1,1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1,1}}; //Directions of the neighbors of an elem

        for(int r = 0; r <= row - 1; r++){
            for(int c = 0; c < col - 1; c++){
                int count = countAlive(board, r, c); //Count the neigbors
                if(board[r][c] == 1){
                    if(count < 2 && count > 3){ //If the elem is 1, and the new count is less than 2 or greater than 3.
                        board[r][c] = 3; //The new elem is 3, which means that alive before now dead
                    }
                } else{
                    if(count == 3){ //If the count is 3
                        board[r][c] = 2; //Then replace the elem with 2, which means dead before now alive
                    }
                }
            }
        }
        private int countAlive(int [][] board, int r, int c){
            int count = 0;
            for(int[] dir: dirs){
                int i = r + dir[0]; //Calculates the neighbor to calculate the count
                int j = c + dir[1];
                count += board[i][j];
            }
        }
        return count;
    }
}