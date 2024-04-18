// Time Complexity : O(M*N), M is the no of rows, N is the no of columns
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class GameOfLife {
    int[][] dirs;
    int noOfRows;
    int noOfColumns;

    public void gameOfLife(int[][] board) {
        this.dirs = new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};//all the 8 possible directions to check neighbors

        this.noOfRows = board.length;
        this.noOfColumns = board[0].length;

        for(int i=0; i<noOfRows; i++) {
            for(int j=0; j<noOfColumns; j++) {
                int count = aliveCount(board, i, j);
                if(board[i][j] == 0) {
                    if(count == 3) {
                        board[i][j] = 2; //alive now, dead previously
                    }
                }else if(board[i][j] == 1) {
                    if(count<2 || count > 3) {
                        board[i][j] = 3; //dead now, alive previously
                    }
                }

            }
        }
        for(int i=0; i<noOfRows; i++) {
            for(int j=0; j<noOfColumns; j++) {
                if(board[i][j] == 2)
                    board[i][j] = 1;
                else if(board[i][j] == 3) 
                    board[i][j] = 0;
            }
        }
    }

        private int aliveCount(int[][] board, int i, int j) {
            int count = 0;
            for(int[] dir:dirs) {
                int r = i+dir[0];
                int c = j+dir[1];
                if(r>=0 && c>=0 && r<noOfRows && c<noOfColumns) {
                    if(board[r][c] == 1 || board[r][c] == 3)
                        count++;
                }
            }
            return count;
        }
}