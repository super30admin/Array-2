// Time Complexity : O (m*n)
// Space Complexity : 0(1) since the size if dirs will be the same always
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class Solution {
    int m, n;
    public void gameOfLife(int[][] board) {

        if (board == null || board.length == 0) return;

        m = board.length;
        n = board[0].length;

        // 1 -> 0 ===> 2
        // 0 -> 1 ===> 3

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                int liveCount = calcLiveCount(board, i, j);
                if (board[i][j] == 1 && (liveCount<2 || liveCount>3)) { // live cell dies
                    board[i][j] = 2;
                } else if (board[i][j] == 0 && liveCount == 3) { // dead cell comes alive
                    board[i][j] = 3;
                }
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int calcLiveCount(int[][] nums, int i, int j) {
        int count = 0;
        int newRow;
        int newCol;
        int[][] dirs = new int[][]{{0,1}, {0,-1}, {-1, 0}, {1,0}, {-1, 1}, {-1, -1}, {1, 1}, {1,-1}};

        for (int[] dir : dirs) {
            newRow = i + dir[0];
            newCol = j + dir[1];
            // condition to check if new row and columns are withint the boundaries and if they have a live neighbor one by one
            if (newRow>=0 && newCol>=0 && newRow<m && newCol<n && (nums[newRow][newCol] == 2 || nums[newRow][newCol] == 1)) {
                count++;
            }
        }
        return count;
    }
}