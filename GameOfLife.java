// Time Complexity : O(mn) where m is the length of the column and n is the length of the row
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No
class Solution {
    public void gameOfLife(int[][] board) {
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j] == 1) {
                    lifeGame(board, i, j);
                }
                else if(board[i][j] == 0) {
                    lifeGame(board, i, j);
                }
            }
        }
        for(int i=0;i< board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j] == 2) {
                    board[i][j] = 0;
                }
                else if(board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }

    }
    public void lifeGame(int [][] board, int i, int j) {
        int liveNeighbors = 0;
        int [][] dirs = new int [][] {{-1,0}, {0,-1}, {1,0}, {0,1}, {-1,-1}, {1,1}, {1,-1}, {-1,1}};
        for(int [] dir: dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if(x < 0 || y < 0 || x >= board.length || y>= board[0].length) {
                continue;
            }
            if(board[x][y] == 1 || board[x][y] == 2) {
                liveNeighbors++;
            }
        }
        if(board[i][j] == 1) {
            if(liveNeighbors < 2 || liveNeighbors > 3) {
                board[i][j] = 2;
            }
        }
        else if(board[i][j] == 0) {
            if(liveNeighbors == 3) {
                board[i][j] = 3;
            }
        }
    }
}
