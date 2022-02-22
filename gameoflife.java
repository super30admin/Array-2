// Time Complexity :O(MN) M=ROWS N=COL
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//mark live and dead with negative or different number to keep the track

class Solution {
     public void gameOfLife(int[][] board) {

        int m = board.length;
        int n = board[0].length;
        int[][] result = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) {
              int count = countNeighbors(board,i,j,m,n);
                if(board[i][j] == 1 && (count < 2 || count>3)) {
                    board[i][j] = 5;
                }
                if(board[i][j] == 0 && count == 3) {
                    board[i][j] = 4;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 5) {
                    board[i][j] = 0;
                } else if(board[i][j] == 4) {
                    board[i][j] = 1;
                }
            }
        }
    }
       private int countNeighbors(int[][] board, int i, int j, int m, int n) {
           int result = 0;
            int[][] neighbors = new int[][] {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};

            for(int[] neighbor:neighbors) {
                int row = i + neighbor[0];
                int column = j + neighbor[1];

                if(row >= 0 && row < m && column >=0 && column < n) {
                    if(board[row][column] == 1 || board[row][column] == 5) {
                        result++;
                    }
                }
            }
            return result;
        }
}