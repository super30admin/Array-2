// Time Complexity :O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : getting started


// Your code here along with comments explaining your approach

public class GameOfLife {
    class Solution {
        // mark die -> live -1
        //mark live -> die 2
        // update -1 -> 1 and 2 -> 0

        //directions of trvael
        final int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

        public void gameOfLife(int[][] board) {
            //base cases
            if (board == null || board.length == 0) return;

            int rows = board.length;
            int columns = board[0].length;

            //loop through board and upate elements with -1 if die->live or 2 if live->die based on count
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (board[i][j] == 0) {
                        int lives = count(board, i, j);
                        if (lives == 3) {
                            board[i][j] = -1;
                        }
                    }

                    if (board[i][j] == 1) {
                        int lives = count(board, i, j);
                        if (lives < 2 || lives > 3) {
                            board[i][j] = 2;
                        }
                    }

                }
            }
            update(board);
        }

        //update the board by updating elements with -1 to 1 and elements with 2 to 0
        private void update(int[][] board){
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if(board[i][j] == -1){
                        board[i][j] = 1;
                    } else if(board[i][j] == 2){
                        board[i][j] = 0;
                    }
                }
            }
        }

        //count the number of live cells
        private int count(int[][] board, int row, int col) {
            int result =0;

            for (int[] dir: dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                //checking to make sure rows and index are valid
                if (newRow >= 0 && newRow < board.length &&
                        newCol >= 0 && newCol < board[0].length &&
                        (board[newRow][newCol] == 1 ||
                                board[newRow][newCol] == 2)){
                    result++;
                }
            }
            return result;
        }
    }
}



