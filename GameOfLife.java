class Solution {
    // Time Complexity : O(mn), where m is the no of rows of board array and n is the no of cols of board array
    // Space Complexity : O(1)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No

    int m;
    int n;
    int[][] dirs;
    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;
        dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0},{-1,1},{1,1},{1,-1},{-1,-1}};
        //1 -- 0 --> 2
        //0 -- 1 --> 3
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int countAlive = countAlive(board, i, j);
                if(board[i][j] == 1 && (countAlive < 2 || countAlive > 3)) {
                    board[i][j] = 2;
                } else if(board[i][j] == 0 && countAlive == 3) {
                    board[i][j] = 3;
                }
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 2) {
                    board[i][j] = 0;
                } else if(board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    public int countAlive(int[][] board, int i, int j) {
        int count = 0;
        for(int[] dir : dirs) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if(newI < m && newI >= 0 && newJ < n && newJ >= 0) {
                if(board[newI][newJ] == 1 || board[newI][newJ] == 2)
                    count++;
            }
        }
        return count;
    }
}